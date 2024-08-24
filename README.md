**Kotlin Multiplatform SpaceX Rocket Launches App**

This project is a Kotlin Multiplatform application that targets both Android and iOS platforms. It fetches SpaceX rocket launch data using the SpaceX API and demonstrates how to use Room for local storage and ViewModel in the shared module. The UI for the Android version is implemented using Jetpack Compose.


**Features**

• **Fetch Rocket Launches**: Retrieves SpaceX rocket launch data.

• **Shared ViewModel**: Implements ViewModel in the shared module for state management.

• **Room Database**: Stores rocket launch data locally using Room in the shared module.

• **Jetpack Compose UI**: The Android UI is built using Jetpack Compose.

• **Dependency Injection**: Uses Koin for dependency injection across platforms.



**Tech Stack**



• **Kotlin Multiplatform**: Shared codebase for Android and iOS.

• **Koin**: Dependency injection framework.

• **Ktor**: HTTP client for making network requests.

• **Room**: Database for storing rocket launch data.

• **Jetpack Compose**: UI toolkit for building native Android UIs.

• **SQLite**: Database engine bundled with Room.



**Dependencies**

`// Core libraries`
`kotlin = "2.0.20"`
`ktor = "2.3.12"`
`koin = "3.5.3"`
`room = "2.7.0-alpha07"`

`// Android`
`agp = "8.5.0"`
`compose = "1.7.0-rc01"`
`compose-material3 = "1.1.2"`
`androidxLifecycle = "2.8.0"`
`coilCompose = "2.7.0"`

`// iOS`
`// Add iOS-specific dependencies here`

**Setup**

1. Clone the repository.

2. Open the project in Android Studio.

3. Sync the project with Gradle.

4. Run the app on Android or iOS.



**Usage**

• **Fetch Data**: On app launch, the SpaceX rocket launches are fetched from the API and stored locally.

• **Offline Access**: Rocket launches can be accessed offline using Room.


**Contribution**

Contributions are welcome! To contribute:

1. Fork the repository.

2. Create a new branch with your feature or bugfix.

3. Commit your changes.

4. Submit a pull request with a detailed description of your changes.

**License**

This project is licensed under the MIT License.