package singleton;

public class EagerSingleton {
	private static EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() {
		System.out.println("-->饿汉式单例模式开始调用构造函数");
	}

	public static EagerSingleton getInstance() {
		return instance;
	}

}
