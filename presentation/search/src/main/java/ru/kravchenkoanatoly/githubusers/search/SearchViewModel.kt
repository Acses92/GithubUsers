package ru.kravchenkoanatoly.githubusers.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.kravchenkoanatoly.githubusers.common.models.ReloadableData
import ru.kravchenkoanatoly.githubusers.common.models.Status
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.useCases.GithubSearchUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val githubSearchUseCase: GithubSearchUseCase
) : ViewModel() {

    private val _userListState = MutableStateFlow(
        ReloadableData<List<GithubUserSearchDomain>>(
            data = null,
            status = Status.EmptyState
        )
    )
    val userListState = _userListState.asStateFlow()


    fun getUserListSearch(userName: String){
        viewModelScope.launch {
            githubSearchUseCase.searchUser(userName)
                .flowOn(Dispatchers.IO)
                .onEach {
                    data -> _userListState.update {
                        it.copy(data = data, status = Status.Idle)
                    }
                }
                .catch { Timber.tag(SEARCH_VIEW_MODEL_TAG).d(it.toString()) }
                .collect()
        }
    }

    companion object{
        const val SEARCH_VIEW_MODEL_TAG = "SEARCH_VIEW_MODEL_TAG"
    }
}