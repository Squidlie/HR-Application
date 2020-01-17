package com.astontech.hr.repositories;

import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {
    ElementType findByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeName(String elementTypeName);
    List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName);
}
