package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GUST_003
 * TestScript Name: TYSS_Tracks_GUST_003
 * Description: Verify that the API returns the Tracks in the order they were added to the user's library.
 * 
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GUST_003 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GUST_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns the Tracks in the order they were added to the user's library.")
	public void TC_TYSS_Tracks_GUST_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Fetch ids from response body */
		String ids = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("items.track.id"));
		
		/* Validate number of ids in response */
		ApiActionUtil.validateTheOrderOfIds(ids,jsonFilePath.getProperty("tracksparams"));
		
	}
}
