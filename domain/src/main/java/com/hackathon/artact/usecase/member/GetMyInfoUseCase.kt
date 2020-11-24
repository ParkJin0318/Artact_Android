package com.hackathon.artact.usecase.member

import com.hackathon.artact.base.BaseUseCase
import com.hackathon.artact.model.Member
import com.hackathon.artact.repository.AuthRepository
import com.hackathon.artact.repository.MemberRepository
import io.reactivex.Single

class GetMyInfoUseCase(
        private val memberRepository: MemberRepository
) : BaseUseCase<Single<Member>>() {

    override fun buildUseCaseObservable(): Single<Member> =
            memberRepository.getMyInfo()
}