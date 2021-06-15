package org.corp.rest.test.automation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetByZipCode_test {
	
		@Test(dataProvider="Zipcode_Data")
		public void getweatherDetails_ByZipCode(String zipcode, String City_Name)
		{
			 String API_KEY = "96d3f7328d7b85b004da63899c8f3f08";
		   //  String City_Name = "Mountain View";
		     //int zipcode=94040;

		     //base URI
			RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
			
			//Request object
			RequestSpecification httpRequest=RestAssured.given();
			
			//Response Object
			Response response=httpRequest.request(Method.GET,"?q="+zipcode+"&appid="+API_KEY);
			
			//Print Response body
			String Response=response.getBody().asString();
			System.out.println("Response Body is: "+Response);
			
			//Verify City Name
			System.out.println("ZipCode : "+zipcode);

			JsonPath jsonpath=response.jsonPath();
			System.out.println("CityName: "+jsonpath.get("name"));
			Assert.assertEquals("City Name",City_Name, jsonpath.get("name"));
			
	}
		@DataProvider(name="Zipcode_Data")
		String [][] getData()
		{
			String data[][]= {{"94040","Mountain View"},{"10007","New York"}};
			return (data);
		}

}
