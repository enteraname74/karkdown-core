plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    jvmToolchain(17)
}

version = "0.1.0"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}
