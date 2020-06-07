package restAPI.postman.srcCodeOAuth;
import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.path.json.JsonPath;

public class OAuthAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//To get authorization code
		/*WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=ahrtftg");
		driver.findElement(By.xpath("//*[@id=\"profileIdentifier\"]")).click();*/
		String curURL = "https://rahulshettyacademy.com/getCourse.php?state=ahrtftg&code=4%2F0AGuL2HjVufjxLx0I_RfRVaH4NUSku2q63Vs3Tea0ay7H8XqNq2iyUT6J1gGPmGE9J7neKAkhAvxh9voA6Wx__s&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
		String partialString = curURL.split("code=")[1];
		String code = partialString.split("&scope")[0];
		System.out.println("CODE IS"+code);
		
		//To get access token
		String accessTokenResponse = given()
		.queryParams("code", code).urlEncodingEnabled(false)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		
		//To get list of courses using access token
		String response = given().queryParam("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php")
		.asString();
		
		System.out.println(response);

	}

}
