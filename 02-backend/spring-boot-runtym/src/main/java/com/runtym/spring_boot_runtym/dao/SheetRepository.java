package com.runtym.spring_boot_runtym.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.runtym.spring_boot_runtym.entity.Sheet;

public interface SheetRepository extends JpaRepository<Sheet, Long>{

	Page<Sheet> findByTitleContaining(@RequestParam("title") String title, Pageable pageable);

	Page<Sheet> findByCategory(@RequestParam("category") String category, Pageable pageable);
}