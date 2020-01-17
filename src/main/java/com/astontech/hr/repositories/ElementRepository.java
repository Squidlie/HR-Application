package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementRepository extends CrudRepository<Element, Integer> {
    Element findByElementName(String elementName);
    List<Element> findAllByElementName(String elementName);
    List<Element> findAllByElementNameIgnoreCase(String elementName);

    Element findDistinctFirstByElementName(String elementName);
    List<Element> findAllByElementNameIsNot(String elementName);
    List<Element> findAllByElementNameStartsWith(String letter);
    List<Element> findTop3ByElementNameStartsWithOrderByIdDesc(String elementName);
    Integer countElementsByElementNameContains(String letter);

}
