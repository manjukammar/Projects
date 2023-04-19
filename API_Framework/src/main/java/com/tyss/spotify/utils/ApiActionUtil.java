package com.tyss.spotify.utils;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tyss.spotify.baseutil.BaseTest;
import com.tyss.spotify.extentreports.ExtentManager;
import com.tyss.spotify.pojo.AccessToken;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


/**
 * Description:: This class contains action methods which is used for performing
 * action while executing script such as API methods GET,PUT,POST,PATCH,DELETE etc...
 * 
 * @author Manikandan A
 * 
 */


public class ApiActionUtil extends BaseTest {

	public static TakesScreenshot screenshot;

	/**
	 * Description Method to provide info in the log,testNg reports
	 * 
	 * @author Manikandan A
	 * @param message
	 */
	public synchronized static void info(String message) {
		BaseTest.logger.info(message);
	}

	/**
	 * Description Method for the error updation in logs
	 * 
	 * @author Manikandan A
	 * @param message
	 */
	public synchronized static void error(String message) {
		BaseTest.logger.error(message);
	}

	/**
	 * Description Method to provide info in the extent report
	 * 
	 * @author Manikandan A
	 * @param message
	 */
	public synchronized static void extentinfo(String message) {
		ExtentManager.getTestReport().info(message);
	}

	/**
	 * Description Method for the pass updation in extent Report
	 * 
	 * @author Manikandan A
	 * @param message
	 */
	public synchronized static void pass(String message) {
		ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * Description Method for the info/error updation in extent Report
	 * 
	 * @author Manikandan A
	 * @param message
	 * @param color
	 */
	public synchronized static void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))
			ExtentManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description Method for the error updation in extent Report
	 * 
	 * @author Manikandan A
	 * @param message
	 */
	public synchronized static void fail(String message) {
		ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description:: Method to wait for mentioned time
	 * 
	 * @author Manikandan A
	 * @param poll
	 */
	public synchronized static void poll(int poll) {
		try {
			Thread.sleep(poll);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Description Method for fetching Current Date Time
	 * 
	 * @author Manikandan A
	 * 
	 */
	public synchronized static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description Method to delete the directory
	 * 
	 * @author Manikandan A
	 * @param pathToDeleteFolder
	 */
	public synchronized static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * Description Method to delete folder directory
	 * 
	 * @author Manikandan A
	 * @param folderToDelete
	 */
	public synchronized static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}
		}
		folderToDelete.delete();
	}

	/**
	 * Description: Capture the screenshot of the complete screen
	 * 
	 * @author Manikandan A
	 * @param path
	 * @return destinationPath
	 */
	public synchronized static String getScreenShot(String path) {
		File src = (screenshot.getScreenshotAs(OutputType.FILE));
		String currentDateTime = getCurrentDateTime();
		String destinationPath = path + BaseTest.className + "-" + currentDateTime + ".png";
		File destination = new File(destinationPath);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			error("Capture Failed " + e.getMessage());
		}
		return "./Screenshots/" + BaseTest.className + "-" + currentDateTime + ".png";
	}

	/**
	 * Description: This method is used to validate the status code
	 * 
	 * @author Bredlin
	 * @param response
	 * @param status_code
	 */
	public synchronized static void validateStatusCode(Response response, String status_code) {
		int statusCode = response.statusCode();
		int expected_status_code = Integer.parseInt(status_code);
		try {
			Assert.assertEquals(expected_status_code, statusCode);
			validationinfo("Expected Status code is: " + expected_status_code + " matching with actual status code: "
					+ statusCode, "blue");
			info("Expected Status code is: " + expected_status_code + " matching with actual status code: "
					+ statusCode);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Expected Status code is: " + expected_status_code + " not matching with actual status code: "
					+ statusCode);
			Assert.fail("Expected Status code is: " + expected_status_code + " not matching with actual status code: "
					+ statusCode);
		}
	}

	/**
	 * Description: This method is used to validate the response time
	 * 
	 * @author Bredlin
	 * @param response
	 * @param responseTime
	 */
	public synchronized static void validateResponseTime(Response response, String responseTime) {
		long expectedResponseTime = Long.parseUnsignedLong(responseTime);
		long actualResponseTime = response.getTime();
		try {
			Assert.assertTrue(actualResponseTime < expectedResponseTime);
			validationinfo("Actual Response Time: " + actualResponseTime + " is less than Expected Response Time: "
					+ expectedResponseTime, "blue");
			info("Actual Response Time: " + actualResponseTime + " is less than Expected Response Time: "
					+ expectedResponseTime);
		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());
			fail("Actual Response Time: " + actualResponseTime + " is greater than Expected Response Time: "
					+ expectedResponseTime);
			Assert.fail("Actual Response Time: " + actualResponseTime + " is greater than Expected Response Time: "
					+ expectedResponseTime);
		}
	}

	/**
	 * Description: This method is used to validate the content type
	 * 
	 * @author Bredlin
	 * @param response
	 * @param expectedContentType
	 */
	public synchronized static void validateContentType(Response response, String expectedContentType) {
		String actualcontentType = response.getContentType();
		try {
			Assert.assertTrue(actualcontentType.contains(expectedContentType));
			validationinfo("expected Content type is: " + expectedContentType + " equal to actual Content type: "
					+ actualcontentType, "blue");
			info("expected Content type is: " + expectedContentType + " equal to actual Content type: "
					+ actualcontentType);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Expected Content type is: " + expectedContentType + " not equal to actual Content type: "
					+ actualcontentType);
			Assert.fail("Expected Content type is: " + expectedContentType + " not equal to Actual Content type: "
					+ actualcontentType);
		}
	}

	/**
	 * Description: This method is used to get the Response Body value using JSON
	 * path
	 * 
	 * @author Bredlin
	 * @param response
	 * @param jsonPath
	 * @return actualResponseBodyValue
	 */
	public synchronized static String getResponseBodyValue(Response response, String jsonPath) {
		String actualResponseBodyValue = null;
		try {
			JsonPath path = new JsonPath(response.asString());
			try {
				actualResponseBodyValue = path.getString(jsonPath);
			} catch (Exception e) {
				System.out.println(jsonPath);
				e.printStackTrace();
			}
			info("Response body value is: " + actualResponseBodyValue);
//			extentinfo("Response body value is: " + actualResponseBodyValue);
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to get the Response body value using JSON path: " + jsonPath);
			Assert.fail("Unable to get the Response body value using JSON path: " + jsonPath);
		}
		return actualResponseBodyValue;

	}

	/**
	 * Description: This method is used to fetch the Authorization details
	 * 
	 * @author Bredlin
	 * @param querParamMap
	 * @param endpoint
	 * @return response
	 */
	public synchronized static Response getMethodForAuthorization(HashMap<String, String> querParamMap,
			String endpoint) {
		Response response;
		try {
			requestSpecification = requestSpecBuilder.addQueryParams(querParamMap).build();
			response = given().spec(requestSpecification).when().get(endpoint).then().log().all().extract().response();
			info("GET request executed for authorization");
			extentinfo("GET request executed for authorization");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to get desired response for GET request");
			Assert.fail("Unable to get desired response for GET request");
		}
		return null;
	}

	/**
	 * Description: This method is used to provide Authorization details and fetch
	 * the token
	 * 
	 * @author Bredlin
	 * @param endpoint
	 * @return response
	 */
	public synchronized static Response postMethodForAuthorization(String endpoint) {
		Response response;
		try {
			HashMap<String, String> queryParamMap = new HashMap<String, String>();
			queryParamMap.put("client_id", prop_constants.getProperty("client_id"));
			queryParamMap.put("client_secret", prop_constants.getProperty("client_secret"));
			queryParamMap.put("grant_type", prop_constants.getProperty("grant_type"));
			queryParamMap.put("refresh_token", prop_constants.getProperty("refresh_token"));
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).formParams(queryParamMap).post(endpoint).then().log().all()
					.extract().response();
			info("POST request executed for authorization");
			extentinfo("POST request executed for authorization");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to get desired response for POST request");
			Assert.fail("Unable to get desired response for POST request");
		}
		return null;
	}

	/**
	 * Description: This method is used to post the request for Authorization
	 * 
	 * @author Bredlin
	 * @param querParamMap
	 * @param endpoint
	 * @return response
	 */
	public synchronized static Response postMethodForAuthorization(HashMap<String, String> queryParamMap,
			String endpoint) {
		Response response;
		try {
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).formParams(queryParamMap).post(endpoint).then().log().all()
					.extract().response();
			extentinfo("POST request executed for authorization");
			info("POST request executed for authorization");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to get desired response for POST request");
			Assert.fail("Unable to get desired response for POST request");
		}
		return null;
	}

	/**
	 * Description: This method is used to add headers for authentication.
	 * 
	 * @author sreelatha
	 */
	public synchronized static void addHeader() {
		try {
			requestSpecBuilder.addHeader("Authorization", "Bearer " + accessToken);
			extentinfo("Headers added successfully for authentication");
			info("Headers added successfully for authentication");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to add headers for authentication");
			Assert.fail("Unable to add headers for authentication");
		}
	}

	/**
	 * Description: This method is used to add headers for authentication.
	 * 
	 * @author sreelatha
	 */
	public synchronized static void addHeaders(String headers, String filePath) {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			if (headers.equals(prop_constants.getProperty("null"))) {
				info("This request do not have headers to add");
			} else {
				String[] headerKey = null;
				headerKey = headers.split(",");
				for (int i = 0; i < headerKey.length; i++) {
					requestSpecBuilder.addHeader(headerKey[i], (String) jsonObject.get(headerKey[i]));
				}
			}
			extentinfo("Headers added successfully for authentication");
			info("Headers added successfully for authentication");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to add headers for authentication");
			Assert.fail("Unable to add headers for authentication");
		}
	}

	/**
	 * Description: This method is used to add path parameter.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param mutipleIds
	 */
	public synchronized static void addPathParam(String filePath, String pathParam) {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			System.out.println("Read from json file " + jsonObject.get("id"));
			if (pathParam.equals(prop_constants.getProperty("null"))) {
				info("This request do not have Path parameters");
			} else {
				String[] pathKey = null;
				pathKey = pathParam.split(",");
				for (int i = 0; i < pathKey.length; i++) {
					requestSpecBuilder.addPathParam(pathKey[i], jsonObject.get(pathKey[i]));
				}
			}
			extentinfo("Path parameters added to the request");
			info("Path parameters added to the request");
		} catch (Exception e) {
			e.printStackTrace();
			error(e.getMessage());
			fail("Unable to add Path parameter");
			Assert.fail("Unable to add Path parameter");
		}
	}

	/**
	 * Description: This method is used to remove path parameter.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * 
	 */
	public synchronized static void removePathParam(String pathParam) {
		try {
			requestSpecification = requestSpecBuilder.removePathParam(pathParam).build();
			extentinfo("Path parameter removed from the request");
			info("Path parameter removed from the request");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to remove Path parameter");
			Assert.fail("Unable to remove Path parameter");
		}
	}

	/**
	 * Description: This method is used to add query parameter.
	 * 
	 * @author sreelatha
	 * @param querParamKey
	 * @param filePath
	 */
	private synchronized static void addQueryParam(String filePath, String querParamKey) {
		try {
			if (querParamKey.equals(prop_constants.getProperty("null"))) {
				info("This reuest do not have Query Parameters");
			} else {
				String[] queryKey = null;
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader(filePath));
				JSONObject jsonObject = (JSONObject) obj;
				queryKey = querParamKey.split(",");
				for (int i = 0; i < queryKey.length; i++) {
					requestSpecBuilder.addQueryParam(queryKey[i], jsonObject.get(queryKey[i]));
				}
			}
			extentinfo("Query parameter added to the request");
			info("Query parameter added to the request");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to add Query parameter");
			Assert.fail("Unable to add Query parameter");
		}
	}

	/**
	 * Description: This method is used to get request using JSON file.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramFilePath
	 * @param payloadFilepath
	 * @return response
	 */
	private synchronized static Response getMethodWithFile(String pathParam, String queryParamKey, String endpoint,
			String paramFilePath, String payloadFilepath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramFilePath, pathParam);
			addQueryParam(paramFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).body(payloadFilepath).log().all().when().get(endpoint).then()
					.log().all().extract().response();
			extentinfo("GET request executed using JSON file for payload");
			info("GET request executed using JSON file for payload");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute GET request using JSON file for payload");
			Assert.fail("Unable to execute GET request using JSON file for payload");
		}
		return null;
	}

	/**
	 * Description: This method is used to get request using parameters.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param filePath
	 * @return response
	 */
	private synchronized static Response getMethodWithParams(String pathParam, String queryParamKey, String endpoint,
			String filePath) {
		Response response;
		try {
			addHeader();
			addPathParam(filePath, pathParam);
			addQueryParam(filePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().when().get(endpoint).then().log().all().extract()
					.response();
			validationinfo(response.asString(), "green");
			extentinfo("GET request executed using parameters");
			info("GET request executed using parameters");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute GET request using parameters");
			Assert.fail("Unable to execute GET request using parameters");
		}
		return null;
	}

	/**
	 * Description: This method is used to put request using JSON file.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 */
	private synchronized static Response putMethodWithFile(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath, String payloadFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).body(payloadFilePath).log().all().when().put(endpoint).then()
					.log().all().extract().response();
			extentinfo("PUT request executed using JSON file for payload");
			info("PUT request executed using JSON file for payload");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PUT request using JSON file for payload");
			Assert.fail("Unable to execute PUT request using JSON file for payload");
		}
		return null;
	}

	/**
	 * Description: This method is used to put request using parameters.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param filePath
	 * @param endpoint
	 * @return response
	 */
	private synchronized static Response putMethodWithParams(String pathParam, String queryParamKey, String endpoint,
			String filePath) {
		Response response;
		try {
			addHeader();
			addPathParam(filePath, pathParam);
			addQueryParam(filePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().when().put(endpoint).then().log().all().extract()
					.response();
			extentinfo("PUT request executed using parameters");
			info("PUT request executed using parameters");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PUT request using parameters");
			Assert.fail("Unable to execute PUT request using parameters");
		}
		return null;
	}

	/**
	 * Description: This method is used to delete request using JSON file.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param paloadFilePath
	 * @return response
	 */
	private synchronized static Response deleteMethodWithFile(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath, String paloadFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().body(paloadFilePath).when().delete(endpoint)
					.then().log().all().extract().response();
			extentinfo("DELETE request executed using JSON file for payload");
			info("DELETE request executed using JSON file for payload");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute DELETE request using JSON file for payload");
			Assert.fail("Unable to execute DELETE request using JSON file for payload");
		}
		return null;
	}

	/**
	 * Description: This method is used to delete request using parameters.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @return response
	 */
	private synchronized static Response deleteMethodWithParams(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().when().delete(endpoint).then().log().all()
					.extract().response();
			extentinfo("DELETE request executed using parameters");
			info("DELETE request executed using parameters");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute DELETE request using parameters");
			Assert.fail("Unable to execute DELETE request using parameters");
		}
		return null;
	}

	/**
	 * Description: This method is used to validate JSON schema
	 * 
	 * @author Abhishek
	 * @param response
	 * @param fileName
	 */
	public synchronized static void jsonSchemaValidation(Response response, String fileName) {
		try {
			response.then().assertThat().body(matchesJsonSchemaInClasspath(fileName));
			info("JSON schema is matching with the response body");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to Validate JSON schema");
			Assert.fail("Unable to Validate JSON schema");
		}
	}

	/**
	 * Description: This method is used to write data into JSON file.
	 * 
	 * @author Abhishek
	 * @param accessToken
	 */
	public synchronized static void writeDataToJSONFile(String accessToken) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			HashMap<String, String> map = new HashMap();
			map.put("accessToken", accessToken);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./src/test/resources/AccessToken.json"), map);
			info("Data is updated in JSON file");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to write data into JSON file");
			Assert.fail("Unable to write data into JSON file");
		}
	}

	/**
	 * Description: This method is used to read data from JSON file.
	 * 
	 * @author Abhishek
	 * 
	 */
	public synchronized static String readDataFromJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			AccessToken token = mapper.readValue(new File("./src/test/resources/AccessToken.json"), AccessToken.class);
			accessToken = token.getAccessToken();
			info("Data fetched from JSON file");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to fetch data from JSON file");
			Assert.fail("Unable to fetch data from JSON file");
		}
		return accessToken;
	}

	/**
	 * Description: This method is used to post request using JSON file.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 */
	public synchronized static Response postMethodWithFile(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath, String payloadFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).body(payloadFilePath).log().all().when().post(endpoint).then()
					.log().all().extract().response();
			extentinfo("POST request executed using JSON file for payload");
			info("POST request executed using JSON file for payload");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute POST request using JSON file for payload");
			Assert.fail("Unable to execute POST request using JSON file for payload");
		}
		return null;
	}

	/**
	 * Description: This method is used to post request using parameters.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @return response
	 */
	private synchronized static Response postMethodWithParams(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().when().post(endpoint).then().log().all().extract()
					.response();
			extentinfo("POST request executed using parameters");
			info("POST request executed using parameters");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute POST request using parameters");
			Assert.fail("Unable to execute POST request using parameters");
		}
		return null;
	}

	/**
	 * Description: This method is used to patch request using parameters.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @return response
	 */
	private synchronized static Response patchMethodWithParams(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).log().all().when().patch(endpoint).then().log().all()
					.extract().response();
			extentinfo("PATCH request executed using parameters");
			info("PATCH request executed using parameters");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PATCH request using parameters");
			Assert.fail("Unable to execute PATCH request using parameters");
		}
		return null;
	}

	/**
	 * Description: This method is used to patch request using JSON file.
	 * 
	 * @author sreelatha
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 */
	private synchronized static Response patchMethodWithFile(String pathParam, String queryParamKey, String endpoint,
			String paramsFilePath, String payloadFilePath) {
		Response response;
		try {
			addHeader();
			addPathParam(paramsFilePath, pathParam);
			addQueryParam(paramsFilePath, queryParamKey);
			requestSpecification = requestSpecBuilder.build();
			response = given().spec(requestSpecification).body(payloadFilePath).log().all().when().post(endpoint).then()
					.log().all().extract().response();
			extentinfo("PATCH request executed using JSON file for payload");
			info("PATCH request executed using JSON file for payload");
			return response;
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PATCH request using JSON file for payload");
			Assert.fail("Unable to execute PATCH request using JSON file for payload");
		}
		return null;
	}

	/**
	 * Description: This method is used to execute PUT request.
	 * 
	 * @author Abhishek
	 * @param methodType
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 * 
	 */
	public synchronized static Response putMethod(String methodType, String pathParam, String queryParamKey,
			String endpoint, String paramsFilePath, String payloadFilePath) {
		Response response = null;
		try {
			switch (methodType) {
			case "params":
				response = putMethodWithParams(pathParam, queryParamKey, endpoint, paramsFilePath);
				break;
			case "file":
				response = putMethodWithFile(pathParam, queryParamKey, endpoint, paramsFilePath, payloadFilePath);
				break;
			default:
				error("Unable to execute PUT request");
				fail("Unable to execute PUT request");
				Assert.fail("Unable to execute PUT request");
				break;
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PUT request");
			Assert.fail("Unable to execute PUT request");
		}
		return response;

	}

	/**
	 * Description: This method is used to execute DELETE request.
	 * 
	 * @author Abhishek
	 * @param methodType
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 * 
	 */
	public synchronized static Response deleteMethod(String methodType, String pathParam, String queryParamKey,
			String endpoint, String paramsFilePath, String payloadFilePath) {
		Response response = null;
		try {
			switch (methodType) {
			case "params":
				response = deleteMethodWithParams(pathParam, queryParamKey, endpoint, paramsFilePath);
				break;
			case "file":
				response = deleteMethodWithFile(pathParam, queryParamKey, endpoint, paramsFilePath, payloadFilePath);
				break;
			default:
				error("Unable to execute DELETE request");
				fail("Unable to execute DELETE request");
				Assert.fail("Unable to execute DELETE request");
				break;
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute DELETE request");
			Assert.fail("Unable to execute DELETE request");
		}
		return response;
	}

	/**
	 * Description: This method is used to execute POST request.
	 * 
	 * @author Abhishek
	 * @param methodType
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return
	 * 
	 */
	public synchronized static Response postMethod(String methodType, String pathParam, String queryParamKey,
			String endpoint, String paramsFilePath, String payloadFilePath) {
		Response response = null;
		try {
			switch (methodType) {
			case "params":
				response = postMethodWithParams(pathParam, queryParamKey, endpoint, paramsFilePath);
				break;
			case "file":
				response = postMethodWithFile(pathParam, queryParamKey, endpoint, paramsFilePath, payloadFilePath);
				break;
			default:
				error("Unable to execute POST request");
				fail("Unable to execute POST request");
				Assert.fail("Unable to execute POST request");
				break;
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute POST request");
			Assert.fail("Unable to execute POST request");
		}
		return response;
	}

	/**
	 * Description: This method is used to execute PATCH request.
	 * 
	 * @author Abhishek
	 * @param methodType
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 * 
	 */
	public synchronized static Response patchMethod(String methodType, String pathParam, String queryParamKey,
			String endpoint, String paramsFilePath, String payloadFilePath) {
		Response response = null;
		try {
			switch (methodType) {
			case "params":
				response = patchMethodWithParams(pathParam, queryParamKey, endpoint, paramsFilePath);
				break;
			case "file":
				response = patchMethodWithFile(pathParam, queryParamKey, endpoint, paramsFilePath, payloadFilePath);
				break;
			default:
				error("Unable to execute PATCH request");
				fail("Unable to execute PATCH request");
				Assert.fail("Unable to execute PATCH request");
				break;
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute PATCH request");
			Assert.fail("Unable to execute PATCH request");
		}
		return response;
	}

	/**
	 * Description: This method is used to execute GET request.
	 * 
	 * @author Abhishek
	 * @param methodType
	 * @param pathParam
	 * @param queryParamKey
	 * @param endpoint
	 * @param paramsFilePath
	 * @param payloadFilePath
	 * @return response
	 * 
	 */
	public synchronized static Response getMethod(String methodType, String pathParam, String queryParamKey,
			String endpoint, String paramsFilePath) {
		Response response = null;
		try {
			switch (methodType) {
			case "params":
				response = getMethodWithParams(pathParam, queryParamKey, endpoint, paramsFilePath);
				break;
			default:
				error("Unable to execute GET request");
				fail("Unable to execute GET request");
				Assert.fail("Unable to execute GET request");
				break;
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to execute GET request");
			Assert.fail("Unable to execute GET request");
		}
		return response;
	}

	// 12-01-2023

	/**
	 * Description: This method is used to validate number of ids present in
	 * response
	 * 
	 * @author Abhishek
	 * @param ids
	 */
	public synchronized static void validateNumberOfIdsInResponse(String ids) {
		try {
			String[] id = ids.split(",");
			if (id.length > 2) {
				info("Response body contains multiple id's: " + ids);
				extentinfo("Response body contains multiple id's");
			} else if (id.length == 2) {
				info("Response body contains two ids: " + ids);
				validationinfo("Response body contains two ids: " + ids, "blue");
			} else {
				info("Response body contains single id: " + ids);
				extentinfo("Response body contains single id: " + ids);
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Response body does not contains any ids");
			Assert.fail("Response body does not contains any ids");
		}
	}

	/**
	 * Description: This method is used to validate response body contains expected
	 * market
	 * 
	 * @author Abhishek
	 * @param availableMarkets
	 */
	public synchronized static void validateResponseContainsMarket(String availableMarkets) {
		try {
			String[] market = availableMarkets.split(",");
			boolean flag = false;
			for (int i = 0; i < market.length; i++) {
				if (availableMarkets.contains(prop_constants.getProperty("market_India"))) {
					info("Response body contains market with country code: " + prop_constants.getProperty("market_India"));
					extentinfo("Response body contains market with country code: "
							+ prop_constants.getProperty("market_India"));
					break;
				} else {
					flag = true;
				}
			}
			if (flag == true) {
				fail("Response body does not contains market with country code: "
						+ prop_constants.getProperty("market_India"));
				error("Response body does not contains market with country code: "
						+ prop_constants.getProperty("market_India"));
				Assert.fail("Response body does not contains market with country code: "
						+ prop_constants.getProperty("market_India"));
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Response body does not contains market with country code: " + prop_constants.getProperty("market"));
			Assert.fail("Response body does not contains market with country code: " + prop_constants.getProperty("market"));
		}
	}

	/**
	 * Description: This method is used to validate response body message
	 * 
	 * @author Abhishek
	 * @param message
	 */
	public synchronized static void validateResponseBodyMessage(String message) {
		try {
			boolean flag = false;
			if (message.contains(prop_constants.getProperty("errormsg_Service_not_found"))) {
				info("Response body contains error message: " + prop_constants.getProperty("errormsg_Service_not_found"));
				extentinfo(
						"Response body contains error message: " + prop_constants.getProperty("errormsg_Service_not_found"));
			} else {
				flag = true;
			}
			if (flag == true) {
				fail("Response body doses not contains error message: "
						+ prop_constants.getProperty("errormsg_Service_not_found"));
				error("Response body doses not contains error message: "
						+ prop_constants.getProperty("errormsg_Service_not_found"));
				Assert.fail("Response body doses not contains error message: "
						+ prop_constants.getProperty("errormsg_Service_not_found"));
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Response body doses not contains error message: "
					+ prop_constants.getProperty("errormsg_Service_not_found"));
			Assert.fail("Response body doses not contains error message: "
					+ prop_constants.getProperty("errormsg_Service_not_found"));
		}
	}

	/**
	 * Description: This method is used to validate the Response Body value using
	 * JSON path
	 * 
	 * @author Abhishek
	 * @param response
	 * @param jsonPath
	 * @param message
	 * @return actualResponseBodyValue
	 */
	public synchronized static String validateResponseBodyValue(Response response, String jsonPath, String message) {
		String actualResponseBodyValue = null;
		try {
			JsonPath path = new JsonPath(response.asString());
			actualResponseBodyValue = path.getString(jsonPath);
			if (actualResponseBodyValue.equals("null")) {
				Assert.fail("Response body contains null");
			} else {
				info("Response body contains " + message + ": " + actualResponseBodyValue);
				validationinfo("Response body contains " + message + ": " + actualResponseBodyValue, "blue");
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to validate Response body value using JSON path");
			Assert.fail("Unable to validate Response body value using JSON path");
		}
		return actualResponseBodyValue;

	}

	// 13-01-2022

	/**
	 * Description: This method is used to validate order of ids from response
	 * 
	 * @author Abhishek
	 * @param expectedOrder
	 * @param filePath
	 */
	public synchronized static void validateTheOrderOfIds(String expectedOrder, String filePath) {
		try {
			expectedOrder=expectedOrder.replaceAll("[^a-zA-Z0-9,]", "");
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			Object actualOrder = jsonObject.get(prop_constants.getProperty("ids"));
			System.out.println("Actual order: " + actualOrder.toString() + " Expected order: " + expectedOrder);
			Assert.assertTrue(expectedOrder.toString().contains(actualOrder.toString()),"");
			info("The order are matching");
			extentinfo("The order are matching");

		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to validate order of ids");
			Assert.fail("Unable to validate order of ids");
		}
	}

	// 14-01-2022

	/**
	 * Description: This method is used to validate the Response Body value using
	 * JSON path
	 * 
	 * @author Abhishek
	 * @param response
	 * @param jsonPath
	 * @param message
	 * @param filePath
	 * @param jsonKey
	 * @return actualResponseBodyValue
	 */
	public synchronized static void validateResponseBodyData(Response response, String jsonPath, String filePath,
			String jsonKey) {
		String actualResponseBodyValue = null;
		try {
			JsonPath path = new JsonPath(response.asString());
			actualResponseBodyValue = path.getString(jsonPath);
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			Object expectedValue = jsonObject.get(jsonKey);
			Assert.assertEquals(expectedValue, actualResponseBodyValue.toString());
			info("Actual value: " + jsonKey + " " + actualResponseBodyValue + " equals expected value: " + jsonKey + " "
					+ expectedValue);
			validationinfo("Actual value: " + actualResponseBodyValue + " equals expected value: " + expectedValue,
					"blue");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to validate Response body value using JSON path");
			Assert.fail("Unable to validate Response body value using JSON path");
		}
	}

	/**
	 * Description: This method is used to validate response body contains true or false
	 * 
	 * @author Abhishek
	 * @param response
	 */
	public synchronized static void validateResponseBody(Response response) {
		try {
			ResponseBody responseBody = response.getBody();
			if (responseBody.asString().contains("true")) {
				info("Response body contains true ");
				extentinfo("Response body contains true ");
			} else {
				info("Response body contains false ");
				extentinfo("Response body contains false ");
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Unable to validate response body value");
			Assert.fail("Unable to validate response body value");
		}
	}

	/**
	 * Description: This method is used to validate the contents in the response body.
	 * 
	 * @author Bredlin
	 * @param response
	 * @param expectedResponseBodyValue
	 * 
	 */
	public synchronized static void verifyContents(Response response, String expectedResponseBodyValue)
			throws IOException, Exception {
		try {
			String actualResponseBodyValue = response.body().asString();
			Assert.assertTrue(actualResponseBodyValue.contains(expectedResponseBodyValue));
			info("Expected value: " + expectedResponseBodyValue + " is present in the response body");
			extentinfo("Expected value: " + expectedResponseBodyValue + " is present in the response body");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Expected value: " + expectedResponseBodyValue + " is not present in the response body");
			Assert.fail(
					"Expected value: " + expectedResponseBodyValue + " is not present in the response body");
		}
	}

	/**
	 * Description: This method is used to validate the contents in the response body.
	 * 
	 * @author Bredlin
	 * @param response
	 * @param jsonPath
	 * @param expectedResponseBodyValue
	 * 
	 */
	public synchronized static void verifyContents(Response response, String jsonPath, String expectedResponseBodyValue)
			throws IOException, Exception {
		String actualResponseBodyValue = null;

		try {
			JsonPath path = new JsonPath(response.asString());
			actualResponseBodyValue = path.getString(jsonPath);
			Assert.assertTrue(actualResponseBodyValue.contains(expectedResponseBodyValue));
			info("Expected value: " + expectedResponseBodyValue + " is present in the response body");
			extentinfo("Expected value: " + expectedResponseBodyValue + " is present in the response body");
		} catch (Exception e) {
			error(e.getMessage());
			fail("Expected value: " + expectedResponseBodyValue + " is not present in the response body");
			Assert.fail(
					"Expected value: " + expectedResponseBodyValue + " is not present in the response body");
		}
	}

	/**
	 * Description: This method is used to validate response body value count.
	 * 
	 * @author Bredlin
	 * @param response
	 * @param pathParam
	 * @param queryParamKey
	 * @param filePath
	 * @param jsonPath
	 * 
	 */
	public synchronized static void validateResponseBodyValueCount(Response response, String pathParam,
			String queryParamKey, String filePath, String jsonPath) throws IOException, Exception {
		int actualSize = 0;
		int expectedSize = 0;
		try {
			String actualResponseBodyValue;
			String[] params = null;
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filePath));
			try {
				params = jsonObject.get(queryParamKey).toString().split(",");
				expectedSize = params.length;
				JsonPath path = new JsonPath(response.asString());
				actualResponseBodyValue = path.getString(jsonPath);
				actualSize = actualResponseBodyValue.split(",").length;
				Assert.assertEquals(expectedSize, actualSize);
				info("Actual ids: " + actualSize + " is equal to Expected ids:" + expectedSize);
				extentinfo("Actual ids: " + actualSize + " is equal to Expected ids:" + expectedSize);
			} catch (Exception e) {
				params = jsonObject.get(pathParam).toString().split(",");
				expectedSize = params.length;
				JsonPath path = new JsonPath(response.asString());
				actualResponseBodyValue = path.getString(jsonPath);
				actualSize = actualResponseBodyValue.split(",").length;
				Assert.assertEquals(expectedSize, actualSize);
				info("Actual ids: " + actualSize + " is equal to Expected ids:" + expectedSize);
				extentinfo("Actual ids: " + actualSize + " is equal to Expected ids:" + expectedSize);
			}
		} catch (Exception e) {
			error(e.getMessage());
			fail("Actual ids: " + actualSize + " is not equal to Expected ids:" + expectedSize);
			Assert.fail("Actual ids: " + actualSize + " is not equal to Expected ids:" + expectedSize);
		}
	}

}
