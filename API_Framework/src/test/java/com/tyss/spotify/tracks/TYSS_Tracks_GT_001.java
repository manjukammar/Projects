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
 * TestCaseId: TC_Tracks_GT_001
 * TestScript Name: TYSS_Tracks_GT_001
 * Description: Verify the response contains exactly one track.
 * 
 * Author: Bredlin
 */
public class TYSS_Tracks_GT_001 extends BaseTest{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GT_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify the response contains exactly one track")
	public void TC_TYSS_Tracks_GT_001(String testCase, String methodType, String pathParam, String queryParamKey, String endpoint) throws IOException, ParseException, Exception {

		/* Get tracks */
		Response response = ApiActionUtil.getMethod(methodType,pathParam,queryParamKey,endpoint,jsonFilePath.getProperty("tracks_paramFilePath"));

		/* Validation content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("get_tracks_schema"));
		
		/* Fetch ids from response body */
		String ids = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("tracks_id_jsonPath"));
		
		/* Verify that the response contains exact number of tracks  */	
		ApiActionUtil.validateNumberOfIdsInResponse(ids);
	}
	
}
