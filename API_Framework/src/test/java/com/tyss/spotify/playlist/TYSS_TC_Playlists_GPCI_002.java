package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TYSS_TC_Playlists_GPCI_002
 * TestScript Name: TYSS_TC_Playlists_GPCI_002
 * Description: "Verify that the response returns the playlist for the provided playlist id."
 * 
 * @Author: Shivananda T S 
 */
public class TYSS_TC_Playlists_GPCI_002 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from PlayList where Sl_No ='TYSS_TC_Playlists_GPCI_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response returns the playlist \r\n"
			+ "for the provided playlist id.")
	public void TC_Playlists_GPCI_002(String slNo, String methodType, String pathParam, String queryParamKey,
			String endpoint) {

		/* Get request for get playlist cover image */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint,
				jsonFilePath.getProperty("playlistparam"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_4000ms"));

		/* Validate url of playlist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("playlist.url"), prop_constants.getProperty("url"));
		
	}
}