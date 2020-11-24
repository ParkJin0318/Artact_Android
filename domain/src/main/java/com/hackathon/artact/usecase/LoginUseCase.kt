package com.hackathon.artact.usecase

import com.hackathon.artact.base.ParamsUseCase
import com.hackathon.artact.repository.AuthRepository
import com.hackathon.artact.request.LoginRequest
import io.reactivex.Completable

class LoginUseCase (
        private val authRepository: AuthRepository
): ParamsUseCase<LoginUseCase.Params, Completable>() {

    override fun buildUseCaseObservable(params: Params): Completable {
        return authRepository.login(LoginRequest(params.id, params.pw))
    }

    data class Params(
            val id: String,
            val pw: String
    )
}