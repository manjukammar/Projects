package com.tyss.spotify.albums;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Albums_GA_001
 * TestScript Name: TYSS_Albums_GA_001
 * Description: verify that the response contains exactly one album.
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GA_001  extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GA_001'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "verify that the response contains exactly one album")
	public void TC_TYSS_Albums_GA_001(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
		
	/* Get request for Album */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	
	/* Validate number of ids present in response */
	ApiActionUtil.validateNumberOfIdsInResponse(prop_constants.getProperty("actualId"));
	
	/* Validate Status Code */
	ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
	
	/* Validate Response Time */
	ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
	
	/* Validate Content Type */
	ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
	
	/* Validate Json Schema */
	ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getAlbumSchemaValidations"));
	
	}
}
