package com.hackathon.artact.base

abstract class ParamsUseCase<in Params, out T> {

    abstract fun buildUseCaseObservable(params: Params): T
}