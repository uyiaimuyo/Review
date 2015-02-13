/* Imagine you have a call center with three levels of employees: fresher, technical lead (TL),
productmanager(PM) There can be multiple employees, but only one TL or PM.
An incoming telephone call must be allocated to a fresher who is free.  If a fresher can’t handle the call, 
he or she must escalate the call to technical lead not free or not able to handle it, then the call should 
be escalated to PM classes and data structures for this problem Implement a method getCallHandler().
*/
// Chain of Responsibility design pattern
// Advantage is that call routing is loosely coupled with business logic of each specific call handler

public abstract class CallHandlerAbstract {
	private static final int FRESHER = 0;
	private static final int TL = 1;
	private static final int PM = 2;

	private boolean rank;
	private boolean isFree;
	protected CallHandlerAbstract next;

	public CallHandlerAbstract (boolean isFree, int rank) {
		this.isFree = isFree;
		this.rank = rank;
	}

	public void setNextCallHandler(CallHandlerAbstract next) {
		this.next = next;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public boolean startCallHandler(Call c) {
		if (isFree && c.rank <= level) {
			this.isFree = false;
			handleRequest(); 
			this.isFree = true;
			return true;
		} else if (next != null) {
			next.startCallHandler(c);
			return true;
		}
		return false;
	}

	abstract protected void handleRequest();
}

public class FresherCallHandler extends CallHandlerAbstract {
	public FresherCallHandler(boolean isFree, int rank) {
		super(isFree, rank);
	}
	protected void handleRequest() {
		System.out.println("A Fresher handled it.");
	}
}

public class TLCallHandler extends CallHandlerAbstract {
	public TLCallHandler(boolean isFree, int rank) {
		super(isFree, rank);
	}
	protected void handleRequest() {
		System.out.println("A TL handled it.");
	}
}
public class PMCallHandler extends CallHandlerAbstract {
	public PMCallHandler(boolean isFree, int rank) {
		super(isFree, rank);
	}
	protected void handleRequest() {
		Thread.sleep(2000);
		System.out.println("A PM handled it.");
	}
}
public class Call {
	protected int rank = 0; //min rank needed to handle call
}
public class CallCenterHandler {
	public static void main(String[] args) {
		// create chain of responsbility
		CallHandlerAbstract f1 = new FresherCallHandler(true, CallHandlerAbstract.FRESHER);
		CallHandlerAbstract f2 = new FresherCallHandler(false, CallHandlerAbstract.FRESHER);
		CallHandlerAbstract tl = new TLCallHandler(true, CallHandlerAbstract.TL);
		CallHandlerAbstract pm = new PMCallHandler(true, CallHandlerAbstract.PM);

		f1.setNextCallHandler(tl);
		f2.setNextCallHandler(tl);
		tl.setNextCallHandler(pm);

		Queue<Call> callQueue = new LinkedList<Call>();
		Call c = new Call();
		callQueue.push(c);

		while (!callQueue.isEmpty()) {
			Call p = callQueue.pop();
			if (!f1.startCallHandler(p)) {
				callQueue.push(c);
			}
		}
	}
}