package source_code;

import javax.ejb.Local;
import javax.ejb.Stateful;

@Local
@Stateful
public interface StatefulSessionBeanInterface  extends InstanceCounterInterface {

}
