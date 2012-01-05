
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import java.nio.*;

// search: clouds.png
public class ZRG extends afv {

    public ZRG(Minecraft minecraft, zh renderengine) {
        super(minecraft, renderengine);
    }

    public void callSuper(float f) {
        super.b(f);
    }

    // the found cloud is inside this function - it draws the plane clouds and calls fancy clouds also
    public void b(float f) {
        ZMod.pingDrawHandle(f);
    }

    // (only function with this signature) this is called after matrix setup and before drawing geometry [you find it called in fuction that calls the function setting up matrixes - search: glu]
    public int a(EntityLiving par1, int par2, double par3) {
        ZMod.pingStartHandle();
        return super.a(par1, par2, par3);
    }
    
    // function that does only: ?++;
    public void d() {
        ZMod.pingPreEntHandle();
        super.d();
    }

    // int [a-z0-9]+ = 64 << 3 -    * is in the function
    public void a() {
        ZMod.itemGraphicsLevelHandle(ZMod.getMinecraft().mcCfg.j); // parameter is the parameter for the first funtion in the original function
        super.a();
    }

}
