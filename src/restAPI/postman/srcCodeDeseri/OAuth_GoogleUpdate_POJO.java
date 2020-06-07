package restAPI.postman.srcCodeDeseri;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class OAuth_GoogleUpdate_POJO {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub


	String[] courseList = {"Selenium Webdriver Java","Cypress","Protractor"};
	String url ="https://rahulshettyacademy.com/getCourse.php?state=ahrtftg&code=4%2F0AFMVIH6mKVvPy9c7GwHZRwiqSwUT7qVJ3cxBGDLcSNO_34oCdtEjepw4PRpeM82OuLagcZ6xBnfstUzPgX8ALM&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
	//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=ahrtftg
	
	String partialcode=url.split("code=")[1];
	String code=partialcode.split("&scope")[0];
	System.out.println(code);
	String response =given().urlEncodingEnabled(false).queryParams("code",code)
			.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.queryParams("grant_type", "authorization_code")
			.queryParams("state", "verifyfjdss")
			.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
			.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
			.when().log().all()
			.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath jsonPath = new JsonPath(response);
		String accessToken = jsonPath.getString("access_token");
		System.out.println(accessToken);

		GetCourses gc=given().contentType("application/json")
				.queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
				.when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourses.class);

		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getInstructor());
		
		//to print price of "SoapUI Webservices testing" api course
		System.out.println(gc.getCourses().getApi().get(1).getPrice());
		
		int apiCount = gc.getCourses().getApi().size();
		

		for(int i=0;i<apiCount;i++)
		{
			if(gc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
				System.out.println(gc.getCourses().getApi().get(i).getPrice());
					}
		}
		
		ArrayList<String> retrievedCourse = new ArrayList<String>();
		
		int webCount = gc.getCourses().getWebAutomation().size();
		for(int j=0;j<webCount;j++)
		{
			retrievedCourse.add(gc.getCourses().getWebAutomation().get(j).getCourseTitle());
		}
		
		List<String> expectedCourses = Arrays.asList(courseList);
		Assert.assertTrue(retrievedCourse.equals(expectedCourses));
		
		System.out.println("Everything is SUCCESSFUL");


}



}