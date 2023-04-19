package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Playlists_AITP_004
 * TestScript Name: TYSS_TC_Playlists_AITP_004
 * Description: Verify that the response contains error when incorrect path param is provided
 * 
 * @Author: Sanjay 
 */
public class TYSS_TC_Playlists_AITP_004 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Playlist where Sl_No ='TC_Playlists_AITP_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains error when  incorrect  path param is provided")
	public void TC_Playlists_AITP_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {


		/* Post request */
		Response response = ApiActionUtil.postMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("playlistsparams"),jsonFilePath.getProperty("playlistspayload"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate error message from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("error.message"), prop_constants.getProperty("error.message"));
	
		
		
	}
}
