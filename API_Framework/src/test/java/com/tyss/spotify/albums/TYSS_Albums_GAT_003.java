package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Albums_GAT_003
 * TestScript Name: TYSS_Albums_GAT_003
 * Description: "Verify that the API returns tracks in the correct order, such as the order they appear in the album
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GAT_003 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GAT_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns tracks in the correct order, such as the order they appear in the album")
	public void TC_TYSS_Albums_GAT_003(String Testcase_Id, String methodType, String pathParam, String queryParamKey,String endPoints) {

		/* Get request for Album Tracks */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints,
				jsonFilePath.getProperty("GetAlbumPath"));

		/* Fetching number of Tracks */
		String actualName = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualTypePath"));
		
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate number of ids in response */
		String actualId = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualids"));
		ApiActionUtil.validateTheOrderOfIds(actualId,jsonFilePath.getProperty("GetAlbumOrderPath"));
		
		/* Validate Json Schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getAlbumTracksSchemaValidations"));
		
	}

}
