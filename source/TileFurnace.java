// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.lang.reflect.*;

// search: "CookTime"
public class oe extends bq
    implements de {

    protected static final boolean zmodmarker = true;

    public oe() {
        k = new dk[3];
        a = 0;
        b = 0;
        j = 0;
    }

    public int c() {
        return k.length;
    }

    public dk d(int i) {
        return k[i];
    }

    public dk a(int i, int l) {
        if(k[i] != null) {
            if(k[i].a <= l) {
                dk dk1 = k[i];
                k[i] = null;
                return dk1;
            }
            dk dk2 = k[i].a(l);
            if(k[i].a == 0)
                k[i] = null;
            return dk2;
        } else {
            return null;
        }
    }

    public void a(int i, dk dk1) {
        k[i] = dk1;
        if(dk1 != null && dk1.a > e())
            dk1.a = e();
    }

    public String d() {
        return "Furnace";
    }

    public void b(ik ik1) {
        super.b(ik1);
        yi yi1 = ik1.l("Items");
        k = new dk[c()];
        for(int i = 0; i < yi1.c(); i++) {
            ik ik2 = (ik)yi1.a(i);
            byte byte0 = ik2.c("Slot");
            if(byte0 >= 0 && byte0 < k.length)
                k[byte0] = dk.a(ik2);
        }

        a = ik1.d("BurnTime");
        j = ik1.d("CookTime");
        b = a(k[1]);
    }

    public void a(ik ik1) {
        super.a(ik1);
        ik1.a("BurnTime", (short)a);
        ik1.a("CookTime", (short)j);
        yi yi1 = new yi();
        for(int i = 0; i < k.length; i++)
            if(k[i] != null) {
                ik ik2 = new ik();
                ik2.a("Slot", (byte)i);
                k[i].b(ik2);
                yi1.a(ik2);
            }

        ik1.a("Items", yi1);
    }

    public int e() {
        return 64;
    }

    public int a(int i) {
        // -----------------------------------------------------------------------------------------------------------------------
        return (j * i) / ZMod.furnaceSmeltTimeHandle();
        // -----------------------------------------------------------------------------------------------------------------------
    }

    public int b(int i) {
        // -----------------------------------------------------------------------------------------------------------------------
        if(b == 0) b = ZMod.furnaceSmeltTimeHandle();
        // -----------------------------------------------------------------------------------------------------------------------
        return (a * i) / b;
    }

    public boolean a() {
        return a > 0;
    }

    public void b() {
        boolean flag = a > 0;
        boolean flag1 = false;
        // -----------------------------------------------------------------------------------------------------------------------
        if(a>0 && ZMod.furnaceUseFuelHandle(  a, p() )) a--;
        // -----------------------------------------------------------------------------------------------------------------------
        if(!c.I) {
            if(a == 0 && p()) {
                b = a = a(k[1]);
                if(a > 0) {
                    flag1 = true;
                    if(k[1] != null) {
                        // -------------------------------------------------------------------------------------------------------
                        k[1] = ZMod.furnaceDecFuelHandle( k[1] ); // update
                        // -------------------------------------------------------------------------------------------------------
                    }
                }
            }
            if(a() && p()) {
                j++;
                // ---------------------------------------------------------------------------------------------------------------
                if(j >= ZMod.furnaceSmeltTimeHandle()) {
                // ---------------------------------------------------------------------------------------------------------------
                    j = 0;
                    o();
                    flag1 = true;
                }
            // -------------------------------------------------------------------------------------------------------------------
            } else if(ZMod.furnaceWasteHandle()) {
            // -------------------------------------------------------------------------------------------------------------------
                j = 0;
            }
            if(flag != (a > 0)) {
                flag1 = true;
                eu.a(a > 0, c, d, e, f);
            }
        }
        if(flag1)
            h();
    }

    private boolean p() {
        if(k[0] == null)
            return false;
        // -----------------------------------------------------------------------------------------------------------------------
        dk dk1 = ZMod.furnaceSmeltingHandle(  k[0].a().bM  );
        if(dk1 == null) dk1 = mt.a().a(k[0].a().bM);
        // -----------------------------------------------------------------------------------------------------------------------
        if(dk1 == null)
            return false;
        if(k[2] == null)
            return true;
        if(!k[2].a(dk1))
            return false;
        if(k[2].a < e() && k[2].a < k[2].c())
            return true;
        return k[2].a < dk1.c();
    }

    public void o() {
        if(!p())
            return;
        // -----------------------------------------------------------------------------------------------------------------------
        dk dk1 = ZMod.furnaceSmeltingHandle(  k[0].a().bM  );
        if(dk1 == null) dk1 = mt.a().a(k[0].a().bM);
        // -----------------------------------------------------------------------------------------------------------------------
        if(k[2] == null)
            k[2] = dk1.k();
        else
        if(k[2].c == dk1.c)
            k[2].a++;
        k[0].a--;
        if(k[0].a <= 0)
            k[0] = null;
    }

    // ===========================================================================================================================
    private static boolean mlInit = false;
    private static Class mlClass;
    private static Method mlMethod;
    private int a(dk dk1) {
        if(dk1 == null)
            return 0;
        int i = dk1.a().bM;
        // -----------------------------------------------------------------------------------------------------------------------
        int fuel = ZMod.furnaceFuelHandle(  i  ); if(fuel!=0) return fuel; //
        if(i < 256 && Block.blockArr[i].blockMat == Material.d) return ZMod.furnaceWoodFuelHandle(); //
        // -----------------------------------------------------------------------------------------------------------------------
        if(i == acy.C.bM)
            return 100;
        if(i == acy.l.bM)
            return 1600;
        if(i == acy.ax.bM)
            return 20000;
        if(i == yy.y.bM)
            return 100;
        // -----------------------------------------------------------------------------------------------------------------------
        if(i == acy.bn.bM) return 2400; //
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

    public boolean b_(vi vi1) {
        if(c.b(d, e, f) != this)
            return false;
        return vi1.f((double)d + 0.5D, (double)e + 0.5D, (double)f + 0.5D) <= 64D;
    }

    public void j() {
    }

    public void k() {
    }

    private dk k[];
    public int a, b, j;
}
