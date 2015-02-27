// Thread safe singleton pattern

public class ThreadSafeSingleton {
	
	private static ThreadSafeSingleton instance = null;

	private ThreadSafeSingleton() {

	}

	// on way is to do make method synchronized ie:
	// public static synchronized ThreadSafeSingletion getInstance()
	// but this has too much overhead for future calls to getInstance when instance has been already set
	// its better to do the following
	public static ThreadSafeSingleton getInstance() {
		if(this.instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				this.instance = new ThreadSafeSingleton();
			}
		}

		return this.instance;
	}

}