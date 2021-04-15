package services;

import model.Account;
import model.Operation;
import org.junit.Before;
import org.junit.Test;
import services.AccountService;
import services.AccountServiceImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountServiceImplUT {

    private Operation op1;
    private Operation op2;
    private AccountService accountService = new AccountServiceImpl();
    private long accountNumber = 1;
    private long accountNumber2 = 2;
    private List<Account> accounts;

    @Before
    public void init() {
        op1 = new Operation("deposit", 20, LocalDate.now(), 10000);
        op2 = new Operation("withdrawal", 300, LocalDate.now(), 10000);
        accounts =  AccountServiceImpl.getAccounts();
    }


    @Test
    public void shouldDeposit() {
        accountService.deposit(accountNumber,op1);
        double  balanceResult = accounts.stream().filter(account -> account.getNumber() == accountNumber).findFirst().orElse(null).getBalance();
        assertEquals(10020, balanceResult, 0.0);
    }

    @Test
    public void shouldWithdrawal() {
        accountService.withdrawal(accountNumber2,op2);
        double  balanceResult = accounts.stream().filter(account -> account.getNumber() == accountNumber2).findFirst().orElse(null).getBalance();
        assertEquals(9700, balanceResult, 0.0);

    }

    @Test
    public void shoulShowHistory() {

        accountService.showHistory(accountNumber);

    }


}

