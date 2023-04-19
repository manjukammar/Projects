package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TYSS_Playlists_CP_002
 * TestScript Name: TC_Playlists_CP_002
 * Description: Verify that the response contains name. 
 * 
 * @Author: Manjappa 
 */

public class TYSS_Playlists_CP_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Playlist where Sl_No ='Playlists_CP_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains name")
	public void TC_Playlists_CP_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Post request for create playlist */
		Response response = ApiActionUtil.postMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("playlistparams"),jsonFilePath.getProperty("createPlaylist"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_201"));
		
		/* Validate play list name */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("name"), "Play list name is :");
		
		/* Validate JSON schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("playist_schema"));
		
	}

}
