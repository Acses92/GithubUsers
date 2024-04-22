import ru.kravchenkoanatoly.githubusers.Dependencies
import ru.kravchenkoanatoly.githubusers.Modules
import ru.kravchenkoanatoly.githubusers.ProjectConfig
import ru.kravchenkoanatoly.githubusers.ProjectConfig.dep


plugins {
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.javaLibrary)
    id(ru.kravchenkoanatoly.githubusers.ProjectConfig.PluginsIds.kotlinJvm)
}

java {
    sourceCompatibility = ProjectConfig.javaVersion
    targetCompatibility = ProjectConfig.javaVersion
}

dependencies{

    implementation(Dependencies.Hilt.hiltInject)
    implementation(Dependencies.Core.coroutineCore)
}