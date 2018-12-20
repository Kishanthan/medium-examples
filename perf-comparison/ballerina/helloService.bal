import ballerina/http;
import ballerina/log;

http:Client backEnd = new("http://localhost:8080/HelloApp/webapi/hello");

@http:ServiceConfig {
    basePath: "/"
}
service helloService on new http:Listener(9090) {

    @http:ResourceConfig {
        path: "/hello"
    }
    resource function hello(http:Caller caller, http:Request request) {
        http:Response outResponse = new;

        var backendResponse = backEnd->get("/ballerina");

        if (backendResponse is http:Response) {
            var result = caller->respond(untaint backendResponse);
            handleError(result);
        } else if (backendResponse is error) {
            outResponse.setPayload(untaint string.convert(backendResponse.detail().message));
            var result = caller->respond(outResponse);
            handleError(result);
        }
    }
}

function handleError(error? result) {
    if (result is error) {
        log:printError(result.reason(), err = result);
    }
}