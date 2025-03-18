package org.example.financeservice.service;

import org.example.financeservice.dto.request.IncomeRequestDTO;
import org.example.financeservice.dto.response.IncomeResponseDTO;
import org.example.financeservice.model.Income;
import org.example.financeservice.model.User;
import org.example.financeservice.repository.IncomeRepository;
import org.example.financeservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;
    
    @Autowired
    private UserRepository userRepository;

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

        User user = userRepository.findById(incomeRequestDTO.user()).orElseThrow(() -> new RuntimeException("User not found"));

        income.setAmount(incomeRequestDTO.amount());
        income.setDate(incomeRequestDTO.date());
        income.setDescription(incomeRequestDTO.description());
        income.setUser(user);

        return incomeRepository.save(income);
    }

    public void deleteIncome(UUID id) {
        incomeRepository.deleteById(id);
    }
}
