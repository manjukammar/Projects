package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Playlists_GP_002
 * TestScript Name: TYSS_Playlists_GP_002
 * Description: "Verify that the response contains playlist name "
 * 
 * @Author: Shivananda T S 
 */
public class TYSS_TC_Playlists_GP_002 extends BaseTest {

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from PlayList where Sl_No ='TYSS_Playlists_GP_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains playlist name")
	public void TYSS_Playlists_GP_002(String slNo, String methodType, String pathParam, String queryParamKey,
			String endpoint) {

		/* Get request for get playlist */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint,
				jsonFilePath.getProperty("playlistparam"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response, prop_constants.getProperty("response_time_4000ms"));

		/* Validate name of first playlist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("name"),
				prop_constants.getProperty("name"));

	}
}