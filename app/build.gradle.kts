plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "com.example.armdroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.armdroid"
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
            isDebuggable = true
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
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE"
            merges += "META-INF/LICENSE.txt"
            merges += "META-INF/DEPENDENCIES"
            merges += "META-INF/NOTICE"
            merges += "META-INF/NOTICE.txt"
            merges += "META-INF/NOTICE.md"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.compose.material:material-android:1.6.7")
    implementation("androidx.wear.compose:compose-material:1.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    //Implementations for retrofit for network call
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Jetpack Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.compose.runtime:runtime-livedata:1.0.4")

// Coroutines for asynchronous programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")

// Dependencies for firebase crashlytics & analytics
// implementation("com.google.firebase:firebase-crashlytics:18.2.13")
// implementation("com.google.firebase:firebase-analytics:21.1.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("com.google.truth:truth:1.1.5")

    implementation("io.coil-kt:coil-compose:2.4.0")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("com.google.truth:truth:1.1.5")

    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestUtil("androidx.test:orchestrator:1.4.2")

    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0")

    implementation("com.google.dagger:hilt-android:2.45")
    // kapt("com.google.dagger:hilt-android-compiler: 2.45")


}
