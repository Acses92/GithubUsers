package ru.kravchenkoanatoly.githubusers

import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.support.delegates.DependencyHandlerDelegate

object ProjectConfig {
    const val applicationId = "ru.kravchenkoanatoly.githubusers"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    fun namespace(modules: Modules? = null): String =
            (modules?.run { "$applicationId.${modules.name}" } ?: applicationId).replace("-", "_")

    fun DependencyHandlerDelegate.dep(modules: Modules): String =
            "${if (modules.root != null) ":${modules.root}" else ""}:${modules.name}"

    val javaVersion = JavaVersion.VERSION_17


    object ConfigData{
        const val androidMinSdk = 24
        const val androidTargetSdk = 33
        const val compileSdk = 33
        const val versionCode = 1
        const val versionName = "1"
    }

    object PluginsVersion{
        const val androidGradleVersion = "8.1.0"
        const val kotlinVersion = "1.9.23"
        const val hiltVersion = "2.48"
        const val benManesVersion = "0.42.0"
        const val gmsVersion = "4.3.15"
    }

    object PluginsIds {
        const val android = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlin = "org.jetbrains.kotlin.android"
        const val kotlinJvm = "org.jetbrains.kotlin.jvm"
        const val kapt = "kotlin-kapt"
        const val javaLibrary = "java-library"
        const val hilt = "com.google.dagger.hilt.android"
        const val benManesVersions = "com.github.ben-manes.versions"
        const val gms = "com.google.gms.google-services"
    }

    object ProGuardSettings{
        const val androidOptimize = "proguard-android-optimize.txt"
        const val rules = "proguard-rules.pro"
        const val consumerRules = "consumer-rules.pro"
    }

}