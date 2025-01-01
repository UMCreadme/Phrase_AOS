package com.umc.phrase.data.model

interface DataMapper<DomainModel> {
    fun toDomain(): DomainModel
}