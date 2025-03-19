package org.example.financeservice.controller;

import org.example.financeservice.dto.request.FinancialBalanceRequestDTO;
import org.example.financeservice.dto.response.FinancialBalanceResponseDTO;
import org.example.financeservice.service.FinancialBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/financial-balance")
public class FinancialBalanceController {

    @Autowired
    private FinancialBalanceService financialBalanceService;

    @GetMapping("/get-financial-balance")
    public ResponseEntity<FinancialBalanceResponseDTO> findFinancialBalance(@RequestBody FinancialBalanceRequestDTO financialBalanceRequestDTO) {
        return ResponseEntity.ok(financialBalanceService.getFinancialBalance(financialBalanceRequestDTO));
    }
}