import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.jworld.androidbasic"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.jworld.androidbasic"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile("proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":core-data"))


    // AndroidX Library
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.AndroidX.material)
    implementation (Libs.AndroidX.constraintLayout)
    implementation (Libs.AndroidX.recyclerview)
    implementation (Libs.AndroidX.legacy)
    implementation (Libs.AndroidX.Lifecycle.extensions)
    implementation (Libs.AndroidX.Lifecycle.livedata)
    implementation (Libs.AndroidX.Lifecycle.viewModel)
    implementation (Libs.AndroidX.Lifecycle.java8)

    // Navigation Component
    implementation (Libs.AndroidX.Navigation.fragment)
    implementation (Libs.AndroidX.Navigation.ui)


    // Test
    testImplementation (Libs.Test.junit)
    androidTestImplementation (Libs.Test.junitExt)
    androidTestImplementation (Libs.Test.espresso)

    // rxjava
    implementation (Libs.Reativex.rxjava)
    implementation (Libs.AndroidX.Room.roomRxjava)

    // multiDex
    implementation (Libs.AndroidX.multiDex)

    // Glide Libs
    implementation (Libs.Glide.glide)
    kapt (Libs.Glide.compiler)

}