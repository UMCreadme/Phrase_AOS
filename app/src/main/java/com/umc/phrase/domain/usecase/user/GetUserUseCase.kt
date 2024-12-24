package com.umc.phrase.domain.usecase.user

import com.umc.phrase.domain.model.User

interface GetUserUseCase {
    suspend operator fun invoke(id: Long): Result<User?>
}