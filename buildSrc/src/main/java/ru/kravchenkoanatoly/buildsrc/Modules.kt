package ru.kravchenkoanatoly.githubusers


sealed class Modules(val root: String?, val name: String) {

    class Root(name: String): Modules(null, name) {
        companion object {
            val app = Root("app")
            val data = Root("data")
            val domain = Root("domain")
        }
    }

    class Presentation(name: String): Modules("presentation", name) {
        companion object {
            val search = Presentation("search")
            val detail = Presentation("detail")
        }
    }

    class Common(name: String): Modules("common", name) {
        companion object {
            val root = Common("")
        }
    }
}
