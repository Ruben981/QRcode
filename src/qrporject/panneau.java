package qrporject;

import java.awt.Graphics;
import java.awt.Image;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import qrporject.Direction;
import qrporject.QR;
import qrporject.Room;
import qrporject.Day;
import qrporject.Time;
import qrporject.Sound;


public class panneau extends JPanel  { 
	
	protected int state=0;
	protected int select=0;
	
	int test=0;
	
	static JTextField textField = null;
	static String qrCodeData ;
	static String filePath ;
	
	static QR qr;
	static Room room = new Room();
	static Direction directions = new Direction();
	static Day day= new Day();
	static Time time = new Time();
	static Sound sound = new Sound();
	
  public void paintComponent(Graphics g){
	  		
	  try {
	      Image img = ImageIO.read(new File("1521703677.jpg"));
	      //g.drawImage(img, 0, 0, this);
	      //Pour une image de fond
	      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      
	      Font font = new Font("Courier", Font.BOLD, 20);
	      g.setFont(font);
	      
	    if(state==0) {
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	      g.setColor(Color.white);
		  g.drawString("Scan a QR code",540 , 400);
	      g.setColor(Color.orange);
	      g.drawRoundRect(530, 380, 190, 25, 10, 10);
	    }
	    else if(state==1) {
	    	  img = ImageIO.read(new File("fond2.jpg"));
	    	  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		      
		    }
	    else if (state==2){
	    	img = ImageIO.read(new File("aurore-boreale-7.jpg"));// img white background
	    	g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    	
	    	Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	    	
	    	switch(select) {
	    	case 1:
	    		test=0;
	    		g.setColor(Color.white);
	    		filePath = "myQRCode1.png";
	    		qr = new QR (filePath);
	    		String QRdata = qr.readQRCode(filePath, hintMap);
	    		String theRoom = room.get(QRdata);
	    		String theDay = day.get(QRdata);
	    		String thetime = time.get(QRdata);
				// get directions
	    		
	    		if((theDay==null)||(theRoom==null) ||(thetime==null)) {
	    			g.drawString("the scanned QR code do not fit the format",500 , 400);
	    			sound.playit(sound.form);
	    			test=1;
	    		}
	    		else if (directions.goodDay(theDay) == false ) {
	    			g.drawString("This is not the good day",500 , 400);
	    			sound.playit(sound.date);
	    			
	    			test=1;
	    		}
	    		else if (directions.validate(theRoom) == false) {
					g.drawString("The directions to this room are unknown",500 , 400);
					sound.playit(sound.room);
					
					test=1;
				}
	    		else if (directions.onTime(thetime) == false) {
	    			g.drawString("the class has started ",500 , 400);
	    			sound.playit(sound.time);
	    			
	    			test=1;
	    		}
	    		
				else if (test==0){
					g.setColor(Color.white);
					g.drawString(QRdata, 500, 200);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString(directions.toBuilding(),100 , 415);
					g.drawString(directions.toFloor(),300 , 430);
					g.drawString(directions.toLocation(),300 , 445);
					sound.playit(sound.QR1);
					
				}
	    		
	    		break;
	    	case 2:
	    		test=0;
	    		g.setColor(Color.white);
	    		filePath = "myQRCode2.png";
	    		qr = new QR (filePath);
	    		String QRdata2 = qr.readQRCode(filePath, hintMap);
	    		String theRoom2 = room.get(QRdata2);
	    		String theDay2 = day.get(QRdata2);
	    		String thetime2 = time.get(QRdata2);
				// get directions
	    		if((theDay2==null)||(theRoom2==null) ||(thetime2==null)) {
	    			g.drawString("the scanned QR code do not fit the format",500 , 400);
	    			sound.playit(sound.form);
	    			test=1;
	    		}
	    		else if (directions.goodDay(theDay2) == false ) {
	    			g.drawString("This is not the good day",500 , 400);
	    			sound.playit(sound.date);
	    			sound.delayfor(7);
	    			test=1;
	    		}
	    		else if (directions.validate(theRoom2) == false) {
					g.drawString("The directions to this room are unknown",500 , 400);
					sound.playit(sound.room);
					
					test=1;
				}
	    		else if (directions.onTime(thetime2)== false ) {
	    			g.drawString("the class has started ",500 , 400);
	    			sound.playit(sound.time);
	    			test=1;
	    		}
	    		
				else if (test==0){
					g.setColor(Color.white);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString(directions.toBuilding(),100 , 415);
					g.drawString(directions.toFloor(),300 , 430);
					g.drawString(directions.toLocation(),300 , 445);
					sound.playit(sound.QR2);
					
				}
	    	case 3:
	    		test=0;
	    		g.setColor(Color.white);
	    		filePath = "myQRCode3.png";
	    		qr = new QR (filePath);
	    		String QRdata3 = qr.readQRCode(filePath, hintMap);
	    		String theRoom3 = room.get(QRdata3);
				
	    		String theDay3 = day.get(QRdata3);
	    		String thetime3 = time.get(QRdata3);
				// get directions
	    		if((theDay3==null)||(theRoom3==null) ||(thetime3==null)) {
	    			g.drawString("the scanned QR code do not fit the format",500 , 400);
	    			sound.playit(sound.form);
	    			test=1;
	    		}
	    		
	    		else if (directions.goodDay(theDay3) == false ) {
	    			g.drawString("This is not the good day",500 , 400);
	    			sound.playit(sound.date);
	    			
	    			test=1;
	    		}
	    		else if (directions.validate(theRoom3) == false) {
					g.drawString("The directions to this room are unknown",500 , 400);
					sound.playit(sound.room);
					
					test=1;
				}
	    		else if (directions.onTime(thetime3)== false ) {
	    			g.drawString("the class has started ",500 , 400);
	    			sound.playit(sound.time);
	    			sound.delayfor(7);
	    			test=1;
	    		}
	    		
				else if (test==0){
					g.setColor(Color.white);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString(directions.toBuilding(),100 , 415);
					g.drawString(directions.toFloor(),300 , 430);
					g.drawString(directions.toLocation(),300 , 445);
					sound.playit(sound.QR3);
					
				}
	    		break;
	    	case 4:
	    		test=0;

	    		filePath = "myQRCode4.png";
	    		qr = new QR (filePath);
	    		String QRdata4 = qr.readQRCode(filePath, hintMap);
	    		String theRoom4 = room.get(QRdata4);
	    		String theDay4 = day.get(QRdata4);
	    		String thetime4 = time.get(QRdata4);
				// get directions
	    		g.setColor(Color.white);
	    		
	    		if((theDay4==null)||(theRoom4==null) ||(thetime4==null)) {
	    			g.drawString("the scanned QR code do not fit the format",500 , 400);
	    			sound.playit(sound.form);
	    			test=1;
	    		}
	    		else if (directions.goodDay(theDay4) == false ) {
	    			g.drawString("This is not the good day",500 , 400);
	    			sound.playit(sound.date);
	    			
	    			test=1;
	    		}
	    		else if (directions.validate(theRoom4) == false) {
					g.drawString("The directions to this room are unknown",500 , 400);
					sound.playit(sound.room);
					
					test=1;
				}
	    		else if (directions.onTime(thetime4)== false) {
	    			g.drawString("the class has started ",500 , 400);
	    			sound.playit(sound.time);
	    			
	    			test=1;
	    		}
	    		
				else if (test==0){
					g.setColor(Color.white);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString(directions.toBuilding(),100 , 415);
					g.drawString(directions.toFloor(),300 , 430);
					g.drawString(directions.toLocation(),300 , 445);
					
				}
	    		break;
	    	case 5:
	    		test=0;
	    		g.setColor(Color.white);
	    		filePath = "myQRCode5.png";
	    		qr = new QR (filePath);
	    		String QRdata5 = qr.readQRCode(filePath, hintMap);
	    		String theRoom5 = room.get(QRdata5);
	    		String theDay5 = day.get(QRdata5);
	    		String thetime5 = time.get(QRdata5);
				// get directions
	    		
	    		if((theDay5==null)||(theRoom5==null) ||(thetime5==null)) {
	    			g.drawString("the scanned QR code do not fit the format",500 , 400);
	    			sound.playit(sound.form);
	    			test=1;
	    		}
	    		
	    		else if (directions.goodDay(theDay5) == false ) {
	    			g.drawString("This is not the right day",500 , 400);
	    			sound.playit(sound.date);
	    			
	    			test=1;
	    		}
	    		else if (directions.validate(theRoom5) == false) {
					g.drawString("The directions to this room are unknown",500 , 400);
					sound.playit(sound.room);
					sound.delayfor(7);
					test=1;
				}
	    		else if (directions.onTime(thetime5)== false) {
	    			g.drawString("the class has started ",500 , 400);
	    			sound.playit(sound.time);
	    			
	    			test=1;
	    		}
	    		
				else if (test==0){
					g.setColor(Color.white);
					g.drawString("DIRECTIONS",540 , 400);
					g.drawString(directions.toBuilding(),100 , 415);
					g.drawString(directions.toFloor(),300 , 430);
					g.drawString(directions.toLocation(),300 , 445);
					
				}
	    		break;
	    	default : 
	    		img = ImageIO.read(new File("25302_fate_zero.jpg"));// img white background
		    	g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    		g.setColor(Color.red);
		    	g.drawString("You are a CHEATER. You Faill, it's impossible to access this menu",500 , 400);
	    		break;
	    	} 	
	    	
	    }
	      
	    } catch (IOException e) {
	      e.printStackTrace();
	    } catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
  }   
 
  }




