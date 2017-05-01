
public class Traffic {
	
	String timeStamp;
	String src;
	String dst;
	String pro;
	String len;
	String info;
	
	public Traffic(String timeStamp, String src, String dst, String pro, String info) {
		super();
		this.timeStamp = timeStamp;
		this.src = src;
		this.dst = dst;
		this.pro = pro;
		this.info = info;
	}
	public void print() {
		System.out.println(timeStamp + " " + src + " " + dst + " "+ pro + " " + info + "\n");
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
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
