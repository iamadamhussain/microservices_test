# Combined Microservices Project

This repository contains two microservices: **service-shuffle** and **service-log**. Follow the steps below to build and run the project.

---

## Prerequisites
- Java 11 or later installed
- Maven installed

---

## Build and Run

### Step 1: Build the Project
Run the following command in the root directory to build both microservices:
```bash
mvn clean install
Step 2: Run the Services
2.1 Run ServiceShuffle

    Navigate to the service-shuffle directory:

cd service-shuffle

Run the ServiceShuffleApplication class:

mvn spring-boot:run

Service will start on port 8080.
Test the shuffle API with the following details:

    POST URL: http://localhost:8080/api/shuffle
    Request Body:

        {
          "number": 2
        }

2.2 Run ServiceLog

    Navigate to the service-log directory:

cd service-log

Run the ServiceLogApplication class:

    mvn spring-boot:run

    Service will start on port 8081.

Notes

    Ensure that ports 8080 and 8081 are not in use before starting the services.
