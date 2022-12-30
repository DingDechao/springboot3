package com.ddc.springboot3.repository;

import com.ddc.springboot3.entity.BalanceSheetEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BalanceSheetRepository extends CrudRepository<BalanceSheetEntity, Long> {

    List<BalanceSheetEntity> findAll();
}
