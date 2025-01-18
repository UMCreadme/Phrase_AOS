package com.umc.phrase.domain.usecase.user

import com.umc.phrase.domain.DataResource
import com.umc.phrase.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    operator fun invoke(id: Long): Flow<DataResource<Unit>> = userRepository.deleteUser(id)
}