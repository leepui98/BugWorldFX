package application;

import javafx.scene.image.ImageView;

public class PlantTest implements ObjectTest{
	private double x;
	private double y;
	private String imagePath;
	private ImageView imageView;
	public ImageView getImageView() {
		return imageView;
	}
	
//	public ImageView setImageView() {
//		return imageView;
//	}
	
	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public PlantTest(double x, double y, String imagePath) { //can define int height and width, getter and setter, pass parameter
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
	}
}
