package org.example.financeservice.service;

import org.example.financeservice.dto.request.IncomeRequestDTO;
import org.example.financeservice.dto.response.IncomeResponseDTO;
import org.example.financeservice.model.Income;
import org.example.financeservice.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public IncomeResponseDTO getIncomeById(UUID id) {
        return incomeRepository.findById(id).map(IncomeResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Income not found"));
    }

    public Income createAndUpdateIncome(IncomeRequestDTO incomeRequestDTO) {
        Income income;
        if(incomeRequestDTO.id() != null && incomeRepository.existsById(incomeRequestDTO.id())) {
            income = incomeRepository.findById(incomeRequestDTO.id()).get();
        } else {
            income = new Income();
        }

        income.setAmount(incomeRequestDTO.amount());
        income.setDate(incomeRequestDTO.date());
        income.setDescription(incomeRequestDTO.description());

        return incomeRepository.save(income);
    }

    public void deleteIncome(UUID id) {
        incomeRepository.deleteById(id);
    }
}
