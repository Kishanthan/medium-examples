FROM golang:latest 
RUN mkdir /app 
ADD go-http-service.go /app/ 
WORKDIR /app 
RUN CGO_ENABLED=0 GOOS=linux go build -o hello .
EXPOSE 8080
CMD ["/app/hello"]
