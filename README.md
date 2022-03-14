# Android Challenge for Passporter

Hello Android Team 👋, here is my code for the challenge. For build this app I used MVVM Architecture with repository pattern and obviously with Kotlin.

---

### Libraries used
 - Coroutines for asynchronous
 - Hilt for dependency injection
 - Android JetPack
 	- Flow
	- ViewModel
	- ViewBinding
	- Room
 - Architecture
 	- MVVM Architecture (View - DataBinding - ViewModel - Model)
	- Repository pattern
 - Material-Components
 - Retrofit2 & OkHttp3
 
---

### Features

✅ Display a list of repositories<br>
✅ Request only 10 repos at a time (pagination)<br>
✅ Show a light green background if fork flag is false or missing<br>
❌ Create a dialog and open it on item long click

---

### Chosen Libraries
**Hilt** Due to this is an "easy app" in terms that we don't have business logic, I decided to use it instead of *Dagger* because is an easiest way to configure and implement the dependency injection, however *Dagger* still the best option for big and moduled apps


**Coroutines** in this project are used to provide a background thread while the data is retrieving

**Flow** instead of liveData for ui and model updates

**Room** for save locally the data retrieved

---

### Disclaimer
The app won't compile unless the developer offer the API_KEY for local testing. I added a functional debug.apk at the repository root, however if you want test the app locally, comment:

 - line *27* and *22* at *Network* object **(client configuration)**
 - line *21* at *build.gradle* **(api_key)**
 - check the remaningCalls `curl -I https://api.github.com/users/DrassApps`

The code doesn't handle backend errors or user non-happy flows like try to get the backend data without internet connection, it may produce a crash

---

### Roadmap

- [ ] Inject repositories on ViewModel and propagate it to domain lay
- [ ] Consider use Paging3 library of JetPack for handle more efficiently the pagination requests
- [ ] Implement Resource<T> response for handle errors
