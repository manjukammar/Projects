package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TYSS_Playlists_AITP_002
 * TestScript Name: TC_Playlists_AITP_002
 * Description: Verify that the response contains snap shot id. 
 * 
 * @Author: Manjappa 
 */
public class TYSS_Playlists_AITP_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Playlist where Sl_No ='Playlists_AITP_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains snap shot id")
	public void TC_Playlists_AITP_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Post request for add items to playlist */
		Response response = ApiActionUtil.postMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("playlistparams"),jsonFilePath.getProperty("addItemstoPlaylist"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_201"));
		
		/* Validate snapshot id */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("snapshotid"), "Snap shot id is :");
					
		/* Validate JSON schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("addItemstoPlaylistSchema"));
		
	}

}
