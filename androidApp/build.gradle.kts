plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.jetbrains.androidApp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    namespace = "com.jetbrains.androidApp"
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0") // Updated version to 1.4.0
    implementation("androidx.appcompat:appcompat:1.4.0") // Updated version to 1.4.0
    implementation("androidx.constraintlayout:constraintlayout:2.1.0") // Updated version to 2.1.0
    implementation("androidx.compose.ui:ui:1.0.0")
    implementation("androidx.compose.material:material:1.0.0")
    implementation("androidx.compose.ui:ui-tooling:1.0.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.0")
    implementation("androidx.activity:activity-compose:1.3.0") // Updated version to 1.3.0
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
}
