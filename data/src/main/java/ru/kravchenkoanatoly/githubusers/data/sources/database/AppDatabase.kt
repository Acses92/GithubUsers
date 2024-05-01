package ru.kravchenkoanatoly.githubusers.data.sources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.kravchenkoanatoly.githubusers.data.models.entity.GithubSearchUserEntity
import ru.kravchenkoanatoly.githubusers.data.sources.database.dao.GithubSearchUserDao

@Database(
    entities = [
        GithubSearchUserEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun githubSearchUserDao(): GithubSearchUserDao
}