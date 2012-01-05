@echo off
cls

call config.cmd

if "%1"=="" goto ALL

jad -nolvt -safe -nonlb -pv -d source -o -r -s .java -stat class_in\%1.class
:: -lnc adds line numbers

goto END
:ALL

jad -nonlb -pv -d source -o -r -s .java -stat class_in\*.class
jad -nonlb -pv -d source -o -r -s .java -stat class_in\net\minecraft\client\*.class

:END
