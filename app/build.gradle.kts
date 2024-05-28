plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "dev.gustavo.analiticatest"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.gustavo.analiticatest"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.squareup.retrofit2", "retrofit","2.11.0")
    implementation("com.squareup.retrofit2", "converter-gson","2.11.0")
    implementation("com.google.code.gson", "gson", "2.10.1")
    implementation("com.squareup.okhttp3","okhttp","5.0.0-alpha.10")
    implementation("com.squareup.okhttp3","logging-interceptor","5.0.0-alpha.10")
}