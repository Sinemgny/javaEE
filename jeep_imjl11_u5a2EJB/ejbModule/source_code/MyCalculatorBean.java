package source_code;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import source_code_client.MyCalculator;

@Stateless
@Remote(MyCalculator.class)
public class MyCalculatorBean implements MyCalculator {

	@Override
	public long getSquare(int base) {
		return base * base;
	}

}
