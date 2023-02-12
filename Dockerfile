FROM maven:3.8.6-openjdk-11-slim
WORKDIR /test
COPY src /test/src
COPY pom.xml /test/pom.xml
COPY runTest.sh /test/runTest.sh
RUN chmod +x /test/runTest.sh
ENTRYPOINT ["./runTest.sh"]
