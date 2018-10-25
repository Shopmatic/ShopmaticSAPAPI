package currencies;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetCurrencyDetailByID {
	String url = "https://world.myshopmaticbeta.com/api/currencies";
	String id="a719e747-8053-413a-aaf3-fd349012c5db";
	
	@Test
	public void testGetCurrencyDetailByID() {
		Response response = given().
				get(url+"/"+id);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		response.getBody().toString().contains(id);
	}

}
