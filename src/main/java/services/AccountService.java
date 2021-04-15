package services;

import Exceptions.IllegalAmountException;
import Exceptions.NegativeAmountException;
import model.Operation;

public interface AccountService {

    public void deposit(long accountNumber, Operation op) throws NegativeAmountException;
    public void withdrawal(long accountNumber ,Operation op) throws IllegalAmountException;
    public void showHistory(long accountNumber);

}
