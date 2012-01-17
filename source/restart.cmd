@echo off
::cls

call config.cmd
SETLOCAL ENABLEDELAYEDEXPANSION

rmdir /S /Q tmp
rmdir /S /Q class_in
rmdir source

mkdir tmp
mkdir class_in\net\minecraft\client
mkdir source

unzip "%APPDATA%\.minecraft\bin\minecraft.jar" "*.class" -d "tmp"
copy "%APPDATA%\.minecraft\bin\jinput.jar" class_in
copy "%APPDATA%\.minecraft\bin\lwjgl.jar" class_in
copy "%APPDATA%\.minecraft\bin\lwjgl_util.jar" class_in
move tmp\com class_in\com
move tmp\paulscode class_in\paulscode

set list=
for %%i in (tmp\*.class) do set list=!list!;%%~ni
java Obfus tmp class_in %list%

set list=
for %%i in (tmp\net\minecraft\client\*.class) do set list=!list!;%%~ni
java Obfus tmp\net\minecraft\client class_in\net\minecraft\client %list%

jad -nonlb -pv -d source -o -r -s .java -stat class_in\*.class
jad -nonlb -pv -d source -o -r -s .java -stat class_in\net\minecraft\client\*.class
