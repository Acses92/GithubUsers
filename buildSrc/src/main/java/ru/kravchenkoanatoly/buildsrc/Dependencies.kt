package ru.kravchenkoanatoly.githubusers

object Dependencies {

    object Core {
        private const val gradleVersion = "8.7.0"
        private const val coroutineAndroidVersion = "1.3.9"
        private const val coroutinesVersion = "1.7.3"

        const val gradle = "com.android.tools.build:gradle:$gradleVersion"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineAndroidVersion"
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    }

    object AndroidX {
        private const val androidCoreVersion = "1.8.0"
        private const val appCompatVersion = "1.6.1"
        private const val lifeCycleVersion = "2.6.1"
        private const val fragmentKtxVersion = "1.5.7"
        private const val recyclerViewVersion = "1.3.1"
        private const val swipeRefreshLayoutVersion = "1.1.0"
        private const val preferencesVersion = "1.2.0"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion"
        const val androidCore = "androidx.core:core-ktx:$androidCoreVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:$fragmentKtxVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:$swipeRefreshLayoutVersion"
        const val preferences = "androidx.preference:preference-ktx:$preferencesVersion"
    }

    object UI {
        private const val materialVersion = "1.9.0"
        private const val constraintLayoutVersion = "2.1.4"

        const val material = "com.google.android.material:material:$materialVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
    }

    object Navigation {
        private const val navigationVersion = "2.6.0"

        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:$navigationVersion"
    }

    object Moshi {
        private const val moshiVersion = "1.15.0"

        const val moshi = "com.squareup.moshi:moshi:$moshiVersion"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
    }

    object Room {
        private const val roomVersion = "2.5.2"

        const val runtime = "androidx.room:room-runtime:$roomVersion"
        const val compiler = "androidx.room:room-compiler:$roomVersion"
        const val ktx = "androidx.room:room-ktx:$roomVersion"
    }


    object Hilt {
        private const val hiltVersion = ProjectConfig.PluginsVersion.hiltVersion
        private const val injectVersion = 1

        const val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
        const val hiltInject = "javax.inject:javax.inject:$injectVersion"
    }


    object Debuging {
        private const val okhttpVersion = "4.11.0"
        private const val timberVersion = "5.0.1"

        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val okhttpLoging = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
        const val timber = "com.jakewharton.timber:timber:$timberVersion"
    }

    object Test {
        private const val jUnitVersion = "4.13.2"
        private const val jUnitExtVersion = "1.1.5"
        private const val espressoVersion = "3.5.1"

        const val jUnit = "junit:junit:$jUnitVersion"
        const val jUnitExt = "androidx.test.ext:junit:$jUnitExtVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    }

    object Retrofit {
        private const val retrofitVersion = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }

    object PlayServices {
        private const val playServicesVersion = "21.0.1"

        const val playServiceLocation = "com.google.android.gms:play-services-location:$playServicesVersion"
    }
}
