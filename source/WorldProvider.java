// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packfields(4) packimports(3) nonlb
// Source File Name:   SourceFile

// search: 24000F
public abstract class k {

    protected static final boolean zmodmarker = true;

    public k() {
        c = false;
        d = false;
        e = false;
        f = new float[16];
        g = 0;
        h = new float[4];
    }

    public final void a(ry ry1) {
        a = ry1;
        b();
        a();
    }

    protected void a() {
        float f1 = 0.0F;
        for(int i = 0; i <= 15; i++) {
            float f2 = 1.0F - (float)i / 15F;
            f[i] = ((1.0F - f2) / (f2 * 3F + 1.0F)) * (1.0F - f1) + f1;
        }

    }

    protected void b() {
        b = new vh(a);
    }

    public ej c() {
        return new xj(a, a.t(), a.z().r());
    }

    public boolean a(int i, int j) {
        int l = a.a(i, j);
        return l == yy.u.bM;
    }

    public float a(long l, float f1) {
        // =========================================================================================================
        long ofs = ZMod.sunOffsetHandle();
        if(ofs != 0) f1 = 0f; // update: f1
        l += ofs;
        // =========================================================================================================
        int i = (int)(l % 24000L);
        float f2 = ((float)i + f1) / 24000F - 0.25F;
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
        float f4 = me.b(f1 * 3.141593F * 2.0F) - 0.0F;
        float f5 = -0F;
        if(f4 >= f5 - f3 && f4 <= f5 + f3) {
            float f6 = ((f4 - f5) / f3) * 0.5F + 0.5F;
            float f7 = 1.0F - (1.0F - me.a(f6 * 3.141593F)) * 0.99F;
            f7 *= f7;
            h[0] = f6 * 0.3F + 0.7F;
            h[1] = f6 * f6 * 0.7F + 0.2F;
            h[2] = f6 * f6 * 0.0F + 0.2F;
            h[3] = f7;
            return h;
        } else {
            return null;
        }
    }

    public fb b(float f1, float f2) {
        float f3 = me.b(f1 * 3.141593F * 2.0F) * 2.0F + 0.5F;
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
        return fb.b(f4, f5, f6);
    }

    public boolean d() {
        return true;
    }

    public static k a(int i) {
        if(i == -1)
            return new aau();
        if(i == 0)
            return new ix();
        if(i == 1)
            return new ol();
        else
            return null;
    }

    public float e() {
        return (float)a.c;
    }

    public boolean f() {
        return true;
    }

    public dh g() {
        return null;
    }

    public ry a;
    public vh b;
    public boolean c, d, e;
    public float f[];
    public int g;
    private float h[];
}
