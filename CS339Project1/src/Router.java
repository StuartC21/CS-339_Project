import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Router {
	ArrayList<InterfaceID> interfaceList = new ArrayList<InterfaceID>();
	String name;

	public void print(BufferedWriter bw) throws IOException {
		bw.write("<" + name + ">\n");
		for (InterfaceID interID : interfaceList){
			bw.write("Interface: " + interID.name + "  IP Address: " + interID.ip + "  IP Mask: " + interID.mask + "  Prefix: " + interID.prefix + "\n");
		}
		bw.write("\n");
	}
}
