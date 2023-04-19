package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Albums_RUSA_003
 * TestScript Name: TYSS_Albums_RUSA_003
 * Description: Verify that the API returns an error when too many Album IDs are provided in the same request
 * 
 * @Author: Abhishek 
 */
public class TYSS_Albums_RUSA_003 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TC_Albums_RUSA_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = " Verify that the API returns an error when too many Album IDs are provided in the same request")
	public void TC_TYSS_Albums_RUSA_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.deleteMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("queryparams"),jsonFilePath.getProperty("payloadFile"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate error from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("error"), prop_constants.getProperty("error"));
	
	}
}
