
public final class ZBF extends zj {

    public ZBF() {
        super(85, 4);
        c(2.0F).b(5F).a(e).a("fence"); // "fence" * drop the last function.
    }
    
    // search for "0 ||" in base class for the original function - straight copy of the original
    public boolean e(vq vq1, int i1, int j1, int k1) {
        int l1 = vq1.a(i1, j1, k1);
        return l1 == 0 || m[l1].cb.i();
    }

}
