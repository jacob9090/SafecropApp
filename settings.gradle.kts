pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }

//    versionCatalogs {
//        create("libs") {
//            version("hilt", "2.47")
//            library("hilt-android", "com.google.dagger", "hilt-android").versionRef("hilt")
//            library("hilt-compiler", "com.google.dagger", "hilt-android-compiler").versionRef("hilt")
//        }
//    }
}

rootProject.name = "Safecrop Insight"
include(":app")
