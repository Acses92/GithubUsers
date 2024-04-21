import ru.kravchenkoanatoly.githubusers.ProjectConfig


plugins {
    id(ProjectConfig.PluginsIds.javaLibrary)
    id(ProjectConfig.PluginsIds.kotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}