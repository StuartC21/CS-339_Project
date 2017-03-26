import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.application.Application;

public class Part1 {
	static Connections connections = new Connections();
	static ArrayList<Router> routerList = new ArrayList<Router>();
	static ArrayList<EndHost> hostList = new ArrayList<EndHost>();
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("results\\parsedConfig.txt"));
	    
	    final String path = "test";
	    File dir = new File(path);
        FilenameFilter filter = new MyFileFilter();
        File[] files = dir.listFiles(filter);
        for(File f : files){
        	routerList.add(parse(f, bw));
        }
		bw.close();
		
		connections = connectingRouters(routerList, connections);
		connections.print();
		
		Application.launch(Visualizer.class, args);
	}

	private static Connections connectingRouters(ArrayList<Router> routerList,Connections connections) {
		for(Router router : routerList){
			for (InterfaceID inter : router.interfaceList){
				//for every interface check all other interfaces n different routers
				for(Router routerID : routerList){
					if (!router.name.equals(routerID.name)){
						for (InterfaceID interID : routerID.interfaceList){
							if(inter.prefix.equals(interID.prefix)){
								connections.connectionList.add(new Connection(router.name, routerID.name, inter.name, interID.name, inter.prefix));
								//System.out.println("RouterA: " + router.name + "  interfaceX: " + inter.name + "  routerB: " + routerID.name + "  interfaceY: "
								//+ interID.name + "\n");
							}
						}
					}
				}
			}
		}
		
		return connections;
		
	}

	private static Router parse(File file, BufferedWriter bw) throws IOException {
		Router router = new Router();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		String routerName = "";
		String[] inter;
		String interName = "";
		String ipAddress = "";
		String ipMask = "";
		
		while(!Pattern.matches("^end$", line)){
			if(Pattern.matches("^hostname\\s.*", line)){
				routerName = line.substring(9);
				router.name = routerName;
			}
			if(Pattern.matches("^interface.*", line)){
				interName = line.substring(10);
				while(!Pattern.matches("!", line)){	
					line = br.readLine();
					if(Pattern.matches("^\\sswitchport\\saccess.*", line)){
						inter = line.split("\\s");
						String vlan = inter[3] + inter[4];
						hostList.add(new EndHost(routerName, vlan, interName));
						System.out.println("Interface: " + interName + "  Router: " + router + "  vlan: " + vlan + "\n");
					}
					if(Pattern.matches("^\\sip\\saddress.*", line)){
						inter = line.split("\\s");
						ipAddress = inter[3];
						ipMask = inter[4];
						router.interfaceList.add(new InterfaceID(interName, ipAddress, ipMask));
					}
				}
			}
			line = br.readLine();	
		}
		br.close();
		System.out.println("<" + routerName + ">");
		router.print(bw);
		return router;
	}
}
