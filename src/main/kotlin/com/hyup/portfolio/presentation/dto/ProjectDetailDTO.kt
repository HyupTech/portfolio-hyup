package com.hyup.portfolio.presentation.dto

import com.hyup.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDTO(
        val content: String,
        val url: String?
) {
    constructor(projectDetail: ProjectDetail) : this(
            content = projectDetail.content,
            url = projectDetail.url
    )
}