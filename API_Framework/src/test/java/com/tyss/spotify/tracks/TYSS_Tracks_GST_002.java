package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GST_002
 * TestScript Name: TYSS_Tracks_GST_002
 * Description: Verify that the response contains Track name,release date
 * 
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GST_002 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GST_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains Track name,release date")
	public void TC_TYSS_Tracks_GST_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate name of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].album.name"), prop_constants.getProperty("name"));
		
		/* Validate release date of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].album.release_date"), prop_constants.getProperty("release_date"));
		
		/* Validate total tracks of first album from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].album.type"), prop_constants.getProperty("type"));
			
		/* Validate JSON schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getSeveralTracksSchemaValidator"));
	
	}
}
