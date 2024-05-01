package ru.kravchenkoanatoly.githubusers.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.kravchenkoanatoly.githubusers.common.models.ReloadableData
import ru.kravchenkoanatoly.githubusers.common.models.Status
import ru.kravchenkoanatoly.githubusers.common.utils.OnceFlow
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain
import ru.kravchenkoanatoly.githubusers.useCases.GithubUserUseCase
import timber.log.Timber

class UserDetailViewModel @AssistedInject constructor(
    @Assisted("userName") private val userName: String,
    private val usersUseCase: GithubUserUseCase
) : ViewModel() {
    companion object {
        const val USER_DETAIL_VIEW_MODEL_TAG = "USER_DETAIL_VIEW_MODEL_TAG"
    }

    private val _repositoriesListState = MutableStateFlow(
        ReloadableData<List<UserRepositoriesDomain>>(
            data = null,
            status = Status.Loading
        )
    )
    val repositoriesList = _repositoriesListState.asStateFlow()

    private val _userDetailActions = OnceFlow<UserDetailAction>()
    val userDetailAction = _userDetailActions.asSharedFlow()


    fun getUsersRepositories() {
        viewModelScope.launch {
            usersUseCase.getUserRepositories(userName, pageSize = 100)
                .flowOn(Dispatchers.IO)
                .onEach { data ->
                    _repositoriesListState.update {
                        it.copy(data = data, Status.Idle)
                    }
                }
                .catch {
                    _userDetailActions.tryEmit(UserDetailAction.Error(it.message.toString()))
                }
                .collect()
        }
    }
}