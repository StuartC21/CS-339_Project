import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Connections {
	ArrayList<Connection> connectionList = new ArrayList<Connection>();

	public void print() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("results\\connections.txt"));
		for (Connection conn : connectionList) {
			bw.write("RouterA: " + conn.routerA + "  interfaceX: " + conn.interfaceX + "  routerB: " + conn.routerB + "  interfaceY: "
					+ conn.interfaceY + "  Prefix: " + conn.prefix + "\n");
			System.out.println("RouterA: " + conn.routerA + "  interfaceX: " + conn.interfaceX + "  routerB: " + conn.routerB + "  interfaceY: "
					+ conn.interfaceY + "  Prefix: " + conn.prefix  + "\n");
		}
		bw.close();
	}
}
