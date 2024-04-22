package ru.kravchenkoanatoly.githubusers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import ru.kravchenkoanatoly.githubusers.useCases.GithubSearchUseCase
import ru.kravchenkoanatoly.githubusers.useCases.GithubUserUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val githubSearchUseCase: GithubSearchUseCase,
    private val githubUserUseCase: GithubUserUseCase
): ViewModel() {

    fun getUserInfo() {
        viewModelScope.launch {
            githubUserUseCase.getUserByUsername(USER_TEST_VALUE)
                .flowOn(Dispatchers.IO)
                .onEach { Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it.login) }
                .catch { Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it) }
                .collect()
        }
    }

    fun getUserListSearch(){
        viewModelScope.launch {
            githubSearchUseCase.searchUser(SEARCH_TEST_VALUE)
                .flowOn(Dispatchers.IO)
                .onEach {
                    if(it.isNotEmpty()) {
                        Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it.toString()) }
                }
                .catch { Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it.toString()) }
                .collect()
        }
    }

    fun getUserFollowers(){
        viewModelScope.launch {
            githubUserUseCase.getUserFollowers(USER_TEST_VALUE)
                .flowOn(Dispatchers.IO)
                .onEach {
                    Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it.toString())
                }
                .catch { Timber.tag(LAUNCH_VIEW_MODEL_TAG).d(it) }
                .collect()
        }
    }

    companion object {
        const val LAUNCH_VIEW_MODEL_TAG = "LAUNCH_VIEW_MODEL_TAG"
        const val SEARCH_TEST_VALUE = "Acses"
        const val USER_TEST_VALUE = "Acses92"
    }
}