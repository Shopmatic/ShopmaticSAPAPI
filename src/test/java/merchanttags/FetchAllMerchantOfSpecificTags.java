package merchanttags;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class FetchAllMerchantOfSpecificTags {
	
String path="/v1/tags-indices-with-data";
	
	@Test
	public void testFetchAllMerchantCategorizedIntoSpecificTags() throws IOException {
		Response response = given().get(GetURL.readToken()+path);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
	}

}
