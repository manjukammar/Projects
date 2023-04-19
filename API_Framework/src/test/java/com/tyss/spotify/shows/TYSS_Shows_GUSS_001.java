package com.tyss.spotify.shows;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Shows_GUSS_001
 * TestScript Name: TYSS_Shows_GUSS_001
 * Description: Verify that the response contains shows  added date.
 * 
 * @Author: Abhishek 
 */
public class TYSS_Shows_GUSS_001 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No ='TC_Shows_GUSS_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains shows  added date.")
	public void TC_TYSS_Shows_GUSS_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("showparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Fetch the error message from response */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("items[0].added_at"), prop_constants.getProperty("added_at"));
	
	}

}
