@echo on
call mvn clean install
rmdir /q /s rd "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps\C4IMSUI"
del "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps\C4IMSUI.war"
copy C:\Codebase\C4IMS\C4IMSUI\target\*.war "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps"

rmdir /q /s rd "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps\C4IMSWS"
del "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps\C4IMSWS.war"
copy "C:\Codebase\C4IMS\C4IMSWS\target\*.war" "C:\Program Files\Apache\apache-tomcat-9.0.72\webapps"
pause