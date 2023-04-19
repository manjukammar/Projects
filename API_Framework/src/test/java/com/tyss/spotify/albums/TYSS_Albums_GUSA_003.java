package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GUSA_003
 * TestScript Name: TYSS_Albums_GUSA_003
 * Description: Verify that the response contains the correct data when multiple album IDs are provided in the same request
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GUSA_003 extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GUSA_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains the correct data when multiple album IDs are provided in the same request")
	public void TC_TYSS_Albums_GUSA_003(String Testcase_Id,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for User Saved Albums */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	 
	/* Validate name of  album from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userMultipleName"), prop_constants.getProperty("name"));
	
	/* Validate release date of album from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userMultipleRelDate"), prop_constants.getProperty("release_date"));
	
	/* Validate list of tracks from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userListofTracks"), prop_constants.getProperty("total_tracks"));
	
    /* Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
	
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	/* Validate Content Type */
	ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
	
	/* Validate Json Schema */
	ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getUserSavedAlbumsSchema"));
	
}


}
