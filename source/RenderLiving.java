// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// search: "deadmau5"   * the one with simpler IF
public class acq extends rg {

    protected static final boolean zmodmarker = true;

    public acq(al al1, float f) {
        g = al1;
        e = f;
    }

    public void a(al al1) {
        h = al1;
    }

    public void a(nq nq1, double d1, double d2, double d3,
            float f, float f1) {
        GL11.glPushMatrix();
        GL11.glDisable(2884);
        g.a = d(nq1, f1);
        if(h != null)
            h.a = g.a;
        g.b = nq1.W();
        if(h != null)
            h.b = g.b;
        g.d = nq1.q_();
        if(h != null)
            h.d = g.d;
        try {
            float f2 = nq1.au + (nq1.at - nq1.au) * f1;
            float f3 = nq1.A + (nq1.y - nq1.A) * f1;
            float f4 = nq1.B + (nq1.z - nq1.B) * f1;
            b(nq1, d1, d2, d3);
            float f5 = c(nq1, f1);
            a(nq1, f5, f2, f1);
            float f6 = 0.0625F;
            GL11.glEnable(32826);
            GL11.glScalef(-1F, -1F, 1.0F);
            a(nq1, f1);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);
            float f7 = nq1.ba + (nq1.bb - nq1.ba) * f1;
            float f8 = nq1.bc - nq1.bb * (1.0F - f1);
            if(nq1.q_())
                f8 *= 3F;
            if(f7 > 1.0F)
                f7 = 1.0F;
            GL11.glEnable(3008);
            g.a(nq1, f8, f7, f1);
            a(nq1, f8, f7, f5, f3 - f2, f4, f6);
            for(int i = 0; i < 4; i++) {
                int j = a(nq1, i, f1);
                if(j <= 0)
                    continue;
                h.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
                if(j == 15) {
                    float f10 = (float)nq1.Z + f1;
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
                        h.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
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

            b(nq1, f1);
            float f9 = nq1.b(f1);
            int k = a(nq1, f9, f1);
            adx.a(adx.b);
            GL11.glDisable(3553);
            adx.a(adx.a);
            if((k >> 24 & 0xff) > 0 || nq1.aP > 0 || nq1.aS > 0) {
                GL11.glDisable(3553);
                GL11.glDisable(3008);
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if(nq1.aP > 0 || nq1.aS > 0) {
                    GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                    g.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
                    for(int l = 0; l < 4; l++)
                        if(b(nq1, l, f1) >= 0) {
                            GL11.glColor4f(f9, 0.0F, 0.0F, 0.4F);
                            h.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
                        }

                }
                if((k >> 24 & 0xff) > 0) {
                    float f11 = (float)(k >> 16 & 0xff) / 255F;
                    float f13 = (float)(k >> 8 & 0xff) / 255F;
                    float f14 = (float)(k & 0xff) / 255F;
                    float f16 = (float)(k >> 24 & 0xff) / 255F;
                    GL11.glColor4f(f11, f13, f14, f16);
                    g.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
                    for(int j1 = 0; j1 < 4; j1++)
                        if(b(nq1, j1, f1) >= 0) {
                            GL11.glColor4f(f11, f13, f14, f16);
                            h.a(nq1, f8, f7, f5, f3 - f2, f4, f6);
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
        adx.a(adx.b);
        GL11.glEnable(3553);
        adx.a(adx.a);
        GL11.glEnable(2884);
        GL11.glPopMatrix();
        a(nq1, d1, d2, d3);
    }

    protected void a(nq nq1, float f, float f1, float f2, float f3, float f4, float f5) {
        a(nq1.ad, nq1.I());
        g.a(nq1, f, f1, f2, f3, f4, f5);
    }

    protected void b(nq nq1, double d1, double d2, double d3) {
        GL11.glTranslatef((float)d1, (float)d2, (float)d3);
    }

    protected void a(nq nq1, float f, float f1, float f2) {
        GL11.glRotatef(180F - f1, 0.0F, 1.0F, 0.0F);
        if(nq1.aS > 0) {
            float f3 = ((((float)nq1.aS + f2) - 1.0F) / 20F) * 1.6F;
            f3 = me.c(f3);
            if(f3 > 1.0F)
                f3 = 1.0F;
            GL11.glRotatef(f3 * a(nq1), 0.0F, 0.0F, 1.0F);
        }
    }

    protected float d(nq nq1, float f) {
        return nq1.d(f);
    }

    protected float c(nq nq1, float f) {
        return (float)nq1.Z + f;
    }

    protected void b(nq nq1, float f) {
    }

    protected int b(nq nq1, int i, float f) {
        return a(nq1, i, f);
    }

    protected int a(nq nq1, int i, float f) {
        return -1;
    }

    protected float a(nq nq1) {
        return 90F;
    }

    protected int a(nq nq1, float f, float f1) {
        return 0;
    }

    protected void a(nq nq1, float f) {
        // -----------------------------------------------------------------------------------------------------------------------
        ZMod.resizeHandle(nq1); // in "a" or "b" !?
        // -----------------------------------------------------------------------------------------------------------------------
    }

    protected void a(nq nq1, double d1, double d2, double d3) {
        if(!Minecraft.u());
    }

    protected void a(nq nq1, String s, double d1, double d2, double d3, int i) {
        float f = nq1.c(c.h);
        if(f > (float)i)
            return;
        abe abe1 = a();
        float f1 = 1.6F;
        float f2 = 0.01666667F * f1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d1 + 0.0F, (float)d2 + 2.3F, (float)d3);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-c.i, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(c.j, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-f2, -f2, f2);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        cv cv1 = cv.a;
        byte byte0 = 0;
        if(s.equals("deadmau5"))
            byte0 = -10;
        GL11.glDisable(3553);
        cv1.b();
        int j = abe1.a(s) / 2;
        cv1.a(0.0F, 0.0F, 0.0F, 0.25F);
        cv1.a(-j - 1, -1 + byte0, 0.0D);
        cv1.a(-j - 1, 8 + byte0, 0.0D);
        cv1.a(j + 1, 8 + byte0, 0.0D);
        cv1.a(j + 1, -1 + byte0, 0.0D);
        cv1.a();
        GL11.glEnable(3553);
        abe1.b(s, -abe1.a(s) / 2, byte0, 0x20ffffff);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        abe1.b(s, -abe1.a(s) / 2, byte0, -1);
        GL11.glEnable(2896);
        GL11.glDisable(3042);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void a(ia ia, double d1, double d2, double d3,
            float f, float f1) {
        a((nq)ia, d1, d2, d3, f, f1);
    }

    protected al g, h;
}
