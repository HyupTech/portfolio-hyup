package com.hyup.portfolio.domain

import com.hyup.portfolio.domain.constant.SkillType
import com.hyup.portfolio.domain.entity.*
import com.hyup.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
        private val achievementRepository: AchievementRepository,
        private val introductionRepository: IntroductionRepository,
        private val linkRepository: LinkRepository,
        private val skillRepository: SkillRepository,
        private val projectRepository: ProjectRepository,
        private val experienceRepository: ExperienceRepository
) {

    @PostConstruct
    fun initializeDate() {

        println("스프링이 실행되었습니다. 테스트 데이터를 초기화합니다.")

        val achievements = mutableListOf<Achievement>(
                Achievement(
                        title = "정보처리기능사",
                        description = "자료구조, 운영체제, 알고리즘, 데이터베이스 등",
                        host = "한국산업인력공단",
                        achievedDate = LocalDate.of(2018, 2, 2),
                        isActive = true),
                Achievement(
                        title = "리눅스마스터 2급",
                        description = "운영체제",
                        host = "한국정보통신진흥협회",
                        achievedDate = LocalDate.of(2019, 2, 2),
                        isActive = true),
                Achievement(
                        title = "네트워크관리사 2급",
                        description = "네트워크",
                        host = "한국정보통신자격협회",
                        achievedDate = LocalDate.of(2020, 2, 2),
                        isActive = true),

                )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
                Introduction(content = "꾸준하게 성장하는 예비개발자입니다", isActive = true),
                Introduction(content = "팀원들과의 소통을 중요시하며 비즈니스 문제 해결을 추구합니다",
                        isActive = true),
                Introduction(content = "단순 코딩보다 유용한 서비스 로직을 만드는 것을 좋아합니다.",
                        isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
                Link(name = "Github", content = "https://github.com/HyupTech", isActive = true),
//                Link(name = "Linkedin", content = "https://www.linkedin.com/in/bokeunjeong",
//                        isActive = true),
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
                title = "한신대학교(Hanshin Univ.)",
                description = "컴퓨터공학 전공",
                startYear = 2021,
                startMonth = 3,
                endYear = 2026,
                endMonth = 12,
                isActive = true,
        )
        experience1.addDetails(
                mutableListOf(
                        ExperienceDetail(content = "GPA 4.0/4.5", isActive = true),
                        ExperienceDetail(content = "소프트웨어 랩실 활동", isActive = true)
                )
        )

//        val experience2 = Experience(
//                title = "주식회사 캣카오(Catkao Corp.)",
//                description = "소셜서비스팀 백엔드 개발자",
//                startYear = 2022,
//                startMonth = 9,
//                endYear = null,
//                endMonth = null,
//                isActive = true,
//        )
//        experience2.addDetails(
//                mutableListOf(
//                        ExperienceDetail(content = "유기묘 위치 공유 서비스 개발", isActive = true),
//                        ExperienceDetail(content = "신입 교육 프로그램 우수상 수상", isActive = true)
//                )
//        )
        experienceRepository.saveAll(mutableListOf(experience1))

        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
//        val python = Skill(name = "Python", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
//        val django = Skill(name = "Django", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
//        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)
//        val kafka = Skill(name = "Kafka", type = SkillType.TOOL.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, spring, mysql))

//        val project1 = Project(
//                name = "유기묘 발견 정보 공유 서비스",
//                description = "유기묘 위치의 실시간 공유, 임시보호까지 연결해주는 서비스. 구글 맵스를 연동하여 유기묘 위치 정보를 직관적으로 파악할 수 있도록 하는 사용자 경험 개선 작업.",
//                startYear = 2022,
//                startMonth = 9,
//                endYear = 2022,
//                endMonth = 12,
//                isActive = true
//        )
//        project1.addDetails(
//                mutableListOf(
//                        ProjectDetail(content = "구글 맵스를 활용한 유기묘 발견 지역 정보 제공 API 개발", url = null, isActive = true),
//                        ProjectDetail(content = "Redis 적용하여 인기 게시글의 조회 속도 1.5초 -> 0.5초로 개선", url = null, isActive = true)
//                )
//        )
//        project1.skills.addAll(
//                mutableListOf(
//                        ProjectSkill(project = project1, skill = java),
//                        ProjectSkill(project = project1, skill = spring),
//                        ProjectSkill(project = project1, skill = mysql),
//
//                        )
//        )

//        val project2 = Project(
//                name = "반려동물 홈 카메라 움직임 감지 분석 모듈",
//                description = "카메라에서 서버로 전달되는 신호를 분석하여 움직임이 감지될 경우 클라이언트에게 알림 발송 작 업.",
//                startYear = 2022,
//                startMonth = 12,
//                endYear = null,
//                endMonth = null,
//                isActive = true
//        )
//        project2.addDetails(
//                mutableListOf(
//                        ProjectDetail(content = "PIL(Pillow) 활용하여 이미지 분석 기능 개발", url = null, isActive = true),
//                        ProjectDetail(content = "알림 발송을 비동기 처리하여 이미지 분석 - 알림 발송 기능간 의존도 감소 ", url = null, isActive = true),
//                        ProjectDetail(content = "Github Repository", url = "https://github.com/infomuscle", isActive = true)
//                )
//        )
//        project2.skills.addAll(
//                mutableListOf(
//                        ProjectSkill(project = project2, skill = python),
//                        ProjectSkill(project = project2, skill = django),
//                        ProjectSkill(project = project2, skill = kafka),
//                )
//        )
//        projectRepository.saveAll(mutableListOf(project1, project2))
    }
}