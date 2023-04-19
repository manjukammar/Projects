package com.tyss.spotify.shows;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TYSS_Shows_CUSS_001
 * TestScript Name: TYSS_Shows_CUSS_001
 * Description: Verify that the response contains true or false.
 * 
 * Author: Bredlin
 */
public class TYSS_Shows_CUSS_001 extends BaseTest{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No='TC_Shows_CUSS_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains true or false")
	public void TC_TYSS_Shows_CUSS_001(String testCase, String methodType, String pathParam, String queryParamKey, String endpoint) throws IOException, ParseException, Exception {

		/* Check user saved shows */
		Response response = ApiActionUtil.getMethod(methodType,pathParam,queryParamKey,endpoint,jsonFilePath.getProperty("shows_paramFilePath"));

		/* Validation content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("check_user_saved_shows_schema"));
		
		/* Validate the response body contains false */
		ApiActionUtil.verifyContents(response,prop_constants.getProperty("false"));
		
		
	}
}