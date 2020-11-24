package com.hackathon.artact.usecase.auth

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.AuthRepository
import com.hackathon.artact.request.LoginRequest
import io.reactivex.Single

class LoginUseCase (
        private val authRepository: AuthRepository
): ParamsUseCase<LoginUseCase.Params, Single<String>>() {

    override fun buildUseCaseObservable(params: Params): Single<String> {
        return authRepository.login(LoginRequest(params.id, params.pw))
    }

    data class Params(
            val id: String,
            val pw: String
    )
}