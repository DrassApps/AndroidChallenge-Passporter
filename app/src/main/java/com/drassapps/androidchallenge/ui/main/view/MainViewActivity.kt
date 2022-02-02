package com.drassapps.androidchallenge.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.drassapps.androidchallenge.R
import com.drassapps.androidchallenge.data.db.ReposDataBase
import com.drassapps.androidchallenge.data.db.RoomDataSource
import com.drassapps.androidchallenge.data.domain.GitHubRepository
import com.drassapps.androidchallenge.data.network.ServerSource
import com.drassapps.androidchallenge.databinding.ActivityMainBinding
import com.drassapps.androidchallenge.ui.main.adapter.RepoAdapter
import com.drassapps.androidchallenge.ui.common.collectFlow
import com.drassapps.androidchallenge.ui.common.getViewModel
import com.drassapps.androidchallenge.ui.common.lastVisible
import com.drassapps.androidchallenge.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.util.*

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainViewActivity : AppCompatActivity() {

    private lateinit var adapter: RepoAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = getViewModel(::buildViewModel)
        adapter = RepoAdapter(this)

        lifecycleScope.collectFlow(viewModel.repositories) { adapter.submitList(it) }
        lifecycleScope.collectFlow(binding.githubReposRv.lastVisible) { viewModel.getRepositories() }

        binding.githubReposRv.adapter = adapter
    }

    private fun buildViewModel() = MainViewModel(
        GitHubRepository(
            RoomDataSource(Room.databaseBuilder(this,
                ReposDataBase::class.java, "gitHubRepos-db").build()),
            ServerSource()
        )
    )
}
