import ru.kravchenkoanatoly.githubusers.Dependencies

plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kapt)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.hilt)
}

android {
    namespace = ru.kravchenkoanatoly.githubusers.ProjectConfig.namespace()
    compileSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        minSdk = ru.kravchenkoanatoly.githubusers.ProjectConfig.ConfigData.androidMinSdk

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
        sourceCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
        targetCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion.toString()
    }
}

dependencies {


    //core
    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.UI.material)
    implementation(Dependencies.PlayServices.playServiceLocation)

    //retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterMoshi)
    implementation(Dependencies.Debuging.okhttpLoging)

    //hilt
    implementation(Dependencies.Hilt.hiltAndroid)
    kapt(Dependencies.Hilt.hiltCompiler)

    //room
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.compiler)

    //moshi
    implementation(Dependencies.Moshi.moshi)
    implementation(Dependencies.Moshi.moshiAdapters)
    implementation(Dependencies.Moshi.moshiKotlin)
    kapt(Dependencies.Moshi.moshiCodegen)

    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
}