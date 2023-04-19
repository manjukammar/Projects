package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Albums_GUSA_005
 * TestScript Name: TYSS_Albums_GUSA_005
 * Description: Verify that the API returns an error when the request format is invalid
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GUSA_005 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GUSA_005'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns an error when the request format is invalid")
	public void TC_TYSS_Albums_GUSA_005(String Testcase_Id,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for User Saved Albums */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	 
	/*Validate Status Code */
    ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
	
    /* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
     /* Validate error from response body */
	ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));
	}
}
