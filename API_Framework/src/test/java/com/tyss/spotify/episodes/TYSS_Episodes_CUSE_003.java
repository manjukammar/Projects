package com.tyss.spotify.episodes;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Episodes_GE_003
 * TestScript Name: TYSS_Episodes_GE_003
 * Description:Verify that the response contains error when provide invalid Episodes ids.
 * @Author: Abhishek 
 */
public class TYSS_Episodes_CUSE_003 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Episodes where Sl_No ='TC_Episodes_CUSE_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when provide invalid Episodes ids.")
	public void TC_TYSS_Episodes_GE_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("showparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));
		
		/* Get response body*/
		ApiActionUtil.validateResponseBodyValue(response,prop_constants.getProperty("error.message"),prop_constants.getProperty("error"));
		
		
	}
}
