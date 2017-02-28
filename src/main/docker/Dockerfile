FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD hazelcast-client-test-sample*.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]