// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// search: 1 = -999;
public abstract class ft extends ug {

    protected static final boolean zmodmarker = true;

    public ft(cx cx1) {
        b = 176;
        c = 166;
        d = cx1;
    }

    public void c() {
        super.c();
        p.h.ar = d;
        e = (q - b) / 2;
        f = (r - c) / 2;
    }

    public void a(int i, int j, float f1) {
        k();
        int k = e;
        int l = f;
        a(f1, i, j);
        se.c();
        GL11.glPushMatrix();
        GL11.glTranslatef(k, l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        wz wz1 = null;
        int i1 = 240;
        int k1 = 240;
        em.a(em.b, (float)i1 / 1.0F, (float)k1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        for(int j1 = 0; j1 < d.e.size(); j1++) {
            wz wz2 = (wz)d.e.get(j1);
            a(wz2);
            if(a(wz2, i, j)) {
                wz1 = wz2;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                int l1 = wz2.d;
                int i2 = wz2.e;
                a(l1, i2, l1 + 16, i2 + 16, 0x80ffffff, 0x80ffffff);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        yn yn1 = p.h.ap;
        if(yn1.j() != null) {
            GL11.glTranslatef(0.0F, 0.0F, 32F);
            g = 200F;
            a.b = 200F;
            a.a(u, p.p, yn1.j(), i - k - 8, j - l - 8);
            a.b(u, p.p, yn1.j(), i - k - 8, j - l - 8);
            g = 0.0F;
            a.b = 0.0F;
        }
        GL11.glDisable(32826);
        se.a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        d();
        if(yn1.j() == null && wz1 != null && wz1.c()) {
            yq yq1 = wz1.b();
            List list = yq1.q();
            if(list.size() > 0) {
                int j2 = 0;
                for(int k2 = 0; k2 < list.size(); k2++) {
                    int i3 = u.a((String)list.get(k2));
                    if(i3 > j2)
                        j2 = i3;
                }

                int l2 = (i - k) + 12;
                int j3 = j - l - 12;
                int k3 = j2;
                int l3 = 8;
                if(list.size() > 1)
                    l3 += 2 + (list.size() - 1) * 10;
                g = 300F;
                a.b = 300F;
                int i4 = 0xf0100010;
                a(l2 - 3, j3 - 4, l2 + k3 + 3, j3 - 3, i4, i4);
                a(l2 - 3, j3 + l3 + 3, l2 + k3 + 3, j3 + l3 + 4, i4, i4);
                a(l2 - 3, j3 - 3, l2 + k3 + 3, j3 + l3 + 3, i4, i4);
                a(l2 - 4, j3 - 3, l2 - 3, j3 + l3 + 3, i4, i4);
                a(l2 + k3 + 3, j3 - 3, l2 + k3 + 4, j3 + l3 + 3, i4, i4);
                int j4 = 0x505000ff;
                int k4 = (j4 & 0xfefefe) >> 1 | j4 & 0xff000000;
                a(l2 - 3, (j3 - 3) + 1, (l2 - 3) + 1, (j3 + l3 + 3) - 1, j4, k4);
                a(l2 + k3 + 2, (j3 - 3) + 1, l2 + k3 + 3, (j3 + l3 + 3) - 1, j4, k4);
                a(l2 - 3, j3 - 3, l2 + k3 + 3, (j3 - 3) + 1, j4, j4);
                a(l2 - 3, j3 + l3 + 2, l2 + k3 + 3, j3 + l3 + 3, k4, k4);
                for(int l4 = 0; l4 < list.size(); l4++) {
                    String s = (String)list.get(l4);
                    if(l4 == 0)
                        s = (new StringBuilder()).append("\247").append(Integer.toHexString(yq1.s().e)).append(s).toString();
                    else
                        s = (new StringBuilder()).append("\2477").append(s).toString();
                    u.a(s, l2, j3, -1);
                    if(l4 == 0)
                        j3 += 2;
                    j3 += 10;
                }

                g = 0.0F;
                a.b = 0.0F;
            }
        }
        GL11.glPopMatrix();
        super.a(i, j, f1);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    protected void d() {
    }

    protected abstract void a(float f1, int i, int j);

    private void a(wz wz1) {
        int i = wz1.d;
        int j = wz1.e;
        yq yq1 = wz1.b();
        boolean flag = false;
        int k = i;
        int i1 = j;
        g = 100F;
        a.b = 100F;
        if(yq1 == null) {
            int j1 = wz1.e();
            if(j1 >= 0) {
                GL11.glDisable(2896);
                p.p.b(p.p.b("/gui/items.png"));
                b(k, i1, (j1 % 16) * 16, (j1 / 16) * 16, 16, 16);
                GL11.glEnable(2896);
                flag = true;
            }
        }
        if(!flag) {
            a.a(u, p.p, yq1, k, i1);
            a.b(u, p.p, yq1, k, i1);
        }
        a.b = 0.0F;
        g = 0.0F;
        if(this == null) {
            g = 100F;
            a.b = 100F;
            if(yq1 == null) {
                int l = wz1.e();
                if(l >= 0) {
                    GL11.glDisable(2896);
                    p.p.b(p.p.b("/gui/items.png"));
                    b(i, j, (l % 16) * 16, (l / 16) * 16, 16, 16);
                    GL11.glEnable(2896);
                    flag = true;
                }
            }
            if(!flag) {
                a.a(u, p.p, yq1, i, j);
                a.b(u, p.p, yq1, i, j);
            }
            a.b = 0.0F;
            g = 0.0F;
        }
    }

    private wz a(int i, int j) {
        for(int k = 0; k < d.e.size(); k++) {
            wz wz1 = (wz)d.e.get(k);
            if(a(wz1, i, j))
                return wz1;
        }

        return null;
    }

    protected void a(int i, int j, int k) {
        super.a(i, j, k);
        if(k == 0 || k == 1) {
            wz wz1 = a(i, j);
            int l = e;
            int i1 = f;
            boolean flag = i < l || j < i1 || i >= l + b || j >= i1 + c;
            int j1 = -1;
            if(wz1 != null)
                j1 = wz1.c;
            if(flag)
                j1 = -999;
            if(j1 != -1) {
                boolean flag1 = j1 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                a(wz1, j1, k, flag1);
            }
        }
    }

    private boolean a(wz wz1, int i, int j) {
        int k = e;
        int l = f;
        i -= k;
        j -= l;
        return i >= wz1.d - 1 && i < wz1.d + 16 + 1 && j >= wz1.e - 1 && j < wz1.e + 16 + 1;
    }

    protected void a(wz wz1, int i, int j, boolean flag) {
        if(wz1 != null)
            i = wz1.c;
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int infinite = 1; // yes ... this is horrible hack - sue me
        if(i==0 && wz1!=null && wz1.getClass()!=wz.class) infinite = ZMod.craftingHandle();
        flag &= infinite == 1;
        while(   p.c.a(d.f, i, j, flag, p.h)   != null && --infinite > 0);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //p.c.a(d.f, i, j, flag, p.h);
    }

    protected void a(char c1, int i) {
        if(i == 1 || i == p.A.s.d)
            p.h.af();
    }

    public void e() {
        if(p.h == null) {
            return;
        } else {
            d.a(p.h);
            p.c.a(d.f, p.h);
            return;
        }
    }

    public boolean b() {
        return false;
    }

    public void a() {
        super.a();
        if(!p.h.O() || p.h.G)
            p.h.af();
    }

    protected static su a = new su();
    protected int b, c, e, f;
    public cx d;

}
