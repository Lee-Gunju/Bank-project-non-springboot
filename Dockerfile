# Use Maven for build
FROM maven:3.8.1-amazoncorretto-8 AS build

WORKDIR /app

# Copy source code and build
COPY . .
RUN mvn clean compile dependency:copy-dependencies

# Use Tomcat for deployment
FROM tomcat:9.0-jdk8

# Copy compiled classes and resources
COPY --from=build /app/src/main/webapp/ /usr/local/tomcat/webapps/ROOT/
COPY --from=build /app/target/classes/ /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/

# Manually copy dependencies to WEB-INF/lib
RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/lib
COPY --from=build /app/target/dependency/*.jar /usr/local/tomcat/webapps/ROOT/WEB-INF/lib/

# Expose port and run Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]