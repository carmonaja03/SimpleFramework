package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RoninApiSteps {
    private Response response;

    @Given("^user gets staked address from \"(.*)\"")
    public void userGetsStakedTokenByAddress(String token) {
        response = RestAssured.given().when()
                .get("https://ronin.rest/katana/pools/"+token+"")
                .then().statusCode(200).log().ifError().extract().response();
        System.out.println(response.asString());
    }

    @Then("^user displays total AXS staked$")
    public void userDisplaysTotalAXSStaked() {
        String staked = response.then().extract().jsonPath().get("axs-staking.my_stake").toString();
        System.out.println("Total staked: "+staked);
    }
}
