package com.umc.phrase.domain.usecase.user

import com.umc.phrase.domain.model.User

interface UpdateUserUseCase{
    suspend operator fun invoke(user: User): Result<Unit>
}