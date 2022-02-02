package com.drassapps.androidchallenge.ui.main.viewmodel

import androidx.lifecycle.*
import com.drassapps.androidchallenge.data.domain.GitHubRepository
import com.drassapps.androidchallenge.data.domain.RepoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel (
    private val repository: GitHubRepository
) : ViewModel() {

    private var _currentPage = 1
    val repositories: Flow<List<RepoModel>> get() = repository.getSavedRepositories()

    init { viewModelScope.launch { getRepositories() } }

    suspend fun getRepositories() {
        repository.requireNewPage(_currentPage)
        _currentPage += 1
    }
}
