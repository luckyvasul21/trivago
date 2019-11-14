Automation Code Challenge
Create a set of Selenium Tests in any programming language for the following requirements.
The website http://trivago.com/ have extended their search filters with some new options.
The new options are to filter on hotels with:
• Free WiFi
• Spa
Write tests to test these new filters.
Test data that can be used for this test includes:
Location: Cork
Dates: One night stay (3 months from today’s date)
Room: Double Room
Results expected:
Select Filter Hotel Name Is Listed
Free Wifi Cork International Hotel True
Free Wifi Jurys Inn Cork False
Spa The River Lee True
Spa Jurys Inn Cork False
Assume that hotels would be expected in the top results (paging does not need to be
considered)
NOTE:
In your solution we are looking for good coding standards/practices for writing automated tests.

#Work in Progress
Run Configurations:
- Run as Java application for class-> /com.trivago/src/main/java/com/trivago/execution/TestRunner.java
- Run as Junit application for class -> /com.trivago/src/main/java/com/trivago/SuiteTest/Practice.java

FrameWork: JUnit, maven
Versions: Junit: 4.12, Selenium: 3.3.1

Notes: 
What included in Project:
- flexible to execute the tests as Java or Junit or Maven TestRunner
- each test case is coded as each test method
- each test method is executed independent of each other
- validations/assertions are based on test case data and requirement.
- no static paramaters used in the scripts, variables are defined in one place holder properties file
- no need of maintaning of external jars or libraries

Still can acheive:
- more code clean
- reduce execution time with parallel execution with Junit or Maven TestRunner or selenium grid
- maintainig element object repository in one place holder
- configure project with Jenkins or Teamcity as part of Continuos Integration
- generate Test execution results on each execution cycle
- test case test data can be passed on commandline
- execute particular single on multiple testcases during smoke or regression testing