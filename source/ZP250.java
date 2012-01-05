
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ZP250 extends Packet {

	public NBTCompound nbtData;
	public ZP250(){}

	public void a(DataInputStream in) {
		nbtData = (NBTCompound) NBTCompound.b(in); // NBT stuff probably never changes
	}

	public void a(DataOutputStream out) {
		NBTCompound.a(nbtData, out); // NBT stuff probably never changes
	}

	public void a(fe handler) { // UPDATE
		ZMod.packet250Handle(this);
	}

	public int a() {
		return 1;
	}

	public static void init(){
		a(250, true, true, ZP250.class); // found in parent class
	}
}
