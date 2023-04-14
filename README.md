# mixed-rice-app
Android App for "Arroces Mixtos" store using latest Architecture components and Dependency Injection 

## Preview for first approach
https://user-images.githubusercontent.com/16215046/125923105-18e7e3c6-aee2-48be-8242-0c3bdad47be8.mp4

## Technologies

### Libraries
- **Android ViewModels**
- **Android LiveData**: UI updates from ViewModel to Activity
- **Koin**: Dependency injection
- **Room**: Local database

### Background Strategy:
- **Kotlin Coroutines**

### Code Quiality
- **Code Style**: Added task using [ktlint](https://github.com/pinterest/ktlint) to keep a good code styel. The code style task is run always before the build task.

### View retrieval strategy 
I'm using **Android DataBinding** and **View Binding**

### TODO
- **Unit Testing**: Created unit test for each Module.

## Architecture
- Using **Clean Architecture** for the whole application and using **MVVM** for the presentation layer.

![Clean Arch](https://user-images.githubusercontent.com/16215046/122849576-5e7a4000-d2d1-11eb-90a2-556d0bcb5225.png)
