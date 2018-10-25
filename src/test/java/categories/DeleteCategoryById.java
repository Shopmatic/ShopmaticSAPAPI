package categories;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteCategoryById {
	
	String url = "https://api.myshopmaticbeta.com/categories";
	String id="8ae4a96c-55f2-406e-993c-d20d95897c7a";
	
	@Test
	public void testDeleteCategoryById() {
		Response response = given().
				header("content_language", "en-US").contentType("application/json").when().delete(url+"/"+id);
				
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			jsonPathEvaluator.get("message").toString().contains("successfully deactivated");
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}

}
