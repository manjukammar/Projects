package com.tyss.spotify.shows;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.dataprovider.DataProviderFactory;
import com.tyss.spotify.dataprovider.DataProviderFileRowFilter;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

/*
 * TestCaseId: TYSS_Shows_GSE_002
 * TestScript Name: TYSS_Shows_GSE_002
 * Description: Verify that the response contains Show with Episode name and release date.
 * 
 * Author: Sreelatha
 */
public class TYSS_Shows_GSE_002 extends BaseTest{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from Shows where Sl_No ='TYSS_Shows_GSE_002'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Verify that the response contains Show with Episode name and release date")
	public void TC_TYSS_Shows_GSE_002(String Sl_No,String methodType,String pathParam,String queryParamKey,String endPoints) {
	
		/*Get request for Show Episodes*/
		Response response=ApiActionUtil.getMethod(methodType, pathParam, queryParamKey, endPoints, jsonFilePath.getProperty("GetShowEpisodesPath"));

        /* Validate Episode Name */
		String actualName = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualEpisodeName"));
        Assert.assertEquals(actualName, prop_constants.getProperty("expectedEpisodeName"), "Response is Displayed with episode name");
        
        /*Validate Release Date */
	    String actualDate = ApiActionUtil.getResponseBodyValue(response, prop_constants.getProperty("actualReleaseDate"));
		Assert.assertEquals(actualDate, prop_constants.getProperty("expectedReleaseDate"), "Response is Displayed with release date");
	        
		/* Validate Status Code */
		ApiActionUtil.validateStatusCode(response, prop_constants.getProperty("status_code_200"));
		
		/* Validate Response Time */
		ApiActionUtil.validateResponseTime(response,prop_constants.getProperty("response_time_2000ms"));
		
		/* Validate Content Type */
		ApiActionUtil.validateContentType(response, prop_constants.getProperty("content_type_json"));
		
		/* Validate Json Schema */
		ApiActionUtil.jsonSchemaValidation(response, jsonFilePath.getProperty("getShowSchemaValidations"));
		
	}

}
