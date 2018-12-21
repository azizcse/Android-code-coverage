
# Android Studio default process

### Enable test coverage first at app lavel gradle

```
buildTypes {
        debug {
            testCoverageEnabled true
        }
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
            testCoverageEnabled true
        }
    }
```
### Run createDebugTestCoverageReport command from app->task->other

![Alt Text](https://github.com/azizcse/Android-code-coverage/blob/master/img/run_test.png)

# Jacoco coverage report

### Run /gradlew jacocoTestReport command

Both android default and Jacoco report will be generaged 

![Alt Text](https://github.com/azizcse/Android-code-coverage/blob/master/img/coverage_report.png)



