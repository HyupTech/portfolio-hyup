package com.hyup.portfolio.presentation.dto

import com.hyup.portfolio.domain.entity.Skill

data class SkillDTO(
        val name: String,
        val type: String
) {
    constructor(skill: Skill) : this(
            name = skill.name,
            type = skill.type.name
    )
}