package com.incubyte.SweetShop.repository;

import com.incubyte.SweetShop.entity.Sweet;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SweetRepository extends JpaRepository<Sweet, Long> {
}
