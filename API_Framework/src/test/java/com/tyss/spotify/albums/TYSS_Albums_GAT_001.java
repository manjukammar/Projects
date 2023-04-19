package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GAT_001
 * TestScript Name: TYSS_Albums_GAT_001
 * Description: Verify that the API returns the expected number of tracks for a given album ID.
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GAT_001 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GAT_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns the expected number of tracks for a given album ID")
	public void TC_TYSS_Albums_GAT_001(String Testcase_Id,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for Album Tracks */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	
    /* Validate number of tracks */
    ApiActionUtil.validateNumberOfIdsInResponse(prop_constants.getProperty("actualTypePath"));
   
    /* Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
	
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	/* Validate Content Type */
	ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
	
	/* Validate Json Schema */
	ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getAlbumTracksSchemaValidations"));
	
}

}
