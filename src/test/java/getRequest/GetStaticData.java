package getRequest;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetStaticData {
	
	@Test
	public void test1ResponseCode()
	{
		Response resp =  get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		int code = resp.getStatusCode();
		
		System.out.println("Status code : "+code);
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void test2Body()
	{
		Response resp =  get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		String respBody = resp.asString();
		
		System.out.println("Response Body : "+respBody);
	}

	@Test
	public void test3ResponseTime()
	{
		Response resp =  get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=a7173ac2af0732e8dde2d21a7b524f73");
		
		long time = resp.getTime();
		
		System.out.println("Response Time : "+time);
	}
}
