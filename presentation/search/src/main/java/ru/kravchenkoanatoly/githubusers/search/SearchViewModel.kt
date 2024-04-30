package ru.kravchenkoanatoly.githubusers.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.kravchenkoanatoly.githubusers.common.models.ReloadableData
import ru.kravchenkoanatoly.githubusers.common.models.Status
import ru.kravchenkoanatoly.githubusers.common.utils.OnceFlow
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.useCases.DatabaseUseCase
import ru.kravchenkoanatoly.githubusers.useCases.GithubSearchUseCase
import ru.kravchenkoanatoly.githubusers.useCases.GithubUserUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val githubSearchUseCase: GithubSearchUseCase,
    private val githubUserUseCase: GithubUserUseCase,
    private val databaseUseCase: DatabaseUseCase
) : ViewModel() {

    var currentPage = 1
    var maxPages = 0

    private val _action = OnceFlow<GithubUserAction>()
    val action = _action.asSharedFlow()

    private val _userListState = MutableStateFlow(
        ReloadableData<List<GithubUserSearchDomain>>(
            data = null,
            status = Status.Loading
        )
    )
    val userListState = _userListState.asStateFlow()

    init {
        subscribeSearchResult()
    }

    fun getUserListSearch(userName: String) {
        viewModelScope.launch {
            githubSearchUseCase.searchUser(userName, PAGE_SIZE, currentPage)
                .flowOn(Dispatchers.IO)
                .catch { Timber.tag(SEARCH_VIEW_MODEL_TAG).d(it.toString()) }
                .onCompletion { currentPage++ }
                .collect()
        }
    }

    fun getUserFollowers(user: GithubUserSearchDomain) {
        viewModelScope.launch {
            user.login.let {
                Timber.tag(SEARCH_VIEW_MODEL_TAG).d("username = $it")
                githubUserUseCase.getUserFollowers(it, 100)
                    .flowOn(Dispatchers.IO)
                    .onEach {
                        Timber.tag(SEARCH_VIEW_MODEL_TAG).d(it.toString())
                    }
                    .catch { Timber.tag(SEARCH_VIEW_MODEL_TAG).d(it.toString()) }
                    .collect()
            }
        }
    }

    private fun subscribeSearchResult() {
        viewModelScope.launch {
            databaseUseCase.subscribeSearchResult()
                .flowOn(Dispatchers.IO)
                .onStart {  }
                .onEach { data ->
                    _userListState.update {
                        it.copy(data = data, status = Status.Idle)
                    }
                }
                .catch { }
                .collect()
        }
    }

    fun getMaxUsersFromRequest(userName: String) {
        viewModelScope.launch {
            githubSearchUseCase.getMaxUsersFromRequest(userName)
                .flowOn(Dispatchers.IO)
                .onStart { currentPage = 1 }
                .onEach {
                    maxPages = it / PAGE_SIZE
                    maxPages = if (it % PAGE_SIZE == 0) maxPages else (maxPages + 1)
                }
                .catch { }
                .collect()
        }
    }

    fun viewModelClearRequestCache(){
        Timber.tag(SEARCH_VIEW_MODEL_TAG).d("Dell call")
        viewModelScope.launch {
            databaseUseCase.dellSearchResultCache()
                .flowOn(Dispatchers.IO)
                .catch {  }
                .collect()
        }
    }

    fun onUserClicked(user: GithubUserSearchDomain) {
        _action.tryEmit(
            GithubUserAction.OnClickedUser(
                user.id,
                user.login,
                user.avatarUrl
            )
        )

    }

    companion object {
        const val SEARCH_VIEW_MODEL_TAG = "SEARCH_VIEW_MODEL_TAG"
        const val PAGE_SIZE = 12
    }
}
