
import java.util.Random;

public final class ZBB extends ay {

    public ZBB() {
        super(47, 35);
        c(1.5F).a(c).a("bookshelf"); // "bookshelf"
    }

    public int blockGetDropCount(int zero, Random random) {
        return 1;
    }

    public int blockGetDropId(int meta, Random random, int zero) {
        return 47;
    }

}
