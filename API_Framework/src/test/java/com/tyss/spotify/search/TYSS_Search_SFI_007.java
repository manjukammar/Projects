package com.tyss.spotify.search;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Search_SEAR_007
 * TestScript Name: TYSS_Search_SFI_007
 * Description: Verify that the API returns an error when the request format is invalid
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Search_SFI_007 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Search where Sl_No ='TYSS_Search_SFI_007'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns an error when the request format is invalid")
	public void TC_TYSS_Search_SFI_007(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Search for Item using Get request*/
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetShowEpisodesPath"));
		
		/*Validate Status Code */
	    ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
	    /* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
	     /* Validate error message from response body */
		ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));
	}
}
