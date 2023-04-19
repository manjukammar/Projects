package com.tyss.spotify.authorizations;

import org.testng.annotations.Test;

import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.endpoints.Endpoints;
import com.tyss.spotify.utils.ApiActionUtil;

import io.restassured.response.Response;

public class ReneweToken extends BaseTest {

	@Test
	public static void getToken() {

		/* POST method for authorization */
		Response response = ApiActionUtil.postMethodForAuthorization(
				prop_constants.getProperty("token_Url") + Endpoints.TOKEN);

		/* Fetch the access token */
		accessToken = ApiActionUtil.getResponseBodyValue(response, "access_token");
		
		/* Write data into Json file */
		ApiActionUtil.writeDataToJSONFile(accessToken);
	}

}
