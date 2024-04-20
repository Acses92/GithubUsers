import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep

plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.android)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kapt)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt)
}


android {
    namespace = ru.kravchenkoanatoly.githubusers.ProjectConfig.namespace()
    compileSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        applicationId = ru.kravchenkoanatoly.githubusers.ProjectConfig.applicationId
        minSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.androidMinSdk
        targetSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.androidTargetSdk
        versionCode = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.versionCode
        versionName = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.versionName

        testInstrumentationRunner = ru.kravchenkoanatoly.githubusers.ProjectConfig.testRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ru.kravchenkoanatoly.githubusers.ProjectConfig.ProGuardSettings.androidOptimize),
                ru.kravchenkoanatoly.githubusers.ProjectConfig.ProGuardSettings.rules
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(project(dep(Modules.Common.root)))


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
    //implementation(project(mapOf("path" to ":feature:mainScreenFeature")))
    kapt(Dependencies.Hilt.hiltCompiler)

    //room
    implementation(Dependencies.Room.runtime)

    implementation(Dependencies.Debuging.timber)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)}