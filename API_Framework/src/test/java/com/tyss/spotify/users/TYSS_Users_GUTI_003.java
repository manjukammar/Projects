package com.tyss.spotify.users;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;

/*
 * TestCaseId: TYSS_Users_GUTI_003
 * TestScript Name: TC_Users_GUTI_003
 * Description: Verify that the response contains
error when provided invalid  end point
 * 
 * @Author: Manjappa 
 */

public class TYSS_Users_GUTI_003 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Users where Sl_No ='Users_GUTI_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when provided invalid  parameter")
	public void TC_Users_GUTI_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request for user top items */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("usersparams"));
		
		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
				
		/* Fetch the response body value from response */
		 ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("error"));
	
	
		
	}


}