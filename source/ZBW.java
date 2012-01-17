
import java.util.Random;

public final class ZBW extends kb {

    //public static Material getMaterial(String name) { try { return (Material)Class.forName("Material").getField(name).get(null); } catch(Exception whatever) { return null; } }
    //public static Material mat_g = getMaterial("g"), mat_h = getMaterial("h"), mat_A = getMaterial("A");
    //public static Material mat_g = Material.g, mat_h = Material.h, Material.A;

    public ZBW(boolean water) {
        super(water ? 8 : 10, water ? Material.g : Material.h);
        if(water) c(100F).f(3).a("water").r(); // "water" * drop the last function.
        else c(0.0F).a(1.0F).f(255).a("lava").r(); // "lava" * drop the last function.
    }
    
    private void j(vq vq1, int i, int i1, int j1) {
        int k1 = vq1.e(i, i1, j1);
        vq1.b(i, i1, j1, bO + 1, k1);
        vq1.c(i, i1, j1, i, i1, j1);
        vq1.j(i, i1, j1);
    }

    public void a(vq vq1, int i, int i1, int j1, Random random) {
        int k1 = h(vq1, i, i1, j1);
        byte byte0 = 1;
        if(cb == aan.h && !vq1.y.e)
            byte0 = 2;
        boolean flag = true;
        if(k1 > 0) {
            int l1 = -100;
            a = 0;
            l1 = f(vq1, i - 1, i1, j1, l1);
            l1 = f(vq1, i + 1, i1, j1, l1);
            l1 = f(vq1, i, i1, j1 - 1, l1);
            l1 = f(vq1, i, i1, j1 + 1, l1);
            int i2 = l1 + byte0;
            if(i2 >= 8 || l1 < 0)
                i2 = -1;
            if(h(vq1, i, i1 + 1, j1) >= 0) {
                int k2 = h(vq1, i, i1 + 1, j1);
                if(k2 >= 8)
                    i2 = k2;
                else
                    i2 = k2 + 8;
            }

            if(a >= 2) i2 = 0; // UPDATE

            if(cb == aan.h && k1 < 8 && i2 < 8 && i2 > k1 && random.nextInt(4) != 0) {
                i2 = k1;
                flag = false;
            }
            if(i2 != k1) {
                k1 = i2;
                if(k1 < 0) {
                    vq1.g(i, i1, j1, 0);
                } else {
                    vq1.f(i, i1, j1, k1);
                    vq1.a(i, i1, j1, bO, e());
                    vq1.j(i, i1, j1, bO);
                }
            } else
            if(flag)
                j(vq1, i, i1, j1);
        } else {
            j(vq1, i, i1, j1);
        }
        if(m(vq1, i, i1 - 1, j1)) {
            if(cb == aan.h && vq1.f(i, i1 - 1, j1) == aan.g) {
                vq1.g(i, i1 - 1, j1, oe.v.bO);
                i(vq1, i, i1 - 1, j1);
                return;
            }
            if(k1 >= 8)
                vq1.d(i, i1 - 1, j1, bO, k1);
            else
                vq1.d(i, i1 - 1, j1, bO, k1 + 8);
        } else
        if(k1 >= 0 && (k1 == 0 || l(vq1, i, i1 - 1, j1))) {
            boolean aflag[] = k(vq1, i, i1, j1);
            int j2 = k1 + byte0;
            if(k1 >= 8)
                j2 = 1;
            if(j2 >= 8)
                return;
            if(aflag[0])
                g(vq1, i - 1, i1, j1, j2);
            if(aflag[1])
                g(vq1, i + 1, i1, j1, j2);
            if(aflag[2])
                g(vq1, i, i1, j1 - 1, j2);
            if(aflag[3])
                g(vq1, i, i1, j1 + 1, j2);
        }
    }

    private void g(vq vq1, int i, int i1, int j1, int k1) {
        if(m(vq1, i, i1, j1)) {
            int l1 = vq1.a(i, i1, j1);
            if(l1 > 0)
                if(cb == aan.h)
                    i(vq1, i, i1, j1);
                else
                    oe.m[l1].a(vq1, i, i1, j1, vq1.e(i, i1, j1), 0);
            vq1.d(i, i1, j1, bO, k1);
        }
    }

    private int c(vq vq1, int i, int i1, int j1, int k1, int l1) {
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
            if(l(vq1, k2, l2, i3) || vq1.f(k2, l2, i3) == cb && vq1.e(k2, l2, i3) == 0)
                continue;
            if(!l(vq1, k2, l2 - 1, i3))
                return k1;
            if(k1 >= 4)
                continue;
            int j3 = c(vq1, k2, l2, i3, k1 + 1, j2);
            if(j3 < i2)
                i2 = j3;
        }

        return i2;
    }

    private boolean[] k(vq vq1, int i, int i1, int j1) {
        for(int k1 = 0; k1 < 4; k1++) {
            c[k1] = 1000;
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
            if(l(vq1, i2, l2, i3) || vq1.f(i2, l2, i3) == cb && vq1.e(i2, l2, i3) == 0)
                continue;
            if(!l(vq1, i2, l2 - 1, i3))
                c[k1] = 0;
            else
                c[k1] = c(vq1, i2, l2, i3, 1, k1);
        }

        int l1 = c[0];
        for(int j2 = 1; j2 < 4; j2++)
            if(c[j2] < l1)
                l1 = c[j2];

        for(int k2 = 0; k2 < 4; k2++)
            b[k2] = c[k2] == l1;

        return b;
    }

    private boolean l(vq vq1, int i, int i1, int j1) {
        int k1 = vq1.a(i, i1, j1);
        if(k1 == oe.aG.bO || k1 == oe.aN.bO || k1 == oe.aF.bO || k1 == oe.aH.bO || k1 == oe.aZ.bO)
            return true;
        if(k1 == 0)
            return false;
        aan aan1 = oe.m[k1].cb;
        if(aan1 == aan.A)
            return true;
        return aan1.c();
    }

    protected int f(vq vq1, int i, int i1, int j1, int k1) {
        int l1 = h(vq1, i, i1, j1);
        if(l1 < 0)
            return k1;
        if(l1 == 0)
            a++;
        if(l1 >= 8)
            l1 = 0;
        return k1 >= 0 && l1 >= k1 ? k1 : l1;
    }

    private boolean m(vq vq1, int i, int i1, int j1) {
        aan aan1 = vq1.f(i, i1, j1);
        if(aan1 == cb)
            return false;
        if(aan1 == aan.h)
            return false;
        else
            return !l(vq1, i, i1, j1);
    }

}

