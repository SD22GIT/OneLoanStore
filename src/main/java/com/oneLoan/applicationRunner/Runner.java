package com.oneLoan.applicationRunner;

import java.util.List;
import com.oneLoan.entity.Loan;
import com.oneLoan.logic.ValidateAndAggregate;
import com.oneLoan.repository.Repository;
import com.oneLoan.transmission.FetchData;
import com.oneLoan.transmission.FetchDataImpl;

public class Runner {

  public static void main(String[] args) throws Exception {

    FetchData data = new FetchDataImpl();
    List<Loan> loans = data.fetchLoanDataFromSource();
    ValidateAndAggregate validate = new ValidateAndAggregate();
    Repository repository = new Repository();

    for (Loan loan : loans) {

      if (!validate.checkPaymentDatePassedDueDate(loan.getPaymentDate(), loan.getDueDate())) {
        validate.checkDueDateCrossed(loan.getPaymentDate(), loan.getRemainingAmount());
        repository.saveLoan(loan);
      }
    }
    validate.displayAggregate();



  }

}
