package com.tyss.spotify.authorizations;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.endpoints.Endpoints;
import com.tyss.spotify.utils.ApiActionUtil;

public class GetToken extends BaseTest{
	
	@Test
	public void getToken() {
			HashMap<String, String> queryParamMap = new HashMap<String, String>();

			queryParamMap.put("client_id",prop_constants.getProperty("client_id"));
			queryParamMap.put("redirect_uri",prop_constants.getProperty("redirect_uri"));	
			queryParamMap.put("client_secret",prop_constants.getProperty("client_secret"));
			queryParamMap.put("grant_type",prop_constants.getProperty("granttype"));
			queryParamMap.put("code", prop_constants.getProperty("code"));
			ApiActionUtil.postMethodForAuthorization(queryParamMap,prop_constants.getProperty("token_Url")+Endpoints.TOKEN);
		}

}
