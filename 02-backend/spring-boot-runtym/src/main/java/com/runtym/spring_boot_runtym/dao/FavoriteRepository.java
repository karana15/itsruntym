package com.runtym.spring_boot_runtym.dao;

import com.runtym.spring_boot_runtym.entity.Favorite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
	
	Page<Favorite> findBySheetId(@RequestParam("sheet_id") Long sheetId, Pageable pageable);
}
