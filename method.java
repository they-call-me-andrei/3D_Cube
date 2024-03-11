
public class method {
	public static object o = new object();
	
	public static void main(String[] args) {
		o.createFrame();
		Thread t = new Thread(new Render());
		t.start();
	}

}
