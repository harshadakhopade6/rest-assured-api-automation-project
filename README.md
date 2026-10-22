# REST Assured API Automation

A Java API testing project using REST Assured and TestNG to validate requests and responses from the public [JSONPlaceholder](https://jsonplaceholder.typicode.com/) posts API.

## Technology stack

- Java 17
- REST Assured 5.5.6
- TestNG 7.11.0
- Maven
- Jackson Databind

## Test scenarios

The current `PostTests.java` contains tests for:

| HTTP operation | Scenario | Assertions visible in the test |
|---|---|---|
| GET | Retrieve one post by ID | Status code, post ID, user ID, title presence |
| GET | Retrieve all posts | Status code and non-empty list |
| POST | Create a post | Status code and returned fields |
| PUT | Replace a post | Status code and updated title/body |
| PATCH | Partially update a post | Status code and updated title |
| DELETE | Delete a post | Status code |

JSONPlaceholder is a demo API. Write operations simulate changes and do not provide a durable database for test data.

## Project structure

```text
.
├── java/
│   ├── models/Post.java
│   ├── pages/PostAPI.java
│   └── tests/PostTests.java
├── resources/
├── pom.xml
└── README.md
```

The repository currently uses a non-standard Maven source layout (`java/` rather than `src/main/java` and `src/test/java`). The Maven configuration and Java source placement should be aligned before relying on a conventional `mvn test` workflow in a fresh clone.

## Prerequisites

- JDK 17
- Maven
- Network access to JSONPlaceholder

## Current status

The Java source demonstrates REST Assured request methods and TestNG response assertions. The current POM defines dependencies and Java 17 properties, but this repository has not been executed in this review environment; no passing build or test result is claimed.

## Suggested next improvements

1. Move production classes to `src/main/java` and test classes to `src/test/java`, or explicitly configure Maven for the existing layout.
2. Add a reproducible TestNG/Maven test configuration.
3. Add assertions for response content types and relevant headers where appropriate.
4. Add environment-driven base URL configuration.
5. Run the suite from a clean clone and publish verified test results.

## Related project

[REST Assured API Automation overview](https://github.com/harshadakhopade6/rest-assured-api-automation)

## Author

**Harshada Khopade** · [GitHub profile](https://github.com/harshadakhopade6) · [LinkedIn](https://www.linkedin.com/in/harshadakhopade/)
