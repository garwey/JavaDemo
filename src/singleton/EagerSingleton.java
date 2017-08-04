package singleton;

public class EagerSingleton {
	private static EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() {
		System.out.println("-->����ʽ����ģʽ��ʼ���ù��캯��");
	}

	public static EagerSingleton getInstance() {
		return instance;
	}

}
