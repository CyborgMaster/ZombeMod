// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.lang.reflect.*;

// search: "CookTime"
public class afd extends kf
    implements ic {

    protected static final boolean zmodmarker = true;

    public afd() {
        d = new yq[3];
        a = 0;
        b = 0;
        c = 0;
    }

    public int a() {
        return d.length;
    }

    public yq f_(int i) {
        return d[i];
    }

    public yq a(int i, int j) {
        if(d[i] != null) {
            if(d[i].a <= j) {
                yq yq1 = d[i];
                d[i] = null;
                return yq1;
            }
            yq yq2 = d[i].a(j);
            if(d[i].a == 0)
                d[i] = null;
            return yq2;
        } else {
            return null;
        }
    }

    public void a(int i, yq yq1) {
        d[i] = yq1;
        if(yq1 != null && yq1.a > d())
            yq1.a = d();
    }

    public String c() {
        return "Furnace";
    }

    public void a(abx abx1) {
        super.a(abx1);
        mu mu1 = abx1.m("Items");
        d = new yq[a()];
        for(int i = 0; i < mu1.d(); i++) {
            abx abx2 = (abx)mu1.a(i);
            byte byte0 = abx2.d("Slot");
            if(byte0 >= 0 && byte0 < d.length)
                d[byte0] = yq.a(abx2);
        }

        a = abx1.e("BurnTime");
        c = abx1.e("CookTime");
        b = a(d[1]);
    }

    public void b(abx abx1) {
        super.b(abx1);
        abx1.a("BurnTime", (short)a);
        abx1.a("CookTime", (short)c);
        mu mu1 = new mu();
        for(int i = 0; i < d.length; i++)
            if(d[i] != null) {
                abx abx2 = new abx();
                abx2.a("Slot", (byte)i);
                d[i].b(abx2);
                mu1.a(abx2);
            }

        abx1.a("Items", mu1);
    }

    public int d() {
        return 64;
    }

    public int b(int i) {
        // -----------------------------------------------------------------------------------------------------------------------
        return (c * i) / ZMod.furnaceSmeltTimeHandle();
        // -----------------------------------------------------------------------------------------------------------------------
    }

    public int c(int i) {
        // -----------------------------------------------------------------------------------------------------------------------
        if(b == 0) b = ZMod.furnaceSmeltTimeHandle();
        // -----------------------------------------------------------------------------------------------------------------------
        return (a * i) / b;
    }

    public boolean g() {
        return a > 0;
    }

    public void k_() {
        boolean flag = a > 0;
        boolean flag1 = false;
        // -----------------------------------------------------------------------------------------------------------------------
        if(a>0 && ZMod.furnaceUseFuelHandle(  a, o() )) a--;
        // -----------------------------------------------------------------------------------------------------------------------
        if(!i.I) {
            if(a == 0 && o()) {
                b = a = a(d[1]);
                if(a > 0) {
                    flag1 = true;
                    if(d[1] != null) {
                        // -------------------------------------------------------------------------------------------------------
                        d[1] = ZMod.furnaceDecFuelHandle( d[1] ); // update
                        // -------------------------------------------------------------------------------------------------------
                    }
                }
            }
            if(g() && o()) {
                c++;
                // ---------------------------------------------------------------------------------------------------------------
                if(c >= ZMod.furnaceSmeltTimeHandle()) {
                // ---------------------------------------------------------------------------------------------------------------
                    c = 0;
                    n();
                    flag1 = true;
                }
            // -------------------------------------------------------------------------------------------------------------------
            } else if(ZMod.furnaceWasteHandle()) {
            // -------------------------------------------------------------------------------------------------------------------
                c = 0;
            }
            if(flag != (a > 0)) {
                flag1 = true;
                afl.a(a > 0, i, j, k, l);
            }
        }
        if(flag1)
            C_();
    }

    private boolean o() {
        if(d[0] == null)
            return false;
        // -----------------------------------------------------------------------------------------------------------------------
        yq yq1 = ZMod.furnaceSmeltingHandle(  d[0].a().bO  );
        if(yq1 == null) yq1 = ds.a().a(d[0].a().bO);
        // -----------------------------------------------------------------------------------------------------------------------
        if(yq1 == null)
            return false;
        if(d[2] == null)
            return true;
        if(!d[2].a(yq1))
            return false;
        if(d[2].a < d() && d[2].a < d[2].c())
            return true;
        return d[2].a < yq1.c();
    }

    public void n() {
        if(!o())
            return;
        // -----------------------------------------------------------------------------------------------------------------------
        yq yq1 = ZMod.furnaceSmeltingHandle(  d[0].a().bO  );
        if(yq1 == null) yq1 = ds.a().a(d[0].a().bO);
        // -----------------------------------------------------------------------------------------------------------------------
        if(d[2] == null)
            d[2] = yq1.k();
        else
        if(d[2].c == yq1.c)
            d[2].a++;
        d[0].a--;
        if(d[0].a <= 0)
            d[0] = null;
    }

    // ===========================================================================================================================
    private static boolean mlInit = false;
    private static Class mlClass;
    private static Method mlMethod;
    private int a(yq yq1) {
        if(yq1 == null)
            return 0;
        int i = yq1.a().bO;
        // -----------------------------------------------------------------------------------------------------------------------
        int fuel = ZMod.furnaceFuelHandle(  i  ); if(fuel!=0) return fuel; //
        if(i < 256 && Block.blockArr[i].blockMat == Material.d) return ZMod.furnaceWoodFuelHandle(); //
        // -----------------------------------------------------------------------------------------------------------------------
        if(i == ww.D.bO)
            return 100;
        if(i == ww.m.bO)
            return 1600;
        if(i == ww.ay.bO)
            return 20000;
        if(i == oe.A.bO)
            return 100;
        // -----------------------------------------------------------------------------------------------------------------------
        if(i == ww.bo.bO) return 2400; //
        try {
            if(!mlInit) {
                mlInit = true;
                mlClass = Class.forName("ModLoader");
                mlMethod = mlClass.getDeclaredMethod("AddAllFuel", new Class[]{ Integer.TYPE });
            }
            if(mlMethod != null) return (Integer)(mlMethod.invoke(null, new Object[]{ i })); // update: i
        } catch(Exception whatever) { }
        return 0;
        // -----------------------------------------------------------------------------------------------------------------------
    }
    // ===========================================================================================================================

    public boolean a_(xb xb1) {
        if(i.b(j, k, l) != this)
            return false;
        return xb1.f((double)j + 0.5D, (double)k + 0.5D, (double)l + 0.5D) <= 64D;
    }

    public void e() {
    }

    public void D_() {
    }

    private yq d[];
    public int a, b, c;
}
