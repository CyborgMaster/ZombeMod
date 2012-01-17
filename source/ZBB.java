
import java.util.Random;

public final class ZBB extends fb {

    public ZBB() {
        super(47, 35);
        c(1.5F).a(e).a("bookshelf"); // "bookshelf"
    }

    public int blockGetDropCount(int zero, Random random) {
        return 1;
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return 47;
    }

}
