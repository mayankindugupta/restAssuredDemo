package changeResource;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Delete_PutExample {
	
	@Test
	public void testPost()
	{
		//Declaring the request specification
		RequestSpecification req = RestAssured.given();
		
		//request header declaration in which content type is declared
		req.headers("Content-Type","application/json");
		
		//defining the req body in json form using JSONObject
		JSONObject json = new JSONObject();
		json.put("id", "valID");
		json.put("title", "valTitle");
		json.put("author", "valAuther");
		
		// declaring request body with passing Json object as string
		req.body(json.toJSONString());
		
		// getting the response from POST operation
		Response res = req.post("http://localhost:3000/posts");
		
		//get the status code
		int code = res.getStatusCode();
		
		//asserting the output
		Assert.assertEquals(code, 201);
	}
	
	@Test
	public void testPut()
	{
		//Declaring the request specification
		RequestSpecification req = RestAssured.given();
		
		//request header declaration in which content type is declared
		req.headers("Content-Type","application/json");
		
		//defining the req body in json form using JSONObject
		JSONObject json = new JSONObject();
		json.put("id", "valID");
		json.put("title", "valTitle1");
		json.put("author", "valAuther1");
		
		// declaring request body with passing Json object as string
		req.body(json.toJSONString());
		
		// getting the response from PUT operation. URL should be with full resource path
		Response res = req.put("http://localhost:3000/posts/25");
		
		//get the status code would 200 bcz it's not creating any new resource
		int code = res.getStatusCode();
		
		//asserting the output
		Assert.assertEquals(code, 200);
	}
	
	
	@Test //for delete only specification and resource url are enough to execute
	public void testDelete()
	{
		// Declaring the request specification
		RequestSpecification req = RestAssured.given();
		
		// getting the response from DELETE operation
		Response res = req.post("http://localhost:3000/posts/21");
		
		//get the status code
		int code = res.getStatusCode();
		
		//asserting the output
		Assert.assertEquals(code, 200);
	}
	
	//int code = RestAssured.given().auth().preemptive().basic("UserID", "PSWD").when().get("http://localhost:3000/posts").getStatusCode();
	
/*	under baseclass
	public void setUP()
	{
		RestAssured.authentication = RestAssured.preemptive().basic("UserID", "PSWD");
		RestAssured.baseURI = "http://localhost:3000/posts";
	}
	
	testclass extends baseclass{
		@test
		void test() {
			int code = RestAssured.given().get().getStatusCode();
		}
	}
*/
}

/*package getRequest;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
//import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testResponseCode()
	{
		Response resp =  RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		int code = resp.getStatusCode();
		
		System.out.println("Status code : "+code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void testBody()
	{
		Response resp =  RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		String respBody = resp.asString();
		
		System.out.println("Response Body : "+respBody);
	}

	@Test
	public void testResponseTime()
	{
		Response resp =  RestAssured.get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		long time = resp.getTime();
		
		System.out.println("Response Time : "+time);
	}
}
*/