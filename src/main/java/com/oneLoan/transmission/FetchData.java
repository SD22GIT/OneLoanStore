package com.oneLoan.transmission;

import java.util.List;
import com.oneLoan.entity.Loan;

public interface FetchData {

  public List<Loan> fetchLoanDataFromSource();

}
