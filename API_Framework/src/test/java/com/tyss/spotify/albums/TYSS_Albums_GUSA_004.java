package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GUSA_004
 * TestScript Name: TYSS_Albums_GUSA_004
 * Description: Verify that the request is able to do by providing limit as more than 50
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GUSA_004 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GUSA_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the request is able to do by providing limit as more than 50")
	public void TC_TYSS_Albums_GUSA_004(String Testcase_Id,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for User Saved Albums */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	 
	/*Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_400"));
	
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	/* Validate error from response body */
	ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("actualErrorPath"), prop_constants.getProperty("errormsg_invalidId"));
}


}
