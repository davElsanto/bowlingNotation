# Java Challange - Build Instructions

## Software Needed
Please verify your correct installation
[Java](https://www.java.com/en/download/manual.jsp) v18 is used in challange.

```sh
java --version
```
```sh
openjdk 18.0.1.1 2022-04-22
OpenJDK Runtime Environment (build 18.0.1.1+2-6)
OpenJDK 64-Bit Server VM (build 18.0.1.1+2-6, mixed mode, sharing)
```

[Maven](https://maven.apache.org/download.cgi) v3.8.6 to generate executable.
```sh
mvn --version
```

```sh
Apache Maven 3.8.6 (84538c9988a25aec085021c365c560670ad80f63)
Maven home: /opt/maven-3.8.6
Java version: 18.0.1.1, vendor: Oracle Corporation, runtime: /home/david/.sdkman/candidates/java/18.0.1.1-open
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.15.49-1-manjaro", arch: "amd64", family: "unix"
```

## Build Instructions
Verify you are in branch `davisantos_bowling`
```sh
git branch
* davisantos_bowling
  master
```
If you are not, just type
```sh
git checkout davisantos_bowling
```
Then type `mvn clean package` to build.
```sh
mvn clean package
```
Maven will start to work.
```sh
[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for JavaChallenge.wiki:JavaChallenge.wiki:jar:0.0.1-SNAPSHOT
[WARNING] 'dependencies.dependency.version' for junit:junit:jar is either LATEST or RELEASE (both of them are being deprecated) @ line 16, column 13
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: junit:junit:jar -> version 3.8.1 vs RELEASE @ line 13, column 15
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO] 
[INFO] ---------------< JavaChallenge.wiki:JavaChallenge.wiki >----------------
[INFO] Building JavaChallenge.wiki 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ JavaChallenge.wiki ---
[INFO] Deleting /home/david/Documents/interview/JavaChallenge.wiki/target
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ JavaChallenge.wiki ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/david/Documents/interview/JavaChallenge.wiki/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ JavaChallenge.wiki ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 13 source files to /home/david/Documents/interview/JavaChallenge.wiki/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ JavaChallenge.wiki ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/david/Documents/interview/JavaChallenge.wiki/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ JavaChallenge.wiki ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 2 source files to /home/david/Documents/interview/JavaChallenge.wiki/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ JavaChallenge.wiki ---
[INFO] Surefire report directory: /home/david/Documents/interview/JavaChallenge.wiki/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.jobsity.test.ProcessPlayerTest
{user1=[1, 9], user2=[10]}
Frame		1		2		3		4		56		7		8		9		10		
David Santos
Pinfalls	 	X	 	X	 	X	 	X	 X	 	X	 	X	 	X	 	X	 	X 	X	 	X	
Score		30		60		90		120		150		180		210		240		270		300		

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.136 sec
Running com.jobsity.test.ProcessScoreTest
11 -> perfect game
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 sec

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ JavaChallenge.wiki ---
[INFO] Building jar: /home/david/Documents/interview/JavaChallenge.wiki/target/JavaChallenge.wiki-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- maven-assembly-plugin:2.2-beta-5:single (default) @ JavaChallenge.wiki ---
[INFO] Building jar: /home/david/Documents/interview/JavaChallenge.wiki/target/JavaChallenge.wiki-0.0.1-SNAPSHOT-jar-with-dependencies.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  6.825 s
[INFO] Finished at: 2022-06-27T17:31:55-05:00
[INFO] ------------------------------------------------------------------------
```
So a new file was created inside `target` folder. In this case its name is `JavaChallenge.wiki-0.0.1-SNAPSHOT-jar-with-dependencies.jar`
You can execute it with `java -jar`.
```sh
java -jar target/JavaChallenge.wiki-0.0.1-SNAPSHOT-jar-with-dependencies.jar 
```
## How to use
When you execute the `jar`. Next message will apear.
```sh
Please, insert your bowling score:

```
Then you can paste you score.
```
Jeff    10
John    3
John    7
Jeff    7
Jeff    3
John    6
John    3
Jeff    9
Jeff    0
John    10
Jeff    10
John    8
John    1
Jeff    0
Jeff    8
John    10
Jeff    8
Jeff    2
John    10
Jeff    F
Jeff    6
John    9
John    0
Jeff    10
John    7
John    3
Jeff    10
John    4
John    4
Jeff    10
Jeff    8
Jeff    1
John    10
John    9
John    0
```
Hit enter to process.
```sh
Frame		1		2		3		4		56		7		8		9		10		
Jeff
Pinfalls	 	X	7	/	9	-	 	X	-8	8	/	F	6	 	X	 	X	 	X8	1	
Score		20		39		48		66		74		84		90		120		148		167		

Frame		1		2		3		4		56		7		8		9		10		
John
Pinfalls	3	/	6	3	 	X	8	1	 X	 	X	9	-	7	/	4	4	 	X9	-	
Score		16		25		44		53		82		101		110		124		132		151		
```
Examples:
>Perfect Game
```
Please, insert your bowling score:
John    10
John    10
John    10
John    10
John    10
John    10
John    10
John    10
John    10
John    10
John    10
John    10

Frame		1		2		3		4		5		6		7		8		9		10		
John
Pinfalls	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 	X	 X	
Score		30		60		90		120		150		180		210		240		270		300		
```
>Game with no enough entries, program will complete it.
```sh
Please, insert your bowling score:
John    10
John    2
John    f
David   3
David   6
David   10
David   10

Frame		1		2		3		4		5		6		7		8		9		10		
John
Pinfalls	 	X	2	-	-	0	-	0	-	0	-	0	-	0	-	0	-	0	-	0	-	0	
Score		12		14		14		14		14		14		14		14		14		14		

Frame		1		2		3		4		5		6		7		8		9		10		
David
Pinfalls	3	6	 	X	 	X	-	0	-	0	-	0	-	0	-	0	-	0	-	0	-	0	
Score		9		29		39		39		39		39		39		39		39		39		
```