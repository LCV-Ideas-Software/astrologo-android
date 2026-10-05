plugins {
    id("com.android.application")
}

android {
    namespace = "dev.lcv.astrologo"
    compileSdk = 37

    defaultConfig {
        applicationId = "dev.lcv.astrologo"
        // Android 16: nenhum aplicativo *-android abaixo dele (decisão do
        // operador, 04/10/2026).
        minSdk = 36
        targetSdk = 37
        versionCode = 1
        versionName = "0.1.0"
    }

    // Release signing is injected by the publishing workflow through the
    // android.injected.signing.* properties, so no key material and no
    // password is ever written into this repository.
}
