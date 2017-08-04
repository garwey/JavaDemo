package singleton;

public class LazySingleton {
	private static LazySingleton instance;

	private LazySingleton() {
		System.out.println("-->����ʽ����ģʽ��ʼ���ù��캯��");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			System.out.println("-->����ʽ���캯����ʵ����ǰ��û�б�����");
			instance = new LazySingleton();
		}
		return instance;
	}
}
