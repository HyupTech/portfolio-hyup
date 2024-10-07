package com.hyup.portfolio.domain.repository

import com.hyup.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long> {
    // select * from Link where is_active = :isActive;
    fun findAllByIsActive(isActive: Boolean): List<Link>
}