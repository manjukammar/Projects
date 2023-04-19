package com.tyss.spotify.search;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Search_SEAR_004
 * TestScript Name: TYSS_Search_SFI_004
 * Description: Verify that the API returns tracks details while including the audio to the URI.
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Search_SFI_004 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Search where Sl_No ='TYSS_Search_SFI_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns tracks details while including the audio to the URI")
	public void TC_TYSS_Search_SFI_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Search for Item using Get request*/
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetSearchPath"));
		
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
	}

}
