package com.tyss.spotify.albums;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import bsh.ParseException;
import io.restassured.response.Response;
/*
 * TestCaseId: TC_Albums_CUSA_005
 * TestScript Name: TYSS_Albums_CUSA_005
 * Description: Verify the response returns error when request format is invalid.
 * 
 * Author: Bredlin
 */
public class TYSS_Albums_CUSA_005 extends BaseTest{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TC_Albums_CUSA_005'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify the response returns error when request format is invalid")
	public void TC_TYSS_Albums_CUSA_005(String testCase, String methodType, String pathParam, String queryParamKey, String endpoint) throws IOException, ParseException, Exception {
		
		/* Check user saved Albums  */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("albums1_paramFilePath"));
		
		/* Validation content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));
	
		/* Validate Status Code  */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
	}

}
