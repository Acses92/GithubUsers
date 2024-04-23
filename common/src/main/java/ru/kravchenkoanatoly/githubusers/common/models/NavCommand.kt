package ru.kravchenkoanatoly.githubusers.common.models

import android.os.Bundle
import androidx.navigation.NavOptions

data class NavCommand(
    val action: Int,
    val args: Bundle? = null,
    val navOptions: NavOptions? = null
)
