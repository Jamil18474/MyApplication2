# Application Sécurité Économique

## Description

Application Android native en Kotlin pour consulter le guide officiel "La sécurité économique au quotidien, en 28 fiches pratiques" du ministère de l'Économie.

## Fonctionnalités

- Navigation intuitive avec menu principal
- 28 fiches pratiques de sécurité économique
- Liens email cliquables vers délégués régionaux
- Interface Material Design 3
- Contenu organisé en 7 sections thématiques

## Technologies

- **Kotlin** + **Jetpack Compose**
- **Material Design 3**
- **Navigation Component**
- **Android SDK**

## Installation

1. Cloner le repository
```bash
git clone https://github.com/Jamil18474/MyApplication2.git
cd MyApplication2
```

2. Ouvrir dans Android Studio et synchroniser

3. Lancer sur émulateur ou appareil Android 7.0+

Structure du contenu

    Avant-Propos & Éditorial : Introduction officielle
    A - Penser la sécurité : Politique, veille, protection
    B - Dans l'entreprise : Locaux, personnel, visiteurs
    C - Protéger son patrimoine : Savoir, compétences, archives
    D - Conduite des affaires : Financements, conformité
    E - Le numérique : Cybersécurité, télétravail
    F - Communiquer : Communication, réseaux sociaux
    G - À l'extérieur : Déplacements, salons

## Build

```bash
### APK debug
./gradlew assembleDebug

### APK release
./gradlew assembleRelease
```