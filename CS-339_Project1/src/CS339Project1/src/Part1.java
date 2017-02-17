package CS339Project1.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Part1 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("parsedConfig.txt"));
		parse("config1.txt", bw);
		parse("config2.txt", bw);
		parse("config3.txt", bw);
		parse("config4.txt", bw);
		parse("config5.txt", bw);
		parse("config6.txt", bw);
		parse("config7.txt", bw);
		parse("config8.txt", bw);
		parse("config9.txt", bw);
		parse("config10.txt", bw);
		parse("config11.txt",bw);
		parse("config12.txt", bw);
		parse("config13.txt", bw);
		bw.close();
	}

	private static void parse(String file, BufferedWriter bw) throws IOException {
		ArrayList<InterfaceID> router = new ArrayList<InterfaceID>();
		BufferedReader br = new BufferedReader(new FileReader(new File(file)));
		String line = br.readLine();
		String routerName = "";
		String[] inter;
		String interName = "";
		String ipAddress = "";
		String ipMask = "";
		
		while(!Pattern.matches("^end$", line)){
			if(Pattern.matches("^hostname\\s.*", line)){
				routerName = line.substring(9);
			}
			if(Pattern.matches("^interface.*", line)){
				interName = line.substring(10);
				while(!Pattern.matches("!", line)){	
					line = br.readLine();
					if(Pattern.matches("^\\sip\\saddress.*", line)){
						inter = line.split("\\s");
						ipAddress = inter[3];
						ipMask = inter[4];
						router.add(new InterfaceID(interName, ipAddress, ipMask));
					}
				}
				
				
			}
			line = br.readLine();	
		}
		br.close();
		
		
		bw.write("<" + routerName + ">\n");
		System.out.println("<" + routerName + ">");
		for (InterfaceID interID : router){
			interID.print(bw);
		}
		bw.write("\n");
	}
}
