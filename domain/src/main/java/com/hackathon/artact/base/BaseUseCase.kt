package com.hackathon.artact.base

abstract class BaseUseCase<out T> {

    abstract fun buildUseCaseObservable(): T
}