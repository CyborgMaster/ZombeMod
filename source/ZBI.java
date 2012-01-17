
import java.util.Random;

public final class ZBI extends jl {

    public ZBI() {
        super(79, 67);
        c(0.5F).f(3).a(j).a("ice"); // "ice" * drop the last function.
    }
    
    public int blockGetDropCount(int zero, Random random) {
        return 1;
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return 79;
    }

/*
    public void a(World map, EntityPlayer player, int x, int y, int z, int meta) { // \], 1\); * function in base class
        // found in base class (Block) ... stright copy
        player.a(ny.C[79], 1); // public static agh C[] = a("stat.mineBlock", 0x1000000);
        player.d(0.025F);      // food ?
        if(b() && !n[79] && ml.d(player.entInventory)) {
            ItemStack stack = c_(meta);
            if(stack != null) a(map, x, y, z, stack);
        } else {
            int kst = ml.e(player.entInventory);
            a(map, x, y, z, meta, kst);
        }
        // original fn ... just without the "isSolid ||" part
        Material mat = map.e(x, y - 1, z);
        if(mat.matGetIsLiquid()) map.g(x, y, z, 8);
    }
    
        aan aan1 = vq1.f(i, j - 1, k);
        if(aan1.c() || aan1.d())
            vq1.g(i, j, k, oe.C.bO);

*/

    public void a(vq vq1, xb xb1, int i1, int j1, int k1, int l1) {
        // found in base class (Block) ... stright copy
        xb1.a(gl.C[bO], 1);
        xb1.c(0.025F);
        if(b() && !p[bO] && agn.d(xb1.ap)) {
            yq yq1 = b(l1);
            if(yq1 != null)
                a(vq1, i1, j1, k1, yq1);
        } else {
            int i2 = agn.e(xb1.ap);
            a(vq1, i1, j1, k1, l1, i2);
        }
        // original fn ... just without the "isSolid ||" part
        Material mat = vq1.f(i1, j1 - 1, k1);
        if(mat.matGetIsLiquid()) vq1.g(i1, j1, k1, 8);
    }

}
