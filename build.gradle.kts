// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.android) version ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsVersion.androidGradleVersion apply false
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin) version ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsVersion.kotlinVersion apply false
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlinJvm) version ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsVersion.kotlinVersion apply false
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary) version ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsVersion.androidGradleVersion apply false
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt) version ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsVersion.hiltVersion apply false
}