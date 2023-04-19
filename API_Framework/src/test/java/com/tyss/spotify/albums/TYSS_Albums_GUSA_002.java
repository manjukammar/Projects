package com.tyss.spotify.albums;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GUSA_002
 * TestScript Name: TYSS_Albums_GUSA_002
 * Description: Verify that the response contains Album name,release date and list of tracks
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GUSA_002 extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GUSA_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains Album name,release date and list of tracks")
	public void TC_TYSS_Albums_GUSA_002(String Testcase_Id,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for User Saved Albums */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	 
	/* Validate response contains User saved Albums */
	Assert.assertTrue(prop_constants.getProperty("actualItem").contains(prop_constants.getProperty("expectedItem")), "Response contains correct data");
	
	/* Validate name of  album from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userAlbumName"), prop_constants.getProperty("name"));
	
	/* Validate release date of album from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userAlbumRelDate"), prop_constants.getProperty("release_date"));
	
	/* Validate list of tracks from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("userTracks"), prop_constants.getProperty("total_tracks"));
	
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
