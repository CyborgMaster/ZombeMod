
import java.util.Random;

// BlockGlass
public final class ZBG extends vu {

    //public static Material getMaterial(String name) { try { return (Material)Class.forName("Material").getField(name).get(null); } catch(Exception whatever) { return null; } }

    public ZBG() {
        super(20, 49, /*getMaterial("q")*/ Material.q, false);       // Variable class name conflict
        c(0.3F).a(j).a("glass"); // "glass" * drop the last function.
    }

    public int blockGetDropCount(int zero, Random random) {
        return 1;
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return 20;
    }

}
