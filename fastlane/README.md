fastlane documentation
================
# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```
xcode-select --install
```

Install _fastlane_ using
```
[sudo] gem install fastlane -NV
```
or alternatively using `brew cask install fastlane`

# Available Actions
## Android
### android CI
```
fastlane android CI
```
Runs all the tests
### android cleanProject
```
fastlane android cleanProject
```
Clean project
### android createDebugBuild
```
fastlane android createDebugBuild
```
Runs all the tests
### android unitTest
```
fastlane android unitTest
```
Create coverage report
### android uiTest
```
fastlane android uiTest
```
Create coverage report
### android coverageReport
```
fastlane android coverageReport
```
Run all the tests

----

This README.md is auto-generated and will be re-generated every time [fastlane](https://fastlane.tools) is run.
More information about fastlane can be found on [fastlane.tools](https://fastlane.tools).
The documentation of fastlane can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
