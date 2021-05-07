package com.brito.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.brito.vendas.dto.SaleSuccessDTO;
import com.brito.vendas.dto.SaleSumDTO;
import com.brito.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT NEW com.brito.vendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupeBySeller();
	
	@Query("SELECT NEW com.brito.vendas.dto.SaleSuccessDTO(obj.seller, "
			+ "SUM(obj.visited), SUM(obj.deals))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
