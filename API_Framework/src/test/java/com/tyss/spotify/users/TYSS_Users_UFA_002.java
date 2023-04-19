package com.tyss.spotify.users;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;

/*
 * TestCaseId: TYSS_Users_UFA_002
 * TestScript Name: TC_Users_UFA_002
 * Description: Verify that the response contains error when provided invalid  end point.  
 * 
 * @Author: Manjappa 
 */

public class TYSS_Users_UFA_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Users where Sl_No ='Users_UFA_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when provided invalid  end point")
	public void TC_Users_UFA_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Delete request for unfollow artist */
		Response response = ApiActionUtil.deleteMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("users_params"),prop_constants.getProperty("null"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_4000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
				
		/* Fetch the response body value from response */
		String responseBodyValue = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("error"));
	
		/* Validate response body message */
		ApiActionUtil.validateResponseBodyMessage(responseBodyValue);
	}


}
