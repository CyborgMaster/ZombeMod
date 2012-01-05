// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb 
// Source File Name:   SourceFile

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

// search: "Center"
public class MinecraftAppletImpl extends Minecraft {

    public MinecraftAppletImpl(MinecraftApplet minecraftapplet, Component component, Canvas canvas, MinecraftApplet minecraftapplet1, int i, int j, boolean flag) {
        super(component, canvas, minecraftapplet1, i, j, flag);
        a = minecraftapplet;
        ZMod.initialize(this); // initialization
    }

    public void a(UnexpectedThrowable error) {
        a.removeAll();
        a.setLayout(new BorderLayout());
        a.add(new PanelCrashReport(error), "Center");
        a.validate();
    }

    public void mcStartGame() {
        super.mcStartGame();
        ZMod.initOverrides();
    }

    public void mcRunTick() {
        ZMod.pingUpdateHandle();
        super.mcRunTick();
    }

    public void mcRespawn(boolean flag, int kst, boolean flag2) {
        super.mcRespawn(flag, kst, flag2);
        ZMod.pingRespawnHandle(flag);
    }

    final MinecraftApplet a;
}
