package org.example.financeservice.controller;

import org.example.financeservice.dto.request.IncomeRequestDTO;
import org.example.financeservice.dto.response.IncomeResponseDTO;
import org.example.financeservice.model.Income;
import org.example.financeservice.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;


    @GetMapping("/get-income/{id}")
    public ResponseEntity<IncomeResponseDTO> findIncomeById(@PathVariable UUID id) {
        return ResponseEntity.ok(incomeService.getIncomeById(id));
    }

    @PostMapping("/create-income")
    public ResponseEntity<Income> createIncome(@RequestBody IncomeRequestDTO incomeRequestDTO) {
        return ResponseEntity.status(201).body(incomeService.createAndUpdateIncome(incomeRequestDTO));
    }

    @PutMapping("/update-income")
    public ResponseEntity<Income> updateIncome(@RequestBody IncomeRequestDTO incomeRequestDTO) {
        return ResponseEntity.status(201).body(incomeService.createAndUpdateIncome(incomeRequestDTO));
    }

    @DeleteMapping("/delete-income/{id}")
    public ResponseEntity<IncomeResponseDTO> deleteIncome(@PathVariable UUID id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}