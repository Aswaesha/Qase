package tests;


import adapters.ProjectAdapter;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void negativeGetProjectTest() {
        String actual = new ProjectAdapter().getPr(404, "!!!!");
        assertEquals(actual, "{\"status\":false,\"errorMessage\":\"Project code is invalid\"}");

    }

    @Test
    public void emptyGetProjectTest() {
        String actual = new ProjectAdapter().getPr(200, "GOLDPROJEC");
        assertEquals(actual, "{\"status\":true,\"result\":{\"title\":\"GoldProjectWithoutCase\",\"code\":\"GOLDPROJEC\",\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}}");

    }

    @Test
    public void caseGetProjectTest() {
        String actual = new ProjectAdapter().getPr(200, "GOLDPROJO");
        assertEquals(actual, "{\"status\":true,\"result\":{\"title\":\"GoldProjectWithOneCase\",\"code\":\"GOLDPROJO\",\"counts\":{\"cases\":1,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}}");

    }


//    @Test
//    public void negativeApiTest() {
//       // {"title" : "BlaBla", "code" : "!!!!"}
//        Project project = Project.builder().
//                title("BlaBla")
//                .code("!!!!")
//                .build();
//        ResponseStatus actual = new ProjectAdapter().post(project,422);
//        ResponseStatus expected = ResponseStatus.builder()
//                         .status(false)
//                         .errorMessage("Data is invalid.")
////                         .errorFields(ErrorFields.builder()
////                                 .field("code")
////                                 .error("Project code can contain only latin alphabet symbols.")
////                                 .build())
//                         .build();
//
//        assertEquals(actual, expected);
//       // assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
//    }

//    @Test
//    public void getProjectTest(){
//        Project project = Project.builder().
//                title("BlaBla")
//                .code("!!!!")
//                .build();
//       ResponseStatus response = new ProjectAdapter().getProject(200,"QWERTFF");
//        System.out.println(response);
//
//        String actual = new ProjectAdapter().getProject(200,"QWERTFF");
//
//    }


    //    @Test
//    public void positiveApiTest() {
//      //  "{\"title\" : \"ForApiTestP\", \"code\" : \"QWERTB\"}"
//        Project project = Project.builder().
//                title("ForApiTest")
//                .code("QWERTFF")
//                .build();
//        ResponseStatus actual = new ProjectAdapter().post(project,200);
//
//        assertEquals(actual,"{\"status\":true,\"result\":{\"code\":\"QWERTFF\"}}");
//
//
//    }
}


