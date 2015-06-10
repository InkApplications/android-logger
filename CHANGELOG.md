Change Log
==========

v3.0.0
------
 - Loggers no longer require android resources as a dependency.
 - New `LogName` annotation used instead of the old `ScreenName` in order to
   decouple the logged statements from the user-displayed name.

v2.0.0
------
 - Added new logger types
     - Added a composite logger for combining different logs
     - Added a logger for google analytics
 - Added an option for making the console logger sensitive, causing crashes
   on errors.
 - Moved project to be distributed with Jitpack

v1.1.0
------
 - Made dependencies optional

v1.0.0
------
 - Created a Apache Log implementation of an Android logger.
 - Made the logger aware of the build environment through a constructor
   parameter.
