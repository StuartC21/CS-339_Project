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
	
	static ArrayList<Traffic> trafficList = new ArrayList<Traffic>();
		
	public static void main(String[] args) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("results\\parsedConfig.txt"));
	    
	    final String path = "test";
	    File dir = new File(path);
        FilenameFilter filter = new MyFileFilter();
        File[] files = dir.listFiles(filter);
        for(File f : files){
        	parse(f, bw);
        }
        bw.close();
        //Application.launch(Interface.class, args);
        Application.launch(PieChartInterface.class, args);
		
		
}


	private static void parse(File file, BufferedWriter bw) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		
		while(!(line == null)){
			if(Pattern.matches("^No\\..*", line)){
				line = br.readLine();
				String[] split = line.split("\\s");
				split = removeSpace(split);
				String timeStamp = split[1];
				String src = split[2];
				String dst = split[3];
				String pro = split[4];
				String info = split[6];
				Traffic traffic = new Traffic(timeStamp, src, dst, pro, info);
				trafficList.add(traffic);
				traffic.print();
			}
			line = br.readLine();	
		}
		br.close();
		
	}


	private static String[] removeSpace(String[] split) {
		int j = 0;
		for (int i = 0; i < split.length; i++){
			if(!(split[i].equals(""))){
				split[j] = split[i];
				j++;
			}
		}
		split[6] = getInfo(split);;
		return split;
		
	}


	private static String getInfo(String[] split) {
		String info = ""; 
		int i = 6;
		while(!(split[i].equals("")) && (i < split.length-1)){
			info += " " + split[i];
			i++;
		}
		return info;
	}
}
