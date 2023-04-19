package com.tyss.spotify.artists;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_Artists_GA_004 
 * TestScript Name: TYSS_TC_Artists_GA_004 
 * Description: Verify that the response contains artist genres 
 * 
 * @Author: Sanjay 
 */
public class TYSS_TC_Artists_GA_004 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Artists where Sl_No ='TC_Artists_GA_004'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains artist genres ")
	public void TC_Artists_GA_004(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("artistsparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate genres of artist from response body */
		ApiActionUtil.validateResponseBodyValue(response, prop_constants.getProperty("genres[0]"), prop_constants.getProperty("genres[0]"));
		
		
	}
}
