
public class Connection {
	String routerA;
	String routerB;
	String interfaceX;
	String interfaceY;

	public Connection(String routerA, String routerB, String interfaceX, String interfaceY) {
		super();
		this.routerA = routerA;
		this.routerB = routerB;
		this.interfaceX = interfaceX;
		this.interfaceY = interfaceY;
	}

	public String getRouterA() {
		return routerA;
	}

	public void setRouterA(String routerA) {
		this.routerA = routerA;
	}

	public String getRouterB() {
		return routerB;
	}

	public void setRouterB(String routerB) {
		this.routerB = routerB;
	}

	public String getInterfaceX() {
		return interfaceX;
	}

	public void setInterfaceX(String interfaceX) {
		this.interfaceX = interfaceX;
	}

	public String getInterfaceY() {
		return interfaceY;
	}

	public void setInterfaceY(String interfaceY) {
		this.interfaceY = interfaceY;
	}
	
}
