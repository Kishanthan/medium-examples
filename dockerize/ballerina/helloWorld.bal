import ballerina/http;
import ballerina/log;
import ballerinax/docker;

@docker:Expose {}
listener http:Listener helloWorldEP = new(9090);

@docker:Config {
    name: "helloworld",
    tag: "v1.0"
}
service hello on helloWorldEP {

    resource function sayHello(http:Caller caller, http:Request req) {
        http:Response res = new;
        res.setPayload("Hello World from Ballerina !!!");

        var result = caller->respond(res);
        if (result is error) {
            log:printError("Error sending response", err = result);
        }
    }
}
