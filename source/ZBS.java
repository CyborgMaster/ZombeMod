
import java.util.Random;

public final class ZBS extends wh {

    public static Material getMaterial(String name) { try { return (Material)Class.forName("Material").getField(name).get(null); } catch(Exception whatever) { return null; } }
    public static Material mat_g;

    public ZBS() {
        super(19);
        mat_g = getMaterial("g");
        c(0.6F).a(e).a("sponge"); // "sponge"
    }
    
    public void blockOnAdd(World map, int x, int y, int z) { // onBlockAdd
        boolean water = false;
        if(map.e(x+1, y, z) == mat_g) water = true; // present in the original implementation of this function
        else if(map.e(x, y, z+1) == mat_g) water = true;
        else if(map.e(x-1, y, z) == mat_g) water = true;
        else if(map.e(x, y, z-1) == mat_g) water = true;
        if(water && map.e(x, y+1, z) != mat_g) {
            map.mapSetIdMetaNoUpdate(x,y,z, 19, 1);
            map.mapUpdateBlock(x,y,z, 19, 5);
        }
    }

    public void blockOnRemove(World map, int x, int y, int z) { }

    public void blockOnUpdate(World map, int x, int y, int z, Random rnd) {
        int meta = map.mapGetMeta(x,y,z);
        if(meta == 0) return;
        map.mapSetIdMetaNoUpdate(x,y,z,0,0); // remove the block
        if(map.e(x, y+1, z) == mat_g) return;
        // spread: mapGetMat, mapSetIdMetaNoUpdate, scheduleBlockUpdate
        if(map.e(x+1, y, z) == mat_g) { map.mapSetIdMetaNoUpdate(x+1,y,z, 19, 1); map.mapUpdateBlock(x+1,y,z, 19, 5); }
        if(map.e(x, y, z+1) == mat_g) { map.mapSetIdMetaNoUpdate(x,y,z+1, 19, 1); map.mapUpdateBlock(x,y,z+1, 19, 5); }
        if(map.e(x-1, y, z) == mat_g) { map.mapSetIdMetaNoUpdate(x-1,y,z, 19, 1); map.mapUpdateBlock(x-1,y,z, 19, 5); }
        if(map.e(x, y, z-1) == mat_g) { map.mapSetIdMetaNoUpdate(x,y,z-1, 19, 1); map.mapUpdateBlock(x,y,z-1, 19, 5); }
    }
    
    public int blockGetTickRate() {
        return 5;
    }

}
