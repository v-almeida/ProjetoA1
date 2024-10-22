plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "br.edu.up.supermercado"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.edu.up.supermercado"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
dependencies {
    implementation ("androidx.room:room-runtime:2.4.2")
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.material:material:1.3.2")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.material3.android)
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0")
}


