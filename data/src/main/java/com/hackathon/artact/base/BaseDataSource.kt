package com.hackathon.artact.base

abstract class BaseDataSource<RT, CH> {
    abstract val remote: RT
    abstract val cache : CH
}