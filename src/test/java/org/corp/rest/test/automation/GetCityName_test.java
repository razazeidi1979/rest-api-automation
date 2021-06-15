package org.corp.rest.test.automation;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetCityName_test {
	@Test
	public void getweatherByCityName()
	{
		 String API_KEY = "96d3f7328d7b85b004da63899c8f3f08";
	     String City_Name = "Langhorne";

	    //base URI
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
		
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response Object
		Response response=httpRequest.request(Method.GET,"?q="+City_Name+"&appid="+API_KEY);
		
		//Print Response body
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is: "+responseBody);
		
		//print status code
		System.out.println(response.getStatusCode());
		
		//Verify City Name
		JsonPath jsonpath=response.jsonPath();
		System.out.println("CityName: "+jsonpath.get("name"));
		Assert.assertEquals(responseBody.contains(City_Name),true);

	}
}
