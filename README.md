# ExlTestRepo

This is demo tests for EXL requirment for automating Google map web app searching. 

1. This automation project is created using Java and Selenium 3.14.X
2. This automation is using appache mvn jar for installing selenium dependencies and running tests 
3. The test framerwork is used is TestNg
4. And project depcits an example of creating an automation framework from scratch , where there are diffeerent where there is separtaion of certain ( different layers of code )
5. This project uses basic Selenium architecture - Page object Model
6. THis project has only 1 tests but this tests can be extended to test multipe inputs like curreltly we are using below data as given in asissigmen

**Test input** **
1. Launch Chrome
2. Navigate to Google Maps (maps.google.com)
3. Search for San Francisco, California
4. Verify the coordinates for San Francisco are 37.7577627,-122.4726194
Hint: You can find this in the URL.
5. Then search for driving directions (by car) from Chico, California to San Francisco, California.
6. Verify three routes are displayed in the list.
7. Then print the route title, distance in miles, and the travel time to a file titled “routes.txt”.


**Known Bug **
As noticed while executing the test script in different browsers i.e. Chrome amnd FireFox  , the latitude and longitude values which comes in URL chanegs in ForeFox browser in comprarison what is mentioned in the assigment , hence i have data driven test cases for asserting values of latitude and longitude for different browser cases. So in cae when verifying test script if you find the chnage in test which runs in Firefox , please note its intentional otherwise tests always fails due to incorrect values of latitude and longitude .


**Important points**
1. Test runs in chrome and firefox right now but the solution is extendable so any browser can be added in future 
2. The routes.txt file is different for different browser and output path of these route files is given as relative to project foler , so it will be always under <YourMappedFolder>\ExlTestRepo\googlemap\src so after test execution you can find file in this pass with name route_Chrome.txt and route_FF.txt

************************************************************************
**Running Test**
1. This project is maven , so you can easily run test under this rpoject by using command line arguments .
2. before running tests , please do below steps , if jdk 15 and maven 3.8.1 already present in system , then just go to **Executing tests** run test command 
**java install**
Instal JDK 15 in your system
once installing JDK 15
set system variable
 new- JAVA_HOME: C:\Program Files\Java\jdk-15.0.2 (by default JDK will be installed in C drive but incase other drive is chosen then kindly specify path till "jdk-15.0.2" foler
 edit already existing path 
 C:\Program Files\Java\jdk-15.0.2\bin (by default JDK will be installed in C drive but incase other drive is chosen then kindly specify path till "bin" folder
 save and apply
 to verify correct installtion - open cmd and type : java --version
 insatlled jdk version should come
********************************************************* 
 
 **Maven install**
Instal apcahe maven 3.8.1  in your system from https://maven.apache.org/download.cgi
install bin.zip file for windows pc  https://mirror.olnevhost.net/pub/apache/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip   
once installing maven
set system variable
 new- Maven_HOME: C:\Users\Shivam\Downloads\apache-maven-3.8.1-bin\apache-maven-3.8.1 (Here i have specify my downaloded path , kindly specify path  where you have downaloaded maven till "apache-maven-3.8.1" folder)
 edit already existing path 
C:\Users\Shivam\Downloads\apache-maven-3.8.1-bin\apache-maven-3.8.1\bin (Here i have specify my downaloded path , kindly specify path  where you have downaloaded maven till "apache-maven-3.8.1\bin" folder
 save and apply
 to verify correct installtion - open cmd and type : mvn --version
 information about maven and jdk will be shown
 
 *****************************************************************
 **Github repo mapping**
  easiest way 
  Sign in to https://github.com/ and login
  search for my repo : https://github.com/shivampathak86/ExlTestRepo
  Now option to map repo will come , under code button > Open Github desktop version
  it will download github deskptop client ( insatll only in case not done already)
  map remote repo( i.e. https://github.com/shivampathak86/ExlTestRepo) to local system using Github desktop client
  change the branch to master 
  under repository main menu option
  drop down downn option will come to Pull repository
  click on Pull
  once sync between local repo and remote repo is completed 
  Open local repo folder 
  ************************************************************************
  **Executing tests**
  1. Once local folder is mapper with https://github.com/shivampathak86/ExlTestRepo
  2. you should see folder structure like 
<your local folder path>\ExlTestRepo\googlemap> *All src folders*
  3. now from googlemap *Open command prompt* in Admin mode
  4. run command : mvn install -X
  the abobve command will insatll all the required dependencies like Selenium , TestNG
  finally at the end it will trigger all the tests 
 5. similarly you can use anotehr command: mvn clean test
  the above command will clean project and run tests
 6. once tests are completed ouput file ( route_Chrome.txt and route_FF.txt ) should be shown in <your local folder path\ExlTestRepo\googlemap\src
  
****************************************************************************************
**Test Reports**
1. The plugins used in this project will automatically generates reports 
2. you can veiew different format of reports 
Example as below , *Please note both report will have same data*
If you use "mvn install" report will be generated in <your local folder path>\ExlTestRepo\googlemap\target\surefire-reports\emailable-report.html and index.html
If you use "mvn clean test" report will be generated in <your local folder path>\ExlTestRepo\googlemap\test-output\emailable-report.html and index.html
  
**********************************************************************************************
**Execution of tests in cloud - LambdaTest**
1. I have also created provision of running testin distributed - Selenium grid achitecture using cloud grid prvoder called lambdatest
2. All you need  is uncomment code for running test in cloud architecture in file <your local folder path>\ExlTestRepo\googlemap\src\test\java\exl\googlemap\GoogleMapWebUITests.java
3. Benifits 
 you can see video logs
 command logs with each command screenshot 
 network logs 
 text logs
4.We can see  test results for cloud execution together as i cannot share credendtails on public forum.

*********************************************************************

***PLEASE LET ME KNOW IN CASE YOU ARE NOT ABLE TO ACCESS PROJECT AND RUN TEST***
