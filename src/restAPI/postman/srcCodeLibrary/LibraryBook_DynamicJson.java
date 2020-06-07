package restAPI.postman.srcCodeLibrary;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import files.ReUsableMethod;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;

public class LibraryBook_DynamicJson {
	
	
	@Test(dataProvider="BookData")
	public void AddBook(String bName,String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().headers("Content-Type", "application/json").body(payLoad.AddBookJson(bName,isbn,aisle)).
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
	
	//use DataProvider of TestNG to pass the values to JSON
	@DataProvider (name="BookData")
	public Object[][]  getData()
	{
		return new Object[][] {{"App Mech29","apptggmech","78569"},
			{"Nursary20","nutr","321"},
			{"Jr KG20","jrtkg","66"},
			{"Att20","httr","35"}};
	}

}
