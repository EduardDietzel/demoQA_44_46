package api;

import api.schemas.RegistrationDto;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class RegistrationApi extends ApiBase {

    Response response;
    RegistrationDto dto;
    Faker faker = new Faker();

    public RegistrationDto randomDataBodyForRegistration(String password) {
        dto = new RegistrationDto();
//        dto.setUserName(faker.name().username());
//        dto.setPassword("z6oBkW");
        dto.setUserName(faker.name().username());
        // dto.setPassword("yA*UeeuA2pU3");
        dto.setPassword(password);
        return dto;
    }

    public Response registerUser(Integer code, String password) {
        String endpoint = "/Account/v1/User";
        response = postRequest(endpoint, code, randomDataBodyForRegistration(password));
        return response;
    }
}
