package partner;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class GetListOfPartners {
	
	String path="/v1/partners";
	
	@Test
	public void getListOfPartners() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
	}

}
