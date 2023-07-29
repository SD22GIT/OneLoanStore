package com.oneLoan.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.oneLoan.repository.Repository;

public class ValidateAndAggregate {

  public boolean checkPaymentDatePassedDueDate(Date paymentDate, Date dueDate) throws Exception {
    if (paymentDate.compareTo(dueDate) > 0) {
      throw new Exception("Payment Date is greater than due date");
    }
    return false;
  }

  public boolean checkDueDateCrossed(Date dueDate, double remainingAmount) {
    Date currentDate = new Date();
    if (currentDate.compareTo(dueDate) > 0 && remainingAmount > 0) {
      System.out.println("Log alert");
      return true;
    }

    return false;
  }

  public void displayAggregate() throws ClassNotFoundException, SQLException {
    Repository repository = new Repository();
    String query =
        "select customerid, lenderid, sum(remainingAmount), min(interestPerDay), max(penaltyPerDay)  from loan Group by lenderid, interestPerDay, customerid;";
    ResultSet result = repository.execute(query);
    System.out.println("Logging Aggregation Result -- Start");
    while (result.next()) {
      System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getDouble(3)
          + " " + result.getDouble(4) + " " + result.getDouble(5));


    }
    System.out.println("Logging Aggregation Result -- End");
  }

}
