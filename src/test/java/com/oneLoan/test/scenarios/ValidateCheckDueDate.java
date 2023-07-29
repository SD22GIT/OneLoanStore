package com.oneLoan.test.scenarios;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import com.oneLoan.logic.ValidateAndAggregate;

public class ValidateCheckDueDate {

  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  ValidateAndAggregate validate = new ValidateAndAggregate();

  @Test
  public void testDueDateNotCrossed() {
    Date dueDate = null;
    try {
      dueDate = dateFormat.parse("05/12/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      assertEquals(false, validate.checkDueDateCrossed(dueDate, 1000));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDueDateCrossed() {
    Date dueDate = null;
    try {
      dueDate = dateFormat.parse("05/04/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      assertEquals(true, validate.checkDueDateCrossed(dueDate, 1000));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testDueDateCrossedNoRemainingAmount() {
    Date dueDate = null;
    try {
      dueDate = dateFormat.parse("05/04/2023");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    try {
      assertEquals(false, validate.checkDueDateCrossed(dueDate, 0));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
