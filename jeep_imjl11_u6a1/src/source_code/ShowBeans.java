package source_code;

public class ShowBeans {
	private static StatefulSessionBeanInterface statefulCount;
	private static StatelessSessionBeanInterface statelessCount;
	
	static void setState(StatefulSessionBeanInterface stateful, StatelessSessionBeanInterface stateless){
		ShowBeans.statefulCount = stateful;
		ShowBeans.statelessCount = stateless;
	}
	public int getStatefulCount() {
		return statefulCount.getInstanceCount();
	}
	public int getStatelesCount() {
		return statelessCount.getInstanceCount();
	}
}
