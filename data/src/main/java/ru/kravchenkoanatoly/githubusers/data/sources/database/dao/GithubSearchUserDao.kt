package ru.kravchenkoanatoly.githubusers.data.sources.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.data.models.entity.GithubSearchUserEntity

@Dao
interface GithubSearchUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(entities: List<GithubSearchUserEntity?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entities: GithubSearchUserEntity)

    @Query("DELETE FROM github_search_user")
    fun deleteAll()

    @Query("SELECT * FROM github_search_user")
    fun subscribeGithubUserSearch(): Flow<List<GithubSearchUserEntity>>

    @Query("UPDATE github_search_user SET followersNumber =:followers, followersLoad =:followersLoad WHERE login =:userName")
    fun updateFollower(userName: String, followers: Int, followersLoad: Boolean)
}