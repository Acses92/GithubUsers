package ru.kravchenkoanatoly.githubusers


sealed class Modules(val root: String?, val name: String) {

    class Root(name: String): Modules(null, name) {
        companion object {
            val app = Root("app")
            val data = Root("data")
            val domain = Root("domain")
        }
    }

    class Feature(name: String): Modules("feature", name) {
        companion object {
            val mainScreenFeature = Feature("mainScreenFeature")
            val detailScreenFeature = Feature("detailScreenFeature")
            val settingsScreenFeature = Feature("settingScreenFeature")
        }
    }

    class Common(name: String): Modules("common", name) {
        companion object {
            val commonaAndroid = Modules.Common("common-android")
            val commonJava = Modules.Common("common-java")
            val root = Common("")
        }
    }

    class Data(name: String): Modules("data", name) {
        companion object {
            val root = Data("")
            val weatherData = Data("weatherData")
        }
    }
}
