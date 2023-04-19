package com.tyss.spotify.search;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Search_SEAR_005
 * TestScript Name: TYSS_Search_SFI_005
 * Description: Verify that the API returns an error when an invalid Spotify catalog is provided.
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Search_SFI_005 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Search where Sl_No ='TYSS_Search_SFI_005'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns an error when an invalid Spotify catalog is provided")
	public void TC_TYSS_Search_SFI_005(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Search for Item using Get request*/
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetSearchPath"));
		
		/*Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate error message from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("actualErrorPath"), prop_constants.getProperty("errormsg_invalidId"));
	}
}
