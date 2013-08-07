package color;

import color.Color;

public class RandomColor {
	private Color[] colors;
	private int count = 50;
	
	public void setCount(int size){
		this.count = size;
	}
	
	public Color[] getColors(){
		colors = new Color[count];
		double high = 255;
		for(int i = 0; i < colors.length; i++){
			colors[i] = new Color((int) (Math.random() * high), (int) (Math.random() * high), (int) (Math.random() * high));
		}
		return colors;
	}
}

