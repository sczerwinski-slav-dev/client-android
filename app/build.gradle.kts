plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.android.junit5)
    alias(libs.plugins.detekt)
}

android {
    namespace = "dev.slav.client.android"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.slav.client.android"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom("$rootDir/config/detekt.yml")
}

dependencies {
    implementation(project(":modules:features:posts"))

    implementation(project(":modules:common:network"))
    implementation(project(":modules:common:ui"))

    implementation(libs.kotlinx.serialization)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.androidx.ui)
    implementation(libs.bundles.androidx.navigation)
    implementation(libs.bundles.hilt)
    ksp(libs.bundles.hilt.ksp)
    implementation(libs.timber)

    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.assertj.core)

    androidTestImplementation(libs.junit.jupiter.api)
    androidTestImplementation(libs.assertj.core)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.android)

    debugImplementation(libs.bundles.androidx.ui.debug)

    detekt(libs.bundles.detekt)
}
