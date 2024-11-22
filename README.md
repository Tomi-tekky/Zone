# Test Automation Framework

This project is a test automation framework built using Java, Maven, TestNG, and IntelliJ IDEA.

## Prerequisites

Before you begin, ensure you have the following software installed on your PC:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or later)
- [Apache Maven](https://maven.apache.org/install.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Git](https://git-scm.com/downloads)

## Setup Instructions

### 1. Clone the Repository

Open a terminal and run the following command to clone the repository:

```sh
git clone git@github.com:Tomi-tekky/Zone.git
```

### 2. Import the Project into IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click on `File` -> `Open`.
3. Navigate to the cloned repository directory and select it.
4. IntelliJ IDEA will detect the `pom.xml` file and prompt you to import the Maven project. Select `Import Maven`.

### 3. Configure Project SDK

1. Go to `File` -> `Project Structure`.
2. In the `Project Settings` section, select `Project`.
3. Ensure that the `Project SDK` is set to the installed JDK version.
4. Click `OK`.

### 4. Build the Project

Open the terminal in IntelliJ IDEA and run:

```sh
mvn clean install
```

### 5. Run Tests

To run the TestNG tests, follow these steps:

1. Navigate to the `src/test/java` directory.
2. Right-click on the test class or test method you want to run.
3. Select `Run 'TestClass'` or `Run 'testMethod'`.

Alternatively, you can run all tests using Maven:

```sh
mvn test
```

### Project Structure

- `src/main/java` - Contains the main application code.
- `src/test/java` - Contains the test classes.
- `pom.xml` - Maven project configuration file.
- - `testng.xml` - Contains the test suite.
