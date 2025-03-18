package org.example.financeservice.repository;

import org.example.financeservice.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface IncomeRepository extends JpaRepository<Income, UUID> {
    @Query("SELECT SUM (i.amount) FROM Income i WHERE i.date BETWEEN :startDate AND :endDate")
    BigDecimal findTotalIncomeBetweenDates(@Param("starDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
