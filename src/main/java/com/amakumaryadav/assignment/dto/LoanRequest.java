package com.amakumaryadav.assignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class LoanRequest {
    @Positive(message = "Loan amount must be positive")
    private double loanAmount;

    @Positive(message = "Tenure must be positive")
    private int tenure;

    @Min(value = 0, message = "Rate of interest cannot be negative")
    private double rateOfInterest;

    @Pattern(regexp = "^(weekly|monthly)$", message = "Repayment type must be either 'weekly' or 'monthly'")
    private String repaymentType;

    public double getLoanAmount() { return loanAmount; }
    public int getTenure() { return tenure; }
    public double getRateOfInterest() { return rateOfInterest; }
    public String getRepaymentType() { return repaymentType; }
}