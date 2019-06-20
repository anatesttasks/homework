# How to run acceptance tests locally
___

### RUN FROM INTELLIJ IDEA
All tests:  
CukesRunner class allows to execute all tests directly via jUnit runner. It's present in testing project.

For running features one by one or by scenario (without CukesRunner), the glue must be defined as follows:  
> _Edit Configurations (Run/Debug Configurations) --> Default --> Cucumber java —> Glue_  
>  _`src/test/groovy/steps/`_  
   _`src/test/groovy/env/`_  

Web tests by default are executed with Chrome browser.
ChromeDriver should be installed on local machine:
```http://chromedriver.chromium.org/downloads```

Report file can be found [../build/report/index.html]()  

___
### RUN TESTS WITH TASK FROM COMMAND LINE
Open project folder in console or Intellij Idea terminal

To execute whole test suite use command the following comand: 

```shell
./gradlew clean test
```
