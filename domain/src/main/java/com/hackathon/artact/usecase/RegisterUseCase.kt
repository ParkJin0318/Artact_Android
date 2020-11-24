package com.hackathon.artact.usecase

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.AuthRepository
import com.hackathon.artact.request.RegisterRequest
import io.reactivex.Completable

class RegisterUseCase(
        private val authRepository: AuthRepository
): ParamsUseCase<RegisterUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable =
            authRepository.register(RegisterRequest(params.id, params.pw, params.name, params.age))

    data class Params(
            val id: String,
            val pw: String,
            val name: String,
            val age: Int
    )
}