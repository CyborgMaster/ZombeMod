@echo off
::cls

del /Q class_out\*
del mod.zip

call recompile MinecraftAppletImpl
call recompile MinecraftImpl
call recompile ZRND
call recompile ZER
call recompile ZRG
call recompile ZP250
call recompile ZBB
call recompile ZBF
call recompile ZBFL
call recompile ZBG
call recompile ZBI
call recompile ZBL
call recompile ZBM
call recompile ZBS
call recompile ZBW
call recompile EntityPlayer
call recompile ZMod
call recompile Explosion
call recompile GuiContainer
call recompile PlayerControllerSP
call recompile RenderLiving
call recompile TileFurnace
call recompile WorldProvider

zip -j mod.zip class_out/*