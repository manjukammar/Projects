package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GUST_004
 * TestScript Name: TYSS_Tracks_GUST_004
 * Description: Verify  that the API returns an error when invalid endpoint is provided.
 * 
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GUST_004 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GUST_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify  that the API returns an error when invalid endpoint is provided")
	public void TC_TYSS_Tracks_GUST_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
		/* Fetch the error message from response */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("error.message"),prop_constants.getProperty("error"));
		
	}
}