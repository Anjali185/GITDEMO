package restAPI.postman.srcCodeLibrary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import files.ReUsableMethod;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LibraryBook_StaticJson {
	
	@Test
	public void AddBook() throws IOException
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().headers("Content-Type", "application/json").
		body(GenerateStringFromResource("E:\\API Training DOCs_POSTMAN\\AddBookDetails.json")).   //path of json file is provided
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
		
		JsonPath js = ReUsableMethod.RawToJson(response);
		String Id = js.getString("ID");
		System.out.println("Book ID is "+Id);
		
		//Delete Book API
		given().log().all().headers("Content-Type", "application/json").body(payLoad.DeleteBookJson(Id)).
		when().post("Library/DeleteBook.php").
		then().log().all().assertThat().statusCode(200);
		System.out.println("**************Deleted Book**********");
	}
	
	
	//method to read json file
	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	

}
