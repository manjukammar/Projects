package com.tyss.spotify.tracks;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Tracks_CUST_002
 * TestScript Name: TYSS_Tracks_CUST_002
 * Description: Verify the request can handle multiple ids and give response.
 * 
 * Author: Bredlin
 */
public class TYSS_Tracks_CUST_002 extends BaseTest{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_CUST_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify the request can handle multiple ids and give response")
	public void TC_TYSS_Tracks_CUST_002(String testCase, String methodType, String pathParam, String queryParamKey, String endpoint) throws IOException, ParseException, Exception {

		/* Check user saved tracks */
		Response response = ApiActionUtil.getMethod(methodType,pathParam,queryParamKey,endpoint,jsonFilePath.getProperty("tracks_paramFilePath"));

		/* Validation content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("check_user_saved_tracks_schema"));
	
	}
	
}
