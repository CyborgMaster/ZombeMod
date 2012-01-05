// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.util.*;
import java.lang.reflect.*;

// search: "humanoid"
public abstract class vi extends nq {

    public static Method getClassMethod(String c, String m, Class param[]) { try { return Class.forName(c).getMethod(m, param); } catch(Exception e) { e.printStackTrace(); return null; } }
    public static Field getClassField(String c, String m) { try { return Class.forName(c).getField(m); } catch(Exception e) { e.printStackTrace(); return null; } }
    public static Object getResult(Method m, Object obj, Object param[]) { try { return m.invoke(obj, param); } catch(Exception whatever) { } return null; }
    public static Object getValue(Field field, Object obj) { try { return field.get(obj); } catch(Exception whatever) { } return null; }
    public static Material getMaterial(String name) { try { return (Material)Class.forName("Material").getField(name).get(null); } catch(Exception whatever) { return null; } }
    public static Material mat_g = getMaterial("g");
    public static Method c_b = getClassMethod("c", "b", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE});

    // ---------------------------------------------------------------------------------------------------------------------------
    protected static boolean zmodmarker = true;
    public final void callSuper(double mx, double my, double mz) { super.entMove(mx,my,mz); }

    public void entMove(double mx, double my, double mz) {
        ZMod.flyHandle(this, mx, my, mz);
    }

    // this thing is in this class: add first variable (noclip)
    public boolean L() {
        return !entNoClip && !bT && super.L();
    }

    // ... as is this: first chance to undo the dickmove
    public void c() {
        ZMod.flyDickmoveCancel();
        if(bC > 0)
            bC--;
        if(o.v == 0 && ag() < f_() && (Z % 20) * 12 == 0)
            a_(1);
        by.b();
        bF = bG;
        super.c();
        aI = cg;
        aJ = ch;
        if(X()) {
            aI += (double)cg * 0.29999999999999999D;
            aJ += (double)ch * 0.29999999999999999D;
        }
        float f = me.a(v * v + x * x);
        float f1 = (float)Math.atan(-w * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
            f = 0.1F;
        if(!D || ag() <= 0)
            f = 0.0F;
        if(D || ag() <= 0)
            f1 = 0.0F;
        bG += (f - bG) * 0.4F;
        aV += (f1 - aV) * 0.8F;
        if(ag() > 0) {
            List list = o.b(this, C.b(1.0D, 0.0D, 1.0D));
            if(list != null) {
                for(int i1 = 0; i1 < list.size(); i1++) {
                    ia ia1 = (ia)list.get(i1);
                    if(!ia1.K)
                        l(ia1);
                }

            }
        }
    }

    // ... as is this. search: 0.8F
    protected void ak() {
        super.ak();
        // -----------------------------------------------------------------------------------------------------------------------
        entMotionY *= ZMod.flyJumpHandle();
        // -----------------------------------------------------------------------------------------------------------------------
        a(ny.u, 1);
        if(X())
            g(0.8F);
        else
            g(0.2F);
    }

    // ... and this. search: "Notch"
    public void a(pm pm1) {
        ZMod.pingOnDeathHandle();
        super.a(pm1);
        a(0.2F, 0.2F);
        d(s, t, u);
        w = 0.10000000149011612D;
        if(bJ.equals("Notch"))
            a(new dk(acy.i, 1), true);
        by.g();
        if(pm1 != null) {
            v = -me.b(((aR + y) * 3.141593F) / 180F) * 0.1F;
            x = -me.a(((aR + y) * 3.141593F) / 180F) * 0.1F;
        } else {
            v = x = 0.0D;
        }
        L = 0.1F;
        a(ny.y, 1);
    }

    // ---------------------------------------------------------------------------------------------------------------------------

    public vi(ry ry1) {
        super(ry1);
        by = new x(this);
        bB = new eq();
        bC = 0;
        bD = 0;
        bE = 0;
        bH = false;
        bI = 0;
        bM = 0;
        bY = 20;
        bZ = false;
        cc = new wq();
        cg = 0.1F;
        ch = 0.02F;
        ci = null;
        bz = new gd(by, !ry1.I);
        bA = bz;
        L = 1.62F;
        dh dh1 = ry1.v();
        c((double)dh1.a + 0.5D, dh1.b + 1, (double)dh1.c + 0.5D, 0.0F, 0.0F);
        aD = "humanoid";
        aC = 180F;
        aa = 20;
        aA = "/mob/char.png";
    }

    public int f_() {
        return 20;
    }

    protected void b() {
        super.b();
        ag.a(16, Byte.valueOf((byte)0));
        ag.a(17, Byte.valueOf((byte)0));
    }

    public dk ax() {
        return d;
    }

    public int ay() {
        return e;
    }

    public boolean az() {
        return d != null;
    }

    public int aA() {
        if(az())
            return d.l() - e;
        else
            return 0;
    }

    public void aB() {
        if(d != null)
            d.a(o, this, e);
        aC();
    }

    public void aC() {
        d = null;
        e = 0;
        if(!o.I)
            c(false);
    }

    public boolean aj() {
        return az() && acy.d[d.c].c(d) == ps.d;
    }

    public void a() {
        if(d != null) {
            dk dk1 = by.a();
            if(dk1 != d) {
                aC();
            } else {
                if(e <= 25 && e % 4 == 0)
                    b(dk1, 5);
                if(--e == 0 && !o.I)
                    aD();
            }
        }
        if(bM > 0)
            bM--;
        if(ar()) {
            a++;
            if(a > 100)
                a = 100;
            if(!o.I)
                if(!aR())
                    a(true, true, false);
                else
                if(o.l())
                    a(false, true, true);
        } else
        if(a > 0) {
            a++;
            if(a >= 110)
                a = 0;
        }
        super.a();
        if(!o.I && bA != null && !bA.a(this)) {
            m();
            bA = bz;
        }
        if(cc.b) {
            for(int i1 = 0; i1 < 8; i1++);
        }
        if(V() && cc.a)
            y();
        bN = bQ;
        bO = bR;
        bP = bS;
        double d1 = s - bQ;
        double d2 = t - bR;
        double d3 = u - bS;
        double d4 = 10D;
        if(d1 > d4)
            bN = bQ = s;
        if(d3 > d4)
            bP = bS = u;
        if(d2 > d4)
            bO = bR = t;
        if(d1 < -d4)
            bN = bQ = s;
        if(d3 < -d4)
            bP = bS = u;
        if(d2 < -d4)
            bO = bR = t;
        bQ += d1 * 0.25D;
        bS += d3 * 0.25D;
        bR += d2 * 0.25D;
        a(ny.k, 1);
        if(n == null)
            c = null;
        if(!o.I)
            bB.a(this);
    }

    protected void b(dk dk1, int i1) {
        if(dk1.m() == ps.c)
            o.a(this, "random.drink", 0.5F, o.w.nextFloat() * 0.1F + 0.9F);
        if(dk1.m() == ps.b) {
            for(int j1 = 0; j1 < i1; j1++) {
                fb fb1 = fb.b(((double)Y.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
                fb1.a((-z * 3.141593F) / 180F);
                fb1.b((-y * 3.141593F) / 180F);
                fb fb2 = fb.b(((double)Y.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-Y.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
                fb2.a((-z * 3.141593F) / 180F);
                fb2.b((-y * 3.141593F) / 180F);
                fb2 = fb2.c(s, t + (double)E(), u);
                o.a((new StringBuilder()).append("iconcrack_").append(dk1.a().bM).toString(), fb2.a, fb2.b, fb2.c, fb1.a, fb1.b + 0.050000000000000003D, fb1.c);
            }

            o.a(this, "random.eat", 0.5F + 0.5F * (float)Y.nextInt(2), (Y.nextFloat() - Y.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected void aD() {
        if(d != null) {
            b(d, 16);
            int i1 = d.a;
            dk dk1 = d.b(o, this);
            if(dk1 != d || dk1 != null && dk1.a != i1) {
                by.a[by.c] = dk1;
                if(dk1.a == 0)
                    by.a[by.c] = null;
            }
            aC();
        }
    }

    public void a(byte byte0) {
        if(byte0 == 9)
            aD();
        else
            super.a(byte0);
    }

    protected boolean ai() {
        return ag() <= 0 || ar();
    }

    protected void m() {
        bA = bz;
    }

    public void U() {
        bL = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftCloaks/").append(bJ).append(".png").toString();
        ae = bL;
    }

    public void M() {
        double d1 = s;
        double d2 = t;
        double d3 = u;
        super.M();
        bF = bG;
        bG = 0.0F;
        k(s - d1, t - d2, u - d3);
    }

    public void u() {
        L = 1.62F;
        a(0.6F, 1.8F);
        super.u();
        h(f_());
        aS = 0;
    }

    private int aQ() {
        if(a(abg.e))
            return 6 - (1 + b(abg.e).c()) * 1;
        if(a(abg.f))
            return 6 + (1 + b(abg.f).c()) * 2;
        else
            return 6;
    }

    protected void n() {
        int i1 = aQ();
        if(bH) {
            bI++;
            if(bI >= i1) {
                bI = 0;
                bH = false;
            }
        } else {
            bI = 0;
        }
        aL = (float)bI / (float)i1;
    }

    private void l(ia ia1) {
        ia1.a(this);
    }

    public int aE() {
        return bE;
    }

    public void b(ia ia1, int i1) {
        bE += i1;
        if(ia1 instanceof vi)
            a(ny.A, 1);
        else
            a(ny.z, 1);
    }

    protected int d(int i1) {
        int j1 = ml.a(by);
        if(j1 > 0 && Y.nextInt(j1 + 1) > 0)
            return i1;
        else
            return super.d(i1);
    }

    public void l_() {
        a(by.a(by.c, 1), false);
    }

    public void a(dk dk1) {
        a(dk1, false);
    }

    public void a(dk dk1, boolean flag) {
        if(dk1 == null)
            return;
        ih ih1 = new ih(o, s, (t - 0.30000001192092896D) + (double)E(), u, dk1);
        ih1.c = 40;
        float f = 0.1F;
        if(flag) {
            float f2 = Y.nextFloat() * 0.5F;
            float f4 = Y.nextFloat() * 3.141593F * 2.0F;
            ih1.v = -me.a(f4) * f2;
            ih1.x = me.b(f4) * f2;
            ih1.w = 0.20000000298023224D;
        } else {
            float f1 = 0.3F;
            ih1.v = -me.a((y / 180F) * 3.141593F) * me.b((z / 180F) * 3.141593F) * f1;
            ih1.x = me.b((y / 180F) * 3.141593F) * me.b((z / 180F) * 3.141593F) * f1;
            ih1.w = -me.a((z / 180F) * 3.141593F) * f1 + 0.1F;
            f1 = 0.02F;
            float f3 = Y.nextFloat() * 3.141593F * 2.0F;
            f1 *= Y.nextFloat();
            ih1.v += Math.cos(f3) * (double)f1;
            ih1.w += (Y.nextFloat() - Y.nextFloat()) * 0.1F;
            ih1.x += Math.sin(f3) * (double)f1;
        }
        a(ih1);
        a(ny.v, 1);
    }

    protected void a(ih ih1) {
        o.a(ih1);
    }

    public float a(yy yy1) {
        float f = by.a(yy1);
        float f1 = f;
        int i1 = ml.b(by);
        if(i1 > 0 && by.b(yy1))
            f1 += i1 * i1 + 1;
        if(a(abg.e))
            f1 *= 1.0F + (float)(b(abg.e).c() + 1) * 0.2F;
        if(a(abg.f))
            f1 *= 1.0F - (float)(b(abg.f).c() + 1) * 0.2F;
        if(a(mat_g) && !ml.g(by))
            f1 /= 5F;
        if(!D)
            f1 /= 5F;
        return f1;
    }

    public boolean b(yy yy1) {
        return by.b(yy1);
    }

    public void b(ik ik1) {
        super.b(ik1);
        yi yi1 = ik1.l("Inventory");
        by.b(yi1);
        bK = ik1.e("Dimension");
        bT = ik1.m("Sleeping");
        a = ik1.d("SleepTimer");
        cf = ik1.g("XpP");
        cd = ik1.e("XpLevel");
        ce = ik1.e("XpTotal");
        if(bT) {
            bU = new dh(me.c(s), me.c(t), me.c(u));
            a(true, true, false);
        }
        if(ik1.b("SpawnX") && ik1.b("SpawnY") && ik1.b("SpawnZ"))
            b = new dh(ik1.e("SpawnX"), ik1.e("SpawnY"), ik1.e("SpawnZ"));
        bB.a(ik1);
        cc.b(ik1);
    }

    public void a(ik ik1) {
        super.a(ik1);
        ik1.a("Inventory", by.a(new yi()));
        ik1.a("Dimension", bK);
        ik1.a("Sleeping", bT);
        ik1.a("SleepTimer", (short)a);
        ik1.a("XpP", cf);
        ik1.a("XpLevel", cd);
        ik1.a("XpTotal", ce);
        if(b != null) {
            ik1.a("SpawnX", b.a);
            ik1.a("SpawnY", b.b);
            ik1.a("SpawnZ", b.c);
        }
        bB.b(ik1);
        cc.a(ik1);
    }

    public void a(de de) {
    }

    public void b(int i1, int j1, int k1) {
    }

    public void a(int i1, int j1, int k1) {
    }

    public void a(ia ia1, int i1) {
    }

    public float E() {
        return 0.12F;
    }

    protected void aF() {
        L = 1.62F;
    }

    public boolean a(pm pm1, int i1) {
        if(cc.a && !pm1.f())
            return false;
        bq = 0;
        if(ag() <= 0)
            return false;
        if(ar() && !o.I)
            a(true, true, false);
        ia ia1 = pm1.a();
        if((ia1 instanceof zo) || (ia1 instanceof ro)) {
            if(o.v == 0)
                i1 = 0;
            if(o.v == 1)
                i1 = i1 / 2 + 1;
            if(o.v == 3)
                i1 = (i1 * 3) / 2;
        }
        if(i1 == 0)
            return false;
        ia ia2 = ia1;
        if((ia2 instanceof ro) && ((ro)ia2).c != null)
            ia2 = ((ro)ia2).c;
        if(ia2 instanceof nq)
            a((nq)ia2, false);
        a(ny.x, i1);
        return super.a(pm1, i1);
    }

    protected int d(pm pm1, int i1) {
        int j1 = super.d(pm1, i1);
        if(j1 <= 0)
            return 0;
        int k1 = ml.a(by, pm1);
        if(k1 > 20)
            k1 = 20;
        if(k1 > 0 && k1 <= 20) {
            int l1 = 25 - k1;
            int i2 = j1 * l1 + aO;
            j1 = i2 / 25;
            aO = i2 % 25;
        }
        return j1;
    }

    protected boolean aG() {
        return false;
    }

    protected void a(nq nq1, boolean flag) {
        if((nq1 instanceof abh) || (nq1 instanceof is))
            return;
        if(nq1 instanceof aik) {
            aik aik1 = (aik)nq1;
            if(aik1.aG() && bJ.equals(aik1.aD()))
                return;
        }
        if((nq1 instanceof vi) && !aG())
            return;
        List list = o.a(aik.class, ( (c)getResult(c_b, null, new Object[]{s, t, u, s + 1.0D, t + 1.0D, u + 1.0D}) ).b(16D, 4D, 16D));
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            ia ia1 = (ia)iterator.next();
            aik aik2 = (aik)ia1;
            if(aik2.aG() && aik2.aC() == null && bJ.equals(aik2.aD()) && (!flag || !aik2.aE())) {
                aik2.d(false);
                aik2.a(nq1);
            }
        } while(true);
    }

    protected void i(int i1) {
        by.f(i1);
    }

    protected int o_() {
        return by.f();
    }

    protected void b(pm pm1, int i1) {
        if(!pm1.d() && aj())
            i1 = 1 + i1 >> 1;
        i1 = c(pm1, i1);
        i1 = d(pm1, i1);
        g(pm1.e());
        super.b(pm1, i1);
    }

    public void a(oe oe) {
    }

    public void a(bp bp) {
    }

    public void a(u u1) {
    }

    public void a(tt tt) {
    }

    public void j(ia ia1) {
        if(ia1.c(this))
            return;
        dk dk1 = aH();
        if(dk1 != null && (ia1 instanceof nq)) {
            dk1.a((nq)ia1);
            if(dk1.a <= 0) {
                dk1.a(this);
                aI();
            }
        }
    }

    public dk aH() {
        return by.a();
    }

    public void aI() {
        by.a(by.c, null);
    }

    public double O() {
        return (double)(L - 0.5F);
    }

    public void m_() {
        if(!bH || bI >= aQ() / 2 || bI < 0) {
            bI = -1;
            bH = true;
        }
    }

    public void k(ia ia1) {
        int i1 = by.a(ia1);
        if(a(abg.g))
            i1 += 3 << b(abg.g).c();
        if(a(abg.t))
            i1 -= 2 << b(abg.t).c();
        int j1 = 0;
        int k1 = 0;
        if(ia1 instanceof nq) {
            k1 = ml.a(by, (nq)ia1);
            j1 += ml.b(by, (nq)ia1);
        }
        if(X())
            j1++;
        if(i1 > 0 || k1 > 0) {
            boolean flag = Q > 0.0F && !D && !ah() && !D() && !a(abg.q) && n == null && (ia1 instanceof nq);
            if(flag)
                i1 += Y.nextInt(i1 / 2 + 2);
            i1 += k1;
            boolean flag1 = ia1.a(pm.a(this), i1);
            if(flag1) {
                if(j1 > 0) {
                    ia1.h(-me.a((y * 3.141593F) / 180F) * (float)j1 * 0.5F, 0.10000000000000001D, me.b((y * 3.141593F) / 180F) * (float)j1 * 0.5F);
                    v *= 0.59999999999999998D;
                    x *= 0.59999999999999998D;
                    a(false);
                }
                if(flag)
                    a(ia1);
                if(k1 > 0)
                    b(ia1);
                if(i1 >= 18)
                    a(ut.E);
            }
            dk dk1 = aH();
            if(dk1 != null && (ia1 instanceof nq)) {
                dk1.a((nq)ia1, this);
                if(dk1.a <= 0) {
                    dk1.a(this);
                    aI();
                }
            }
            if(ia1 instanceof nq) {
                if(ia1.K())
                    a((nq)ia1, true);
                a(ny.w, i1);
                int l1 = ml.c(by, (nq)ia1);
                if(l1 > 0)
                    ia1.e(l1 * 4);
            }
            g(0.3F);
        }
    }

    public void a(ia ia1) {
    }

    public void b(ia ia1) {
    }

    public void n_() {
    }

    public abstract void r();

    public void c(dk dk1) {
    }

    public void v() {
        super.v();
        bz.b(this);
        if(bA != null)
            bA.b(this);
    }

    public qy d(int i1, int j1, int k1) {
        if(!o.I) {
            if(ar() || !K())
                return qy.e;
            if(o.y.c)
                return qy.b;
            if(o.l())
                return qy.c;
            if(Math.abs(s - (double)i1) > 3D || Math.abs(t - (double)j1) > 2D || Math.abs(u - (double)k1) > 3D)
                return qy.d;
            double d1 = 8D;
            double d2 = 5D;
            //List list = o.a(aik.class, ( (c)getResult(c_b, null, new Object[]{s, t, u, s + 1.0D, t + 1.0D, u + 1.0D}) ).b(16D, 4D, 16D));
            List list = o.a(zo.class, ( (c)getResult(c_b, null, new Object[]{(double)i1 - d1, (double)j1 - d2, (double)k1 - d1, (double)i1 + d1, (double)j1 + d2, (double)k1 + d1}) ) );
            if(!list.isEmpty())
                return qy.f;
        }
        a(0.2F, 0.2F);
        L = 0.2F;
        if(o.i(i1, j1, k1)) {
            int l1 = o.d(i1, j1, k1);
            int i2 = aab.e(l1);
            float f = 0.5F;
            float f1 = 0.5F;
            switch(i2) {
            case 0: // '\0'
                f1 = 0.9F;
                break;

            case 2: // '\002'
                f1 = 0.1F;
                break;

            case 1: // '\001'
                f = 0.1F;
                break;

            case 3: // '\003'
                f = 0.9F;
                break;
            }
            b(i2);
            d((float)i1 + f, (float)j1 + 0.9375F, (float)k1 + f1);
        } else {
            d((float)i1 + 0.5F, (float)j1 + 0.9375F, (float)k1 + 0.5F);
        }
        bT = true;
        a = 0;
        bU = new dh(i1, j1, k1);
        v = x = w = 0.0D;
        if(!o.I)
            o.A();
        return qy.a;
    }

    private void b(int i1) {
        bV = 0.0F;
        bX = 0.0F;
        switch(i1) {
        case 0: // '\0'
            bX = -1.8F;
            break;

        case 2: // '\002'
            bX = 1.8F;
            break;

        case 1: // '\001'
            bV = 1.8F;
            break;

        case 3: // '\003'
            bV = -1.8F;
            break;
        }
    }

    public void a(boolean flag, boolean flag1, boolean flag2) {
        a(0.6F, 1.8F);
        aF();
        dh dh1 = bU;
        dh dh2 = bU;
        if(dh1 != null && o.a(dh1.a, dh1.b, dh1.c) == yy.S.bM) {
            aab.a(o, dh1.a, dh1.b, dh1.c, false);
            dh dh3 = aab.f(o, dh1.a, dh1.b, dh1.c, 0);
            if(dh3 == null)
                dh3 = new dh(dh1.a, dh1.b + 1, dh1.c);
            d((float)dh3.a + 0.5F, (float)dh3.b + L + 0.1F, (float)dh3.c + 0.5F);
        }
        bT = false;
        if(!o.I && flag1)
            o.A();
        if(flag)
            a = 0;
        else
            a = 100;
        if(flag2)
            a(bU);
    }

    private boolean aR() {
        return o.a(bU.a, bU.b, bU.c) == yy.S.bM;
    }

    public static dh a(ry ry1, dh dh1) {
        ej ej1 = ry1.x();
        ej1.a(dh1.a - 3 >> 4, dh1.c - 3 >> 4);
        ej1.a(dh1.a + 3 >> 4, dh1.c - 3 >> 4);
        ej1.a(dh1.a - 3 >> 4, dh1.c + 3 >> 4);
        ej1.a(dh1.a + 3 >> 4, dh1.c + 3 >> 4);
        if(ry1.a(dh1.a, dh1.b, dh1.c) != yy.S.bM) {
            return null;
        } else {
            dh dh2 = aab.f(ry1, dh1.a, dh1.b, dh1.c, 0);
            return dh2;
        }
    }

    public float aJ() {
        if(bU != null) {
            int i1 = o.d(bU.a, bU.b, bU.c);
            int j1 = aab.e(i1);
            switch(j1) {
            case 0: // '\0'
                return 90F;

            case 1: // '\001'
                return 0.0F;

            case 2: // '\002'
                return 270F;

            case 3: // '\003'
                return 180F;
            }
        }
        return 0.0F;
    }

    public boolean ar() {
        return bT;
    }

    public boolean aK() {
        return bT && a >= 100;
    }

    public int aL() {
        return a;
    }

    public void b(String s1) {
    }

    public dh aM() {
        return b;
    }

    public void a(dh dh1) {
        if(dh1 != null)
            b = new dh(dh1);
        else
            b = null;
    }

    public void a(px px) {
        a(px, 1);
    }

    public void a(px px, int i1) {
    }

    public void d(float f, float f1) {
        double d1 = s;
        double d2 = t;
        double d3 = u;
        if(cc.b) {
            double d4 = w;
            float f2 = aJ;
            aJ = 0.05F;
            super.d(f, f1);
            w = d4 * 0.59999999999999998D;
            aJ = f2;
        } else {
            super.d(f, f1);
        }
        j(s - d1, t - d2, u - d3);
    }

    public void j(double d1, double d2, double d3) {
        if(n != null)
            return;
        if(a(mat_g)) {
            int i1 = Math.round(me.a(d1 * d1 + d2 * d2 + d3 * d3) * 100F);
            if(i1 > 0) {
                a(ny.q, i1);
                g(0.015F * (float)i1 * 0.01F);
            }
        } else
        if(D()) {
            int j1 = Math.round(me.a(d1 * d1 + d3 * d3) * 100F);
            if(j1 > 0) {
                a(ny.m, j1);
                g(0.015F * (float)j1 * 0.01F);
            }
        } else
        if(ah()) {
            if(d2 > 0.0D)
                a(ny.o, (int)Math.round(d2 * 100D));
        } else
        if(D) {
            int k1 = Math.round(me.a(d1 * d1 + d3 * d3) * 100F);
            if(k1 > 0) {
                a(ny.l, k1);
                if(X())
                    g(0.09999999F * (float)k1 * 0.01F);
                else
                    g(0.01F * (float)k1 * 0.01F);
            }
        } else {
            int l1 = Math.round(me.a(d1 * d1 + d3 * d3) * 100F);
            if(l1 > 25)
                a(ny.p, l1);
        }
    }

    private void k(double d1, double d2, double d3) {
        if(n != null) {
            int i1 = Math.round(me.a(d1 * d1 + d2 * d2 + d3 * d3) * 100F);
            if(i1 > 0)
                if(n instanceof vm) {
                    a(ny.r, i1);
                    if(c == null)
                        c = new dh(me.c(s), me.c(t), me.c(u));
                    else
                    if(c.a(me.c(s), me.c(t), me.c(u)) >= 1000D)
                        a(ut.q, 1);
                } else
                if(n instanceof no)
                    a(ny.s, i1);
                else
                if(n instanceof fd)
                    a(ny.t, i1);
        }
    }

    protected void c(float f) {
        if(cc.c)
            return;
        if(f >= 2.0F)
            a(ny.n, (int)Math.round((double)f * 100D));
        super.c(f);
    }

    public void a(nq nq1) {
        if(nq1 instanceof zo)
            a(((px) (ut.s)));
    }

    public int a(dk dk1, int i1) {
        int j1 = super.a(dk1, i1);
        if(dk1.c == acy.aQ.bM && ci != null) {
            j1 = dk1.b() + 16;
        } else {
            if(dk1.c == acy.br.bM)
                if(i1 == 1)
                    return dk1.b();
                else
                    return 141;
            if(d != null && dk1.c == acy.j.bM) {
                int k1 = dk1.l() - e;
                if(k1 >= 18)
                    return 133;
                if(k1 > 13)
                    return 117;
                if(k1 > 0)
                    return 101;
            }
        }
        return j1;
    }

    public void S() {
        if(bY > 0) {
            bY = 10;
            return;
        } else {
            bZ = true;
            return;
        }
    }

    public void k(int i1) {
        bE += i1;
        cf += (float)i1 / (float)aN();
        ce += i1;
        while(cf >= 1.0F)  {
            cf--;
            aS();
        }
    }

    public void l(int i1) {
        cd -= i1;
        if(cd < 0)
            cd = 0;
    }

    public int aN() {
        return 7 + (cd * 7 >> 1);
    }

    private void aS() {
        cd++;
    }

    public void g(float f) {
        if(cc.a)
            return;
        if(!o.I)
            bB.a(f);
    }

    public eq aO() {
        return bB;
    }

    public boolean b(boolean flag) {
        return (flag || bB.c()) && !cc.a;
    }

    public boolean aP() {
        return ag() > 0 && ag() < f_();
    }

    public void c(dk dk1, int i1) {
        if(dk1 == d)
            return;
        d = dk1;
        e = i1;
        if(!o.I)
            c(true);
    }

    public boolean e(int i1, int j1, int k1) {
        return true;
    }

    protected int b(vi vi1) {
        int i1 = cd * 7;
        if(i1 > 100)
            return 100;
        else
            return i1;
    }

    protected boolean ae() {
        return true;
    }

    public void c(int i1) {
    }

    public void d(vi vi1) {
        by.a(vi1.by);
        aM = vi1.aM;
        bB = vi1.bB;
        cd = vi1.cd;
        ce = vi1.ce;
        cf = vi1.cf;
        bE = vi1.bE;
    }

    public x by;
    public pj bz, bA;
    protected eq bB;
    protected int bC;
    public byte bD;
    public int bE, bI, bK, bM, bY;
    public float bF, bG, bV, bW, bX;
    public boolean bH;
    public String bJ, bL;
    public double bN, bO, bP, bQ, bR;
    public double bS;
    protected boolean bT, bZ;
    public dh bU;
    private int a, e;
    private dh b, c;
    public float ca, cb, cf;
    public wq cc;
    public int cd, ce;
    private dk d;
    protected float cg, ch;
    public ael ci;
}
