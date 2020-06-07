package restAPI.postman.srcCodeJira;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.ReUsableMethod;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraSrcCode {
	
	@Test
	public void jiraCode()
	{
		String actualComment = "Retested Issue and it still exists";
		int defId=10306;
		
		RestAssured.baseURI="http://localhost:8082";
		SessionFilter session = new SessionFilter();
		
		//Jira authentication with Cookie
		given().log().all().header("Content-Type","application/json").
		body(payLoad.JiraAuth()).filter(session).
		when().post("rest/auth/1/session").
		then().log().all().assertThat().statusCode(200);
		
		//To create a issue/defect
		/*
		 * String createDefectRes =
		 * given().log().all().header("Content-Type","application/json").
		 * body(payLoad.JiraIssueCreation()).filter(session).
		 * when().post("rest/api/2/issue").
		 * then().log().all().assertThat().statusCode(201).extract().response().asString
		 * ();
		 */
		
		//Extract defect id from response of create defect and pass that defectid in add comment
		//JsonPath js1 =ReUsableMethod.RawToJson(createDefectRes);
		//int defId = js1.getInt("id");
		System.out.println("*******************Defect Id is "+defId);
		
		//To add a comment
		String addCommRes = given().log().all().header("Content-Type","application/json").pathParam("key", defId).filter(session).
		body(payLoad.JiraAddComment(actualComment)).
		when().post("rest/api/2/issue/{key}/comment").
		then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		//Extract id of the comment added 
		JsonPath js2 = ReUsableMethod.RawToJson(addCommRes);
		int defCommId = js2.getInt("id");
		System.out.println("*******************Comment Id is "+defCommId);
		
		
		
		//To add attachment
		given().log().all().header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data").
		pathParam("key", defId).multiPart("file",new File("jira.txt")).filter(session).
		when().post("rest/api/2/issue/{key}/attachments").
		then().log().all().assertThat().statusCode(200);
		
		//To GET issue details

		String getIssRes = given().log().all().pathParam("key", defId).filter(session).//queryParams("fields", "comment").
		when().get("rest/api/2/issue/{key}").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		//Extract particular comment
		JsonPath js3 = ReUsableMethod.RawToJson(getIssRes);
		int commCount = js3.getInt("fields.comment.comments.size()");
		
		for(int i =0;i<commCount;i++)
		{
			if(defCommId ==js3.getInt("fields.comment.comments.id["+i+"]"))
			{
				Assert.assertEquals(actualComment, js3.getString("fields.comment.comments.body["+i+"]"));
				System.out.println("*******COMMENTS ADDED ARE SAME********");
			}
		}

		
		
	}

}
