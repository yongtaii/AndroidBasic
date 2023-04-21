plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jworld.core.common"
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
    implementation (Libs.AndroidX.material)

    // Test
    testImplementation (Libs.Test.junit)
    androidTestImplementation (Libs.Test.junitExt)
    androidTestImplementation (Libs.Test.espresso)

    //Hilt
    implementation (Libs.Hilt.hilt)
    kapt (Libs.Hilt.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}