package com.tyss.spotify.shows;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TYSS_Shows_SSFCU_003
 * TestScript Name: TYSS_Shows_SSFCU_003
 * Description: Verify that the response contains error when provided invalid shows ids
 * 
 * Author: Sreelatha
 */
public class TYSS_Shows_SSFCU_003  extends BaseTest {
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No ='TYSS_Shows_SSFCU_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when provided invalid shows ids")
	public void TC_TYSS_Shows_SSFCU_003(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
		
		/* Save Shows for Current User using PUT method */
		Response response=ApiActionUtil.putMethod(methodType, pathParam, queryParamKey, endPoints,jsonFilePath.getProperty("GetShowEpisodesPath") , prop_constants.getProperty("payloadFilePath"));

		/*Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));
			
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate error message from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("actualErrorPath"), prop_constants.getProperty("errormsg_invalidId"));
	}
}
