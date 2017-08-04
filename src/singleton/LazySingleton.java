package singleton;

public class LazySingleton {
	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("-->懒汉式单例模式开始调用构造函数");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			System.out.println("-->懒汉式构造函数的实例当前并没有被创建");
			instance = new LazySingleton();
		}
		return instance;
	}
}
