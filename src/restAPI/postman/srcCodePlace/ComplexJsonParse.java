package restAPI.postman.srcCodePlace;

import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payLoad.complexResponse());
		
		//Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println("No of courses :- "+count);

		//Print Purchase Amount
		int pAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount :- " +pAmount);

		//Print Title of the first course
		String FirstCourseTitle = js.getString("courses[0].title");
		System.out.println("First Course Title :- "+FirstCourseTitle);

		//Print All course titles and their respective Prices
		int curPrice = 0;
		for(int i=0;i<count;i++)
		{
			System.out.println(js.getString("courses["+i+"].title")+" :- " +js.getInt("courses["+i+"].price"));
			if(js.getString("courses["+i+"].title").equalsIgnoreCase("RPA"))
			{
				System.out.println("RPA Copies are :- "+js.getInt("courses["+i+"].copies"));   //Print no of copies sold by RPA Course
			}
			
			curPrice = (js.getInt("courses["+i+"].price")*js.getInt("courses["+i+"].copies")) + curPrice;
			System.out.println(curPrice);
		}
		
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		if(pAmount==curPrice)
		{
			System.out.println("******Sum of all Course prices matches with Purchase Amount******");
		}
		
		

	}

}
