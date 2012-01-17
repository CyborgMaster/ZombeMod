// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// search: "deadmau5"   * the one with simpler IF
public class ey extends ti {

    protected static final boolean zmodmarker = true;

    public ey(hb hb1, float f) {
        a = hb1;
        g = f;
    }

    public void a(hb hb1) {
        b = hb1;
    }

    public void a(aar aar1, double d1, double d2, double d3,
            float f, float f1) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        a.h = c(aar1, f1);
        if(b != null)
            b.h = a.h;
        a.i = aar1.W();
        if(b != null)
            b.i = a.i;
        a.k = aar1.l();
        if(b != null)
            b.k = a.k;
        try {
            float f2 = aar1.be + (aar1.bd - aar1.be) * f1;
            float f3 = aar1.w + (aar1.u - aar1.w) * f1;
            float f4 = aar1.x + (aar1.v - aar1.x) * f1;
            a(aar1, d1, d2, d3);
            float f5 = d(aar1, f1);
            a(aar1, f5, f2, f1);
            float f6 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1F, -1F, 1.0F);
            a(aar1, f1);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);
            float f7 = aar1.bL + (aar1.bM - aar1.bL) * f1;
            float f8 = aar1.bN - aar1.bM * (1.0F - f1);
            if(aar1.l())
                f8 *= 3F;
            if(f7 > 1.0F)
                f7 = 1.0F;
            GL11.glEnable(3008);
            a.a(aar1, f8, f7, f1);
            a(aar1, f8, f7, f5, f3 - f2, f4, f6);
            for(int i = 0; i < 4; i++) {
                int j = b(aar1, i, f1);
                if(j <= 0)
                    continue;
                b.a(aar1, f8, f7, f1);
                b.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                if(j == 15) {
                    float f10 = (float)aar1.V + f1;
                    a("%blur%/misc/glint.png");
                    GL11.glEnable(3042);
                    float f12 = 0.5F;
                    GL11.glColor4f(f12, f12, f12, 1.0F);
                    GL11.glDepthFunc(514);
                    GL11.glDepthMask(false);
                    for(int i1 = 0; i1 < 2; i1++) {
                        GL11.glDisable(2896);
                        float f15 = 0.76F;
                        GL11.glColor4f(0.5F * f15, 0.25F * f15, 0.8F * f15, 1.0F);
                        GL11.glBlendFunc(768, 1);
                        GL11.glMatrixMode(5890);
                        GL11.glLoadIdentity();
                        float f17 = f10 * (0.001F + (float)i1 * 0.003F) * 20F;
                        float f18 = 0.3333333F;
                        GL11.glScalef(f18, f18, f18);
                        GL11.glRotatef(30F - (float)i1 * 60F, 0.0F, 0.0F, 1.0F);
                        GL11.glTranslatef(0.0F, f17, 0.0F);
                        GL11.glMatrixMode(5888);
                        b.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                    }

                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    GL11.glMatrixMode(5890);
                    GL11.glDepthMask(true);
                    GL11.glLoadIdentity();
                    GL11.glMatrixMode(5888);
                    GL11.glEnable(2896);
                    GL11.glDisable(3042);
                    GL11.glDepthFunc(515);
                }
                GL11.glDisable(3042);
                GL11.glEnable(3008);
            }

            b(aar1, f1);
            float f9 = aar1.a(f1);
            int k = a(aar1, f9, f1);
            em.a(em.b);
            GL11.glDisable(3553);
            em.a(em.a);
            if((k >> 24 & 0xff) > 0 || aar1.bA > 0 || aar1.bD > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if(aar1.bA > 0 || aar1.bD > 0) {
                    GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                    a.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                    for(int l = 0; l < 4; l++)
                        if(a(aar1, l, f1) >= 0) {
                            GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                            b.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                        }

                }
                if((k >> 24 & 0xff) > 0) {
                    float f11 = (float)(k >> 16 & 0xff) / 255F;
                    float f13 = (float)(k >> 8 & 0xff) / 255F;
                    float f14 = (float)(k & 0xff) / 255F;
                    float f16 = (float)(k >> 24 & 0xff) / 255F;
                    GL11.glColor4f(f11, f13, f14, f16);
                    a.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                    for(int j1 = 0; j1 < 4; j1++)
                        if(a(aar1, j1, f1) >= 0) {
                            GL11.glColor4f(f11, f13, f14, f16);
                            b.a(aar1, f8, f7, f5, f3 - f2, f4, f6);
                        }

                }
                GL11.glDepthFunc(515);
                GL11.glDisable(3042);
                GL11.glEnable(3008);
                GL11.glEnable(3553);
            }
            GL11.glDisable(32826);
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
        em.a(em.b);
        GL11.glEnable(3553);
        em.a(em.a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        b(aar1, d1, d2, d3);
    }

    protected void a(aar aar1, float f, float f1, float f2, float f3, float f4, float f5) {
        a(aar1.Z, aar1.M());
        a.a(aar1, f, f1, f2, f3, f4, f5);
    }

    protected void a(aar aar1, double d1, double d2, double d3) {
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
    }

    protected void a(aar aar1, float f, float f1, float f2) {
        GL11.glRotatef(180F - f1, 0.0F, 1.0F, 0.0F);
        if(aar1.bD > 0) {
            float f3 = ((((float)aar1.bD + f2) - 1.0F) / 20F) * 1.6F;
            f3 = ga.c(f3);
            if(f3 > 1.0F)
                f3 = 1.0F;
            GL11.glRotatef(f3 * a(aar1), 0.0F, 0.0F, 1.0F);
        }
    }

    protected float c(aar aar1, float f) {
        return aar1.g(f);
    }

    protected float d(aar aar1, float f) {
        return (float)aar1.V + f;
    }

    protected void b(aar aar1, float f) {
        // -----------------------------------------------------------------------------------------------------------------------
        ZMod.resizeHandle(aar1); // in "a" or "b" !?
        // -----------------------------------------------------------------------------------------------------------------------
    }

    protected int a(aar aar1, int i, float f) {
        return b(aar1, i, f);
    }

    protected int b(aar aar1, int i, float f) {
        return -1;
    }

    protected float a(aar aar1) {
        return 90F;
    }

    protected int a(aar aar1, float f, float f1) {
        return 0;
    }

    protected void a(aar aar1, float f) {
    }

    protected void b(aar aar1, double d1, double d2, double d3) {
        if(!Minecraft.u());
    }

    protected void a(aar aar1, String s, double d1, double d2, double d3, int i) {
        float f = aar1.e(e.h);
        if(f > (float)i)
            return;
        mq mq1 = a();
        float f1 = 1.6F;
        float f2 = 0.01666667F * f1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1 + 0.0F, (float)d2 + 2.3F, (float)d3);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-e.i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(e.j, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-f2, -f2, f2);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        aby aby1 = aby.a;
        byte byte0 = 0;
        if(s.equals("deadmau5"))
            byte0 = -10;
        GL11.glDisable(3553);
        aby1.b();
        int j = mq1.a(s) / 2;
        aby1.a(0.0F, 0.0F, 0.0F, 0.25F);
        aby1.a(-j - 1, -1 + byte0, 0.0D);
        aby1.a(-j - 1, 8 + byte0, 0.0D);
        aby1.a(j + 1, 8 + byte0, 0.0D);
        aby1.a(j + 1, -1 + byte0, 0.0D);
        aby1.a();
        GL11.glEnable(3553);
        mq1.b(s, -mq1.a(s) / 2, byte0, 0x20ffffff);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        mq1.b(s, -mq1.a(s) / 2, byte0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void a(ms ms, double d1, double d2, double d3,
            float f, float f1) {
        a((aar)ms, d1, d2, d3, f, f1);
    }

    protected hb a, b;
}
