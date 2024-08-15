import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static pageObject.CONSTANT.*;

public class UserApiSteps {

    public static RequestSpecification requestSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL_MAIN_PAGE);
    }

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUserApi user) {
        return requestSpec()
                .body(user)
                .when()
                .post(CREATE_USER)
                .then().log().all();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(DeleteUserApi deleteUser) {
        return requestSpec()
                .headers(
                        "Authorization", deleteUser.getUserToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .body(deleteUser)
                .when()
                .delete(DELETE_USER)
                .then().log().all();
    }
}
