import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

public class UserApiPull {

    @Step("Успешное удаление")
    public void checkRemoveOk(ValidatableResponse response) {
        response
                .statusCode(202)
                .assertThat().body("success", Matchers.equalTo(true));
    }
}
