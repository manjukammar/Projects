package com.tyss.spotify.artists;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Artists_GATT_003
 * TestScript Name: TYSS_TC_Artists_GATT_003
 * Description: Verify that the response contains type as artist
 * 
 * @Author: Sanjay 
 */
public class TYSS_TC_Artists_GATT_003 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Artists where Sl_No ='TC_Artists_GATT_003'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains type as artist")
	public void TC_Artists_GATT_003(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("artiststoptracksparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
			
		/* Validate type as artist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("tracks[9].artists[1].type"), prop_constants.getProperty("tracks[9].artists[1].type"));

		
	}
}
