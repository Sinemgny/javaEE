package report;

import java.util.Map;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
public interface ReportGenerator {
	void sendReportMail();
	Map<Integer, Integer> getAgeDistribution();
	Map<String, Integer> getCountryDistribution();
}
