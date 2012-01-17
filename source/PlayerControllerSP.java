// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nolvt nonlb safe
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

// NEED TO DECOMPILE SEPARATELY WITH SAFE MODE ON
// search: = -180F  * the smaller file
public class acq extends js {

    protected static final boolean zmodmarker = true;

    public acq(Minecraft minecraft) {
        super(minecraft);
        c = -1;
        d = -1;
        e = -1;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0;
    }

    public void a(xb xb1) {
        xb1.u = -180F;
    }

    public boolean d() {
        return true;
    }

    public boolean b(int j, int k, int i1, int j1) {
        int k1 = a.f.a(j, k, i1);
        int l1 = a.f.e(j, k, i1);
        boolean flag = super.b(j, k, i1, j1);
        yq yq1 = a.h.au();
        boolean flag1 = a.h.b(oe.m[k1]);
        // -----------------------------------------------------------------------------------------------------------------------
        flag = ZMod.harvestableHandle(flag);
        // -----------------------------------------------------------------------------------------------------------------------
        if(yq1 != null) {
            yq1.a(k1, j, k, i1, ((xb) (a.h)));
            if(yq1.a == 0) {
                yq1.a(((xb) (a.h)));
                a.h.av();
            }
        }
        if(flag && flag1)
            oe.m[k1].a(a.f, ((xb) (a.h)), j, k, i1, l1);
        return flag;
    }

    public void a(int j, int k, int i1, int j1) {
        if(!a.h.e(j, k, i1))
            return;
        a.f.a(((xb) (a.h)), j, k, i1, j1);
        int k1 = a.f.a(j, k, i1);
        if(k1 > 0 && f == 0.0F)
            oe.m[k1].a(a.f, j, k, i1, ((xb) (a.h)));
        if(k1 > 0 && oe.m[k1].a(((xb) (a.h))) >= 1.0F)
            b(j, k, i1, j1);
    }

    public void a() {
        f = 0.0F;
        i = 0;
    }

    public void c(int j, int k, int i1, int j1) {
        if(i > 0) {
            i--;
            return;
        }
        if(j == c && k == d && i1 == e) {
            int k1 = a.f.a(j, k, i1);
            if(!a.h.e(j, k, i1))
                return;
            if(k1 == 0)
                return;
            oe oe1 = oe.m[k1];
            // -------------------------------------------------------------------------------------------------------------------
            float add;
            f += add = ZMod.digProgressHandle(  oe1.a(((xb) (a.h)))  , k1 );
            int skip = add > 1.0f ? (int)(6f / add - 0.99999f) : 5;
            // -------------------------------------------------------------------------------------------------------------------
            //f += oe1.a(((xb) (a.h)));
            if(h % 4F == 0.0F && oe1 != null)
                a.C.b(oe1.bZ.d(), (float)j + 0.5F, (float)k + 0.5F, (float)i1 + 0.5F, (oe1.bZ.b() + 1.0F) / 8F, oe1.bZ.c() * 0.5F);
            h++;
            if(f >= 1.0F) {
                b(j, k, i1, j1);
                f = 0.0F;
                g = 0.0F;
                h = 0.0F;
                i = skip; // ****** UPDATE ******
            }
        } else {
            f = 0.0F;
            g = 0.0F;
            h = 0.0F;
            c = j;
            d = k;
            e = i1;
        }
    }

    public void a(float f1) {
        if(f <= 0.0F) {
            a.w.b = 0.0F;
            a.g.g = 0.0F;
        } else {
            float f2 = g + (f - g) * f1;
            a.w.b = f2;
            a.g.g = f2;
        }
    }

    public float b() {
        // -----------------------------------------------------------------------------------------------------------------------
        return ZMod.digReachHandle();
        // -----------------------------------------------------------------------------------------------------------------------
    }

    public void a(vq vq1) {
        super.a(vq1);
    }

    public xb b(vq vq1) {
        xb xb1 = super.b(vq1);
        return xb1;
    }

    public void c() {
        g = f;
        a.C.c();
    }

    public boolean a(xb xb1, vq vq1, yq yq1, int j, int k, int i1, int j1) {
        int k1 = vq1.a(j, k, i1);
        if(k1 > 0 && oe.m[k1].b(vq1, j, k, i1, xb1))
            return true;
        if(yq1 == null)
            return false;
        else
            return yq1.a(xb1, vq1, j, k, i1, j1);
    }

    public boolean f() {
        return true;
    }

    private int c, d, e, i;
    private float f, g, h;
}
