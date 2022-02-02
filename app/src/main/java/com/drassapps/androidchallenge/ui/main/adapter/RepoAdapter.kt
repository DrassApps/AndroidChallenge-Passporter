package com.drassapps.androidchallenge.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.drassapps.androidchallenge.R
import com.drassapps.androidchallenge.data.domain.RepoModel
import com.drassapps.androidchallenge.databinding.ItemRepositoryBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class RepoAdapter(
    private val context: Context
) : ListAdapter<RepoModel, RepoAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_repository, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) = with(holder) {
        val item = getItem(position)
        bind(item, context)
    }

    // TODO: HANDLE CLICKS FOR SHOW DIALOG

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRepositoryBinding.bind(itemView)

        fun bind(item: RepoModel, context: Context) = with(binding) {
            repoName.text = item.repoName
            repoDesc.text = item.repoDesc
            repoOwnerName.text = item.owner.login

            if (item.isFromFork == true) {
                repoBottomLay.setBackgroundColor(ContextCompat.getColor(context, R.color.c_green))
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<RepoModel>() {
    override fun areItemsTheSame(oldItem: RepoModel, newItem: RepoModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RepoModel, newItem: RepoModel): Boolean {
        return oldItem == newItem
    }
}