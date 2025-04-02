package com.amakumaryadav.assignment.controller;

import com.amakumaryadav.assignment.dto.LoanRequest;
import com.amakumaryadav.assignment.dto.RepaymentScheduleEntry;
import com.amakumaryadav.assignment.services.LoanRepaymentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
class LoanRepaymentController {
    private final LoanRepaymentService loanRepaymentService;

    public LoanRepaymentController(LoanRepaymentService loanRepaymentService) {
        this.loanRepaymentService = loanRepaymentService;
    }

    @PostMapping("/schedule")
    public List<RepaymentScheduleEntry> calculateSchedule(@Validated @RequestBody LoanRequest request) {
        return loanRepaymentService.calculateRepaymentSchedule(request);
    }
}