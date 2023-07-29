package com.oneLoan.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.oneLoan.entity.Loan;

public class Repository {

  Connection con;
  PreparedStatement pstmt;

  public Repository() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loanStore", "root", "password");

  }

  public void saveLoan(Loan loan) throws SQLException {

    String query =
        "INSERT INTO loan ( loanid, customerid, lenderid, amount,remainingAmount,paymentDate,interestPerDay,dueDate,penaltyPerDay) VALUES (?,?,?,?,?,?,?,?,?);";
    pstmt = con.prepareStatement(query);
    PreparedStatement pstmt = con.prepareStatement(query);
    pstmt.setString(1, loan.getLoanId());
    pstmt.setString(2, loan.getCustomerId());
    pstmt.setString(3, loan.getLenderId());
    pstmt.setDouble(4, loan.getAmount());
    pstmt.setDouble(5, loan.getRemainingAmount());
    pstmt.setDate(6, new java.sql.Date(loan.getPaymentDate().getTime()));
    pstmt.setFloat(7, loan.getInterestPerDay());
    pstmt.setDate(8, new java.sql.Date(loan.getDueDate().getTime()));
    pstmt.setFloat(9, loan.getPenaltyPerDay());

    pstmt.executeUpdate();

  }

  public ResultSet execute(String query) throws SQLException {
    PreparedStatement pstmt = con.prepareStatement(query);
    ResultSet result = pstmt.executeQuery();
    return result;
  }



}
