package partner;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class GetPartnerDetailsByID {
	
	String path="/v1/partners";
	String id="574312ca-bf76-4ab3-bd4a-5dedcdb5dc28";
	
	@Test
	public void getPartnerDetailsById() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path+"/"+id);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.getBody().toString().contains(id);
		response.prettyPrint();
	}

}
