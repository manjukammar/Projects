package com.tyss.spotify.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Search_SEAR_001
 * TestScript Name: TYSS_Search_SFI_001
 * Description: Verify that the API Returns Spotify catalog information about albums, artists, playlists, tracks, shows or episodes that match a keyword string
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Search_SFI_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Search where Sl_No ='TYSS_Search_SFI_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API Returns Spotify catalog information about albums, artists, playlists, tracks, shows or episodes that match a keyword string")
	public void TC_TYSS_Search_SFI_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Search for Item using Get request*/
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetSearchPath"));
			
		/*Validate Catalog */
		Assert.assertTrue(prop_constants.getProperty("actualArtistPath").contains(prop_constants.getProperty("expectedArtist")), "catalog information about artist is Displayed");
		
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate JSON Schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getSearchSchemaValidator"));
		
	}

}
