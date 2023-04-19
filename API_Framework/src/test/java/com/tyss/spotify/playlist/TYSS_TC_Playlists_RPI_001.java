package com.tyss.spotify.playlist;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Playlists_RPI_001
 * TestScript Name: TYSS_TC_Playlists_RPI_001
 * Description: Verify that the user is able to delete the request with valid Album id.
 * 
 * @Author: Shivananda T S 
 */
public class TYSS_TC_Playlists_RPI_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from PlayList where Sl_No ='TYSS_TC_Playlists_RPI_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the user is able to delete the items in playlist")
	public void TC_Playlists_RPI_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Delete request for Remove playlist items*/
		Response response = ApiActionUtil.deleteMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("playlistparam"),jsonFilePath.getProperty("removeplaylistitem"));

		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	}
}
