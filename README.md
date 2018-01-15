[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]() 

# DigitalNotes
Things written in android will be transferred to PC, where it is displayed like notes. 

# Dependencies

  * PIP
  * ADB
  * matplotlib


# How to use?

1. Install ADB [Windows](https://www.howtogeek.com/125769/how-to-install-and-use-abd-the-android-debug-bridge-utility/) & [Linux](https://www.linuxbabe.com/ubuntu/how-to-install-adb-fastboot-ubuntu-16-04-16-10-14-04).
2. Install the mobile app from app/build/outputs/apk using the command ```adb install app-debug.apk```
3. ``` git clone https://github.com/thunderbo1t/DigitalNotes.git ```
4. ``` cd DigitalNotes ```
5. ``` pip install -r requirements.txt ```
6. Open the app in phone 
7. ``` python server.py ``` 

