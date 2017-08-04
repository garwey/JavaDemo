package singleton;
public class test {
	public static void main(String[] args) {
		LazySingleton ls = LazySingleton.getInstance();
		EagerSingleton es = EagerSingleton.getInstance();
	}
}
