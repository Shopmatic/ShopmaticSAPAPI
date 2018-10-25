package currencies;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteCurrencyByID {
	
	String url = "https://world.myshopmaticbeta.com/api/currencies";
	String id="a719e747-8053-413a-aaf3-fd349012c5db";
	
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
