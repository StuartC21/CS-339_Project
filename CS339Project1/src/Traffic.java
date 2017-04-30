
public class Traffic {
	
	String timeStamp;
	String src;
	String dst;
	String protocol;
	String length;
	String info;
	
	public Traffic(String timeStamp, String src, String dst, String protocol, String length, String info) {
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
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
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
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
