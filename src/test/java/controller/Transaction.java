package controller;

import com.github.javafaker.PhoneNumber;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.TransactionModel;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class Transaction extends Setup {

    private String message;

    public Transaction() throws IOException {
        initConfig();
    }

    //invalid agent phoneNumber
    public void depositeMoneyFromSystemWithInvalidPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", "019283635362", 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //valid agent phone number
    public void depositeMoneyWithSystemPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 5000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Agent_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //invalid amount
    public void depositeMoneyFromSystemInsufficientAmount() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 5);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //sufficient valid amount
    public void depositeMoneyFromSystemWithSufficient() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 100);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Agent_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //valid agent and invalid customer
    public void depositeMoneyAgentToCustomerWithInvalidPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transModel = new TransactionModel(agent_phone_number, "0343721931", 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());

        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //invalid agent number
    public void depositeMoneyInvalidAgentToCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transModel = new TransactionModel("0139238247", customer_Phone_Number, 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());

        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //valid agent and valid customer
    public void depositeMoneyAgentToCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_phone_number = prop.getProperty("Agent_phone_number");

        TransactionModel transModel = new TransactionModel(agent_phone_number, customer_Phone_Number, 2000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Customer_TrnxId", jsonResponse.get("trnxId").toString());

        String message = jsonResponse.get("message");
        setMessage(message);


    }

    //valid agent and invalid customer
    public void depositeMoneyAgentToInvalidCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_phone_number = prop.getProperty("Agent_phone_number");

        TransactionModel transModel = new TransactionModel(agent_phone_number, "03981371253", 200);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);


    }

    // Check customer balance with invalid customer phoneNumber
    public void checkCustomerBalanceWithInValidPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/01872347367");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // Check customer balance with valid customer phoneNumber
    public void checkCustomerBalanceWithValidPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/" + PhoneNumber);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    // Check statement with invalid transaction id
    public void checkStatementByInvalidTransactionId() {
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/TXN130111");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // Check statement with valid trasaction id
    public void checkStatementByValidTransactionId() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String TransactionId = prop.getProperty("Agent_TrnxId");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/" + TransactionId);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);


    }

    // Withdraw money by customer  to invalid agent phone number
    public void withdrawMoneyByCustomerToInvalidAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_Phone_Number, "01521332333", 1000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // Withdraw money by customer with valid agent phone number
    public void withdrawMoneyByCustomerTovalidAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_Phone_Number = prop.getProperty("Agent_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_Phone_Number, agent_Phone_Number, 60);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //Withdraw money by customer with Insufficient Balance
    public void withdrawMoneyByCustomerWithInsufficientBalance() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 5);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //Withdraw money by customer with Sufficient Balance
    public void withdrawMoneyByCustomerWithSufficientBalance() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 1000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // send money customer to agent
    public void sendMoneyCustomerToAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }


    //Send money customer to another customer with invalid phone number
    public void sendMoneyCustomerToCustomerWithInvalid_phnNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01293843734", 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //Send money to customer to another customer with valid phone number
    public void sendMoneyCustomerToCustomerWithvalid_phnNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //Send money customer to another customer with invalid amount
    public void sendMoneyCustomerToCustomerWithInvalidAmount() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 3);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    //Send money customer to another customer with valid amount
    public void sendMoneyCustomerToCustomerWithvalidAmount() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 500);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // Check Customer statement with invalid phoneNumber
    public void checkCustomerStatementWithInvalidPhoneNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/01881122334");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    // Check Customer statement with valid phoneNumber
    public void checkCustomerStatementWithValidPhoneNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/" + customer_phone_Number);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }
}
