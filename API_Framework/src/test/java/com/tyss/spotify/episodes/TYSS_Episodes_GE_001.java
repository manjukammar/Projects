package com.tyss.spotify.episodes;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Episodes_GE_001
 * TestScript Name: TYSS_Episodes_GE_001
 * Description:Verify that the response contains number of Episodes.
 * @Author: Abhishek 
 */
public class TYSS_Episodes_GE_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resourc3es/data/Data.xlsx", sql = "Select * from Episodes where Sl_No ='TC_Episodes_GE_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains number of Episodes.")
	public void TC_TYSS_Episodes_GE_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("episodesparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response contains available markets */
		String availableMarkets= ApiActionUtil.validateResponseBodyValue(response,prop_constants.getProperty("show.available_markets"),prop_constants.getProperty("available_markets"));
	
		/* Validate country code 'IN' from response body */
		ApiActionUtil.validateResponseContainsMarket(availableMarkets);
		
		
	}
}
