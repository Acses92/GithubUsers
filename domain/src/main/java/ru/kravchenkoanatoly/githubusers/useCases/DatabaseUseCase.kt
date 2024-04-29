package ru.kravchenkoanatoly.githubusers.useCases

import ru.kravchenkoanatoly.githubusers.repositories.DatabaseRepository
import javax.inject.Inject

class DatabaseUseCase @Inject constructor(
    private val repository: DatabaseRepository
){
    fun subscribeSearchResult() = repository.subscribeGithubUserSearch()

    fun dellSearchResultCache() = repository.dellSearchResultCache()
}