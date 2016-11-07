How to run:

1) mvn clean install
2) check tar.gz file under target folder
3) Unzip/open tar file (use 7zip on windows)
4) Go to bin and run startup.bat (or .sh)
5) Access application @ http://localhost/myspringapp/persons


In Source code check this:

1) Check how tomcat is bundled alongwith sourcecode. Use tomcat version specific to project.
2) Put Maven assembly plugin in pom.xml
3) Define assmblydescriptor.xml to package tar/zip which will contain preconfigured tomcat and deployed web application.
4) If required you can rename startup.sh/.bat to project specific name like startup-pass.sh etc.
5)you can create and copy other folders in tar as per requirement like doc, scripts etc. for this update  assmblydescriptor.xml.
