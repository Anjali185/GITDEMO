package restAPI.postman.srcCodeSeria;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import files.ReUsableMethod;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddPlace_RequestPOJO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json").
		body(ap).when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		//Extracting response
		System.out.println(response);
		
		/*JsonPath js = ReUsableMethod.RawToJson(response);
		//JsonPath js = new JsonPath(response);
		String PlaceId = js.getString("place_id");  //placeid from json response is stored
		
		System.out.println(PlaceId);
		
		//Update Place
		
		String address = "70 winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body("{\r\n" + 
				"\"place_id\":\""+PlaceId+"\",\r\n" + 
				"\"address\":\""+address+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").
		when().put("maps/api/place/update/json").
		then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		System.out.println("SUCCESSFUL");
		
		//Get Place
		
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId).
		header("User-Agent","PostmanRuntime/7.24.1").
		when().get("maps/api/place/get/json").
		then().log().all().assertThat().statusCode(200).body("address", equalTo(address));
		
		System.out.println("Address Is Correct");*/

	}

}
