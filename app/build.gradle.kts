import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.ummaaack.halueumpyo.Dep
import com.ummaaack.halueumpyo.App


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}


android {

    compileSdk = App.compileSdk
    defaultConfig {
        applicationId = "com.fork.multimodule_study"
        minSdk = App.minSdk
        targetSdk = App.targetSdk
        versionCode = App.versionCode
        versionName = App.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", getApiKey("base_url"))
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
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
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(Dep.Coroutine.core)
    implementation(Dep.Coroutine.android)
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation(Dep.Coroutine.test)

    implementation(Dep.Android.core)
    implementation(Dep.Android.appcompat)
    implementation(Dep.Android.material)
    implementation(Dep.Android.constraintLayout)
    implementation(Dep.Android.fragment)

    implementation(Dep.Lifecycle.viewModel)
    implementation(Dep.Lifecycle.runtime)
    implementation(Dep.Lifecycle.savedState)
    implementation(Dep.Lifecycle.livedata)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)

    implementation(Dep.OkHttp.core)
    implementation(Dep.OkHttp.loggingInterceptor)
    implementation(Dep.OkHttp.mockWebServer)
    implementation(Dep.Retrofit.core)
    implementation(Dep.Retrofit.converterMoshi)
    implementation(Dep.Moshi.core)
    implementation(Dep.Moshi.kotlin)
    // Gson
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.4.1")
    implementation("androidx.security:security-crypto:1.1.0-alpha03")
    kapt("com.github.bumptech.glide:compiler:4.12.0")


    implementation(Dep.timber)
    implementation(Dep.Moshi.core)
    implementation(Dep.Moshi.kotlin)

    testImplementation(Dep.Test.junit)
    androidTestImplementation(Dep.AndroidTest.core)
    androidTestImplementation(Dep.AndroidTest.rules)
    androidTestImplementation(Dep.AndroidTest.runner)
    androidTestImplementation(Dep.AndroidTest.junitExt)
}

fun getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyKey)
}