// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.util.*;
import java.lang.reflect.*;

// search: "random.explode", 4F
public class aef {

    protected static final boolean zmodmarker = true;
    private int type;
    private int eX, eY, eZ;

    public aef(vq vq1, ms ms1, double d1, double d2, double d3, float f1) {
        // -----------------------------------------------------------------------------------------------------------------------
        // force: tnt=4.0, creeper=3.0, fireball=1.0
        eX = (int)d1; eY = (int)d2; eZ = (int)d3; // update
        if(ms1 instanceof EntityCreeper) type = 1; // update   creeper
        else if(f1 < 2.5f) type = 2;               //          fireball
        else if(f1 > 3.5f) type = 3;               //          tnt
        f = ZMod.boomScaleHandle(f1, type); // update AND DO NOT FORGET TO REMOVE THE ORIGINAL!
        // -----------------------------------------------------------------------------------------------------------------------
        a = false;
        h = new Random();
        g = new HashSet();
        i = vq1;
        e = ms1;
        b = d1;
        c = d2;
        d = d3;
    }

    public void a() {
        float f1 = f;
        int j = 16;
        for(int k = 0; k < j; k++) {
            for(int i1 = 0; i1 < j; i1++) {
label0:
                for(int k1 = 0; k1 < j; k1++) {
                    if(k != 0 && k != j - 1 && i1 != 0 && i1 != j - 1 && k1 != 0 && k1 != j - 1)
                        continue;
                    double d1 = ((float)k / ((float)j - 1.0F)) * 2.0F - 1.0F;
                    double d2 = ((float)i1 / ((float)j - 1.0F)) * 2.0F - 1.0F;
                    double d3 = ((float)k1 / ((float)j - 1.0F)) * 2.0F - 1.0F;
                    double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
                    d1 /= d4;
                    d2 /= d4;
                    d3 /= d4;
                    float f2 = f * (0.7F + i.w.nextFloat() * 0.6F);
                    double d6 = b;
                    double d8 = c;
                    double d10 = d;
                    float f3 = 0.3F;
                    do {
                        if(f2 <= 0.0F)
                            continue label0;
                        int i3 = ga.c(d6);
                        int j3 = ga.c(d8);
                        int k3 = ga.c(d10);
                        int l3 = i.a(i3, j3, k3);
                        if(l3 > 0)
                            f2 -= (oe.m[l3].a(e) + 0.3F) * f3;
                        if(f2 > 0.0F)
                            g.add(new pr(i3, j3, k3));
                        d6 += d1 * (double)f3;
                        d8 += d2 * (double)f3;
                        d10 += d3 * (double)f3;
                        f2 -= f3 * 0.75F;
                    } while(true);
                }

            }

        }

        f *= 2.0F;
        int l = ga.c(b - (double)f - 1.0D);
        int j1 = ga.c(b + (double)f + 1.0D);
        int l1 = ga.c(c - (double)f - 1.0D);
        int i2 = ga.c(c + (double)f + 1.0D);
        int j2 = ga.c(d - (double)f - 1.0D);
        int k2 = ga.c(d + (double)f + 1.0D);
        List list = i.b(e, vi.b(l, l1, j2, j1, i2, k2));
        bk bk1 = bk.b(b, c, d);
        for(int l2 = 0; l2 < list.size(); l2++) {
            ms ms1 = (ms)list.get(l2);
            double d5 = ms1.g(b, c, d) / (double)f;
            if(d5 <= 1.0D) {
                double d7 = ms1.o - b;
                double d9 = ms1.p - c;
                double d11 = ms1.q - d;
                double d12 = ga.a(d7 * d7 + d9 * d9 + d11 * d11);
                d7 /= d12;
                d9 /= d12;
                d11 /= d12;
                double d13 = i.a(bk1, ms1.y);
                double d14 = (1.0D - d5) * d13;
                ms1.a(ll.l, (int)(((d14 * d14 + d14) / 2D) * 8D * (double)f + 1.0D));
                double d15 = d14;
                ms1.r += d7 * d15;
                ms1.s += d9 * d15;
                ms1.t += d11 * d15;
            }
        }

        f = f1;
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(g);
    }

    public void a(boolean flag) {
        // -----------------------------------------------------------------------------------------------------------------------
        boolean damage = ZMod.boomDamageHandle(eX, eY, eZ, type);
        // -----------------------------------------------------------------------------------------------------------------------

        i.a(b, c, d, "random.explode", 4F, (1.0F + (i.w.nextFloat() - i.w.nextFloat()) * 0.2F) * 0.7F);
        i.a("hugeexplosion", b, c, d, 0.0D, 0.0D, 0.0D);
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(g);
        for(int j = arraylist.size() - 1; j >= 0; j--) {
            pr pr1 = (pr)arraylist.get(j);
            int l = pr1.a;
            int j1 = pr1.b;
            int l1 = pr1.c;
            int j2 = i.a(l, j1, l1);
            if(flag) {
                double d1 = (float)l + i.w.nextFloat();
                double d2 = (float)j1 + i.w.nextFloat();
                double d3 = (float)l1 + i.w.nextFloat();
                double d4 = d1 - b;
                double d5 = d2 - c;
                double d6 = d3 - d;
                double d7 = ga.a(d4 * d4 + d5 * d5 + d6 * d6);
                d4 /= d7;
                d5 /= d7;
                d6 /= d7;
                double d8 = 0.5D / (d7 / (double)f + 0.10000000000000001D);
                d8 *= i.w.nextFloat() * i.w.nextFloat() + 0.3F;
                d4 *= d8;
                d5 *= d8;
                d6 *= d8;
                i.a("explode", (d1 + b * 1.0D) / 2D, (d2 + c * 1.0D) / 2D, (d3 + d * 1.0D) / 2D, d4, d5, d6);
                i.a("smoke", d1, d2, d3, d4, d5, d6);
            }

            // -------------------------------------------------------------------------------------------------------------------
            if(!damage) continue;
            float chance = ZMod.boomDropHandle( j2 ); // update : id
            // -------------------------------------------------------------------------------------------------------------------

            if(j2 > 0) {
                oe.m[j2].a(i, l, j1, l1, i.e(l, j1, l1), chance, 0); // UPDATE!
                i.g(l, j1, l1, 0);
                oe.m[j2].b(i, l, j1, l1);
            }
        }

        if(a) {
            for(int k = arraylist.size() - 1; k >= 0; k--) {
                pr pr2 = (pr)arraylist.get(k);
                int i1 = pr2.a;
                int k1 = pr2.b;
                int i2 = pr2.c;
                int k2 = i.a(i1, k1, i2);
                int l2 = i.a(i1, k1 - 1, i2);
                if(k2 == 0 && oe.o[l2] && h.nextInt(3) == 0)
                    i.g(i1, k1, i2, oe.at.bO);
            }

        }
    }

    public boolean a;
    private Random h;
    private vq i;
    public double b, c, d;
    public ms e;
    public float f;
    public Set g;
}
