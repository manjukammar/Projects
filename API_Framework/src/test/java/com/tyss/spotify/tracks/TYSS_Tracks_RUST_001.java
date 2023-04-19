package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Tracks_RUST_001
 * TestScript Name: TYSS_Tracks_RUST_001
 * Description: Verify that the API request, Delete the track while providing valid track id
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Tracks_RUST_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TYSS_Tracks_RUST_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API request, Delete the track while providing valid track id")
	public void TC_TYSS_Tracks_RUST_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Remove User Saved Tracks using Delete request */
		Response response = ApiActionUtil.deleteMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetTracksPath"),prop_constants.getProperty("payloadFilePath"));

		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
	}

}
