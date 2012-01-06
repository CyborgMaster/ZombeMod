@echo off
::cls

call recompile %1

zip -j "%APPDATA%\.minecraft\bin\minecraft.jar" class_out/%~n1.class
zip -j "%APPDATA%\.minecraft\bin\minecraft.jar" class_out/%~n1$*.class