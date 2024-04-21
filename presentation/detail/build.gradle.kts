import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep
import ru.kravchenkoanatoly.githubusers.ProjectConfig



plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kapt)
}

android {
    namespace = ru.kravchenkoanatoly.githubusers.ProjectConfig.namespace()
    compileSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        minSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.androidMinSdk

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
        sourceCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
        targetCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion.toString()
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
}

dependencies {
    implementation(project(dep(Modules.Common.root)))
    implementation(project(dep(Modules.Root.domain)))
    implementation(project(dep(Modules.Root.data)))

    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.UI.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)
}