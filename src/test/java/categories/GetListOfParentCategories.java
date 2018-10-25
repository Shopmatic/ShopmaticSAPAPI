package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetListOfParentCategories {
	
	String path = "/parent-categories";
	
	@Test
	public void testGetListOfCategories() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path);
		response.getBody().prettyPrint();
		JsonPath jsonPathEvaluator = response.jsonPath();

		if(response.getStatusCode()==200) {
			List<String> parentCategoryIds=jsonPathEvaluator.getList("parent_category_id");
			for(int i=0;i<parentCategoryIds.size();i++) {
				parentCategoryIds.get(i).contains("");
			}
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}
	
	

}
