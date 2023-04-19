package com.tyss.spotify.episodes;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Episodes_SECU_001
 * TestScript Name: TYSS_Episodes_SECU_001
 * Description:Verify that the response contains status code for Episodes request
 * @Author: Abhishek 
 */
public class TYSS_Episodes_SECU_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Episodes where Sl_No ='TC_Episodes_SECU_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains status code for Episodes request")
	public void TC_TYSS_Episodes_SECU_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.putMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("episodesparams"),jsonFilePath.getProperty("saveEpisodeForUser"));

		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
	}
}
