package com.hackathon.artact.repository

import com.hackathon.artact.model.Member
import io.reactivex.Single

interface MemberRepository {
    fun getMyInfo(): Single<Member>
}