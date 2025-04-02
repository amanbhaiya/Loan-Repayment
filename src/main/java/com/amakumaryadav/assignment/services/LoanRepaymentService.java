package com.amakumaryadav.assignment.services;

import com.amakumaryadav.assignment.dto.LoanRequest;
import com.amakumaryadav.assignment.dto.RepaymentScheduleEntry;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoanRepaymentService {
    public List<RepaymentScheduleEntry> calculateRepaymentSchedule(LoanRequest request) {
        List<RepaymentScheduleEntry> schedule = new ArrayList<>();
        double principal = request.getLoanAmount();
        int tenure = request.getTenure();
        boolean isWeekly = "weekly".equalsIgnoreCase(request.getRepaymentType());

        double totalInterest = (principal * request.getRateOfInterest() * tenure) / 1200;
        double totalAmount = principal + totalInterest;
        double emi = isWeekly ? totalAmount / (tenure * 4) : totalAmount / tenure;

        LocalDate startDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (int i = 1; i <= (isWeekly ? tenure * 4 : tenure); i++) {
            LocalDate dueDate = isWeekly ? startDate.plusDays(7L * i) : startDate.plusMonths(i);
            double interestDue = (principal * request.getRateOfInterest()) / 1200;
            double principalDue = emi - interestDue;
            principal -= principalDue;

            schedule.add(new RepaymentScheduleEntry(i, dueDate.format(formatter), dueDate.getDayOfWeek().name(), principal + principalDue, interestDue, emi, Math.max(principal, 0)));
        }

        return schedule;
    }


}