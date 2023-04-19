package com.tyss.spotify.albums;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Albums_GNR_001
 * TestScript Name: TYSS_Albums_GNR_001
 * Description: Verify the response returns IN in the available market.
 * 
 * Author: Bredlin
 */
public class TYSS_Albums_GNR_001 extends BaseTest{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No='TC_Albums_GNR_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify the response returns IN in the available market")
	public void TC_TYSS_Albums_GNR_001(String testCase, String methodType, String pathParam, String queryParamKey, String endpoint) throws IOException, ParseException, Exception {
		
		/* Check user saved Albums  */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("albums1_paramFilePath"));
		
		/* Validation content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("get_new_release_albums_schema"));
		
		/* Validate the available market contains provided market */
		ApiActionUtil.verifyContents(response, prop_constants.getProperty("albums_market_jsonPath"), prop_constants.getProperty("market_India"));	
		
	}
}
