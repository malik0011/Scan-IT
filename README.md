# ScanIt 🔍

## A Smart Nutritional Information Scanner
*Created with ❤️ by Ayan Malik*

![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Open Food Facts](https://img.shields.io/badge/Open%20Food%20Facts-API-blue?style=for-the-badge)

---

### 🌟 What's ScanIt?

Ever wondered what's really in your food? ScanIt is your pocket nutritionist! Simply scan any product's barcode, and boom 💥 - you get instant access to detailed nutritional information. No more squinting at tiny labels or trying to decode complex nutritional tables!

### ✨ Features

- **Quick Scan** 📱
    - Lightning-fast barcode scanning
    - Smooth, intuitive interface
    - Real-time product recognition

- **Detailed Nutrition Info** 🥗
    - Calories
    - Protein content
    - Sugar levels
    - Fats
    - Carbohydrates
    - Fiber content

- **Beautiful UI** 🎨
    - Sleek, modern design
    - Animated transitions
    - Progress indicators
    - Eye-friendly color scheme

### 🛠️ Tech Stack

- **Language**: Kotlin
- **Platform**: Android
- **Architecture**: MVVM
- **Key Libraries**:
  ```kotlin
  dependencies {
      // Retrofit for API calls
      implementation("com.squareup.retrofit2:retrofit:2.9.0")
      implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
      
      // Moshi for JSON parsing
      implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
      
      // Coroutines for async operations
      implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
      
      // ZXing for barcode scanning
      implementation("com.journeyapps:zxing-android-embedded:4.3.0")
      
      // Material Design components
      implementation("com.google.android.material:material:1.11.0")
  }
  ```

### 🌈 Color Palette

Our carefully chosen color palette ensures a pleasant user experience:

```xml
background: #F8F9FA  // Clean, crisp background
primary: #5C6BC0    // Trustworthy blue
accent: #26A69A     // Fresh teal
text: #37474F       // Readable dark gray
```

### 🎯 How It Works

1. **Launch & Animate** ✨
    - Beautiful splash screen with fade and slide animations
    - Smooth transition to scanner

2. **Scan & Process** 📸
    - Position barcode in frame
    - Instant recognition
    - Real-time API connection

3. **Display & Inform** 📊
    - Clean card layout
    - Visual progress indicators
    - Comprehensive nutritional breakdown

### 🔌 API Integration

ScanIt leverages the Open Food Facts API to fetch detailed product information:

```kotlin
interface OpenFoodFactsService {
    @GET("api/v0/product/{barcode}.json")
    suspend fun getProduct(@Path("barcode") barcode: String): ProductResponse
}
```

### 🎨 Design Philosophy

The app follows Material Design principles while maintaining its unique identity:
- Clean, minimalist interfaces
- Intuitive navigation
- Visual feedback
- Consistent spacing and typography

### 🚀 Future Roadmap

- [ ] Offline mode support
- [ ] Nutritional recommendations
- [ ] Product comparison
- [ ] Dietary preferences
- [ ] History tracking
- [ ] Share functionality

### 📱 Screenshots

[Insert beautiful screenshots here]

### 🤝 Contributing

Feel free to contribute to ScanIt! Whether it's:
- 🐛 Bug fixes
- ✨ New features
- 📚 Documentation
- 🎨 UI/UX improvements

### 📄 License

```
MIT License

Copyright (c) 2024 Ayan Malik

Permission is hereby granted, free of charge...
```

### 🙏 Acknowledgments

- Open Food Facts for their comprehensive food database
- ZXing for reliable barcode scanning
- Material Design for UI inspiration
- The amazing open-source community

---

<p align="center">
Made with 💖 and ☕ by <a href="https://github.com/malik0011">Ayan Malik</a>
</p>

---

*Note: Replace placeholder content (like screenshots) with actual content before publishing.*
