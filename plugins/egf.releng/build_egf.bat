@echo off
set JAVA_HOME=D:\jdk\jdk1.5.0
set view=D:\dev\eclipse\workspace-3.5
call %view%/egf.releng/build.bat D:\eclipse-3.5-M5 %view%/egf.builder D:/prod_egf/builds %view% D:/prod_egf/org.eclipse.releng.basebuilder/plugins/org.eclipse.equinox.launcher.jar %view%/egf.releng/build.xml D:/prod_egf/testhost