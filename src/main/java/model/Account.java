package model;

import java.util.List;
import java.util.UUID;

public class Account {


    private UUID id;
    long number;
    double balance;
    String nom;
    String prenom;
    List<Operation> operations;



    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Account( long number, double balance, String nom, String prenom, List<Operation> operations) {

        this.number = number;
        this.balance = balance;
        this.nom = nom;
        this.prenom = prenom;
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", balance=" + balance +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", operations=" + operations +
                '}';
    }
}
