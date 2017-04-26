
public class Traffic {
	
	float timeStamp;
	String src;
	String dst;
	String protocol;
	int length;
	String info;
	public void print() {
		System.out.println(timeStamp + " " + src + " " + dst + " "+ protocol + " "+ length + " " + info + "\n");
	}
	
}
