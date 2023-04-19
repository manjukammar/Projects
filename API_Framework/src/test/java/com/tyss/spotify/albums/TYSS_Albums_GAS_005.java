package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Albums_GAS_005
 * TestScript Name: TYSS_Albums_GAS_005
 * Description: Verify that the API returns an error when an invalid Album ID is provided. 
 * 
 * @Author: Abhishek 
 */
public class TYSS_Albums_GAS_005 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TC_Albums_GAS_005'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = " Verify that the API returns an error when an invalid Album ID is provided")
	public void TC_TYSS_Albums_GAS_005(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("showparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));
		
		/* Validate error from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("error"), prop_constants.getProperty("error"));
	
	}
}