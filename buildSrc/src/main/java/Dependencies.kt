internal object Versions {
    // Basics
    const val kotlinVersion = "1.5.10"
    const val coreKtxVersion = "1.6.0"
    const val appCompatVersion = "1.3.0"

    // Ktlint
    const val ktLintVersion = "0.41.0"

    // DI
    const val koinVersion = "2.1.5"

    // Test
    const val jUnitVersion = "4.12"
    const val jUnitExtAndroidVersion = "1.1.3"
    const val espressoTestingVersion = "3.4.0"
    const val mockito3Version = "3.3.3"
    const val coroutinesTestingVersion = "1.3.7"

    // Lifecycle
    const val lifecycleVersion = "2.3.1"

    // DB
    const val roomVersion = "2.3.0"

    // API
    const val retrofitVersion = "2.9.0"

    // Background Strategy
    const val coroutinesVersion = "1.3.7"

    // Gson
    const val gsonVersion = "2.8.7"

    // UI
    const val materialVersion = "1.4.0"
    const val navigationVersion = "2.3.5"
    const val constraintLayoutVersion = "2.0.4"
    const val cardViewVersion = "1.0.0"
    const val picassoVersion = "2.71828"
    const val swipeRefreshLayoutVersion = "1.1.0"
}

object Dependencies {
    // Bascis
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // Ktlint
    const val ktLint = "com.pinterest:ktlint:${Versions.ktLintVersion}"

    // DI
    const val koinCore = "org.koin:koin-core:${Versions.koinVersion}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koinVersion}"

    // Lifecycle
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    // DB
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"

    // API
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // Background Strategy
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"

    // Gson
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    // UI
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val constraintLayout ="androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardViewVersion}"
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayoutVersion}"

}

object TestDependencies {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitExtAndroid = "androidx.test.ext:junit:${Versions.jUnitExtAndroidVersion}"
    const val espressoTesting = "androidx.test.espresso:espresso-core:${Versions.espressoTestingVersion}"
    const val mockito3 = "org.mockito:mockito-core:${Versions.mockito3Version}"
    const val coroutinesTesting = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestingVersion}"
}
