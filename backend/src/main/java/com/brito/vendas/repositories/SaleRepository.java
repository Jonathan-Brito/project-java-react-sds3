package com.brito.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brito.vendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
