[![](https://jitpack.io/v/adnanaslamdev/Chromatic.svg)](https://jitpack.io/#adnanaslamdev/Chromatic)

# Chromatic

🎨 Color Picker for Jetpack compose

**Chromatic** is a powerful, customizable color picker library designed to provide an experience similar to Photoshop's color picker. With a sleek, intuitive interface, Chromatic enables developers to integrate a professional-grade color selection tool into their applications. Ideal for any project that requires precise color picking, Chromatic offers advanced features such as color sliders, hue and saturation adjustments, and real-time preview capabilities.


# Download

If you are using Kotlin, add this to `settings.gradle.kts`:
```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }
}
```

If you are using Groovy, add this to `settings.gradle`:
```groovy
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		maven { url 'https://jitpack.io' }
	}
}
```

For your module level gradle, if using Kotlin `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.adnanaslamdev:Chromatic:1.0.2")
}
```

For your module level gradle, if using Groovy `build.gradle`:

```groovy
dependencies {
        implementation 'com.github.adnanaslamdev:Chromatic:1.0.2'
}
```


# Usage

```kotlin
ChromaticPicker { color ->

}
```

You can provide options for **ChromaticPicker**:

_By default these options are set to true_

```kotlin
ChromaticPicker(
    showHue = false,
    showSaturation = false,
    showBrightness = false,
    showColorCode = false
) { color ->

}
```

#### ChromaticPicker Options
- Show/Hide Hue Text _(By default set to true)_

```kotlin
ChromaticPicker(
    showHue = false,
) { color ->

}
```
- Show/Hide Saturation Text _(By default set to true)_

```kotlin
ChromaticPicker(
    showSaturation = false,
) { color ->

}
```

- Show/Hide Brightness Text _(By default set to true)_

```kotlin
ChromaticPicker(
    showBrightness = false,
) { color ->

}
```

- Show/Hide Color Code Text _(By default set to true)_

```kotlin
ChromaticPicker(
    showColorCode = false,
) { color ->

}
```

#### _You can use this composable in any composable._
