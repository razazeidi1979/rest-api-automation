package org.corp.rest.test.automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetByLatLon_test {
	@Test
	public void getweatherDetails_ByCoordinates()
	{
		 String API_KEY = "96d3f7328d7b85b004da63899c8f3f08";
		 String lat="40.7143";
		 String lon="-74.006";
	 
	     //base URI
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"?lat="+lat+"&lon="+lon+"&appid="+API_KEY);

		//Print Response body
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body is: "+ResponseBody);

		JsonPath jsonpath=response.jsonPath();
		System.out.println("City_Name: "+jsonpath.get("name"));
		
		//verify Latitude:
		System.out.println("Latitude: "+jsonpath.get("coord.lat"));
		Assert.assertEquals(ResponseBody.contains(lat),true);

		//verify Longitude:
		System.out.println("Longitude: "+jsonpath.get("coord.lon"));
		Assert.assertEquals(ResponseBody.contains(lon),true);


}
}