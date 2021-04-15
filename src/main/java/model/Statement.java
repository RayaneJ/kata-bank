package model;



import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Statement {

    List<Operation> operations ;

    private Date date1;

    private Date date2;

    private UUID statementId;

    public Statement(List<Operation> operations, Date date1, Date date2, UUID statementId) {
        this.operations = operations;
        this.date1 = date1;
        this.date2 = date2;
        this.statementId = statementId;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public UUID getStatementId() {
        return statementId;
    }

    public void setStatementId(UUID statementId) {
        this.statementId = statementId;
    }
}

