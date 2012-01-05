
import java.util.Random;

public final class ZBM extends kk {

    public ZBM() {
        super(52, 65);
        c(5F).a(g).a("mobSpawner").r(); // "mobSpawner"
    }
    
    public void blockOnAdd(World map, int x, int y, int z) {
        super.blockOnAdd(map, x, y, z);
        String mob = ZMod.mobTypeHandle();
        if(mob == null) return;
        TileSpawner spawner = (TileSpawner)(map.mapGetTile(x,y,z));
        spawner.tileSetMob(mob);
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return ZMod.spawnderDropHandle() ? 52 : 0;
    }
    
    public int blockGetDropCount(int zero, Random random) {
        return ZMod.spawnderDropHandle() ? 1 : 0;
    }

}
