import ru.kravchenkoanatoly.githubusers.Dependencies

plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
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
            proguardFiles(getDefaultProguardFile(ru.kravchenkoanatoly.githubusers.ProjectConfig.ProGuardSettings.androidOptimize),
                ru.kravchenkoanatoly.githubusers.ProjectConfig.ProGuardSettings.rules)
        }
    }
    compileOptions {
        sourceCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
        targetCompatibility = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ru.kravchenkoanatoly.githubusers.ProjectConfig.javaVersion.toString()
    }}

dependencies {
    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.UI.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationFragment)
}