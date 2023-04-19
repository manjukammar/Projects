package com.tyss.spotify.categories;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Categories_GSEBC_002
 * TestScript Name: TYSS_Categories_GSEBC_002
 * Description: Verify that the API returns an error when the request format is invalid.
 * 
 * @Author: Sreelatha 
 */

public class TYSS_Categories_GSEBC_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Categories where Sl_No ='TYSS_Categories_GSEBC_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns an error when the request format is invalid")
	public void TC_TYSS_Categories_GSEBC_002(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/*Get Several Browse Categories using Get request */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetShowEpisodesPath"));
	
	/* Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
	
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	 /* Validate error message from response body */
	ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));

	}


}
