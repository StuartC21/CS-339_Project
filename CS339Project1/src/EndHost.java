import java.io.BufferedWriter;
import java.io.IOException;

public class EndHost {
	String router;
	String vlan;
	String name;
	
	public EndHost(String router, String vlan, String name) {
		super();
		this.router = router;
		this.vlan = vlan;
		this.name = name;
	}
	
	public void print(BufferedWriter bw) throws IOException{
		bw.write("Interface: " + name + "  Router: " + router + "  vlan: " + vlan + "\n");
	}
}
