package source_code;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

@Stateful
public class StatefulSessionBean implements StatefulSessionBeanInterface {

	private static int sessionBeanInstanzen = 0;
	private static Object lock = new Object();
	
	@Override
	public int getInstanceCount() {
		return sessionBeanInstanzen;
	}
	
	@PostConstruct
	private void up() {
		synchronized (lock) {
			++sessionBeanInstanzen;
		}
	}
	@PreDestroy
	private void down() {
		synchronized (lock) {
			--sessionBeanInstanzen;
		}
	}


}
