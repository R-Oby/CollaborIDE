FROM eclipse-temurin:25-jdk-ubi10-minimal AS maven-downloader
RUN microdnf install -y tar gzip && \
    curl -fsSL https://archive.apache.org/dist/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz \
    -o /tmp/maven.tgz && \
    tar -xzf /tmp/maven.tgz -C /opt && \
    ln -s /opt/apache-maven-3.9.9/bin/mvn /usr/local/bin/mvn

FROM eclipse-temurin:25-jdk-ubi10-minimal AS build
COPY --from=maven-downloader /opt/apache-maven-3.9.9 /opt/maven
ENV PATH="/opt/maven/bin:$PATH"
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:25-jre-ubi10-minimal
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]