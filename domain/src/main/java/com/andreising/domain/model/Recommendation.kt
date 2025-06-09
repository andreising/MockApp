package com.andreising.domain.model

enum class Recommendation(val key: String?) {
    NEAR_VACANCIES("near_vacancies"),
    LEVEL_UP_RESUME("level_up_resume"),
    TEMPORARY_JOB("temporary_job"),
    UNDEFINED(null);

    companion object {
        fun getRecommendationByString(key: String?): Recommendation {
            return when(key) {
                NEAR_VACANCIES.key -> NEAR_VACANCIES
                LEVEL_UP_RESUME.key -> LEVEL_UP_RESUME
                TEMPORARY_JOB.key -> TEMPORARY_JOB
                else -> UNDEFINED
            }
        }
    }
}