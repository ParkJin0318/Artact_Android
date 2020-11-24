package com.hackathon.artact.repository

import com.hackathon.artact.model.Member
import com.hackathon.artact.network.remote.MemberRemote
import io.reactivex.Single

class MemberRepositoryImpl(
        private val memberRemote: MemberRemote
) : MemberRepository {

    override fun getMyInfo(): Single<Member> =
            memberRemote.getMyInfo()
}