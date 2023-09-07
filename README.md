Education api

Running the app
- clone the repo git clone https://github.com/Abdullah8006/education-api.git
- run the class EducationApiApplication in your fav IDE

The swagger ui is accessible at http://localhost:8080/swagger-ui/index.html
There are some test data that is loaded when the app boots up

The URL for h2 database is http://localhost:8080/h2-console/login.do
username: sa
password: password

There are three different profiles
-dev
-test
-prod

A profile can be activated by updating **spring.profiles.active=dev** in the application.properties 

---

Note: JWT implementation is in a different branch jwt-implementation
