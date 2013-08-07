package statistic;

import java.util.HashMap;

public class Statistik {
	private HashMap<String, Integer> browsers = new HashMap<String, Integer>();
	private HashMap<String, Integer> os = new HashMap<String, Integer>();
	private String[] tempOs;
	private int value;
	
	public HashMap<String, Integer> getStatistic1() {
		return browsers;
	}
	
	public HashMap<String, Integer> getStatistic2() {
		return os;
	}
	
	public void setBrowsers(String browser) {
		String[] temp = browser.split(",");
		/*
		 * Diese Funktion braucht man nur für die erste Ausführung.
		 * Wenn HashMap leer ist, lese alle Parameter aus der xml Datei,
		 * sonst mach nichts.
		 */
		if(this.browsers.isEmpty()){
			for(int i = 0; i < temp.length; i++){
				this.browsers.put(temp[i], 0);
			}
		}
		else{
			
		}
		
	}
	
	public void setOs(String os) {
		this.tempOs = os.split(",");
		/*
		 * Diese Funktion braucht man nur für die erste Ausführung.
		 * Wenn HashMap leer ist, lese alle Parameter aus der xml Datei,
		 * sonst mach nichts.
		 */
		if(this.os.isEmpty()){
			for(int i = 0; i < this.tempOs.length; i++){
				this.os.put(this.tempOs[i], 0);
			}
		}
		else{
			
		}
		
	}
	
	public void setStat(String br){
		String[] browser = br.split("/");
		
		if(this.browsers.containsKey(browser[0])){
			value = this.browsers.get(browser[0]);
			value += 1;
			this.browsers.put(browser[0], value);
		}
		
		for(String x : this.tempOs){
			if(browser[1].contains(x)){
				value = this.os.get(x);
				value += 1;
				this.os.put(x, value);
			}
		}
	
	}
	
	public void setBrowser(String browser){
		
	}	
}
