package currencies;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetListOfCurrencies {
	
	String url = "https://world.myshopmaticbeta.com/api/currencies";
	
	@Test
	public void testGetListOfCurrencies() {
		Response response = given().
				get(url);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
	}


}
