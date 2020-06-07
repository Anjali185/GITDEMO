package files;

public class payLoad {
	
	public static String requestBody()
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
	}
	
	public static String complexResponse()
	{
		return "{\r\n" + 
				"\r\n" +
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 5710,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Appium\",\r\n" + 
				"\r\n" + 
				"\"price\": 78,\r\n" + 
				"\r\n" + 
				"\"copies\": 5\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 98\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
	}
	
	public static String AddBookJson(String bname,String isbn,String aisle)
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"name\":\""+bname+"\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String DeleteBookJson(String Id)
	{
		return"{\r\n" + 
				"\"ID\" : \""+Id+"\"\r\n" + 
				"}";
	}
	
	public static String JiraAuth()
	{
		return "{ \"username\": \"anjalirdeshmukh\", \"password\": \"Mangalwedha@123\" }";
	}
	
	public static String JiraIssueCreation()
	{
		return "{\r\n" + 
				"\r\n" + 
				"\"fields\":\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"       \"project\":\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"          \"key\": \"JA\"\r\n" + 
				"\r\n" + 
				"        },\r\n" + 
				"\r\n" + 
				"       \"summary\": \"Attachment Bug123\",\r\n" + 
				"\r\n" + 
				"       \"description\": \"Creating my first bug5\",\r\n" + 
				"\r\n" + 
				"       \"issuetype\":\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"\r\n" + 
				"       }\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"";
	}
	
	public static String JiraAddComment(String comment)
	{
		return"{\r\n" + 
				"    \"body\": \""+comment+"\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
	}


}
