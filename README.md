
# ⏱️⏱️ **StopWatch** 
A simple stopwatch application that allows users to **start**, **pause** and **reset**. Useful for workouts, timing tasks, or tracking durations.

<img width="180" height="300" alt="Screenshot (127)" src="https://github.com/user-attachments/assets/0a90d205-e28c-44e5-b9d9-bfa70a983d92" /> <img width="180" height="300" alt="Screenshot (126)" src="https://github.com/user-attachments/assets/eb724630-1aaa-4872-900d-7853176d7ae6" />

#### 🚀 **Features**

- Start, Stop, and Reset functionality
- Clean and user-friendly interface
- Accurate time tracking using system clock

#### 🛠️ **Technologies Used**

- **Programming Language:** Kotlin  
- **Frameworks:** Android SDK, Jetpack Compose  
- **Tools:** Android Studio  

## How to build this app: step by step guide

#### 📖 **Mathematical Formulas to be remembered:**
The time is to be printed in the form **Hour**:**Minute**:**Second**:**MilliSecond**.

- Hour = (time/(1000*60*60))%24
- Minute = (time/(1000*60))%60
- Second = (time/1000)%60
- MilliSecond = time%1000

#### **Step 1**:  🧰 Install Android Studio
- Download Android Studio from the official website: [https://developer.android.com/studio](https://developer.android.com/studio)
- Follow the installation instructions for your operating system (Windows, macOS, or Linux)
- Make sure to install:
  -  **Android SDK**
  -   **Emulator**
  -    **Jetpack Compose support

#### **Step 2**: 📁 Create a New File
1. Create a new Kotlin file for your composable and stopwatch logic inside your project’s `ui` layer.

#### **Step 3**:  📦 Important packages to be imported:
<img width="300" height="600" alt="Screenshot (124)" src="https://github.com/user-attachments/assets/7e95b4c2-b15d-4115-a048-44954eddaaf6" />

#### **Step 4**: 🧩Composable Function Preview
- @Composable marks the function as a UI component.
- @Preview renders the UI in Android Studio's preview window.
```
@Preview( showBackground = true, showSystemUi = true)
@Composable
fun Stopwatch(modifier: Modifier = Modifier){}
```

####**Step 5**: 🧠 Logic

i) 🔢 Variables Used
- `time`: Stores the current elapsed time.
- `start_time`: Stores the starting time when the stopwatch starts. This helps in accurately resuming the timer after pauses.
- `is_running`: Boolean that tracks whether the stopwatch is currently active (`true`) or paused/stopped (`false`).

ii) 🔄 LaunchedEffect
Used in Jetpack Compose to launch a coroutine tied to the lifecycle of the composable. Ideal for running timers, animations, or background tasks.

iii) 🕒 System.currentTimeMillis()
Returns the current system time in milliseconds. Useful for measuring time differences and tracking elapsed time in real-time.

iv) ⚙️ How It Works
- `LaunchedEffect` observes the `is_running` state.
- When `is_running` becomes `true`, it calculates `start_time`.
- It enters a loop that continuously updates `time` using the difference between the current system time and `start_time`.
- `delay(10L)` controls the refresh rate of the stopwatch (every 10 milliseconds).

v) Code:
``` Kotlin
LaunchedEffect(is_running) {
   if (is_running) {
       start_time = System.currentTimeMillis()
       while (true) {
           time = System.currentTimeMillis() - start_time
                delay(10L)
       }
   }
}
```
#### **Step 6**:🧮 Formatted Time - **HH:MM:SS:MS**
- A new variable `formatted_time` is derived from `time` to convert raw milliseconds into a readable format (e.g., minutes:seconds:milliseconds).
- This improves the user interface by showing the stopwatch time in a clean, familiar format.

``` Kotlin
val hour = (time / (1000 * 60 * 60)) % 24
        val min = (time / (1000 * 60)) % 60
        val sec = (time / 1000) % 60
        val milsec = time % 1000
  
val formatted_time = String.format("%02d:%02d:%02d:%03d", hour, min, sec, milsec)
```

#### **Step 7**: ▶️ Defining Buttons-

There are 3 buttons — **Start**, **Stop**, and **Reset**:

- If the timer is not yet started, the **Start** button is active. After clicking it, the timer starts running.
- If the timer is running, the **Stop** button becomes active and stops the timer when clicked.
  
``` Kotlin
 Button(onClick = {is_running = !is_running}){
        Text( text = if(is_running) "stop" else "start")
}
```

- On the right side is the Reset button for resetting the timer.
  
``` Kotlin
Button(onClick = {is_running = false
     time=0}){
     Text(text = "Reset")
}
```

#### **Step 8**: 📱 Run the App

- Connect an Android device or start an emulator  
- Click on the **Run** ▶️ button in Android Studio
  
### Note : 🤝 For Contributors
- Contributions are welcome and appreciated! Whether it's fixing bugs, improving UI, or enhancing documentation — every bit helps.

#### 1. **Fork the Repository**
   - Click on the **Fork** button on the top-right of this repo
   - This creates a copy of the project under your GitHub account.
     
#### 2. Clone the Project
```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```
##### 3.🔁 Create a New Branch

```bash
git checkout -b my-feature-branch
```
#### 4.Make Changes
- Modify code or documentation using Android Studio or your preferred editor

#### 5. ✅ Commit Your Changes
```bash
git add .
git commit -m "✨ Add new feature or fix"
```
#### 6. Push to GitHub
```bash
git push origin my-feature-branch
```
#### 7. Create Pull Request
- Go to your fork on GitHub
- Click on Compare & pull request
- Write a meaningful title and description
- Click Create pull request

### ✅ Final Thoughts
This stopwatch app is a great project for learning:
  - ⏳ Real-time UI updates
  - ⚙️ State management in Compose
  - 🧠 Coroutines and side effects with LaunchedEffect
  - 🎨 Jetpack Compose UI design
    
You can extend this app by adding:
  - 📝 Lap functionality
  - 🔔 Notifications
  - 📊 Saving session history
    
# Happy coding! 🚀🚀🚀..














