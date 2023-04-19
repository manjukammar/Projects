package com.tyss.spotify.episodes;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Episodes_GE_002
 * TestScript Name: TYSS_Episodes_GE_002
 * Description:Verify that the response contains available markets for Episodes.
 * @Author: Abhishek 
 */
public class TYSS_Episodes_GSE_002 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Episodes where Sl_No ='TC_Episodes_GSE_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API returns, the Recommendations are generated based on the available information for a given seed entity and matched against similar artists and tracks.")
	public void TC_TYSS_Episodes_GE_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("episodesparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response contains available markets */
		String availableMarkets= ApiActionUtil.getResponseBodyValue(response,prop_constants.getProperty("episodes.show.available_markets"));
	
		/* Validate country code 'IN' from response body */
		ApiActionUtil.validateResponseContainsMarket(availableMarkets);
		
		
	}
}
