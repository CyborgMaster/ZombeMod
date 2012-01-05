// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb 
// Source File Name:   SourceFile

import java.awt.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftApplet;

// search: "Center"
public final class MinecraftImpl extends Minecraft {

    public MinecraftImpl(Component component, Canvas canvas, MinecraftApplet minecraftapplet, int i, int j, boolean flag, Frame frame) {
        super(component, canvas, minecraftapplet, i, j, flag);
        a = frame;
        ZMod.initialize(this); // initialization
    }

    public void a(UnexpectedThrowable error) {
        a.removeAll();
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

    final Frame a;
}
