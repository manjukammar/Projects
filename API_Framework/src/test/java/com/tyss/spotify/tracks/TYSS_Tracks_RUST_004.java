package com.tyss.spotify.tracks;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Tracks_RUST_004
 * TestScript Name: TYSS_Tracks_RUST_004
 * Description: Verify that the API Returns an error when the request format is invalid
 * 
 * @Author: Sreelatha 
 */
public class TYSS_Tracks_RUST_004 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Tracks where Sl_No ='TYSS_Tracks_RUST_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API Returns an error when the request format is invalid")
	public void TC_TYSS_Tracks_RUST_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Remove User Saved Tracks using Delete request */
		Response response = ApiActionUtil.deleteMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetTracksPath"),prop_constants.getProperty("payloadFilePath"));

		/*Validate Status Code */
	    ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_404"));
		
	    /* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
	     /* Validate error message from response body */
		ApiActionUtil.validateResponseBodyMessage(prop_constants.getProperty("errormsg_Service_not_found"));
	}

}
