package com.tyss.spotify.albums;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;
/*
 * TestCaseId: TC_Albums_GA_002
 * TestScript Name: TYSS_Albums_GA_002
 * Description: Verify that the response contains album name,release date and list of tracks
 * 
 * Author: Sreelatha
 */
public class TYSS_Albums_GA_002  extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Albums where Sl_No ='TYSS_Albums_GA_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains album name,release date and list of tracks")
	public void TC_TYSS_Albums_GA_002(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
	/* Get request for Album */
	Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetAlbumPath"));
	
	/* Fetch and Validate Album Name */
	String actualName=ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualAlbumName"));
	Assert.assertTrue(actualName.contains(prop_constants.getProperty("expAlbumName")), "Album name is correctly displayed");
	
	/* Fetch and Validate Release Date */
	String actualRelDate=ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualAlbumRelDate"));
	Assert.assertTrue(actualRelDate.contains(prop_constants.getProperty("expAlbumRelDate")), "Album Release Date is correctly displayed");
	
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
