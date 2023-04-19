package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId:TC_Playlists_CPD_002
 * TestScript Name: TYSS_TC_Playlists_CPD_002
 * Description: "Verify that the response contains error when  incorrect endpoint is provided"
 * 
 * @Author: Shivananda T S 
 */
public class TYSS_TC_Playlists_CPD_002 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from PlayList where Sl_No ='TYSS_TC_Playlists_CPD_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when  incorrect endpoint is provided")
	public void TC_Playlists_CPD_002(String slNo, String methodType, String pathParam, String queryParamKey,
			String endpoint) {

		/* Put request for update playlist */
		Response response = ApiActionUtil.putMethod(methodType, pathParam, queryParamKey, endpoint,
				jsonFilePath.getProperty("playlistparam"), jsonFilePath.getProperty("updateplaylist"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_4000ms"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));

		/* Validate error from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("error"),
				prop_constants.getProperty("error"));

	}
}