plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.8.20"
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jworld.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    // AndroidX Library
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.AndroidX.Lifecycle.java8)

    // Test
    testImplementation (Libs.Test.junit)
    androidTestImplementation (Libs.Test.junitExt)
    androidTestImplementation (Libs.Test.espresso)

    // retrofit
    implementation (Libs.Square.retrofit)
    implementation (Libs.Square.gson)
    implementation (Libs.Square.okhttp3Logging)
    implementation (Libs.Square.adapterRxjava)
    implementation (Libs.Square.jackson)
    implementation (Libs.Square.jacksonAnnotation)
    implementation (Libs.Square.jacksonDatabind)

    //rxjava
    implementation (Libs.Reativex.rxjava)

    //coroutine
    implementation (Libs.Kotlin.coroutine)

    //Hilt
    implementation (Libs.Hilt.hilt)
    kapt (Libs.Hilt.hiltCompiler)

    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

}

kapt {
    correctErrorTypes = true
}