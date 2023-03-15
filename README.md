# Dmoney-API-Testing-with-Rest-Assured

## Scenerio:
1. Call login API
2. Create  a new customer and an agent
3. Search by the customer phone number
4. Deposit 5000 tk to the Agent from system
5. Deposit 2000 tk by agent to customer 
6. Check balance of customer
7. Check statement by trnxId 
8. Withdraw 1000 tk by customer and assert expected balance
9. Send 500 tk to another customer and assert expected balance
10. Check customer statement

## Technology and Tool Used:
- Rest-assured
- TestNG
- Java
- Gradle
- intellij idea
- jackson-databind
- Allure
- lombok
## Prerequisite
- JDK 8 or higher
- java IDE
- configure JAVA_HOME and GRADLE_HOME

## How to run this project:
- Clone this project
- Hit the following command: gradle clean test
## Command for Allure Report
- After run the project give the following command for generate Allure Report
`     -- allure generate allure-results --clean -o allure-report
      -- allure serve allure-results
      
## Test cases:
  - Link: https://docs.google.com/spreadsheets/d/1z_YRpaBWZZ0RfGorGzfLSb2ToxBJe3mEZ47jQ7PEjgA/edit?usp=sharing
      
 ## Allure Reports: 
 ![allureReport1](https://user-images.githubusercontent.com/78273243/225321042-8a85f3f5-4446-456d-a92a-0f500faa45ef.png)
 
 ![allureReport2](https://user-images.githubusercontent.com/78273243/225321302-197d7926-7592-4dd3-8164-823d6d06856c.png)

## Gradle Report: 
![testRunnerGradleReport](https://user-images.githubusercontent.com/78273243/225321828-b1f3bcf2-ea85-487b-8748-ca814731d350.png)
![userRunnerReportGradle](https://user-images.githubusercontent.com/78273243/225321853-30e4a3b0-57b6-4297-b99d-0064b7d20f64.png)
![transReportGradle](https://user-images.githubusercontent.com/78273243/225322391-a161dca1-1743-4af9-be34-d3f172536a89.png)

## TestRunner:
User Test Runner:
![UserTestRunner](https://user-images.githubusercontent.com/78273243/225322784-c3679b36-25c4-449d-9ade-d91a6c62da81.png)
Transaction Test Runner:
![TransactionTestRunner](https://user-images.githubusercontent.com/78273243/225321927-c9d5cdfa-5505-4411-9997-b8ae2914b2d4.png)

## Video Output:
https://user-images.githubusercontent.com/78273243/225323343-a3b59651-32ea-414e-959c-f6d9e922e55a.mp4

