# IDINA Language Adventure

## Overview
IDINA is a 3D immersive language learning mobile game for Android that transforms language acquisition into an urban survival experience. The game focuses on European languages (Spanish, English, and French) and provides an engaging way to learn through interactive gameplay.

## Features
- **3D Immersive Environments**: Explore realistic cityscapes for each language
- **Voice Recognition**: Practice speaking with advanced voice recognition
- **Cultural Authenticity**: Experience authentic cultural elements in each city
- **Progressive Learning**: Adaptive difficulty based on player's language level
- **Offline Play**: Continue learning without an internet connection

## Technical Stack
- **Language**: Kotlin
- **3D Engine**: LibGDX with Box2D
- **Dependency Injection**: Koin
- **Voice Recognition**: Google ML Kit
- **Architecture**: MVVM with Clean Architecture principles

## Setup Instructions
1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Build and run on an emulator or physical device

## Project Structure
```
app/
├── src/
│   ├── main/
│   │   ├── java/com/idina/languageadventure/
│   │   │   ├── di/               # Dependency Injection modules
│   │   │   ├── game/             # Core game logic and rendering
│   │   │   ├── ui/               # Activities and fragments
│   │   │   └── util/             # Utility classes
│   │   └── res/                  # Resources
│   └── test/                     # Unit tests
└── build.gradle                 # Project-level build configuration
```

## Building the Project
1. Ensure you have Android Studio 2022.2.1 or later
2. Open the project in Android Studio
3. Wait for Gradle sync to complete
4. Click 'Run' to build and deploy to a device/emulator

## Contributing
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

## Acknowledgments
- [LibGDX](https://libgdx.com/) - The game development framework
- [Koin](https://insert-koin.io/) - Dependency injection framework
- [Material Components](https://material.io/components) - UI components