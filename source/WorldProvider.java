// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

// search: 24000F
public abstract class aip {

    protected static final boolean zmodmarker = true;

    public aip() {
        d = false;
        e = false;
        f = false;
        g = new float[16];
        h = 0;
        i = new float[4];
    }

    public final void a(vq vq1) {
        a = vq1;
        b = vq1.z().t();
        a();
        h();
    }

    protected void h() {
        float f1 = 0.0F;
        for(int k = 0; k <= 15; k++) {
            float f2 = 1.0F - (float)k / 15F;
            g[k] = ((1.0F - f2) / (f2 * 3F + 1.0F)) * (1.0F - f1) + f1;
        }

    }

    protected void a() {
        if(a.z().t() == um.b)
            c = new ff(zp.c, 0.5F, 0.5F);
        else
            c = new qu(a);
    }

    public bs b() {
        if(b == um.b)
            return new wo(a, a.t(), a.z().r());
        else
            return new aji(a, a.t(), a.z().r());
    }

    public boolean a(int k, int l) {
        int i1 = a.a(k, l);
        return i1 == oe.w.bO;
    }

    public float a(long l, float f1) {
        // =========================================================================================================
        long ofs = ZMod.sunOffsetHandle();
        if(ofs != 0) f1 = 0f; // update: f1
        l += ofs;
        // =========================================================================================================
        int k = (int)(l % 24000L);
        float f2 = ((float)k + f1) / 24000F - 0.25F;
        if(f2 < 0.0F)
            f2++;
        if(f2 > 1.0F)
            f2--;
        float f3 = f2;
        f2 = 1.0F - (float)((Math.cos((double)f2 * 3.1415926535897931D) + 1.0D) / 2D);
        f2 = f3 + (f2 - f3) / 3F;
        return f2;
    }

    public int b(long l, float f1) {
        return (int)(l / 24000L) % 8;
    }

    public float[] a(float f1, float f2) {
        float f3 = 0.4F;
        float f4 = ga.b(f1 * 3.141593F * 2.0F) - 0.0F;
        float f5 = -0F;
        if(f4 >= f5 - f3 && f4 <= f5 + f3) {
            float f6 = ((f4 - f5) / f3) * 0.5F + 0.5F;
            float f7 = 1.0F - (1.0F - ga.a(f6 * 3.141593F)) * 0.99F;
            f7 *= f7;
            i[0] = f6 * 0.3F + 0.7F;
            i[1] = f6 * f6 * 0.7F + 0.2F;
            i[2] = f6 * f6 * 0.0F + 0.2F;
            i[3] = f7;
            return i;
        } else {
            return null;
        }
    }

    public bk b(float f1, float f2) {
        float f3 = ga.b(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f3 < 0.0F)
            f3 = 0.0F;
        if(f3 > 1.0F)
            f3 = 1.0F;
        float f4 = 0.7529412F;
        float f5 = 0.8470588F;
        float f6 = 1.0F;
        f4 *= f3 * 0.94F + 0.06F;
        f5 *= f3 * 0.94F + 0.06F;
        f6 *= f3 * 0.91F + 0.09F;
        return bk.b(f4, f5, f6);
    }

    public boolean d() {
        return true;
    }

    public static aip a(int k) {
        if(k == -1)
            return new ahv();
        if(k == 0)
            return new ma();
        if(k == 1)
            return new hv();
        else
            return null;
    }

    public float e() {
        return (float)a.c;
    }

    public boolean c() {
        return true;
    }

    public td f() {
        return null;
    }

    public int g() {
        if(b == um.b)
            return 4;
        else
            return a.c / 2;
    }

    public boolean i() {
        return b != um.b && !f;
    }

    public double j() {
        return b != um.b ? 0.03125D : 1.0D;
    }

    public vq a;
    public um b;
    public qu c;
    public boolean d, e, f;
    public float g[];
    public int h;
    private float i[];
}
