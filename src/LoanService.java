import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LoanService {

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, LoanDetails> loanDetailsMap = new HashMap<>();
        File file = new File("C:\\Users\\admin\\Downloads\\testCase1.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] statement = sc.nextLine().split(" ");
            if (statement[0].equals("LOAN")) {
                long principal_amount = Long.parseLong(statement[3]);
                int no_of_years = Integer.parseInt(statement[4]);
                int interest = Integer.parseInt(statement[5]);
                LoanDetails loanDetail = new LoanDetails();
                loanDetail.setAccount_holder_name(statement[2]);
                loanDetail.setBank_name(statement[1]);
                loanDetail.setPrincipal_amount(principal_amount);
                loanDetail.setInterest(interest);
                loanDetail.setNo_of_years(no_of_years);
                long amount = principal_amount + (principal_amount * interest * no_of_years) / 100;
                loanDetail.setLoan_amount(amount);
                loanDetail.setNof_of_emis_left(no_of_years * 12);
                loanDetail.setEmi_amount(Math.round((amount / (double)(no_of_years * 12))));
                loanDetail.setCredited_amount(0);
                loanDetail.setCredited_at_emi_number(0);
                loanDetailsMap.put(statement[2], loanDetail);
            } else if (statement[0].equals("BALANCE")) {
                LoanDetails loanDetail = loanDetailsMap.get(statement[2]);
                if (loanDetail.getCredited_at_emi_number() == 0) {
                    System.out.print(loanDetail.getBank_name() + " " +
                            loanDetail.getAccount_holder_name() + " " +
                            loanDetail.getEmi_amount() * Integer.parseInt(statement[3]) + " " +
                            (loanDetail.getNof_of_emis_left() - Integer.parseInt(statement[3])) + "\n");
                } else {
                    if (loanDetail.getCredited_at_emi_number() > Integer.parseInt(statement[3])) {
                        System.out.print(loanDetail.getBank_name() + " " +
                                loanDetail.getAccount_holder_name() + " " +
                                loanDetail.getEmi_amount() * Integer.parseInt(statement[3]) + " " +
                                (loanDetail.getNof_of_emis_left() - Integer.parseInt(statement[3])) + "\n");
                    } else {
                        long credited_amount = loanDetail.getCredited_amount();
                        int credited_at_emi_number = loanDetail.getCredited_at_emi_number();
                        long credited_amount_up_to_lump_emi = (loanDetail.getEmi_amount() * (loanDetail.getCredited_at_emi_number())) + credited_amount;
                        int number_of_emi_left_after_credited_lump_sum = (int) ((loanDetail.getLoan_amount() - credited_amount_up_to_lump_emi) / loanDetail.getEmi_amount());
                        System.out.print(loanDetail.getBank_name() + " " +
                                loanDetail.getAccount_holder_name() + " " +
                                (credited_amount_up_to_lump_emi + ((Integer.parseInt(statement[3]) - credited_at_emi_number) * loanDetail.getEmi_amount())) + " " +
                                (number_of_emi_left_after_credited_lump_sum) + "\n");
                    }
                }
            } else if (statement[0].equals("PAYMENT")) {
                LoanDetails loanDetail = loanDetailsMap.get(statement[2]);
                loanDetail.setCredited_at_emi_number(Integer.parseInt(statement[4]));
                loanDetail.setCredited_amount(Long.parseLong(statement[3]));
            }
        }

    }
}
