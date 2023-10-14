package com.api.calculate.module.reajuste.domain.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.api.calculate.module.reajuste.domain.entity.Reajuste;
import com.api.calculate.shared.core.generic.crud.repository.GenericRepository;

@Repository
public interface ReajusteRepository extends GenericRepository<Reajuste, UUID> {
}
