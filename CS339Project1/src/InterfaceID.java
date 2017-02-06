import java.io.BufferedWriter;
import java.io.IOException;

public class InterfaceID {
	String name;
	String ip;
	String mask;
	String prefix = "";
	
	public InterfaceID(String name, String ip, String mask) {
		super();
		this.name = name;
		this.ip = ip;
		this.mask = mask;
		findPrefix(mask, ip);
	}
	
	private void findPrefix(String mask, String ip) {
		String[] oct = ip.split("\\.");
		String[] maskOct = mask.split("\\.");
		for (int i = 0; i < 4; i++){
			int x = Integer.parseInt(oct[i]);
			int y = Integer.parseInt(maskOct[i]);
			int z = x & y;
			prefix+= z;
			if (i < 3) prefix+=".";
		
		}
		
	}

	public void print(BufferedWriter bw) throws IOException{
		bw.write("Interface: " + name + "  IP Address: " + ip + "  IP Mask: " + mask + "  Prefix: " + prefix + "\n");
	}

}
