apply plugin: 'com.android.application'

android {
    compileSdkVersion 22
    buildToolsVersion '22.0.1'
    defaultConfig {
        applicationId "com.example.android.testing.espresso.BasicSample"
        minSdkVersion 10
        targetSdkVersion 22
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        exclude 'LICENSE.txt'
    }
    lintOptions {
        abortOnError false
    }
    productFlavors {
    }
}

dependencies {
    // App dependencies
    compile 'com.android.support:support-annotations:22.2.0'
    // Testing-only dependencies
    androidTestCompile 'com.android.support.test:runner:0.3'
    androidTestCompile 'com.android.support.test:rules:0.3'
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2'
}
