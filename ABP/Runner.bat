%~d1

cd "%~p1"

java -cp "./lib/*;target/classes;target/test-classes" com.tyss.abp.testsuitegenerator.TestSuiteGenerator
java -cp "./lib/*;target/classes;target/test-classes" org.testng.TestNG TestSuite.xml

pause
