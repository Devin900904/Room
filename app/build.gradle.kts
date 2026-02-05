plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // 必要的插件
}

android {

    namespace = "te.oldpa.myroom"
    compileSdk = 36
    buildFeatures{
        dataBinding =true
    }
    defaultConfig {
        applicationId = "te.oldpa.myroom"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}



dependencies {
//    implementation(libs.sdp.android)
//    implementation(libs.ssp.android)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation ( "com.intuit.sdp:sdp-android:1.1.1" )
    implementation ( "com.intuit.ssp:ssp-android:1.1.1" )

    // ★★★ 關鍵修正區 ★★★
    // 這裡我們全部使用剛剛在 TOML 定義好的變數，版本就會統一變成 2.6.1
    // 不會再有 2.5.2 和 2.8.4 打架的問題
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)

    // 使用 kapt 載入編譯器
    kapt(libs.androidx.room.compiler)

    // 測試用
    androidTestImplementation(libs.androidx.room.testing)
    // ★★★ 修正結束 ★★★



    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}