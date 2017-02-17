package CS339Project1.src;

import java.io.BufferedWriter;
import java.io.IOException;

public class InterfaceID {
	String name;
	String ip;
	String mask;
	
	public InterfaceID(String name, String ip, String mask) {
		super();
		this.name = name;
		this.ip = ip;
		this.mask = mask;
	}
	
	public void print(BufferedWriter bw) throws IOException{
		bw.write("Interface: " + name + "  IP Address: " + ip + "  IP Mask: " + mask + "\n");
	}

}
