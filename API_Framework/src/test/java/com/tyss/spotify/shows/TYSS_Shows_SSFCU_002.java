package com.tyss.spotify.shows;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TYSS_Shows_SSFCU_002
 * TestScript Name: TYSS_Shows_SSFCU_002
 * Description: Verify that the response contains error when provided invalid endpoint.
 * 
 * Author: Sreelatha
 */
public class TYSS_Shows_SSFCU_002  extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No ='TYSS_Shows_SSFCU_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when provided invalid endpoint")
	public void TC_TYSS_Shows_SSFCU_002(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Save Shows for Current User using PUT method */
	Response response=ApiActionUtil.putMethod(methodType, pathParam, queryParamKey, endPoints,jsonFilePath.getProperty("GetShowEpisodesPath") , prop_constants.getProperty("payloadFilePath"));

	/*Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	/* Validate error message from response body */
	ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));
	}

}
