package services;

import Exceptions.AccountNotFoundException;
import Exceptions.IllegalAmountException;
import Exceptions.NegativeAmountException;
import model.Account;
import model.Operation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
    }

    public final static LocalDate today = LocalDate.now();
    public final static List<Operation> operations = new ArrayList<Operation>(
            Arrays.asList(new Operation("deposit", 20, today, 2000)));


    public static List<Account> accounts = new ArrayList<Account>(
            Arrays.asList(new Account(1, 10000, "DIF", "Rayene", operations),
                    new Account(2, 10000, "DIF", "NOUR", operations)
            ));

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static LocalDate getToday() {
        return today;
    }

    public static List<Operation> getOperations() {
        return operations;
    }

    public static void setAccounts(List<Account> accounts) {
        AccountServiceImpl.accounts = accounts;
    }

    @Override
    public void deposit(long accountNumber, Operation op) throws NegativeAmountException {
        Account ac = accounts.stream().filter(account -> account.getNumber() == accountNumber).findFirst().orElse(null);

        if (ac != null) {
            if (op.getAmount() > 0) {

                double newbalance = ac.getBalance() + op.getAmount();
                ac.setBalance(newbalance);
                ac.getOperations().add(new Operation(op.getType(), op.getAmount(), op.getDate(), ac.getBalance()));
            } else {
                throw new NegativeAmountException("Negative amount");
            }
        } else {
            throw new AccountNotFoundException("not account found for this number");
        }
    }


    @Override
    public void withdrawal(long accountNumber, Operation op) throws IllegalAmountException {
        Account ac = accounts.stream().filter(account -> account.getNumber() == accountNumber).findFirst().orElse(null);

        if (ac != null) {
            if (ac.getBalance() > op.getAmount()) {
                double newbalance = ac.getBalance() - op.getAmount();
                ac.setBalance(newbalance);
                ac.getOperations().add(new Operation(op.getType(), op.getAmount(), op.getDate(), ac.getBalance()));
            } else {
                throw new IllegalAmountException("Insufficient balance");

            }
        } else {
            throw new AccountNotFoundException("not account found for this number");
        }
    }


    @Override
    public void showHistory(long accountNumber) {

       System.out.println( accounts.stream().filter(account -> account.getNumber() == accountNumber).findFirst().orElse(null));
    }

}
