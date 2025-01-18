package com.umc.phrase.domain.repository

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun createUser(user: User): Flow<DataResource<Unit>>
    suspend fun deleteUser(id: Long): Flow<DataResource<Unit>>
    suspend fun getUser(id: Long) : Flow<DataResource<User>>
    suspend fun updateUser(user: User): Flow<DataResource<Unit>>
}