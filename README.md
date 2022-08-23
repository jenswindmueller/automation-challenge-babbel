
# Automation Test Framework for web and native Android apps 


When presented with this challenge, I saw a good opportunity to combine my previous experience with Cucumber and 
Selenium with Appuim knowing that Babbel uses it for Mobile Test Automation. 
Overall I really enjoyed this hiring challenge as it truly tests the necessary knowledge of Test Automation Engineering and I even learned 
new things along the way. I could have spent weeks perfecting it more and more so it was quite hard to find a cut off point and hand 
it in but I am very pleased with my result.



## Installation
Download or clone this repository since we will be executing the Anndroid test scenarios in this app:
https://github.com/babbel-careers/automation-challenge

Download and Install IntelliJ - IDE (community version is fine for this project) https://www.jetbrains.com/idea/download/#section=mac

Same goes for Android Studio https://developer.android.com/studio/
after installing check if android studio needs to be restarted

Install ***Java 11***    
After that do the following in the terminal, enter ```$ nano ~/.profile``` or ```$ open -e .bash_profile```
copy these commands and set your own username and JDK version and paste the following on profile:
```
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
export ANDROID_HOME=/Users/<user>/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export PATH=$ANDROID_HOME/tools/bin:$PATH
```
Save from File > Save and close the bash profile text editor  
Now your Java and Android home environment variable has been set

then source the profile file:
```
source ~/.profile
```

### Install all the pre-requisites for Appium

Install Xcode command line 
```
$ Xcode-select --install
```
Install Homebrew 
```
$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
Use following commands
```
$ brew install npm
```
Check if nodeJS is installed with below command
```
$ node -v
```
```
$ npm install -g appium
```
```
$ npm install appium-doctor -g
```


Run ```$ appium-doctor```
Add missing dependencies

***Open the QA app in Android Studio***

Install the Pixel ***4 API 30*** emulator platform 11  
The test will run on this device (later you can change it in the test framework under Capabilities.java)  
Run the App on the emulator  
Close the project  

The Android Studio welcome window will appear, click on the dropdown menu on the very left and select ***Virtual Device Manager***

<img width="998" alt="Screenshot 2022-08-22 at 16 34 15" src="https://user-images.githubusercontent.com/73068211/186099566-92bdfbd4-673b-427a-8bef-bae4de6f1ccb.png">


Select ***Pixel 4 API 30***

<img width="793" alt="Create device" src="https://user-images.githubusercontent.com/73068211/186099644-1ea3a709-7239-46a2-be13-6a75ac222e8c.png">


Now we are almost ready to run our tests for Android

Open this test framework in IntelliJ

After the build has finished:

Go to src/main/java/androidSetUp/Capabilities.java
In line 25 add the file path of the app-debug.apk that way the server knows which app we are running our automation on (it should look something like this “/automation-challenge-master/android/app-debug.apk”)

Then proceed to build.gradle
on the bottom of the file there are two tasks cucumberWeb() and cucumberAndroid()  
First run cucumberWeb() after that run cucumberAndroid()

Then you can open the feature files and run whichever test needed 
(for andriod tests make sure you leave the emulator open)


