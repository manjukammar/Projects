package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GR_001
 * TestScript Name: TYSS_Tracks_GR_001
 * Description:Verify that the API returns, the Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GR_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GR_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns, the Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.")
	public void TC_TYSS_Tracks_GR_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate seed artist from response body */
		ApiActionUtil.validateResponseBodyData(response, prop_constants.getProperty("seeds[0].id"),jsonFilePath.getProperty("tracksparams"),prop_constants.getProperty("seed_artists"));
		
		/* Validate seed track from response body */
		ApiActionUtil.validateResponseBodyData(response, prop_constants.getProperty("seeds[1].id"),jsonFilePath.getProperty("tracksparams"),prop_constants.getProperty("seed_tracks"));
		
		/* Validate seed genre from response body */
		ApiActionUtil.validateResponseBodyData(response, prop_constants.getProperty("seeds[2].id"),jsonFilePath.getProperty("tracksparams"),prop_constants.getProperty("seed_genres"));
		
	}
}
