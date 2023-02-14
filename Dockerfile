FROM maven:3.9.0-openjdk-11-slim
WORKDIR /test
COPY src /test/src
COPY pom.xml /test/pom.xml
COPY runTest.sh /test/runTest.sh
RUN chmod +x /test/runTest.sh
RUN mvn dependency:go-offline test-compile
ENTRYPOINT ["./runTest.sh"]
CMD ["http://localhost:4444"]
