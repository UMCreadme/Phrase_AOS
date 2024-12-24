package com.umc.phrase.domain.usecase.user

import com.umc.phrase.domain.model.User

interface DeleteUserUseCase {
    suspend operator fun invoke(user: User): Result<Unit>
}