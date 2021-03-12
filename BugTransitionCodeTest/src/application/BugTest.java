package application;

import javafx.scene.image.ImageView;

public class BugTest implements ObjectTest {
	private double x;
	private double y;
	private String imagePath;
	private int bugMovingDirection;
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
	
	public int getBugMovingDirection() {
		return bugMovingDirection;
	}
	public void setBugMovingDirection(int bugMovingDirection) {
		this.bugMovingDirection = bugMovingDirection;
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
	public BugTest(double x, double y, String imagePath) { //can define int height and width, getter and setter, pass parameter
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.bugMovingDirection= (int) (Math.random()*7)+1;
	}
}
