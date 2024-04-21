import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep
import ru.kravchenkoanatoly.githubusers.ProjectConfig

plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.android)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kapt)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt)
}

android {
    namespace = ProjectConfig.namespace()
    compileSdk = ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.ConfigData.androidMinSdk
        targetSdk = ProjectConfig.ConfigData.androidTargetSdk
        versionCode = ProjectConfig.ConfigData.versionCode
        versionName = ProjectConfig.ConfigData.versionName

        testInstrumentationRunner = ProjectConfig.testRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectConfig.ProGuardSettings.androidOptimize),
                ProjectConfig.ProGuardSettings.rules
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.javaVersion.toString()
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(project(dep(Modules.Common.root)))
    implementation(project(dep(Modules.Root.data)))
    implementation(project(dep(Modules.Root.domain)))
    implementation(project(dep(Modules.Prenentation.search)))
    implementation(project(dep(Modules.Prenentation.detail)))

    //core
    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.viewModel)
    implementation(Dependencies.Core.coroutineCore)

    //ui
    implementation(Dependencies.UI.material)
    implementation(Dependencies.UI.constraintLayout)

    //navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUi)

    //retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterMoshi)
    implementation(Dependencies.Debuging.okhttpLoging)

    //hilt
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)

    //room
    implementation(Dependencies.Room.runtime)

    implementation(Dependencies.Debuging.timber)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}