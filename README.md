
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

# Code coverage with Jacoco

 use jacoco in root gradle
```
classpath "org.jacoco:org.jacoco.core:$jacocoVersion"
```
In app.gradle add below snippet 

```
apply plugin: 'jacoco'

jacoco {
    toolVersion = "$jacocoVersion"
}

tasks.withType(Test) {
    jacoco.includeNoLocationClasses = true
}

task jacocoTestReport(type: JacocoReport, dependsOn: ['testDebugUnitTest', 'createDebugCoverageReport']) {

    reports {
        xml.enabled = true
        html.enabled = true
    }

    def fileFilter = ['**/R.class', '**/R$*.class', '**/BuildConfig.*', '**/Manifest*.*', '**/*Test*.*', 'android/**/*.*', '**/*$[0-9].*']
    def debugTree = fileTree(dir: "$project.buildDir/tmp/kotlin-classes/debug", excludes: fileFilter)
    def mainSrc = "$project.projectDir/src/main/kotlin"

    sourceDirectories = files([mainSrc])
    classDirectories = files([debugTree])
    executionData = fileTree(dir: project.buildDir, includes: ['jacoco/testDebugUnitTest.exec',
                                                               'outputs/code_coverage/debugAndroidTest/connected/**/*.ec'])
}

android {

    sourceSets {
        main.java.srcDirs += 'src/main/kotlin'
        test.java.srcDirs += 'src/test/kotlin'
        androidTest.java.srcDirs += 'src/androidTest/kotlin'
    }

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

    testOptions {
        execution 'ANDROIDX_TEST_ORCHESTRATOR'
        animationsDisabled true

        unitTests {
            includeAndroidResources = true
        }
    }
}

```
### Run below command in Android studio Terminal

*/gradlew jacocoTestReport*

Both android default and Jacoco report will be generaged 

![Alt Text](https://github.com/azizcse/Android-code-coverage/blob/master/img/coverage_report.png)

# Open index.html with browser

![Alt Text](https://github.com/azizcse/Android-code-coverage/blob/master/img/result.png)




