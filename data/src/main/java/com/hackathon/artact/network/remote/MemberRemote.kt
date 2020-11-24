package com.hackathon.artact.network.remote

import com.hackathon.artact.base.BaseRemote
import com.hackathon.artact.model.Member
import com.hackathon.artact.network.repoonse.MemberData
import com.hackathon.artact.network.service.MemberService
import io.reactivex.Single

class MemberRemote(
        override val service: MemberService
) : BaseRemote<MemberService>() {

    fun getMyInfo(): Single<Member> =
            service.getMyInfo().map(getResponseData()).map(MemberData::member)
}
