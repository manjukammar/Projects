package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Playlists_UPI_001
 * TestScript Name: TYSS_TC_Playlists_UPI_001
 * Description: Verify the status code in response of playlist
 * 
 * @Author: Sanjay 
 */
public class TYSS_TC_Playlists_UPI_001 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Playlist where Sl_No ='TC_Playlists_UPI_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify the status code in response of playlist")
	public void TC_Playlists_UPI_001(String slNo, String methodType, String pathParam, String queryParamKey,
			String endpoint) {

		/* Put request for update playlist items */
		Response response = ApiActionUtil.putMethod(methodType, pathParam, queryParamKey, endpoint,
				jsonFilePath.getProperty("playlistsparams"), jsonFilePath.getProperty("putplaylistspayload"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_2000ms"));

	}
}
