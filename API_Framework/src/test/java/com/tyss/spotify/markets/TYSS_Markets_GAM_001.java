package com.tyss.spotify.markets;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Markets_GAM_001
 * TestScript Name: TYSS_Markets_GAM_001
 * Description: Verify that the API Returns the list of markets where Spotify is available

 * 
 * @Author: Sreelatha 
 */
public class TYSS_Markets_GAM_001 extends BaseTest{

	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Markets where Sl_No ='TYSS_Markets_GAM_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the API Returns the list of markets where Spotify is available")
	public void TC_TYSS_Markets_GAM_001(String slNo,String methodType,String pathParam,String queryParamKey,String endpoint) {

		/*Get Available Markets using Get request */
		Response response = ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endpoint, jsonFilePath.getProperty("GetShowEpisodesPath"));
		
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate JSON Schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getAvailableMarketsSchemaValidation"));
		
	}

}
