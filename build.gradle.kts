buildscript {
    extra["compose_version"] = "1.3.0"
    extra["dagger_hilt_version"] = "2.45"
    dependencies {
        // ...
        //TODO: erase the comment slashes once the google-service file is added to the project
        // classpath 'com.google.gms:google-services:4.3.2'
      //  classpath 'com.google.firebase:firebase-crashlytics-gradle:2.9.2'
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}