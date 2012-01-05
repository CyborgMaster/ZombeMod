// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

// search: 1 = -999;
public abstract class mg extends xe {

    protected static final boolean zmodmarker = true;

    public mg(pj pj1) {
        b = 176;
        c = 166;
        d = pj1;
    }

    public void a() {
        super.a();
        l.h.bA = d;
        e = (m - b) / 2;
        f = (n - c) / 2;
    }

    public void a(int i, int j, float f1) {
        j();
        int k = e;
        int l = f;
        a(f1, i, j);
        rt.c();
        GL11.glPushMatrix();
        GL11.glTranslatef(k, l, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(32826);
        vv vv1 = null;
        int i1 = 240;
        int k1 = 240;
        adx.a(adx.b, (float)i1 / 1.0F, (float)k1 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        for(int j1 = 0; j1 < d.e.size(); j1++) {
            vv vv2 = (vv)d.e.get(j1);
            a(vv2);
            if(a(vv2, i, j)) {
                vv1 = vv2;
                GL11.glDisable(2896);
                GL11.glDisable(2929);
                int l1 = vv2.e;
                int i2 = vv2.f;
                a(l1, i2, l1 + 16, i2 + 16, 0x80ffffff, 0x80ffffff);
                GL11.glEnable(2896);
                GL11.glEnable(2929);
            }
        }

        x x1 = this.l.h.by;
        if(x1.i() != null) {
            GL11.glTranslatef(0.0F, 0.0F, 32F);
            this.i = 200F;
            a.b = 200F;
            a.a(q, this.l.p, x1.i(), i - k - 8, j - l - 8);
            a.b(q, this.l.p, x1.i(), i - k - 8, j - l - 8);
            this.i = 0.0F;
            a.b = 0.0F;
        }
        GL11.glDisable(32826);
        rt.a();
        GL11.glDisable(2896);
        GL11.glDisable(2929);
        c();
        if(x1.i() == null && vv1 != null && vv1.c()) {
            dk dk1 = vv1.b();
            List list = dk1.q();
            if(list.size() > 0) {
                int j2 = 0;
                for(int k2 = 0; k2 < list.size(); k2++) {
                    int i3 = q.a((String)list.get(k2));
                    if(i3 > j2)
                        j2 = i3;
                }

                int l2 = (i - k) + 12;
                int j3 = j - l - 12;
                int k3 = j2;
                int l3 = 8;
                if(list.size() > 1)
                    l3 += 2 + (list.size() - 1) * 10;
                this.i = 300F;
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
                        s = (new StringBuilder()).append("\247").append(Integer.toHexString(dk1.s().e)).append(s).toString();
                    else
                        s = (new StringBuilder()).append("\2477").append(s).toString();
                    q.a(s, l2, j3, -1);
                    if(l4 == 0)
                        j3 += 2;
                    j3 += 10;
                }

                this.i = 0.0F;
                a.b = 0.0F;
            }
        }
        GL11.glPopMatrix();
        super.a(i, j, f1);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
    }

    protected void c() {
    }

    protected abstract void a(float f1, int i, int j);

    private void a(vv vv1) {
        int i = vv1.e;
        int j = vv1.f;
        dk dk1 = vv1.b();
        boolean flag = false;
        int k = i;
        int i1 = j;
        this.i = 100F;
        a.b = 100F;
        if(dk1 == null) {
            int j1 = vv1.e();
            if(j1 >= 0) {
                GL11.glDisable(2896);
                this.l.p.b(this.l.p.b("/gui/items.png"));
                b(k, i1, (j1 % 16) * 16, (j1 / 16) * 16, 16, 16);
                GL11.glEnable(2896);
                flag = true;
            }
        }
        if(!flag) {
            a.a(q, this.l.p, dk1, k, i1);
            a.b(q, this.l.p, dk1, k, i1);
        }
        a.b = 0.0F;
        this.i = 0.0F;
        if(this == null) {
            this.i = 100F;
            a.b = 100F;
            if(dk1 == null) {
                int l = vv1.e();
                if(l >= 0) {
                    GL11.glDisable(2896);
                    this.l.p.b(this.l.p.b("/gui/items.png"));
                    b(i, j, (l % 16) * 16, (l / 16) * 16, 16, 16);
                    GL11.glEnable(2896);
                    flag = true;
                }
            }
            if(!flag) {
                a.a(q, this.l.p, dk1, i, j);
                a.b(q, this.l.p, dk1, i, j);
            }
            a.b = 0.0F;
            this.i = 0.0F;
        }
    }

    private vv a(int i, int j) {
        for(int k = 0; k < d.e.size(); k++) {
            vv vv1 = (vv)d.e.get(k);
            if(a(vv1, i, j))
                return vv1;
        }

        return null;
    }

    protected void a(int i, int j, int k) {
        super.a(i, j, k);
        if(k == 0 || k == 1) {
            vv vv1 = a(i, j);
            int l = e;
            int i1 = f;
            boolean flag = i < l || j < i1 || i >= l + b || j >= i1 + c;
            int j1 = -1;
            if(vv1 != null)
                j1 = vv1.d;
            if(flag)
                j1 = -999;
            if(j1 != -1) {
                boolean flag1 = j1 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                a(vv1, j1, k, flag1);
            }
        }
    }

    private boolean a(vv vv1, int i, int j) {
        int k = e;
        int l = f;
        i -= k;
        j -= l;
        return i >= vv1.e - 1 && i < vv1.e + 16 + 1 && j >= vv1.f - 1 && j < vv1.f + 16 + 1;
    }

    protected void a(vv vv1, int i, int j, boolean flag) {
        if(vv1 != null)
            i = vv1.d;
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int infinite = 1; // yes ... this is horrible hack - sue me
        if(i==0 && vv1!=null && vv1.getClass()!=vv.class) infinite = ZMod.craftingHandle();
        flag &= infinite == 1;
        while(   l.c.a(d.f, i, j, flag, l.h)   != null && --infinite > 0);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //l.c.a(d.f, i, j, flag, l.h);
    }

    protected void b(int i, int j, int k) {
        if(k != 0);
    }

    protected void a(char c1, int i) {
        if(i == 1 || i == l.A.s.d)
            l.h.m();
    }

    public void d() {
        if(l.h == null) {
            return;
        } else {
            d.b(l.h);
            l.c.a(d.f, l.h);
            return;
        }
    }

    public boolean b() {
        return false;
    }

    public void s_() {
        super.s_();
        if(!l.h.K() || l.h.K)
            l.h.m();
    }

    protected static iw a = new iw();
    protected int b, c, e, f;
    public pj d;

}
