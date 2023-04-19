package com.tyss.spotify.shows;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TYSS_Shows_GSE_003
 * TestScript Name: TYSS_Shows_GSE_003
 * Description: Verify that the response contains error when provided wrong Show endPoint.
 * 
 * Author: Sreelatha
 */
public class TYSS_Shows_GSE_003 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No ='TYSS_Shows_GSE_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = " Verify that the response contains error when provided wrong Show endpoint")
	public void TC_TYSS_Shows_GSE_003(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
		/*Get request for Show Episodes*/
		Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetShowEpisodesPath"));
		
		/*Validate Status Code */
	    ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
	    /* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
	     /* Validate error message from response body */
		ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));
	
	}
}
