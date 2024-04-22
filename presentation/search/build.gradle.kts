import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig


plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kapt)
}

android {
    namespace = "ru.kravchenkoanatoly.githubusers.search"
    compileSdk = ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        minSdk =ProjectConfig.ConfigData.androidMinSdk

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

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

}

dependencies {
    implementation(project(dep(Modules.Common.root)))
    implementation(project(dep(Modules.Root.domain)))
    implementation(project(dep(Modules.Root.data)))

    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.recyclerView)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationDynamic)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)
}