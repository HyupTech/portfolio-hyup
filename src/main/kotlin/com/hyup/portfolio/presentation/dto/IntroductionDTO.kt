package com.hyup.portfolio.presentation.dto

import com.hyup.portfolio.domain.entity.Introduction

data class IntroductionDTO(
        val content: String,
) {
    constructor(introduction: Introduction) : this(
            content = introduction.content
    )
}