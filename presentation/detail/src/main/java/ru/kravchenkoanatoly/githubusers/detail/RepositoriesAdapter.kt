package ru.kravchenkoanatoly.githubusers.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.kravchenkoanatoly.githubusers.detail.databinding.UserRepositoryItemBinding
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain

class RepositoriesAdapter(
) : androidx.recyclerview.widget.ListAdapter<UserRepositoriesDomain, RepositoriesAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<UserRepositoriesDomain>() {
        override fun areContentsTheSame(
            oldItem: UserRepositoriesDomain,
            newItem: UserRepositoriesDomain
        ): Boolean = oldItem == newItem

        override fun areItemsTheSame(
            oldItem: UserRepositoriesDomain,
            newItem: UserRepositoriesDomain
        ): Boolean = oldItem.id == newItem.id
    }

) {
    inner class ViewHolder(val binding: UserRepositoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoriesAdapter.ViewHolder {
        return ViewHolder(
            UserRepositoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoriesAdapter.ViewHolder, position: Int) {
        with(holder.binding) {
            val item = getItem(position)
            repositoryName.text = item.name
            if(item.description!=null){
                description.text = item.description
            }
            languages.text = "Язык программирования ${item.language}"
            lastPush.text = item.pushedAt
            defaultBranch.text = item.defaultBranch
            forksCount.text = "Количество форков ${item.forksCount.toString()}"
            starsCount.text = "Количество звёзд ${item.stargazersCount.toString()}"
        }

    }


}