package restAPI.postman.srcCodeSeria;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace ap = new AddPlace();  //class object created
		ap.setAccuracy(50);
		ap.setName("Frontline house");
		ap.setPhone_number("(+91) 983 893 3937");
		ap.setAddress("29, side layout, cohen 09");
		ap.setWebsite("http://google.com");
		ap.setLanguage("French-IN");
		
		List<String> listType = new ArrayList<String>();
		listType.add("shoe park");
		listType.add("shop");
		ap.setTypes(listType);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		ap.setLocation(l);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick")
				.setContentType("application/json").build(); 
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).
				expectContentType("application/json").build();
		
		
		RequestSpecification res1 = given().spec(req).body(ap);
		
		Response res2 = res1.when().post("/maps/api/place/add/json").
		then().spec(res).extract().response();
		
		//Extracting response
		System.out.println(res2.asString());
		

	}

}
