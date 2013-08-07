package color;

public class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color(int red, int green, int blue){
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}
}
