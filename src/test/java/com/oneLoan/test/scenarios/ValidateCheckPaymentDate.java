package com.oneLoan.test.scenarios;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import com.oneLoan.logic.ValidateAndAggregate;


public class ValidateCheckPaymentDate {

  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  ValidateAndAggregate validate = new ValidateAndAggregate();

  @Test
  public void testPaymentDateLessThanDueDate() {
    Date paymentDate = null;
    Date dueDate = null;
    try {
      paymentDate = dateFormat.parse("05/06/2023");
      dueDate = dateFormat.parse("05/07/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      assertEquals(false, validate.checkPaymentDatePassedDueDate(paymentDate, dueDate));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testPaymentDateEqualToDueDate() {
    Date paymentDate = null;
    Date dueDate = null;
    try {
      paymentDate = dateFormat.parse("05/06/2023");
      dueDate = dateFormat.parse("05/06/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      assertEquals(false, validate.checkPaymentDatePassedDueDate(paymentDate, dueDate));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test(expected = Exception.class)
  public void testPaymentDateGreaterThanDueDate() throws Exception {
    Date paymentDate = null;
    Date dueDate = null;
    try {
      paymentDate = dateFormat.parse("05/09/2023");
      dueDate = dateFormat.parse("05/06/2023");
    } catch (ParseException e) {
      System.out.println("Date cannot be parsed");
    }

    validate.checkPaymentDatePassedDueDate(paymentDate, dueDate);
  }
}
