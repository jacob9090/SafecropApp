plugins {
    alias(libs.plugins.android.application)
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.jacob.fruitoftek.safecrop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jacob.fruitoftek.safecrop"
        minSdk = 30
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
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        viewBinding = true
    }
//    aaptOptions.noCompress.addAll(listOf("tflite", "lite"))

    androidResources {
        noCompress.add("tflite")
//        noCompress.add("lite") // If you still want to include "lite"
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.work.runtime)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.swiperefreshlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //com.android.application
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.20")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.android.volley:volley:1.2.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("com.google.android.gms:play-services-location:21.2.0")
    implementation ("androidx.exifinterface:exifinterface:1.3.7")
    implementation ("com.github.AtifSayings:CircularImageView:1.0.2")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("com.karumi:dexter:6.2.3")
    implementation ("com.opencsv:opencsv:4.6")
    implementation ("com.squareup.picasso:picasso:2.71828")

    implementation ("com.github.JDevZone:FillProgressLayout:0.0.8")
    implementation ("de.psdev.licensesdialog:licensesdialog:2.1.0")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation ("com.ogaclejapan.smarttablayout:library:2.0.0@aar")
    implementation ("com.ogaclejapan.smarttablayout:utils-v4:2.0.0@aar")
    implementation ("com.github.lzyzsd:circleprogress:1.2.1")
    implementation ("com.heinrichreimersoftware:material-intro:2.0.0")
    implementation ("com.github.f0ris.sweetalert:library:1.6.2")
    implementation ("com.github.onurkagan:ktoast:1.0.3")
    implementation ("com.github.ivbaranov:materialfavoritebutton:0.1.5")

    // Retrofit and OkHttp for networking
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.11.0")
    implementation("androidx.webkit:webkit:1.10.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")

    // Hilt dependencies
//    implementation ("com.google.dagger:dagger:2.47")
//    annotationProcessor ("com.google.dagger:dagger-compiler:2.47")
    implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation ("com.google.dagger:hilt-android:2.47")
    annotationProcessor ("com.google.dagger:hilt-android-compiler:2.47")
    implementation ("androidx.hilt:hilt-work:1.0.0")
    annotationProcessor ("androidx.hilt:hilt-compiler:1.0.0")

    implementation ("androidx.core:core:1.12.0")
    implementation ("com.github.angads25:toggle:1.1.0")

    // CameraX
    implementation ("androidx.camera:camera-core:1.4.1")
    implementation ("androidx.camera:camera-camera2:1.4.1")
    implementation ("androidx.camera:camera-lifecycle:1.4.1")
    implementation ("androidx.camera:camera-view:1.4.1")

    // WorkManager
    implementation ("androidx.work:work-runtime:2.8.1")

    implementation ("org.osmdroid:osmdroid-android:6.1.20")

    //ML Kit (To detect faces)
    implementation ("com.google.mlkit:face-detection:16.1.5")
    implementation ("com.google.android.gms:play-services-mlkit-face-detection:17.0.1")

    //GSON (Conversion of String to Map & Vice-Versa)
    implementation ("com.google.code.gson:gson:2.8.9")

    //Lottie-files (Splash-screen Animation)
    implementation ("com.airbnb.android:lottie:4.2.2")

    //TensorFlow Lite libraries (To recognize faces)
    implementation ("org.tensorflow:tensorflow-lite-task-vision:0.3.0")
    implementation ("org.tensorflow:tensorflow-lite-support:0.3.0")
    implementation ("org.tensorflow:tensorflow-lite:0.0.0-nightly-SNAPSHOT")

    // Room
    implementation ("androidx.room:room-runtime:2.5.2")
    annotationProcessor ("androidx.room:room-compiler:2.5.2")

    implementation ("androidx.security:security-crypto:1.1.0-alpha06")

    // ViewModel & LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")

}