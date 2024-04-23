package ru.kravchenkoanatoly.githubusers.data.sources.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.kravchenkoanatoly.githubusers.data.models.entity.GithubSearchUserEntity

@Dao
interface GithubSearchUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: List<GithubSearchUserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: GithubSearchUserEntity)

    @Query("DELETE FROM github_search_user")
    fun deleteAll()
}