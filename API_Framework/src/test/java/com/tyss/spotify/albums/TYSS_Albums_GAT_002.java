package com.tyss.spotify.albums;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GAT_002
 * TestScript Name: TYSS_Albums_GAT_002
 * Description: Verify that the API returns the correct data for each track, such as the track name, duration and popularity
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GAT_002 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GAT_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns the correct data for each track, such as the track name, duration and popularity")
	public void TC_TYSS_Albums_GAT_002(String Testcase_Id, String methodType, String pathParam, String queryParamKey,
			String endPoints) {

		/* Get request for Album Tracks */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints,jsonFilePath.getProperty("GetAlbumPath"));

		/* Validate Track Name */
		String actualName = ApiActionUtil.getResponseBodyValue(response,prop_constants.getProperty("actualName"));
		Assert.assertTrue(actualName.contains(prop_constants.getProperty("expectedName")), "Albums Track name is correctly displayed");
	
		/* Validate Duration */
		String actualDuration = ApiActionUtil.getResponseBodyValue(response,prop_constants.getProperty("actualDuration"));
		Assert.assertTrue(actualDuration.contains(prop_constants.getProperty("expectedDuration")), "Albums Track duration is correctly displayed");
		
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
