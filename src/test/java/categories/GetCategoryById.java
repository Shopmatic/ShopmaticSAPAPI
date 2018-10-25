package categories;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetCategoryById {
	
	String url = "https://api.myshopmaticbeta.com/categories";
	String id="53ce2b7e-4713-4d24-bfb8-14cd872c2d1e";
	
	@Test
	public void testFindCategoryId() {
		Response response = given().
				get(url+"/"+id);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			jsonPathEvaluator.get("id").toString().contains(id);
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}

}
