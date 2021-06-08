import java.util.Objects;

public class LoanDetails {
    private String bank_name;
    private String account_holder_name;
    private long principal_amount;
    private int no_of_years;
    private int interest;
    private int nof_of_emis_left;
    private long loan_amount;
    private long emi_amount;
    private long credited_amount;
    private int credited_at_emi_number;

    public int getCredited_at_emi_number() {
        return credited_at_emi_number;
    }

    public void setCredited_at_emi_number(int credited_at_emi_number) {
        this.credited_at_emi_number = credited_at_emi_number;
    }

    public long getCredited_amount() {
        return credited_amount;
    }

    public void setCredited_amount(long credited_amount) {
        this.credited_amount = credited_amount;
    }

    public long getEmi_amount() {
        return emi_amount;
    }

    public void setEmi_amount(long emi_amount) {
        this.emi_amount = emi_amount;
    }

    public int getNof_of_emis_left() {
        return nof_of_emis_left;
    }

    public void setNof_of_emis_left(int nof_of_emis_left) {
        this.nof_of_emis_left = nof_of_emis_left;
    }

    public long getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(long loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public long getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(long principal_amount) {
        this.principal_amount = principal_amount;
    }

    public int getNo_of_years() {
        return no_of_years;
    }

    public void setNo_of_years(int no_of_years) {
        this.no_of_years = no_of_years;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "bank_name='" + bank_name + '\'' +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", principal_amount=" + principal_amount +
                ", no_of_years=" + no_of_years +
                ", interest=" + interest +
                ", nof_of_emis_left=" + nof_of_emis_left +
                ", loan_amount=" + loan_amount +
                ", emi_amount=" + emi_amount +
                ", credited_amount=" + credited_amount +
                ", credited_at_emi_number=" + credited_at_emi_number +
                '}';
    }
}
