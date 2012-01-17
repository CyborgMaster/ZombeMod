
import java.util.Random;

// BlockLeaves
public final class ZBL extends BlockLeaves {

    public ZBL() {
        super(18, 52);
        c(0.2F).f(1).a(g).a("leaves").k(); // "leaves" * drop the last function.
    }

    public int blockGetDropCount(int zero, Random random) {
        return ZMod.leavesDropHandle();
    }

    private static int _meta = 0;
    public int blockGetDropId(int meta, Random random, int zero) {
        int id = ZMod.leavesHandle(meta & 3);
        _meta = id >> 16;
        return id & 65535;
    }

    protected int blockGetMeta(int i) { // i=meta-data
        return _meta;
    }

}

