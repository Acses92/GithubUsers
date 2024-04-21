import ru.kravchenkoanatoly.githubusers.ProjectConfig


plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.javaLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlinJvm)
}

java {
    sourceCompatibility = ProjectConfig.javaVersion
    targetCompatibility = ProjectConfig.javaVersion
}