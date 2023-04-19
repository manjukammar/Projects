package com.tyss.spotify.users;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;

/*
 * TestCaseId: TYSS_Users_GCUP_004
 * TestScript Name: TC_Users_GCUP_004
 * Description: verify that the response contains  id.  
 * 
 * @Author: Manjappa 
 */

public class TYSS_Users_GCUP_004 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Users where Sl_No ='Users_GCUP_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "verify that the response contains id")
	public void TC_Users_GCUP_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request for current user playlist */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("usersparams"));
		
		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate id in response */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("id")," Id value");
		
		/* Validate JSON schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getUserProfile"));
		
	}


}
