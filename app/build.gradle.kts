plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.parcelize")
}

android {
    namespace = "com.msa.componentcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.msa.componentcompose"
        minSdk = 26
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.paging.compose.android)
    implementation(libs.play.services.base)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.ui.test.manifest)

    //pager image
    implementation (libs.accompanist.pager)
    implementation (libs.accompanist.pager.indicators)

    //coil loading image
    implementation(libs.coil.compose)

    //material.icons
    implementation(libs.androidx.material.icons.extended.android)

    implementation(libs.haze)

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0-RC.2")

    implementation ("com.airbnb.android:lottie-compose:6.4.0")

    //Richeditor
    implementation("com.mohamedrejeb.richeditor:richeditor-compose:1.0.0-rc05")


    // System UI bars
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    // Permissions
    implementation ("com.google.accompanist:accompanist-permissions:0.28.0")
    //map
    implementation ("org.osmdroid:osmdroid-android:6.1.16")
}