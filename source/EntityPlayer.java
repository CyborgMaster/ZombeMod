// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

import java.util.*;
import java.lang.reflect.*;

// search: "humanoid"
public abstract class xb extends aar {

    public static Method getClassMethod(String c, String m, Class param[]) { try { return Class.forName(c).getMethod(m, param); } catch(Exception e) { e.printStackTrace(); return null; } }
    public static Field getClassField(String c, String m) { try { return Class.forName(c).getField(m); } catch(Exception e) { e.printStackTrace(); return null; } }
    public static Object getResult(Method m, Object obj, Object param[]) { try { return m.invoke(obj, param); } catch(Exception whatever) { } return null; }
    public static Object getValue(Field field, Object obj) { try { return field.get(obj); } catch(Exception whatever) { } return null; }

    // ---------------------------------------------------------------------------------------------------------------------------
    protected static boolean zmodmarker = true;
    public final void callSuper(double mx, double my, double mz) { super.entMove(mx,my,mz); }

    public void entMove(double mx, double my, double mz) {
        ZMod.flyHandle(this, mx, my, mz);
    }

    // this thing is in this class: add first variable (noclip)
    public boolean P() {
        return !entNoClip && !aK && super.P();
    }

    // ... as is this: first chance to undo the dickmove
    public void d() {
        ZMod.flyDickmoveCancel();
        if(at > 0)
            at--;
        if(k.v == 0 && aP() < c() && (V % 20) * 12 == 0)
            k(1);
        ap.g();
        aw = ax;
        super.d();
        bt = aX;
        bu = aY;
        if(Y()) {
            bt += (double)aX * 0.29999999999999999D;
            bu += (double)aY * 0.29999999999999999D;
        }
        float f = ga.a(r * r + t * t);
        float f1 = (float)Math.atan(-s * 0.20000000298023224D) * 15F;
        if(f > 0.1F)
            f = 0.1F;
        if(!z || aP() <= 0)
            f = 0.0F;
        if(z || aP() <= 0)
            f1 = 0.0F;
        ax += (f - ax) * 0.4F;
        bG += (f1 - bG) * 0.8F;
        if(aP() > 0) {
            List list = k.b(this, y.b(1.0D, 0.0D, 1.0D));
            if(list != null) {
                for(int i1 = 0; i1 < list.size(); i1++) {
                    ms ms1 = (ms)list.get(i1);
                    if(!ms1.G)
                        l(ms1);
                }

            }
        }
    }

    // ... as is this. search: 0.8F
    protected void o_() {
        super.o_();
        // -----------------------------------------------------------------------------------------------------------------------
        entMotionY *= ZMod.flyJumpHandle();
        // -----------------------------------------------------------------------------------------------------------------------
        a(gl.u, 1);
        if(Y())
            c(0.8F);
        else
            c(0.2F);
    }

    // ... and this. search: "Notch"
    public void a(ll ll1) {
        ZMod.pingOnDeathHandle();
        super.a(ll1);
        a(0.2F, 0.2F);
        d(o, p, q);
        s = 0.10000000149011612D;
        if(aA.equals("Notch"))
            a(new yq(ww.j, 1), true);
        ap.i();
        if(ll1 != null) {
            r = -ga.b(((bC + u) * 3.141593F) / 180F) * 0.1F;
            t = -ga.a(((bC + u) * 3.141593F) / 180F) * 0.1F;
        } else {
            r = t = 0.0D;
        }
        H = 0.1F;
        a(gl.y, 1);
    }

    // ---------------------------------------------------------------------------------------------------------------------------

    public xb(vq vq1) {
        super(vq1);
        ap = new yn(this);
        as = new mk();
        at = 0;
        au = 0;
        av = 0;
        ay = false;
        az = 0;
        aD = 0;
        aP = 20;
        aQ = false;
        aT = new px();
        aX = 0.1F;
        aY = 0.02F;
        aZ = null;
        aq = new w(ap, !vq1.I);
        ar = aq;
        H = 1.62F;
        td td1 = vq1.v();
        c((double)td1.a + 0.5D, td1.b + 1, (double)td1.c + 0.5D, 0.0F, 0.0F);
        bp = "humanoid";
        bo = 180F;
        W = 20;
        bm = "/mob/char.png";
    }

    public int c() {
        return 20;
    }

    protected void b() {
        super.b();
        ac.a(16, Byte.valueOf((byte)0));
        ac.a(17, Byte.valueOf((byte)0));
    }

    public yq ah() {
        return d;
    }

    public int ai() {
        return e;
    }

    public boolean aj() {
        return d != null;
    }

    public int ak() {
        if(aj())
            return d.l() - e;
        else
            return 0;
    }

    public void al() {
        if(d != null)
            d.a(k, this, e);
        am();
    }

    public void am() {
        d = null;
        e = 0;
        if(!k.I)
            c(false);
    }

    public boolean an() {
        return aj() && ww.e[d.c].c(d) == yt.d;
    }

    public void B_() {
        if(d != null) {
            yq yq1 = ap.b();
            if(yq1 != d) {
                am();
            } else {
                if(e <= 25 && e % 4 == 0)
                    a(yq1, 5);
                if(--e == 0 && !k.I)
                    ao();
            }
        }
        if(aD > 0)
            aD--;
        if(ay()) {
            a++;
            if(a > 100)
                a = 100;
            if(!k.I)
                if(!bc())
                    a(true, true, false);
                else
                if(k.l())
                    a(false, true, true);
        } else
        if(a > 0) {
            a++;
            if(a >= 110)
                a = 0;
        }
        super.B_();
        if(!k.I && ar != null && !ar.b(this)) {
            af();
            ar = aq;
        }
        if(aT.b) {
            for(int i1 = 0; i1 < 8; i1++);
        }
        if(V() && aT.a)
            E();
        aE = aH;
        aF = aI;
        aG = aJ;
        double d1 = o - aH;
        double d2 = p - aI;
        double d3 = q - aJ;
        double d4 = 10D;
        if(d1 > d4)
            aE = aH = o;
        if(d3 > d4)
            aG = aJ = q;
        if(d2 > d4)
            aF = aI = p;
        if(d1 < -d4)
            aE = aH = o;
        if(d3 < -d4)
            aG = aJ = q;
        if(d2 < -d4)
            aF = aI = p;
        aH += d1 * 0.25D;
        aJ += d3 * 0.25D;
        aI += d2 * 0.25D;
        a(gl.k, 1);
        if(j == null)
            c = null;
        if(!k.I)
            as.a(this);
    }

    // WORKAROUND
    public static Method bk_b = getClassMethod("bk", "b", new Class[]{Double.TYPE, Double.TYPE, Double.TYPE});
    protected void a(yq yq1, int i1) {
        if(yq1.m() == yt.c)
            k.a(this, "random.drink", 0.5F, k.w.nextFloat() * 0.1F + 0.9F);
        if(yq1.m() == yt.b) {
            for(int j1 = 0; j1 < i1; j1++) {
                bk bk1 = (bk)getResult(bk_b, null, new Object[]{ ((double)U.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D } );
                //bk bk1 = bk.b(((double)U.nextFloat() - 0.5D) * 0.10000000000000001D, Math.random() * 0.10000000000000001D + 0.10000000000000001D, 0.0D);
                bk1.a((-v * 3.141593F) / 180F);
                bk1.b((-u * 3.141593F) / 180F);
                bk bk2 = (bk)getResult(bk_b, null, new Object[]{ ((double)U.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-U.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D } );
                //bk bk2 = bk.b(((double)U.nextFloat() - 0.5D) * 0.29999999999999999D, (double)(-U.nextFloat()) * 0.59999999999999998D - 0.29999999999999999D, 0.59999999999999998D);
                bk2.a((-v * 3.141593F) / 180F);
                bk2.b((-u * 3.141593F) / 180F);
                bk2 = bk2.c(o, p + (double)J(), q);
                k.a((new StringBuilder()).append("iconcrack_").append(yq1.a().bO).toString(), bk2.a, bk2.b, bk2.c, bk1.a, bk1.b + 0.050000000000000003D, bk1.c);
            }

            k.a(this, "random.eat", 0.5F + 0.5F * (float)U.nextInt(2), (U.nextFloat() - U.nextFloat()) * 0.2F + 1.0F);
        }
    }

    protected void ao() {
        if(d != null) {
            a(d, 16);
            int i1 = d.a;
            yq yq1 = d.b(k, this);
            if(yq1 != d || yq1 != null && yq1.a != i1) {
                ap.a[ap.c] = yq1;
                if(yq1.a == 0)
                    ap.a[ap.c] = null;
            }
            am();
        }
    }

    public void a(byte byte0) {
        if(byte0 == 9)
            ao();
        else
            super.a(byte0);
    }

    protected boolean ap() {
        return aP() <= 0 || ay();
    }

    protected void af() {
        ar = aq;
    }

    public void U() {
        aC = (new StringBuilder()).append("http://s3.amazonaws.com/MinecraftCloaks/").append(aA).append(".png").toString();
        aa = aC;
    }

    public void Q() {
        double d1 = o;
        double d2 = p;
        double d3 = q;
        super.Q();
        aw = ax;
        ax = 0.0F;
        k(o - d1, p - d2, q - d3);
    }

    public void A() {
        H = 1.62F;
        a(0.6F, 1.8F);
        super.A();
        l(c());
        bD = 0;
    }

    private int bb() {
        if(a(yg.e))
            return 6 - (1 + b(yg.e).c()) * 1;
        if(a(yg.f))
            return 6 + (1 + b(yg.f).c()) * 2;
        else
            return 6;
    }

    protected void m_() {
        int i1 = bb();
        if(ay) {
            az++;
            if(az >= i1) {
                az = 0;
                ay = false;
            }
        } else {
            az = 0;
        }
        bw = (float)az / (float)i1;
    }

    private void l(ms ms1) {
        ms1.a(this);
    }

    public int aq() {
        return av;
    }

    public void a(ms ms1, int i1) {
        av += i1;
        if(ms1 instanceof xb)
            a(gl.A, 1);
        else
            a(gl.z, 1);
    }

    protected int d(int i1) {
        int j1 = agn.a(ap);
        if(j1 > 0 && U.nextInt(j1 + 1) > 0)
            return i1;
        else
            return super.d(i1);
    }

    public void ar() {
        a(ap.a(ap.c, 1), false);
    }

    public void a(yq yq1) {
        a(yq1, false);
    }

    public void a(yq yq1, boolean flag) {
        if(yq1 == null)
            return;
        fj fj1 = new fj(k, o, (p - 0.30000001192092896D) + (double)J(), q, yq1);
        fj1.c = 40;
        float f = 0.1F;
        if(flag) {
            float f2 = U.nextFloat() * 0.5F;
            float f4 = U.nextFloat() * 3.141593F * 2.0F;
            fj1.r = -ga.a(f4) * f2;
            fj1.t = ga.b(f4) * f2;
            fj1.s = 0.20000000298023224D;
        } else {
            float f1 = 0.3F;
            fj1.r = -ga.a((u / 180F) * 3.141593F) * ga.b((v / 180F) * 3.141593F) * f1;
            fj1.t = ga.b((u / 180F) * 3.141593F) * ga.b((v / 180F) * 3.141593F) * f1;
            fj1.s = -ga.a((v / 180F) * 3.141593F) * f1 + 0.1F;
            f1 = 0.02F;
            float f3 = U.nextFloat() * 3.141593F * 2.0F;
            f1 *= U.nextFloat();
            fj1.r += Math.cos(f3) * (double)f1;
            fj1.s += (U.nextFloat() - U.nextFloat()) * 0.1F;
            fj1.t += Math.sin(f3) * (double)f1;
        }
        a(fj1);
        a(gl.v, 1);
    }

    protected void a(fj fj1) {
        k.a(fj1);
    }

    public float a(oe oe1) {
        float f = ap.a(oe1);
        float f1 = f;
        int i1 = agn.b(ap);
        if(i1 > 0 && ap.b(oe1))
            f1 += i1 * i1 + 1;
        if(a(yg.e))
            f1 *= 1.0F + (float)(b(yg.e).c() + 1) * 0.2F;
        if(a(yg.f))
            f1 *= 1.0F - (float)(b(yg.f).c() + 1) * 0.2F;
        if(a(aan.g) && !agn.g(ap))
            f1 /= 5F;
        if(!z)
            f1 /= 5F;
        return f1;
    }

    public boolean b(oe oe1) {
        return ap.b(oe1);
    }

    public void a(abx abx1) {
        super.a(abx1);
        mu mu1 = abx1.m("Inventory");
        ap.b(mu1);
        aB = abx1.f("Dimension");
        aK = abx1.n("Sleeping");
        a = abx1.e("SleepTimer");
        aW = abx1.h("XpP");
        aU = abx1.f("XpLevel");
        aV = abx1.f("XpTotal");
        if(aK) {
            aL = new td(ga.c(o), ga.c(p), ga.c(q));
            a(true, true, false);
        }
        if(abx1.c("SpawnX") && abx1.c("SpawnY") && abx1.c("SpawnZ"))
            b = new td(abx1.f("SpawnX"), abx1.f("SpawnY"), abx1.f("SpawnZ"));
        as.a(abx1);
        aT.b(abx1);
    }

    public void b(abx abx1) {
        super.b(abx1);
        abx1.a("Inventory", ap.a(new mu()));
        abx1.a("Dimension", aB);
        abx1.a("Sleeping", aK);
        abx1.a("SleepTimer", (short)a);
        abx1.a("XpP", aW);
        abx1.a("XpLevel", aU);
        abx1.a("XpTotal", aV);
        if(b != null) {
            abx1.a("SpawnX", b.a);
            abx1.a("SpawnY", b.b);
            abx1.a("SpawnZ", b.c);
        }
        as.b(abx1);
        aT.a(abx1);
    }

    public void a(ic ic) {
    }

    public void c(int i1, int j1, int k1) {
    }

    public void a(int i1, int j1, int k1) {
    }

    public void b(ms ms1, int i1) {
    }

    public float J() {
        return 0.12F;
    }

    protected void x() {
        H = 1.62F;
    }

    public boolean a(ll ll1, int i1) {
        if(aT.a && !ll1.g())
            return false;
        cd = 0;
        if(aP() <= 0)
            return false;
        if(ay() && !k.I)
            a(true, true, false);
        ms ms1 = ll1.a();
        if((ms1 instanceof xd) || (ms1 instanceof mr)) {
            if(k.v == 0)
                i1 = 0;
            if(k.v == 1)
                i1 = i1 / 2 + 1;
            if(k.v == 3)
                i1 = (i1 * 3) / 2;
        }
        if(i1 == 0)
            return false;
        ms ms2 = ms1;
        if((ms2 instanceof mr) && ((mr)ms2).c != null)
            ms2 = ((mr)ms2).c;
        if(ms2 instanceof aar)
            a((aar)ms2, false);
        a(gl.x, i1);
        return super.a(ll1, i1);
    }

    protected int b(ll ll1, int i1) {
        int j1 = super.b(ll1, i1);
        if(j1 <= 0)
            return 0;
        int k1 = agn.a(ap, ll1);
        if(k1 > 20)
            k1 = 20;
        if(k1 > 0 && k1 <= 20) {
            int l1 = 25 - k1;
            int i2 = j1 * l1 + bz;
            j1 = i2 / 25;
            bz = i2 % 25;
        }
        return j1;
    }

    protected boolean as() {
        return false;
    }

    protected void a(aar aar1, boolean flag) {
        if((aar1 instanceof wk) || (aar1 instanceof te))
            return;
        if(aar1 instanceof wt) {
            wt wt1 = (wt)aar1;
            if(wt1.al() && aA.equals(wt1.ai()))
                return;
        }
        if((aar1 instanceof xb) && !as())
            return;
        List list = k.a(wt.class, vi.b(o, p, q, o + 1.0D, p + 1.0D, q + 1.0D).b(16D, 4D, 16D));
        Iterator iterator = list.iterator();
        do {
            if(!iterator.hasNext())
                break;
            ms ms1 = (ms)iterator.next();
            wt wt2 = (wt)ms1;
            if(wt2.al() && wt2.aq() == null && aA.equals(wt2.ai()) && (!flag || !wt2.aj())) {
                wt2.d(false);
                wt2.i(aar1);
            }
        } while(true);
    }

    protected void h(int i1) {
        ap.f(i1);
    }

    public int at() {
        return ap.h();
    }

    protected void c(ll ll1, int i1) {
        if(!ll1.e() && an())
            i1 = 1 + i1 >> 1;
        i1 = d(ll1, i1);
        i1 = b(ll1, i1);
        c(ll1.f());
        bx -= i1;
    }

    public void a(afd afd) {
    }

    public void a(ax ax1) {
    }

    public void a(rf rf) {
    }

    public void a(ajn ajn) {
    }

    public void i(ms ms1) {
        if(ms1.c(this))
            return;
        yq yq1 = au();
        if(yq1 != null && (ms1 instanceof aar)) {
            yq1.a((aar)ms1);
            if(yq1.a <= 0) {
                yq1.a(this);
                av();
            }
        }
    }

    public yq au() {
        return ap.b();
    }

    public void av() {
        ap.a(ap.c, null);
    }

    public double R() {
        return (double)(H - 0.5F);
    }

    public void aw() {
        if(!ay || az >= bb() / 2 || az < 0) {
            az = -1;
            ay = true;
        }
    }

    public void j(ms ms1) {
        int i1 = ap.a(ms1);
        if(a(yg.g))
            i1 += 3 << b(yg.g).c();
        if(a(yg.t))
            i1 -= 2 << b(yg.t).c();
        int j1 = 0;
        int k1 = 0;
        if(ms1 instanceof aar) {
            k1 = agn.a(ap, (aar)ms1);
            j1 += agn.b(ap, (aar)ms1);
        }
        if(Y())
            j1++;
        if(i1 > 0 || k1 > 0) {
            boolean flag = M > 0.0F && !z && !q() && !I() && !a(yg.q) && j == null && (ms1 instanceof aar);
            if(flag)
                i1 += U.nextInt(i1 / 2 + 2);
            i1 += k1;
            boolean flag1 = ms1.a(ll.a(this), i1);
            if(flag1) {
                if(j1 > 0) {
                    ms1.c(-ga.a((u * 3.141593F) / 180F) * (float)j1 * 0.5F, 0.10000000000000001D, ga.b((u * 3.141593F) / 180F) * (float)j1 * 0.5F);
                    r *= 0.59999999999999998D;
                    t *= 0.59999999999999998D;
                    b(false);
                }
                if(flag)
                    c(ms1);
                if(k1 > 0)
                    d(ms1);
                if(i1 >= 18)
                    a(dk.E);
            }
            yq yq1 = au();
            if(yq1 != null && (ms1 instanceof aar)) {
                yq1.a((aar)ms1, this);
                if(yq1.a <= 0) {
                    yq1.a(this);
                    av();
                }
            }
            if(ms1 instanceof aar) {
                if(ms1.O())
                    a((aar)ms1, true);
                a(gl.w, i1);
                int l1 = agn.c(ap, (aar)ms1);
                if(l1 > 0)
                    ms1.e(l1 * 4);
            }
            c(0.3F);
        }
    }

    public void c(ms ms1) {
    }

    public void d(ms ms1) {
    }

    public void w_() {
    }

    public abstract void y();

    public void b(yq yq1) {
    }

    public void B() {
        super.B();
        aq.a(this);
        if(ar != null)
            ar.a(this);
    }

    // WORKAROUND
    public static Field cc_e = getClassField("cc", "e");
    public static Field cc_b = getClassField("cc", "b");
    public static Field cc_c = getClassField("cc", "c");
    public static Field cc_d = getClassField("cc", "d");
    public static Field cc_f = getClassField("cc", "f");
    public static Field cc_a = getClassField("cc", "a");
    public cc d(int i1, int j1, int k1) {
        if(!k.I) {
            if(ay() || !O())
                return (cc)getValue(cc_e, null);
            if(k.y.d)
                return (cc)getValue(cc_b, null);
            if(k.l())
                return (cc)getValue(cc_c, null);
            if(Math.abs(o - (double)i1) > 3D || Math.abs(p - (double)j1) > 2D || Math.abs(q - (double)k1) > 3D)
                return (cc)getValue(cc_d, null);
            double d1 = 8D;
            double d2 = 5D;
            List list = k.a(xd.class, vi.b((double)i1 - d1, (double)j1 - d2, (double)k1 - d1, (double)i1 + d1, (double)j1 + d2, (double)k1 + d1));
            if(!list.isEmpty())
                return (cc)getValue(cc_f, null);
        }
        a(0.2F, 0.2F);
        H = 0.2F;
        if(k.d(i1, j1, k1)) {
            int l1 = k.e(i1, j1, k1);
            int i2 = oo.e(l1);
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
            c(i2);
            d((float)i1 + f, (float)j1 + 0.9375F, (float)k1 + f1);
        } else {
            d((float)i1 + 0.5F, (float)j1 + 0.9375F, (float)k1 + 0.5F);
        }
        aK = true;
        a = 0;
        aL = new td(i1, j1, k1);
        r = t = s = 0.0D;
        if(!k.I)
            k.A();
        return (cc)getValue(cc_a, null);
    }

    private void c(int i1) {
        aM = 0.0F;
        aO = 0.0F;
        switch(i1) {
        case 0: // '\0'
            aO = -1.8F;
            break;

        case 2: // '\002'
            aO = 1.8F;
            break;

        case 1: // '\001'
            aM = 1.8F;
            break;

        case 3: // '\003'
            aM = -1.8F;
            break;
        }
    }

    public void a(boolean flag, boolean flag1, boolean flag2) {
        a(0.6F, 1.8F);
        x();
        td td1 = aL;
        td td2 = aL;
        if(td1 != null && k.a(td1.a, td1.b, td1.c) == oe.U.bO) {
            oo.a(k, td1.a, td1.b, td1.c, false);
            td td3 = oo.f(k, td1.a, td1.b, td1.c, 0);
            if(td3 == null)
                td3 = new td(td1.a, td1.b + 1, td1.c);
            d((float)td3.a + 0.5F, (float)td3.b + H + 0.1F, (float)td3.c + 0.5F);
        }
        aK = false;
        if(!k.I && flag1)
            k.A();
        if(flag)
            a = 0;
        else
            a = 100;
        if(flag2)
            a(aL);
    }

    private boolean bc() {
        return k.a(aL.a, aL.b, aL.c) == oe.U.bO;
    }

    public static td a(vq vq1, td td1) {
        bs bs1 = vq1.x();
        bs1.c(td1.a - 3 >> 4, td1.c - 3 >> 4);
        bs1.c(td1.a + 3 >> 4, td1.c - 3 >> 4);
        bs1.c(td1.a - 3 >> 4, td1.c + 3 >> 4);
        bs1.c(td1.a + 3 >> 4, td1.c + 3 >> 4);
        if(vq1.a(td1.a, td1.b, td1.c) != oe.U.bO) {
            return null;
        } else {
            td td2 = oo.f(vq1, td1.a, td1.b, td1.c, 0);
            return td2;
        }
    }

    public float ax() {
        if(aL != null) {
            int i1 = k.e(aL.a, aL.b, aL.c);
            int j1 = oo.e(i1);
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

    public boolean ay() {
        return aK;
    }

    public boolean az() {
        return aK && a >= 100;
    }

    public int aA() {
        return a;
    }

    public void b(String s) {
    }

    public td aB() {
        return b;
    }

    public void a(td td1) {
        if(td1 != null)
            b = new td(td1);
        else
            b = null;
    }

    public void a(ahm ahm) {
        a(ahm, 1);
    }

    public void a(ahm ahm, int i1) {
    }

    public void a_(float f, float f1) {
        double d1 = o;
        double d2 = p;
        double d3 = q;
        if(aT.b) {
            double d4 = s;
            float f2 = bu;
            bu = 0.05F;
            super.a_(f, f1);
            s = d4 * 0.59999999999999998D;
            bu = f2;
        } else {
            super.a_(f, f1);
        }
        i(o - d1, p - d2, q - d3);
    }

    public void i(double d1, double d2, double d3) {
        if(j != null)
            return;
        if(a(aan.g)) {
            int i1 = Math.round(ga.a(d1 * d1 + d2 * d2 + d3 * d3) * 100F);
            if(i1 > 0) {
                a(gl.q, i1);
                c(0.015F * (float)i1 * 0.01F);
            }
        } else
        if(I()) {
            int j1 = Math.round(ga.a(d1 * d1 + d3 * d3) * 100F);
            if(j1 > 0) {
                a(gl.m, j1);
                c(0.015F * (float)j1 * 0.01F);
            }
        } else
        if(q()) {
            if(d2 > 0.0D)
                a(gl.o, (int)Math.round(d2 * 100D));
        } else
        if(z) {
            int k1 = Math.round(ga.a(d1 * d1 + d3 * d3) * 100F);
            if(k1 > 0) {
                a(gl.l, k1);
                if(Y())
                    c(0.09999999F * (float)k1 * 0.01F);
                else
                    c(0.01F * (float)k1 * 0.01F);
            }
        } else {
            int l1 = Math.round(ga.a(d1 * d1 + d3 * d3) * 100F);
            if(l1 > 25)
                a(gl.p, l1);
        }
    }

    private void k(double d1, double d2, double d3) {
        if(j != null) {
            int i1 = Math.round(ga.a(d1 * d1 + d2 * d2 + d3 * d3) * 100F);
            if(i1 > 0)
                if(j instanceof ajl) {
                    a(gl.r, i1);
                    if(c == null)
                        c = new td(ga.c(o), ga.c(p), ga.c(q));
                    else
                    if(c.a(ga.c(o), ga.c(p), ga.c(q)) >= 1000D)
                        a(dk.q, 1);
                } else
                if(j instanceof ej)
                    a(gl.s, i1);
                else
                if(j instanceof pt)
                    a(gl.t, i1);
        }
    }

    protected void e(float f) {
        if(aT.c)
            return;
        if(f >= 2.0F)
            a(gl.n, (int)Math.round((double)f * 100D));
        super.e(f);
    }

    public void a(aar aar1) {
        if(aar1 instanceof xd)
            a(((ahm) (dk.s)));
    }

    public int b(yq yq1, int i1) {
        int j1 = super.b(yq1, i1);
        if(yq1.c == ww.aR.bO && aZ != null) {
            j1 = yq1.b() + 16;
        } else {
            if(yq1.a().c())
                return yq1.a().a(yq1.i(), i1);
            if(d != null && yq1.c == ww.k.bO) {
                int k1 = yq1.l() - e;
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

    public void T() {
        if(aP > 0) {
            aP = 10;
            return;
        } else {
            aQ = true;
            return;
        }
    }

    public void i(int i1) {
        av += i1;
        int j1 = 0x7fffffff - aV;
        if(i1 > j1)
            i1 = j1;
        aW += (float)i1 / (float)aC();
        aV += i1;
        for(; aW >= 1.0F; aW = aW / (float)aC()) {
            aW = (aW - 1.0F) * (float)aC();
            bd();
        }

    }

    public void j(int i1) {
        aU -= i1;
        if(aU < 0)
            aU = 0;
    }

    public int aC() {
        return 7 + (aU * 7 >> 1);
    }

    private void bd() {
        aU++;
    }

    public void c(float f) {
        if(aT.a)
            return;
        if(!k.I)
            as.a(f);
    }

    public mk aD() {
        return as;
    }

    public boolean a(boolean flag) {
        return (flag || as.c()) && !aT.a;
    }

    public boolean aE() {
        return aP() > 0 && aP() < c();
    }

    public void c(yq yq1, int i1) {
        if(yq1 == d)
            return;
        d = yq1;
        e = i1;
        if(!k.I)
            c(true);
    }

    public boolean e(int i1, int j1, int k1) {
        return true;
    }

    protected int b(xb xb1) {
        int i1 = aU * 7;
        if(i1 > 100)
            return 100;
        else
            return i1;
    }

    protected boolean aF() {
        return true;
    }

    public void b(int i1) {
    }

    public void d(xb xb1) {
        ap.a(xb1.ap);
        bx = xb1.bx;
        as = xb1.as;
        aU = xb1.aU;
        aV = xb1.aV;
        aW = xb1.aW;
        av = xb1.av;
    }

    public yn ap;
    public cx aq, ar;
    protected mk as;
    protected int at;
    public byte au;
    public int av, az, aB, aD, aP;
    public float aw, ax, aM, aN, aO;
    public boolean ay;
    public String aA, aC;
    public double aE, aF, aG, aH, aI;
    public double aJ;
    protected boolean aK, aQ;
    public td aL;
    private int a, e;
    private td b, c;
    public float aR, aS, aW;
    public px aT;
    public int aU, aV;
    private yq d;
    protected float aX, aY;
    public aau aZ;
}
