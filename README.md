
# StopWatch
A simple stopwatch application that allows users to **start**, **pause** and **reset**. Useful for workouts, timing tasks, or tracking durations.

## 🚀 Features

- Start, Stop, and Reset functionality
- Lap time recording
- Clean and user-friendly interface
- Accurate time tracking using system clock


# How to build this app:

### Mathematical Formulas to be remembered-
The time is to be printed in the form **Hour**:**Minute**:**Second**:**MilliSecond**.

- Hour = (time/(1000*60*60))%24
- Minute = (time/(1000*60))%60
- Second = (time/1000)%60
- MilliSecond = time%1000

### Defining Buttons-
There are 3 buttons Start, Stop and Reset:

- If the timer is not yet started the Start button is active after clicking it the timer starts running.
- If the timer is running the stop button gets active.
  
** Button(onClick = {is_running = !is_running}){
        Text( text = if(is_running) "stop" else "start")
}**

- On the right side is the reset button for reseting the timer.

**Button(onClick = {is_running = false
     time=0}){
     Text(text = "Reset")
}**

### -



  ## 📌 Usage











