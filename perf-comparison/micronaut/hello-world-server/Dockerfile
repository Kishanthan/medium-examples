FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/pass-through-servicer*.jar pass-through-service.jar
CMD java ${JAVA_OPTS} -jar pass-through-service.jar