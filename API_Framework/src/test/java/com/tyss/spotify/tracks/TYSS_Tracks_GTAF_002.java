package com.tyss.spotify.tracks;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Tracks_GTAF_002
 * TestScript Name: TYSS_Tracks_GTAF_002
 * Description: Verify that the API returns the correct data for audio features for multiple tracks based on their Spotify IDs.
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Tracks_GTAF_002 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TYSS_Tracks_GTAF_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns the correct data for audio features for multiple tracks based on their Spotify IDs")
	public void TC_TYSS_Tracks_GTAF_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request for Tracks Audio Features */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetTracksPath"));

		/*Validate response returns correct data */
		Assert.assertTrue(prop_constants.getProperty("actualAudioFeature").contains(prop_constants.getProperty("expectedAudioFeature")), "response returned correct data");
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate JSON Schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getTracksAudioFeaturesSchema"));
	
	}

}
