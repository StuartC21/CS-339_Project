
public class Traffic {
	
	float timeStamp;
	String src;
	String dst;
	String protocol;
	int length;
	String info;
	
	public Traffic(float timeStamp, String src, String dst, String protocol, int length, String info) {
		super();
		this.timeStamp = timeStamp;
		this.src = src;
		this.dst = dst;
		this.protocol = protocol;
		this.length = length;
		this.info = info;
	}
	public void print() {
		System.out.println(timeStamp + " " + src + " " + dst + " "+ protocol + " "+ length + " " + info + "\n");
	}
	public float getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(float timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
