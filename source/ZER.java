
import net.minecraft.client.Minecraft;

public final class ZER extends EntityRenderer {

    public ZER(Minecraft minecraft, EntityRenderer prev) {
        super(minecraft);
        c = prev.c;
        d = prev.d;
        m = prev.m;
    }

    public void b(float par) {
        super.b(par);
        ZMod.pingDrawGUIHandle(par);
    }
    
    // search: environment/snow.png
    protected void c(float par) {
        ZMod.spoofCloudFogConfig();
        if(ZMod.drawRainHandle()) super.c(par);
    }
    
/* too god-damn broken
    private static EntityPlayerSP voodooDoll;
    private static void setVoodooDoll() {
        Minecraft mc = ZMod.getMinecraft();
        if(voodooDoll == null) voodooDoll = new EntityPlayerSP(mc, mc.mcMap, mc.k, 0); // session: % 1000L  * xx.session
        EntityLiving view = mc.mcView;
        voodooDoll.entPrevX = voodooDoll.entPrevPosX = voodooDoll.entPosX = view.entPosX;
        voodooDoll.entPrevY = voodooDoll.entPrevPosY = voodooDoll.entPosY = view.entPosY + view.entGetMountOffset();
        voodooDoll.entPrevZ = voodooDoll.entPrevPosZ = voodooDoll.entPosZ = view.entPosZ;
        voodooDoll.u = voodooDoll.entYaw = view.entYaw;
        voodooDoll.v = voodooDoll.entPitch = view.entPitch;
        mc.mcView = voodooDoll;
    }
    
    public void a(float par1, long par2) { // 0x3b9aca00L  * is in function
        Minecraft mc = ZMod.getMinecraft();
        EntityLiving view = mc.mcView;
        if(!(mc.mcView instanceof EntityPlayer)) setVoodooDoll();
        super.a(par1, par2);
        mc.mcView = view;
    }
*/

    public void a() {
        Minecraft mc = ZMod.getMinecraft();
        EntityLiving view = mc.mcView;
        if(!(mc.mcView instanceof EntityPlayerSP)) mc.mcView = mc.mcPlayer; // setVoodooDoll();
        
        super.a();

        mc.mcView = view;
    }

}
