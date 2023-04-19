package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GUST_002
 * TestScript Name: TYSS_Tracks_GUST_002
 * Description: Verify that the API returns the correct data for each Track
 * 
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GUST_002 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GUST_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns the correct data for each Track")
	public void TC_TYSS_Tracks_GUST_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate name of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("items[0].track.name"), prop_constants.getProperty("name"));
		
		/* Validate total tracks of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("items[0].track.type"), prop_constants.getProperty("type"));
		
		/* Validate name of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("items[1].track.name"), prop_constants.getProperty("name"));
		
		/* Validate total tracks of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("items[1].track.type"), prop_constants.getProperty("type"));
		
	}
}
