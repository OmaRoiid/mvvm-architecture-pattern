# Mvvm-Architecture-Pattern
Android Architecture components are a collection of libraries that help you design robust, testable, and maintainable apps with more power over lifecycle management and data persistence. 
## Getting Started
* What is MVVM?.
 * MVVM is one of the architectural patterns which enhances the separation of concerns, it allows separating the user interface logic from the business (or the back-end) logic. Its target is to achieve the following principle “Keeping UI code simple and free of app logic in order to make it easier to manage”.
 * There are 3 parts to the Model-View-ViewModel architecture:
* 1- Model is the data layer of your app. It abstracts the data source.

* 2- View contains the UI of your app. Most often it’s implemented as an Activity or Fragment. View informs ViewModel of user interactions and displays results received from the ViewModel.View should be lightweight and contain zero to very little business logic.
* 3- ViewModel serves as a bridge between your View and Model. It works with the Model to get and save the data. The View observes and reacts to the data changes exposed by the ViewModel.
 ![myimage-alt-tag](https://miro.medium.com/max/1200/1*KnYBBZIDDeg4zVDDEcLw2A.png)
 ## Resources
  * 1- Please Visit [codelabs](https://codelabs.developers.google.com/codelabs/android-room-with-a-view-kotlin/#0) for the guidance  of how to use a MVVM Architectural Patterns in  best practice
  * 2- This [Playlist](https://www.youtube.com/watch?v=ARpn-1FPNE4&list=PLrnPJCHvNZuDihTpkRs6SpZhqgBqPU118) will helps you to understand the Architectural but it just to make you familiar with its implementation
  ## Just for Help 
* Please don't copy the  code in the resource no worries if some  of  it  but try to understand  the Architecture on your own way by reading from more resources then note it on your Notepad then implement it on your understanding  
*  You are not forced  to learn every new Architectural Pattern in Android development you just need to learn a new one  if  your project needs it , if not, just be familiar with it 
* Hope this two Articles helps  [Learnings From 3 Years Of Android Development](https://medium.com/mindorks/learnings-from-3-years-of-android-development-c0d68b8ecea1) , [Android Architecture Patterns ](https://medium.com/upday-devs/android-architecture-patterns-part-1-model-view-controller-3baecef5f2b6)
## At The End
*  Comments and reviews are so welcome  
