import ballerina/http;
  
http:Client nettyEP = new("http://localhost:8688/backend");

@http:ServiceConfig {basePath:"/"}
service passthroughService on new http:Listener(9090) {
    @http:ResourceConfig {
        path:"/passthrough"
    }
    resource function passthrough(http:Caller caller, http:Request clientRequest) {
        var response = nettyEP -> forward("/", clientRequest);

        if (response is http:Response) {
       	    var result = caller -> respond(response);
        } else {
            http:Response res = new;
            res.statusCode = 500;
            res.setPayload(<string> response.detail().message);
            var result = caller->respond(res);
        }
    }
}

