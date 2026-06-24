# Basic Jetpack Compose

This repository is a demonstration of an Android application built using **Jetpack Compose**, showcasing modern architectural patterns and various UI components.

## Features

- **MVVM Architecture**: Implemented in the Fruits section to manage state and logic using a repository pattern.
- **MVI Architecture**: Implemented in the Counter section, featuring a unidirectional data flow with Intents and State updates.
- **Tabbed Navigation**: Uses a `TabRow` within a `Scaffold` to switch between different architectural examples.

## Jetpack Compose Components Demonstrated

The project utilizes a wide range of Compose components, including:

- **Layouts**: `Scaffold`, `Column`, `Row`, `Spacer`.
- **Containers**: `LazyColumn`, `Card`.
- **UI Elements**:
    - `Text`: For labels and dynamic content.
    - `Buttons`: Including `Button`, `OutlinedButton`, and `FilledTonalButton`.
    - `Image`: Displaying local resources using `painterResource`.
    - `CircularProgressIndicator`: Indicating background processing states.
- **Navigation & State**: `TabRow`, `Tab`, and state management with `StateFlow` and `LiveData`.

## Project Structure

- **MVI**: Located in `com.neilmosca.basiccompose.mvi`
- **MVVM**: Located in `com.neilmosca.basiccompose.mvvm`
- **Navigation**: Managed in `MainScreen.kt`

