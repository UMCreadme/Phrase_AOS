package com.umc.phrase.domain.repository

import com.umc.phrase.domain.model.User

interface UserRepository {
    suspend fun createUser(user: User): Result<Unit>
    suspend fun deleteUser(id: Long): Result<Unit>
    suspend fun getUser(id: Long) : Result<User?>
    suspend fun updateUser(user: User): Result<Unit>
}