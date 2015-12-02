Android-AndroidForDevelopersWorkshop
====================================

##Intro to Java and Android

[Slide Deck](Intro-to-Java-and-Android.pdf)


## Environment Configuration Steps 
  * Install Android Studio 
  * Install VirtualBox 
  * Install Genymotion 
  * Install Genymotion plugin in Android Studio
  * Switch your appearance preferences to Darcula (obviously..)

##Mad Libs

  * Compose the User Interface XML Files
  * Create a model for a Madlib 
  * Connect to web service
  * Update the User Interface from the Activity
  * Pass data from one Activity to another

###MadLib.java

Model Object enapsulating places, people and verbs collections

```java
List<String>mPlaces = new ArrayList<String>(); 

```

###MadLibService.java

Retrofit encapsulation of network code

###MadLibActivity.java

 * Creates a dialog and shows when network task is initialized 
 * Adds items from EditTexts to List 
 * Adds an OnClickListener to button which kicks off MadLibService task 
 * Passes intent with extra data (story) and starts MadLibStoryActivity

###MadLibStoryActivity.java

 * Parse intent extra data 
 * Add extra data to TextView 

###activity_mad_lib.xml

* Linear Layout
* Edit Texts 
* Buttons

###activity_mad_lib_story.xml

* Relative 
* Text View 

###strings.xml

* App Name
* Edit Text Hints 
* Button Text 

###build.gradle

* Retrofit Dependency 

###androidmanifest.xml

* Internet Permission 
* Activity declarations

##To Code along

	1. Configure Android environment (if not completed previously)
	2. Open Android Studio 
	3. Follow Along! 

##Resources 

  * [Slide Deck](Intro-to-Java-and-Android.pdf)
  * [Mad Libs](MadLibsGenerator/)
  * [Node app](Node/)
<a href='https://learn.co/lessons/Android-AndroidForDevelopersWorkshop' data-visibility='hidden'>View this lesson on Learn.co</a>
