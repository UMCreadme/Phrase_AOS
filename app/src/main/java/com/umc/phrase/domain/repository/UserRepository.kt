package com.umc.phrase.domain.repository

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun createUser(user: User): Flow<DataResource<Unit>>
    fun deleteUser(id: Long): Flow<DataResource<Unit>>
    fun getUser(id: Long) : Flow<DataResource<User>>
    fun updateUser(user: User): Flow<DataResource<Unit>>
}