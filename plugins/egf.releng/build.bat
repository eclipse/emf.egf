@echo off
rem check environment
if "%JAVA_HOME%" == "" (
echo You must set the JAVA_HOME env variable e.g D:\jdk\jdk1.5.0
goto end
)

if "%1" =="" (
echo {targetPlatformPath} is missing
echo.
goto usage
)

if "%2" =="" (
echo {builderPath} is missing
echo.
goto usage
)

if "%3" =="" (
echo {outputBuildPath} is missing
echo.
goto usage
)

if "%4" =="" (
echo {viewPath} is missing
echo.
goto usage
)

if "%5" =="" (
echo {builderEquinoxJarFilePath} is missing
echo.
goto usage
)

if "%6" =="" (
echo {buildFile} is missing
echo.
goto usage
)

if "%7" =="" (
echo {eclipseTestHostHome} is missing
echo.
goto usage
)

:next
rem Compute time stamps
set builddate=%DATE:~6,4%%DATE:~3,2%%DATE:~0,2%
set hh=%TIME:~0,2%
set mm=%time:~-8,2%
rem Since there is no leading zero for times before 10 am, have to put in
rem a zero when this is run before 10 am.
if "%time:~0,1%"==" " set hh=0%hh:~1,1% 
rem get only the two digits regarding hours independently from current time (i.e before or after 10am)
set buildtime=%hh:~0,2%%mm%
set timestamp=%builddate%%buildtime%

rem Define pde build properties.
set targetPlatform=%1%
set builder=%2%
set buildDirectory=%3%
rem View  path where sources are located
set viewPath=%4%
set builderEquinoxJarFilePath=%5%
set buildFile=%6%
rem default property values
set buildType=I
set buildId=%timestamp%
set buildLabel=%timestamp%
rem Map file is not used anymore. Sources are fetched directly from view path.
set mapfile=%builder%/egf.map
set eclipseAutomatedTestHome=%7%
goto build

:usage
echo.
echo Usage : build.bat {targetPlatformPath} {builderPath} {outputBuildPath} {viewPath} {builderEquinoxJarFilePath} {buildFile}
rem empty ligne
echo.
echo.
echo targetPlatformPath:         path to an eclipse target platform that allows source code to be able to compile against.
echo builderPath:                path to your product builder (folder that contains allElements.xml, build.properties, ...)
echo outputBuildPath:            path where build is output.
echo viewPath:                   path where sources to build are located.
echo builderEquinoxJarFilePath:  path to the releng basebuilder equinox launcher jar file.
echo buildFile:                  path to the master ant build script.
echo eclipseTestHostHome:        path to the test host target platform parent root folder (folder that contains test.xml, label.properties, ...)
echo.
echo.
echo Example : build.bat F:/distrib/egf_1.0.0_M1/3.5/eclipse D:/views/egf_1.0_dev/MDE_EGF/releng/egf.builder f:/prod_egf/builds D:/views/egf_1.0_dev/MDE_EGF/ f:/prod_egf/org.eclipse.releng.basebuilder/3.5/eclipse/plugins/org.eclipse.equinox.launcher.jar D:/views/egf_1.0_dev/MDE_EGF/releng/build.xml f:/prod_egf/testhost
echo.

:build
rem remove a potential existing subst over X.
echo Don't worry : an error message could be displayed if no mount on X drive already exists.
subst /D x:
rem mount X: over the view path.
subst x: %viewPath%
rem Use the java.exe provided by a jdk to be able to produce the javadoc. 
%JAVA_HOME%\bin\java -Xms256m -Xmx1024m -jar %builderEquinoxJarFilePath% -application org.eclipse.ant.core.antRunner -f %buildFile% -DbaseLocation=%targetPlatform% -DbuildDirectory=%buildDirectory% -Dbuilder=%builder% -DbuildType=%buildType% -DbuildId=%buildId% -DbuildLabel=%buildLabel% -DviewPath=%viewPath%/ -Dmap.file=%mapfile% -DeclipseAutomatedTestHome=%eclipseAutomatedTestHome%
subst /D x:
:end