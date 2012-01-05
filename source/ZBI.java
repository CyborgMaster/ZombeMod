
import java.util.Random;

public final class ZBI extends ahq {

    public ZBI() {
        super(79, 67);
        c(0.5F).h(3).a(h).a("ice"); // "ice" * drop the last function.
    }
    
    public int blockGetDropCount(int zero, Random random) {
        return 1;
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return 79;
    }

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

}
