# Selenium_Docker
 This repository has the sample code and required docker related files to run the selenium scripts inside docker containers.
 
 Basic docker commands & notes related to docker is available <a href="https://github.com/LakshminarayananG/Selenium_Docker/tree/master/Selenium_Docker/src/main/java/Docker%20Notes%20And%20Commands">here</a>
 
## Automation Framework Design
* The framework has a basic factory design pattern with 3 pages having different page actions & 2 tests having a basic workflow. 
* The pages are available in <a href="https://github.com/LakshminarayananG/Selenium_Docker/tree/master/Selenium_Docker/src/main/java/com/app/booking/pages">src/main/java/com/app/booking/pages</a>
* The tests are available in <a href="https://github.com/LakshminarayananG/Selenium_Docker/tree/master/Selenium_Docker/src/main/java/com/app/booking/tests">src/main/java/com/app/booking/tests</a>


 
## Steps to execute the Test
1. Install docker in windows using the link <a href="https://docs.docker.com/desktop/windows/install/">here</a>
2. Download the selenium/hub image using docker command "docker pull selenium/hub:3.141.59" in windows power shell
3. Download selenium chrome & firefox node images using the commands "pull selenium/node-firefox:3.141.59" & "pull selenium/node-chrome:3.141.59"
4. Any other image that is required with the latest version can be downloaded from <a href="https://hub.docker.com">Docker Hub</a>
5. Navigate to the project directory and run "docker-compose up" to launch grid with 1 chrome & 1 firefox instances
6. To have multiple instances of chrome & firefox instances, use "docker-compose up --scale chrome=3 --scale firefox=2" . This will launch 3 chrome & 2 firefox instances

