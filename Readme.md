![](https://cloud.githubusercontent.com/assets/556934/25672246/9a20e960-2fe7-11e7-99d3-23652878a2c2.png)

> ### Android/Kotlin codebase containing real world examples (CRUD, auth, advanced patterns, etc) that adheres to the [RealWorld](https://github.com/gothinkster/realworld) spec and API.

This codebase was created to demonstrate a fully fledged fullstack application built
with **Java** including CRUD operations, authentication, routing, pagination, and more.

See how a Medium.com clone (called Conduit) is built using java in Android to connect
to any other backend from https://realworld.io/.

For more information on how to this works with other backends, head over to
the [RealWorld](https://github.com/gothinkster/realworld) repo.

I've gone to great lengths to adhere to the latest community styleguides &
best practices but had to adapt between the RealWorld specification
and general mobile layout of Medium.com.
### Demo

<table>
  <tr>
    <td> Drawer</td>
     <td> Login/Sign up</td>
     <td> After Login</td>
  </tr>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/71203077/114977235-f8260b00-9ea4-11eb-914d-df11d63af508.png"width="300"></td>
    <td><img src="https://user-images.githubusercontent.com/71203077/114977288-10962580-9ea5-11eb-8d36-d7d48b9d90bc.png"width="300"></td>
    <td><img src="https://user-images.githubusercontent.com/71203077/114977481-58b54800-9ea5-11eb-8ea4-85c6e407b9dd.png"width="300"></td>
  </tr>
 </table>


### Development
This project has been developed with [Android Studio](https://developer.android.com/studio/)

### Concepts
This RealWorld app tries to show the following Android concepts:
* Java Codebase
* MVVM (Model View ViewModel) Architecture
* LiveData
* Kotlin Coroutines
* Jetpack Navigation Architecture

### Other Backends
Obviously, this RealWorld app is a frontend app. But it can connect to all backends implementing the [RealWorld](https://github.com/gothinkster/realworld) spec and API. To test you own backend implementation just change the URL in the settings dialog.

## Testing
This project has been manually tested against
* Emulator
  * Pixel 4 Android SDK 27

## License & Credits
Credits have to go out to [Thinkster](https://thinkster.io/) with their awesome [RealWorld](https://github.com/gothinkster/realworld)

This project is licensed under the MIT license.
