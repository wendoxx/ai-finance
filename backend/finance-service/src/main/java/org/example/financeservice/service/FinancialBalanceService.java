package org.example.financeservice.service;

import lombok.Data;
import org.example.financeservice.dto.request.FinancialBalanceRequestDTO;
import org.example.financeservice.dto.response.FinancialBalanceResponseDTO;
import org.example.financeservice.repository.ExpenseRepository;
import org.example.financeservice.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Service
public class FinancialBalanceService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    IncomeRepository incomeRepository;

    public FinancialBalanceResponseDTO getFinancialBalance(FinancialBalanceRequestDTO financialBalanceRequestDTO) {

        BigDecimal totalIncome = incomeRepository.findTotalIncomeByUserBetweenDates(financialBalanceRequestDTO.user(), financialBalanceRequestDTO.startDate(), financialBalanceRequestDTO.endDate());
        BigDecimal totalExpense = expenseRepository.findTotalExpenseByUserBetweenDates(financialBalanceRequestDTO.user(), financialBalanceRequestDTO.startDate(), financialBalanceRequestDTO.endDate());
        BigDecimal userBalance = totalIncome.subtract(totalExpense);

        return new FinancialBalanceResponseDTO(totalIncome, totalExpense, userBalance);
    }

}
