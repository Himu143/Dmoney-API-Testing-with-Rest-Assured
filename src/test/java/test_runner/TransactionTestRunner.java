package test_runner;

import controller.Transaction;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.IOException;

public class TransactionTestRunner extends Setup {
    Transaction transaction;

    @Test(priority = 1, description = "Deposit money from sysmem with invalid agent Phone number")
    public void depositeMoneyFromAgentWithInvalidPhoneNumber() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyFromSystemWithInvalidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));

    }

    @Test(priority = 2, description = "Deposit money from system with valid agent Phone number")
    public void depositeMoneyFromAgentWithValidPhoneNumber() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyWithSystemPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));

    }

    @Test(priority = 3, description = "Deposit money from system with less than 10 Taka")
    public void depositeMoneyFromAgentWithInsufficientAmount() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyFromSystemInsufficientAmount();
        Assert.assertTrue(transaction.getMessage().contains("Minimum deposit amount 10 tk and maximum deposit amount 10000 tk"));

    }

    @Test(priority = 4)
    public void depositeMoneyFromAgentWithSufficentAmount() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyFromSystemWithSufficient();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));

    }

    @Test(priority = 6, description = "Deposit money from invalid agent to customer")
    public void depositeMoneyInvalidAgentToCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyInvalidAgentToCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 7, description = "  Deposit 2000 tk by valid agent to valid customer ")
    public void depositeMoneyAgentToCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyAgentToCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Deposit successful"));
    }

    @Test(priority = 8, description = "Deposit money from agent to invalid customer")
    public void depositeMoneyAgentToInvalidCustomer() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.depositeMoneyAgentToInvalidCustomer();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 9, description = "Check customer balance with valid phone number")
    public void checkCustomerBalanceWithInValidPhoneNumber() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.checkCustomerBalanceWithInValidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }

    @Test(priority = 10, description = "Check customer balance with valid phone number")
    public void checkCustomerBalanceWithValidPhoneNumber() throws IOException, ConfigurationException {
        transaction = new Transaction();
        transaction.checkCustomerBalanceWithValidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("User balance"));
    }

    @Test(priority = 11, description = "Check statement with invalid transaction Id")
    public void checkStatementByInvalidTransactionId() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementByInvalidTransactionId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction not found"));
    }

    @Test(priority = 12, description = "Check statement with valid transaction Id")

    public void checkStatementByValidTransactionId() throws IOException {
        transaction = new Transaction();
        transaction.checkStatementByValidTransactionId();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

    @Test(priority = 13, description = "Withdraw money by customer to invalid agent phone number")
    public void withdrawMoneyByCustomerToInvalidAgent() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyByCustomerToInvalidAgent();
        Assert.assertTrue(transaction.getMessage().contains("Account does not exist"));
    }

    @Test(priority = 14, description = "Withdraw money by customer to valid agent phone number")
    public void withdrawMoneyByCustomerTovalidAgent() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyByCustomerTovalidAgent();
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }

    @Test(priority = 15, description = "Withdraw money by customer with insufficient amount")
    public void withdrawMoneyByCustomerWithInsufficientBalance() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyByCustomerWithInsufficientBalance();
        Assert.assertTrue(transaction.getMessage().contains("Minimum withdraw amount 10 tk"));
    }

    @Test(priority = 16, description = "Withdraw money by customer with sufficient balance")
    public void withdrawMoneyByCustomerWithSufficientBalance() throws IOException {
        transaction = new Transaction();
        transaction.withdrawMoneyByCustomerWithSufficientBalance();
        Assert.assertTrue(transaction.getMessage().contains("Withdraw successful"));
    }

    @Test(priority = 17, description = "Send money customer to agent number")
    public void sendMoneyCustomerToAgent() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToAgent();
        Assert.assertTrue(transaction.getMessage().contains("From/To account should not be an agent account"));
    }

    @Test(priority = 18, description = "Send money customer to another customer with invalid phone number")
    public void sendMoneyCustomerToCustomerWithInvalid_phnNumber() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithInvalid_phnNumber();
        Assert.assertTrue(transaction.getMessage().contains("From/To Account does not exist"));
    }

    @Test(priority = 19, description = "Send money customer to another customer with valid phone number")
    public void sendMoneyCustomerToCustomerWithvalid_phnNumber() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithvalid_phnNumber();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }

    @Test(priority = 20, description = "Send money to another customer with invalid amount")
    public void sendMoneyCustomerToCustomerWithInvalidAmount() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithInvalidAmount();
        Assert.assertTrue(transaction.getMessage().contains("Minimum amount 10 tk"));
    }

    @Test(priority = 21, description = "Send money to another customer ")
    public void sendMoneyCustomerToCustomerWithvalidAmount() throws IOException {
        transaction = new Transaction();
        transaction.sendMoneyCustomerToCustomerWithvalidAmount();
        Assert.assertTrue(transaction.getMessage().contains("Send money successful"));
    }

    @Test(priority = 22, description = "Check customer statement with invlid customer phoneNumber")
    public void checkCustomerStatementWithInvalidPhoneNumber() throws IOException {
        transaction = new Transaction();
        transaction.checkCustomerStatementWithInvalidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("User not found"));
    }

    @Test(priority = 23, description = "Check customer statement with vlid customer phoneNumber")
    public void checkCustomerStatementWithValidPhoneNumber() throws IOException {
        transaction = new Transaction();
        transaction.checkCustomerStatementWithValidPhoneNumber();
        Assert.assertTrue(transaction.getMessage().contains("Transaction list"));
    }

}
