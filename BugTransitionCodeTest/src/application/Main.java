package application;
	
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//reference from Chathura's code
public class Main extends Application {
	private ArrayList<ObjectTest>objects= new ArrayList<>();
		
	Group g= new Group();
	
	Timeline t= new Timeline();
	HBox h=  new HBox();
	
	final Button btn= new Button("Creatures move");
	final Button btn2= new Button("Bugs stop moving");
	final Button btn4= new Button("Remove Bug");
	final Button btn5= new Button ("Add LadyBird");
	final Button btn6= new Button ("Add Bee");
	final Button btn7=  new Button ("Add Butterfly");

	
	public Main() {
		
		objects.add(new BeeTest(200, 300, "img/bee1.jpg"));
		objects.add(new ButterflyTest(50, 400, "img/butterfly.jpg"));
		objects.add(new LadyBirdTest(400, 200, "img/ladybird.jpg"));
		objects.add(new ButterflyTest(80, 350, "img/butterfly.jpg"));
		objects.add(new BushTest (160, 250, "img/bush.jpg"));
		objects.add(new BushTest (340, 500, "img/bush.jpg"));
		objects.add(new FlowerTest(300,300, "img/flower.jpeg"));
		objects.add(new FlowerTest(500, 400, "img/flower.jpeg"));
		objects.add(new FlowerTest(250, 150, "img/flower.jpeg"));
		objects.add(new FlowerTest(500,500, "img/flower.jpeg"));
		objects.add(new TreeTest (550, 480, "img/tree.png"));
		objects.add(new TreeTest (100, 100, "img/tree.png"));
		//	Collections.copy(objectsReplica,objects);
	}
	
	
	
	private void addLadyBird() {
		objects.add(new LadyBirdTest(90,90,"img/ladybird.jpg"));
		
		g.getChildren().clear();		
		g.getChildren().addAll(btn, btn2, btn4, btn5, btn6, btn7);
		
		for(int a =0; a<objects.size(); a++) {
			ObjectTest o= objects.get(a);
			ImageView i = viewImage(o);
			o.setImageView(i);
			g.getChildren().add(i);  //get image from screen and add to arraylist
			if(o instanceof BugTest) {
				KeyFrame frame= getFrame(i,(BugTest)o);
				t.getKeyFrames().add(frame); //add keyframe to timeline
			}
			
		}
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		
		t.play();
	}
	
	private void addBee() {
		objects.add(new BeeTest(60, 60, "img/bee1.jpg" ));
		g.getChildren().clear();		
		g.getChildren().addAll(btn, btn2, btn4, btn5, btn6, btn7);
		
		for(ObjectTest o : objects) {
			ImageView i = viewImage(o);
			o.setImageView(i);
			g.getChildren().add(i);  //get image from screen and add to arraylist
			if(o instanceof BugTest) {
				KeyFrame frame= getFrame(i,(BugTest)o);
				t.getKeyFrames().add(frame); //add keyframe to timeline
			}
			
		}
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		
		t.play();
	}
	
	private void addButterfly() {
		
		objects.add(new ButterflyTest(40, 100, "img/butterfly.jpg"));
		g.getChildren().clear();		
		g.getChildren().addAll(btn, btn2, btn4, btn5, btn6, btn7);
		
		for(ObjectTest o : objects) {
			ImageView i = viewImage(o);
			o.setImageView(i);
			g.getChildren().add(i);  //get image from screen and add to arraylist
			if(o instanceof BugTest) {
				KeyFrame frame= getFrame(i,(BugTest)o);
				t.getKeyFrames().add(frame); //add keyframe to timeline
			}
			
		}
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		
		t.play();
	}
	
	private void removeRandomBug()
	{
		
		System.out.println("size before= " + this.objects.size());
		int random = -1;
		for(int i=0; i<this.objects.size();i++)
		{
			random = (int) Math.random() * objects.size();
			if(objects.get(random) instanceof BugTest)
				break;
			else
				random = -1;
		}
		if(random == -1)
			return;
		objects.remove(random);
		System.out.println("size after= " + this.objects.size());
		
		
		t.stop();		
		g.getChildren().clear();		
		g.getChildren().addAll(btn, btn2, btn4, btn5, btn6, btn7, h);
		
		for(int a =0; a<objects.size(); a++) {
			ObjectTest o= objects.get(a);
			ImageView i = viewImage(o);
			o.setImageView(i);
			g.getChildren().add(i);  //get image from screen and add to arraylist
			if(o instanceof BugTest) {
				KeyFrame frame= getFrame(i,(BugTest)o);
				t.getKeyFrames().add(frame); //add keyframe to timeline
			}
			
			
		}
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		
		t.play();
	}
	
	
	
	void doThis()
	{
		t.play();
	}
	
	@Override
	
	public void start(Stage primaryStage) {
		try {
			
//			Button btn3= new Button ("Bugs move to plant to eat");
			
			for(ObjectTest o : objects) {
				ImageView i = viewImage(o);
				o.setImageView(i);
				g.getChildren().add(i);  //get image from screen and add to arraylist
				if(o instanceof BugTest) {
					KeyFrame frame= getFrame(i,(BugTest)o);
					
					t.getKeyFrames().add(frame); //add keyframe to timeline
				}
				
			}
			
			t.setCycleCount(javafx.animation.Animation.INDEFINITE);
			
			System.out.println("T: " + t);
			btn.setOnAction(action -> doThis());
						
			
//			btn2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> t.stop());
			btn2.setOnAction(action -> t.pause());
			
			
			btn4.setOnAction(action -> removeRandomBug());
			
			btn5.setOnAction(action -> addLadyBird());
			
			btn6.setOnAction(action -> addBee());
			
			btn7.setOnAction(action -> addButterfly());
			
			
			h.getChildren().addAll(btn, btn2, btn4, btn5, btn6, btn7);
			h.setPadding(new Insets(10,12,10,12));
			h.setStyle("-fx-background-color: #4d4d4d");
			g.getChildren().add(h);
			
			
			
			
			
			Scene scene = new Scene(g,700,700);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Welcome to Bug World");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ImageView viewImage(ObjectTest object) {
		try {
			FileInputStream getImageFile= new FileInputStream(object.getImagePath());
			Image image= new Image (getImageFile); //build image
			ImageView viewImage= new ImageView(image); //show image
			viewImage.setX(object.getX()); //set image size
			viewImage.setY(object.getY());
			viewImage.setFitHeight(60);
			viewImage.setFitWidth(60);
			return viewImage;
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

		
		
		
		
		
			
			
//		private void removeBug() {
//			for(Object o : objects) {
//				if (o instanceof Bug) {
//					
//				}
//			}
//		}
//	
	
//		private Plant searchForPlant(int x, int y) {
//			for(Object o : objects) {
//				if(o instanceof Plant) {
//					Plant p= (Plant) o;
//					if (p.getX()==x && p.getY()==y) {
//						return p;
//					}
//					return null;
//				}
//			}
//			return null;
//		}
//	
	private KeyFrame getFrame(ImageView i, BugTest a) { 
		
		KeyFrame frame= new KeyFrame(Duration.millis(5), e->{ 
		
			 Bounds boundsInScene = i.localToScene(i.getBoundsInLocal());

             double dy = 0;

             double dx = 0;

             int r  = a.getBugMovingDirection();

            

             if(r == 1) {

                         dy = -1;

                         dx = 0;

             } else if(r == 2) {

                         dy = -1;

                         dx = 1;

             } else if(r == 3) {

                         dx = 1;

                         dy = 0;

             } else if(r == 4) {

                         dy = 1;

                         dx = 1;

             } else if(r == 5) {

                         dx = 0;

                         dy = 1;

             } else if(r == 6) {

                         dx = -1;

                         dy = 1;

             } else if(r == 7) {

                         dy = 0;

                         dx = -1;

             } else if(r == 8) {

                         dy = -1;

                         dx = -1;

             }                      

            

             if(boundsInScene.getMinY() <= 50 && (r==8||r==1 || r==2)) {

                         a.setBugMovingDirection((int) (Math.random()*7)+1);

             } else if(boundsInScene.getMinX() >= 600 && (r==2||r==3 || r==4)) {

            	 a.setBugMovingDirection((int) (Math.random()*7)+1);

             } else if(boundsInScene.getMinY() >= 600 && (r==4||r==5 || r==6)) {

            	 a.setBugMovingDirection((int) (Math.random()*7)+1);

             } else if(boundsInScene.getMinX() < 0 && (r==6||r==7 || r==8)) {

            	 a.setBugMovingDirection((int) (Math.random()*7)+1);

             }

             
             a.setY(boundsInScene.getMinY());

             a.setX(boundsInScene.getMinX());

//             Bounds object1 = i.getBoundsInParent();
             
             
             
//             for (int ii=0; ii<objects.size(); ii++) {
//            	ObjectTest o= objects.get(ii);
//            	 Bounds object2 = o.getImageView().getBoundsInParent();
//
//             if (object1.intersects(object2) && a instanceof LadyBirdTest && o instanceof FlowerTest) {               
//             g.getChildren().remove(o.getImageView());
//             objects.remove(o);
//            
//             }
//             }
//             
             
             

             //This will move the bug within the frame

             i.setTranslateX(i.getTranslateX()+dx);

             i.setTranslateY(i.getTranslateY()+dy);
//checkForCollision();
             
 });
		return frame;
		}
	
//	private void checkForCollision (){
//		for (int i = 0; i < objects.size(); i++) {
//
//			for (int j = i + 1; j < objects.size(); j++) {
//
//				ImageView image1 = viewImage(objects.get(i));
//				ImageView image2 = viewImage(objects.get(j));
//
//				if (image1.getBoundsInParent().intersects(image2.getBoundsInParent())) {
//
//					if (objects.get(i) instanceof Ladybird && objects.get(j) instanceof Flower) {
//						objects.remove(i);
//						
//					} 
//						
//
//				}
//
//			}
//
//		}
//	}


	public static void main(String[] args) {
		launch(args);
	}
}
