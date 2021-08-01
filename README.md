# Nagarjuna-NHSBSA

# NHS Advice using Selenium, BDD Framework, Java and Maven

It uses Selenium, Cucumber, JUnit and Maven.


---

# Set up #

1. Install Chrome and Gecko drivers
2. Install Java 8
3. Install Maven locally to run from command line
4. Add Maven dependencies for Selenium and Cucumber 
5. Add Maven Compiler and Sure fire plugins


# Running tests #

To run the test just call Maven at project's root with "clean compile test" command:
```
mvn clean compile test
```

## Tags ##
@NHSBSA

## HTML Report ##

target/htmlReport

## Run the Test in Mozilla or Firefox ##

Go to src\main\resources\config.properties and amend the browser to "mozilla" or "firefox" accordingly.

Run "TestRunner" using the Junit or from command line using "mvn clean compile test" from command prompt.

