package categories;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetListOfCategories {
	
	String url = "https://api.myshopmaticbeta.com/categories";
	
	@Test
	public void testGetListOfCategories() {
		Response response = given().
				get(url);
		Assert.assertEquals(response.getStatusCode(), 200);
		JsonPath jsonPathEvaluator = response.jsonPath();
		jsonPathEvaluator.toString().contains("parent_category_id");
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}
	
	

}
