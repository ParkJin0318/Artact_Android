package com.hackathon.artact.base

import androidx.room.*
import io.reactivex.Completable

@Dao
interface BaseDao<ET> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: ET): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: List<ET>): Completable

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(entity: ET): Completable

    @Delete
    fun delete(entity: ET): Completable
}