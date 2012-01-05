@echo off
::cls

call config.cmd

if "%1"=="" goto ERROR
set filename=%1
if EXIST %filename% goto PROCEED
set filename="%filename%.java"

:PROCEED
java Trans %filename%
IF NOT "%~n1"=="ZMod" goto END

SETLOCAL ENABLEDELAYEDEXPANSION
set list=
for %%i in (class_out\ZMod$*.class) do set list=!list!;%%~ni
java Obfus class_out class_jar %list%

goto END

:ERROR
echo "recompile what?"

:END
