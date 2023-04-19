package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Tracks_GR_003
 * TestScript Name: TYSS_Tracks_GR_003
 * Description:Verify that the response contains id, name,type,durations of seeds.
 * @Author: Abhishek 
 */
public class TYSS_Tracks_GR_003 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TC_Tracks_GR_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains id, name,type,durations of seeds.")
	public void TC_TYSS_Tracks_GR_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("tracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Fetch duration of seed artist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].duration_ms"),prop_constants.getProperty("duration"));
		
		/* Fetch id of seed artist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].id"),prop_constants.getProperty("id"));
		
		/* Fetch name of seed artist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[0].name"),prop_constants.getProperty("name"));
		
	}
}
