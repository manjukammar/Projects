package com.tyss.spotify.authorizations;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.endpoints.Endpoints;
import com.tyss.spotify.utils.ApiActionUtil;

public class Authorization extends BaseTest{
	
	@Test
	public void getAuthorization() {
		
		HashMap<String, String> queryParamMap = new HashMap<String, String>();
		queryParamMap.put("client_id",prop_constants.getProperty("client_id"));
		queryParamMap.put("response_type",prop_constants.getProperty("response_type"));
		queryParamMap.put("redirect_uri",prop_constants.getProperty("redirect_uri"));	
		queryParamMap.put("scope",prop_constants.getProperty("scope"));
		ApiActionUtil.getMethodForAuthorization(queryParamMap,prop_constants.getProperty("authorization_Url")+Endpoints.AUTHORIZE);
	}

}
