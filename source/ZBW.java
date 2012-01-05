
import java.util.Random;

public final class ZBW extends ahx {

    public static Material getMaterial(String name) { try { return (Material)Class.forName("Material").getField(name).get(null); } catch(Exception whatever) { return null; } }
    public static Material mat_g = getMaterial("g"), mat_h = getMaterial("h"), mat_A = getMaterial("A");

    public ZBW(boolean water) {
        super(water ? 8 : 10, water ? mat_g : mat_h);
        if(water) c(100F).h(3).a("water").r(); // "water" * drop the last function.
        else c(0.0F).a(1.0F).h(255).a("lava").r(); // "lava" * drop the last function.
    }
    
    private void j(ry ry1, int i, int i1, int j1) {
        int k1 = ry1.d(i, i1, j1);
        ry1.b(i, i1, j1, bM + 1, k1);
        ry1.c(i, i1, j1, i, i1, j1);
        ry1.j(i, i1, j1);
    }

    public void a(ry ry1, int i, int i1, int j1, Random random) {
        int k1 = g(ry1, i, i1, j1);
        byte byte0 = 1;
        if(bZ == mat_h && !ry1.y.d)
            byte0 = 2;
        boolean flag = true;
        if(k1 > 0) {
            int l1 = -100;
            a = 0;
            l1 = f(ry1, i - 1, i1, j1, l1);
            l1 = f(ry1, i + 1, i1, j1, l1);
            l1 = f(ry1, i, i1, j1 - 1, l1);
            l1 = f(ry1, i, i1, j1 + 1, l1);
            int i2 = l1 + byte0;
            if(i2 >= 8 || l1 < 0)
                i2 = -1;
            if(g(ry1, i, i1 + 1, j1) >= 0) {
                int k2 = g(ry1, i, i1 + 1, j1);
                if(k2 >= 8)
                    i2 = k2;
                else
                    i2 = k2 + 8;
            }
            if(a >= 2) i2 = 0; // UPDATE
            if(bZ == mat_h && k1 < 8 && i2 < 8 && i2 > k1 && random.nextInt(4) != 0) {
                i2 = k1;
                flag = false;
            }
            if(i2 != k1) {
                k1 = i2;
                if(k1 < 0) {
                    ry1.g(i, i1, j1, 0);
                } else {
                    ry1.f(i, i1, j1, k1);
                    ry1.a(i, i1, j1, bM, d());
                    ry1.j(i, i1, j1, bM);
                }
            } else
            if(flag)
                j(ry1, i, i1, j1);
        } else {
            j(ry1, i, i1, j1);
        }
        if(m(ry1, i, i1 - 1, j1)) {
            if(bZ == mat_h && ry1.e(i, i1 - 1, j1) == mat_g) {
                ry1.g(i, i1 - 1, j1, yy.t.bM);
                h(ry1, i, i1 - 1, j1);
                return;
            }
            if(k1 >= 8)
                ry1.d(i, i1 - 1, j1, bM, k1);
            else
                ry1.d(i, i1 - 1, j1, bM, k1 + 8);
        } else
        if(k1 >= 0 && (k1 == 0 || l(ry1, i, i1 - 1, j1))) {
            boolean aflag[] = k(ry1, i, i1, j1);
            int j2 = k1 + byte0;
            if(k1 >= 8)
                j2 = 1;
            if(j2 >= 8)
                return;
            if(aflag[0])
                g(ry1, i - 1, i1, j1, j2);
            if(aflag[1])
                g(ry1, i + 1, i1, j1, j2);
            if(aflag[2])
                g(ry1, i, i1, j1 - 1, j2);
            if(aflag[3])
                g(ry1, i, i1, j1 + 1, j2);
        }
    }

    private void g(ry ry1, int i, int i1, int j1, int k1) {
        if(m(ry1, i, i1, j1)) {
            int l1 = ry1.a(i, i1, j1);
            if(l1 > 0)
                if(bZ == mat_h)
                    h(ry1, i, i1, j1);
                else
                    yy.k[l1].b(ry1, i, i1, j1, ry1.d(i, i1, j1), 0);
            ry1.d(i, i1, j1, bM, k1);
        }
    }

    private int c(ry ry1, int i, int i1, int j1, int k1, int l1) {
        int i2 = 1000;
        for(int j2 = 0; j2 < 4; j2++) {
            if(j2 == 0 && l1 == 1 || j2 == 1 && l1 == 0 || j2 == 2 && l1 == 3 || j2 == 3 && l1 == 2)
                continue;
            int k2 = i;
            int l2 = i1;
            int i3 = j1;
            if(j2 == 0)
                k2--;
            if(j2 == 1)
                k2++;
            if(j2 == 2)
                i3--;
            if(j2 == 3)
                i3++;
            if(l(ry1, k2, l2, i3) || ry1.e(k2, l2, i3) == bZ && ry1.d(k2, l2, i3) == 0)
                continue;
            if(!l(ry1, k2, l2 - 1, i3))
                return k1;
            if(k1 >= 4)
                continue;
            int j3 = c(ry1, k2, l2, i3, k1 + 1, j2);
            if(j3 < i2)
                i2 = j3;
        }

        return i2;
    }

    private boolean[] k(ry ry1, int i, int i1, int j1) {
        for(int k1 = 0; k1 < 4; k1++) {
            cc[k1] = 1000;
            int i2 = i;
            int l2 = i1;
            int i3 = j1;
            if(k1 == 0)
                i2--;
            if(k1 == 1)
                i2++;
            if(k1 == 2)
                i3--;
            if(k1 == 3)
                i3++;
            if(l(ry1, i2, l2, i3) || ry1.e(i2, l2, i3) == bZ && ry1.d(i2, l2, i3) == 0)
                continue;
            if(!l(ry1, i2, l2 - 1, i3))
                cc[k1] = 0;
            else
                cc[k1] = c(ry1, i2, l2, i3, 1, k1);
        }

        int l1 = cc[0];
        for(int j2 = 1; j2 < 4; j2++)
            if(cc[j2] < l1)
                l1 = cc[j2];

        for(int k2 = 0; k2 < 4; k2++)
            cb[k2] = cc[k2] == l1;

        return cb;
    }

    private boolean l(ry ry1, int i, int i1, int j1) {
        int k1 = ry1.a(i, i1, j1);
        if(k1 == yy.aE.bM || k1 == yy.aL.bM || k1 == yy.aD.bM || k1 == yy.aF.bM || k1 == yy.aX.bM)
            return true;
        if(k1 == 0)
            return false;
        p p1 = yy.k[k1].bZ;
        if(p1 == mat_A)
            return true;
        return p1.d();
    }

    protected int f(ry ry1, int i, int i1, int j1, int k1) {
        int l1 = g(ry1, i, i1, j1);
        if(l1 < 0)
            return k1;
        if(l1 == 0)
            a++;
        if(l1 >= 8)
            l1 = 0;
        return k1 >= 0 && l1 >= k1 ? k1 : l1;
    }

    private boolean m(ry ry1, int i, int i1, int j1) {
        p p1 = ry1.e(i, i1, j1);
        if(p1 == bZ)
            return false;
        if(p1 == mat_h)
            return false;
        else
            return !l(ry1, i, i1, j1);
    }

}

