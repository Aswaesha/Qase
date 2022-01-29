package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class ProjectAdapter {

    public String getPr(int statusCode, String url) {

        return given().
                log().all().
                header("Token", "b59a076ef1c88370a9f1602208e9135430c9b3e1").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                when().
                get("https://api.qase.io/v1/project/" + url).
                then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();

    }

    //    public ResponseStatus post(Project project, int statusCode) {
//        String response = post(gson.toJson(project),statusCode , "project");
//        return  gson.fromJson(response, ResponseStatus.class);
//    }
//
//
//    public ResponseStatus getProject(int statusCode, String codeProject) {
//        String response = super.get(statusCode , "project/" + codeProject);
//        return  gson.fromJson(response, ResponseStatus.class);
//
//    }


}
