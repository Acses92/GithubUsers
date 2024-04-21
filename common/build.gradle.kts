import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep
import ru.kravchenkoanatoly.githubusers.ProjectConfig

plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.androidLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlin)
}


android {
    namespace = ProjectConfig.namespace()
    compileSdk = ProjectConfig.ConfigData.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.ConfigData.androidMinSdk

        testInstrumentationRunner = ProjectConfig.testRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile(ProjectConfig.ProGuardSettings.androidOptimize),
                ProjectConfig.ProGuardSettings.rules)
        }
    }
    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.javaVersion.toString()
    }}

dependencies {
    implementation(project(dep(Modules.Root.data)))
    implementation(project(dep(Modules.Root.domain)))

    implementation(Dependencies.AndroidX.androidCore)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.UI.material)
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.jUnitExt)
    androidTestImplementation(Dependencies.Test.espresso)
    implementation(Dependencies.Navigation.navigationUi)
    implementation(Dependencies.Navigation.navigationFragment)
}