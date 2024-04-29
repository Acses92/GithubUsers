package ru.kravchenkoanatoly.githubusers.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.search.databinding.GithubUserItemBinding

class GithubUsersAdapter(
    private val onUserClicked: (GithubUserSearchDomain) -> Unit,
    private val onUserFollowers: (GithubUserSearchDomain) -> Unit,
) : ListAdapter<GithubUserSearchDomain, GithubUsersAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<GithubUserSearchDomain>() {
        override fun areContentsTheSame(
            oldItem: GithubUserSearchDomain,
            newItem: GithubUserSearchDomain
        ): Boolean = oldItem == newItem

        override fun areItemsTheSame(
            oldItem: GithubUserSearchDomain,
            newItem: GithubUserSearchDomain
        ): Boolean = oldItem.id == newItem.id
    }

) {
    inner class ViewHolder(val binding: GithubUserItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GithubUsersAdapter.ViewHolder {
        return ViewHolder(
            GithubUserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GithubUsersAdapter.ViewHolder, position: Int) {
        val context = holder.itemView.context
        with(holder.binding) {
            val item = getItem(position)
            userNameTextView.text = item.login
            if (!item.followersLoad) {
                onUserFollowers(item)
            }
            numberOfFollowers.text = item.followersNumber.toString()
            Glide.with(context).load(item.avatarUrl).circleCrop()
                .error(R.drawable.avatar_placeholder)
                .placeholder(R.drawable.avatar_placeholder).into(avatarImageView)

        }
    }


}