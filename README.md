# Sonora для Android

Sonora — нативный музыкальный плеер для Android 8.0+ на ARM64. Готовые APK находятся в [Releases](https://github.com/MixiYT/SonoraAndroidNative/releases).

## Сборка из исходников

Используйте [общий репозиторий исходников](https://github.com/MixiYT/Sonora-development-share). Текущий снимок Android — 0.3.26. Сохраняйте рядом `sonora-android/` и `crates/`, поскольку скрипт использует относительный путь к UniFFI.

Соберите APK через `./build-native.ps1` из `sonora-android`. Понадобятся JDK 21, JVM toolchain 17, SDK API 37, NDK 27.2.12479018, Rust и цель `aarch64-linux-android`. См. [полную инструкцию](https://github.com/MixiYT/Sonora-development-share#сборка-android).

## Зависимости

```mermaid
flowchart LR
  Screen["Kotlin / Compose"] --> VM["PlayerViewModel"]
  VM --> Media["Media3 / MediaSession"]
  VM --> Network["MusicNetwork / TokenStation"]
  VM --> Shared["Gradle :shared"]
  Network --> Kotlin["Сгенерированные биндинги UniFFI"]
  Kotlin --> Native["JNA / libsonora_ffi.so"]
  Native --> Core["sonora-core"]
```

См. [подробную карту](https://github.com/MixiYT/Sonora-development-share/blob/main/DEPENDENCY-MAP.md), [файловый индекс](https://github.com/MixiYT/Sonora-development-share/blob/main/docs/dependency-index.md) и [историю изменений](https://github.com/MixiYT/Sonora-development-share/blob/main/CHANGELOG.md).
