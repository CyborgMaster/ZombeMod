// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nolvt nonlb safe
// Source File Name:   SourceFile

import net.minecraft.client.Minecraft;

// NEED TO DECOMPILE SEPARATELY WITH SAFE MODE ON
// search: = -180F  * the smaller file
public class dm extends aes {

    protected static final boolean zmodmarker = true;

    public dm(Minecraft minecraft) {
        super(minecraft);
        c = -1;
        d = -1;
        e = -1;
        f = 0.0F;
        g = 0.0F;
        h = 0.0F;
        i = 0;
    }

    public void a(vi vi1) {
        vi1.y = -180F;
    }

    public boolean a() {
        return true;
    }

    public boolean a(int j, int k, int l, int i1) {
        int j1 = a.f.a(j, k, l);
        int k1 = a.f.d(j, k, l);
        boolean flag = super.a(j, k, l, i1);
        dk dk1 = a.h.aH();
        boolean flag1 = a.h.b(yy.k[j1]);
        // -----------------------------------------------------------------------------------------------------------------------
        flag = ZMod.harvestableHandle(flag);
        // -----------------------------------------------------------------------------------------------------------------------
        if(dk1 != null) {
            dk1.a(j1, j, k, l, ((vi) (a.h)));
            if(dk1.a == 0) {
                dk1.a(((vi) (a.h)));
                a.h.aI();
            }
        }
        if(flag && flag1)
            yy.k[j1].a(a.f, ((vi) (a.h)), j, k, l, k1);
        return flag;
    }

    public void b(int j, int k, int l, int i1) {
        if(!a.h.e(j, k, l))
            return;
        a.f.a(((vi) (a.h)), j, k, l, i1);
        int j1 = a.f.a(j, k, l);
        if(j1 > 0 && f == 0.0F)
            yy.k[j1].b(a.f, j, k, l, ((vi) (a.h)));
        if(j1 > 0 && yy.k[j1].a(((vi) (a.h))) >= 1.0F)
            a(j, k, l, i1);
    }

    public void b() {
        f = 0.0F;
        i = 0;
    }

    public void c(int j, int k, int l, int i1) {
        if(i > 0) {
            i--;
            return;
        }
        if(j == c && k == d && l == e) {
            int j1 = a.f.a(j, k, l);
            if(!a.h.e(j, k, l))
                return;
            if(j1 == 0)
                return;
            yy yy1 = yy.k[j1];
            // -------------------------------------------------------------------------------------------------------------------
            float add;
            f += add = ZMod.digProgressHandle(  yy1.a(((vi) (a.h)))  , j1 );
            int skip = add > 1.0f ? (int)(6f / add - 0.99999f) : 5;
            // -------------------------------------------------------------------------------------------------------------------
            if(h % 4F == 0.0F && yy1 != null)
                a.C.b(yy1.bX.d(), (float)j + 0.5F, (float)k + 0.5F, (float)l + 0.5F, (yy1.bX.b() + 1.0F) / 8F, yy1.bX.c() * 0.5F);
            h++;
            if(f >= 1.0F) {
                a(j, k, l, i1);
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
            e = l;
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

    public float c() {
        // -----------------------------------------------------------------------------------------------------------------------
        return ZMod.digReachHandle();
        // -----------------------------------------------------------------------------------------------------------------------
    }

    public void a(ry ry1) {
        super.a(ry1);
    }

    public vi b(ry ry1) {
        vi vi1 = super.b(ry1);
        return vi1;
    }

    public void d() {
        g = f;
        a.C.c();
    }

    public boolean a(vi vi1, ry ry1, dk dk1, int j, int k, int l, int i1) {
        int j1 = ry1.a(j, k, l);
        if(j1 > 0 && yy.k[j1].a(ry1, j, k, l, vi1))
            return true;
        if(dk1 == null)
            return false;
        else
            return dk1.a(vi1, ry1, j, k, l, i1);
    }

    public boolean e() {
        return true;
    }

    private int c, d, e, i;
    private float f, g, h;
}
