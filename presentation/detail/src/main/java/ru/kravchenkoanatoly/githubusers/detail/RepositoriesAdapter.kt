package ru.kravchenkoanatoly.githubusers.detail

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.kravchenkoanatoly.githubusers.detail.databinding.UserRepositoryItemBinding
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
            val context = holder.itemView.context
            val item = getItem(position)
            repositoryName.text = item.name
            if (item.description != null) {
                description.text = item.description
            } else {
                description.text = context.getText(R.string.empty_description_text_view)
            }
            if (item.language != null) {
                languages.text =
                        context.getString(R.string.default_language_text_view, item.language)
            } else {
                languages.text = context.getString(R.string.default_language_empty_text_view)
            }
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && item.pushedAt != null) {
                    lastPush.text = context.getString(
                        R.string.last_push_text_view,
                        dateFormatter(item.pushedAt!!)
                    )
                } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O && item.pushedAt != null) {
                    lastPush.text = oldDateFormat(item.pushedAt!!)
                }
            } catch (error: Throwable) {

            }
            defaultBranch.text =
                    context.getString(R.string.default_branch_text_view, item.defaultBranch)
            forksCount.text = context.getString(R.string.forks_numbers_text_view, item.forksCount)
            starsCount.text =
                    context.getString(R.string.stars_numbers_text_view, item.stargazersCount)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun dateFormatter(date: String): String {
        val oldFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val date = LocalDateTime.parse(date, oldFormat)
        val formater = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
        return formater.format(date)
    }

    private fun oldDateFormat(date: String): String {
        return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT).format(date)
    }


}