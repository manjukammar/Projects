package com.tyss.spotify.episodes;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TC_TYSS_Episodes_GUSE_002
 * TestScript Name: TYSS_Episodes_GUSE_002
 * Description:Verify that the response contains Episodes items name
 * @Author: Abhishek 
 */
public class TYSS_Episodes_GUSE_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Episodes where Sl_No ='TC_Episodes_GUSE_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains Episodes items name")
	public void TC_TYSS_Episodes_GUSE_002(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/* Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("episodesparams"));

		/* Validate content type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate response time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate status code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate response contains episode added date */
		ApiActionUtil.validateResponseBodyValue(response,prop_constants.getProperty("items.episode.name"),prop_constants.getProperty("name"));
	
		
		
	}
}
