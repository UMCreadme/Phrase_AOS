package com.umc.phrase.domain.usecase.user

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.model.User
import com.umc.phrase.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    operator fun invoke(user: User): Flow<DataResource<Unit>> = userRepository.updateUser(user)
}