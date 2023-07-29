package com.oneLoan.transmission;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import com.oneLoan.entity.Loan;

public class FetchDataImpl implements FetchData {

  public List<Loan> fetchLoanDataFromSource() {
    List<Loan> loans = new LinkedList<Loan>();
    Date paymentDate1 = null;
    Date dueDate1 = null;
    Date paymentDate2 = null;
    Date dueDate2 = null;
    Date paymentDate3 = null;
    Date dueDate3 = null;
    Date paymentDate4 = null;
    Date dueDate4 = null;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    try {
      paymentDate1 = dateFormat.parse("05/06/2023");
      dueDate1 = dateFormat.parse("05/07/2023");
      paymentDate2 = dateFormat.parse("01/06/2023");
      dueDate2 = dateFormat.parse("05/08/2023");
      paymentDate3 = dateFormat.parse("04/04/2023");
      dueDate3 = dateFormat.parse("04/05/2023");
      paymentDate4 = dateFormat.parse("04/04/2023");
      dueDate4 = dateFormat.parse("04/05/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    Loan loan1 = new Loan("L1", "C1", "LEN1", 10000, 10000, paymentDate1, 1F, dueDate1, 0.01F);
    Loan loan2 = new Loan("L2", "C1", "LEN1", 20000, 5000, paymentDate2, 1F, dueDate2, 0.01F);
    Loan loan3 = new Loan("L3", "C2", "LEN2", 50000, 30000, paymentDate3, 2F, dueDate3, 0.02F);
    Loan loan4 = new Loan("L4", "C3", "LEN2", 50000, 30000, paymentDate4, 2F, dueDate4, 0.02F);

    loans.add(loan1);
    loans.add(loan2);
    loans.add(loan3);
    loans.add(loan4);

    return loans;

  }

}
