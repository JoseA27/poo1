package robotwar.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Ejemplo_Move {
	
		public static String rutaImagenes = "C:\\Users\\Erick Kauffmann\\eclipse-workspace\\ejemplo\\src\\ejemplo\\Imagen\\";
		public int dir = 0;
		public void Simular() {
			JFrame frame = new JFrame("Prueba");  
			//frame.getContentPane();
		    JPanel panel1 = new JPanel();
		    panel1.setSize(1300, 800);
		    JButton button1 = new JButton();
		    JButton button2 = new JButton();
		    JButton button3 = new JButton();
		    JButton button4 = new JButton();
		    JButton button5 = new JButton();
		    
		    BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File(rutaImagenes + "Bicho4.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		    
			Interfaz(frame, panel1);
			mostrarButtons(panel1, button1, button2, button3, button4, button5);
			mostrarTrampas(panel1);
			Background(panel1);
			/*panel1.setComponentZOrder(picLabel, 2); 
			panel1.setComponentZOrder(button1, 2);
			panel1.setComponentZOrder(button2, 2);
			panel1.setComponentZOrder(button3, 2);
			panel1.setComponentZOrder(button4, 2);
			panel1.setComponentZOrder(button5, 2);*/
			boolean simulacion = true;
			int s = 0;
			int x = 550;
			int y = 200;
			
			while(simulacion == true) {
				//panel1.removeAll();
				panel1.remove(picLabel);
				s++;
				int direccion = moveImagen(panel1, button1, button2, button3, button4, button5, dir);
				if(direccion == 1) {
					if(y<=-200) {
						setDir(2);
						//direccion = 2;
						//x = x;
						//y = y;
					}
					else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
						//x = x;
						//y = y;
						setDir(2);
					}
					else if((y>=550)&&(x>=300)&&(x<=900)) {
						//x = x;
						//y = y;
						setDir(2);
					}
					else if((y>=10)&&(y<=500)&&(x<=10)) {
						//x = x;
						//y = y;
						setDir(2);
					}
					else {
						y -= 20;//25;//50;//75;
					}
				}
				else if(direccion == 2) {
					if(y>=600 /*panel1.getHeight()*/) {
						setDir(1);
						//direccion = 1;
						//x = x;
						//y = y;
					}
					else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
						//x = x;
						//y = y;
						setDir(1);
					}
					else if((y>=550)&&(x>=300)&&(x<=900)) {
						//x = x;
						//y = y;
						setDir(1);
					}
					else if((y>=10)&&(y<=500)&&(x<=10)) {
						//x = x;
						//y = y;
						setDir(1);
					}
					else {
						y += 20;//25;//50;//75;
					}
				}
				else if(direccion == 3) {
					if(x<=-100) {
						setDir(4);
						//direccion = 4;
						//x = x;
						//y = y;
					}
					else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
						//x = x;
						//y = y;
						setDir(4);
					}
					else if((y>=550)&&(x>=300)&&(x<=900)) {
						//x = x;
						//y = y;
						setDir(4);
					}
					else if((y>=10)&&(y<=500)&&(x<=10)) {
						//x = x;
						//y = y;
						setDir(4);
					}
					else {
						x -= 20;//25;//50;//75;
					}
				}
				else if(direccion == 4) {
					if(x>=1200/*panel1.getWidth()*/) {
						setDir(3);
						//direccion = 3;
						//x = x;
						//y = y;
					}
					else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
						//x = x;
						//y = y;
						setDir(3);
					}
					else if((y>=550)&&(x>=300)&&(x<=900)) {
						//x = x;
						//y = y;
						setDir(3);
					}
					else if((y>=10)&&(y<=500)&&(x<=10)) {
						//x = x;
						//y = y;
						setDir(3);
					}
					else {
						x += 20;//25;//50;//75;
					}
				}
				else if(direccion == 5) {
					x = x;
					y = y;
				}
				
				System.out.println("--------------------------------");
				try {
					System.out.println(s);
					//mostrarImagen(panel1, x, y);
					mostrarImagen(panel1, x, y, picLabel);
					//Background(panel1);
					
					System.out.println("--------------------------------");
					Thread.sleep(50);
					//Thread.sleep(500);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
		        panel1.revalidate();
				panel1.repaint();
			}
		}
		
	
	
		public void Interfaz(JFrame frame, JPanel panel1) {
			  
		    			
			//JPanel mainPanel = new JPanel();
			//BorderLayout mainLayout = new BorderLayout();
			//mainPanel.setLayout(mainLayout);	
			
			panel1.setLayout(null);
			panel1.setBackground(Color.GRAY);
			frame.getContentPane();
			frame.add(panel1);
			
			
			//FlowLayout f1 = new FlowLayout();
		    //panel1.setLayout(f1);
	        
					    		
		    frame.setSize(1300, 800);  
		    frame.setLocationRelativeTo(null);  
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		    frame.setVisible(true); 
		    
		}
		

		void Background(JPanel panel) {
				
			try {
				BufferedImage myPicture = null;
				myPicture = ImageIO.read(new File(rutaImagenes + "Piso5.jpg"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				//picLabel.setLocation(100, 500);
				panel.add(picLabel);
				Dimension size = picLabel.getPreferredSize();
		        picLabel.setBounds(-25, -50, size.width, size.height);
		        //panel.setComponentZOrder(picLabel, 3);
			} catch (IOException e) {
				System.out.println("Error cargando imagen ");
				e.printStackTrace();
			}
	        
	    }
		
		
		void mostrarTrampas(JPanel panel) {
			
			try {
				BufferedImage myPicture = null;
				myPicture = ImageIO.read(new File(rutaImagenes + "Trampa1.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				//picLabel.setLocation(100, 500);
				panel.add(picLabel);
				Dimension size = picLabel.getPreferredSize();
		        picLabel.setBounds(1000, 0, size.width, size.height);
		        
		        BufferedImage myPicture2 = null;
				myPicture2 = ImageIO.read(new File(rutaImagenes + "Trampa2.png"));
				JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
				//picLabel.setLocation(100, 500);
				panel.add(picLabel2);
				Dimension size2 = picLabel2.getPreferredSize();
		        picLabel2.setBounds(350, 565, size2.width, size2.height);
		        
		        BufferedImage myPicture3 = null;
				myPicture3 = ImageIO.read(new File(rutaImagenes + "Trampa3.png"));
				JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
				//picLabel.setLocation(0, 600);
				panel.add(picLabel3);
				Dimension size3 = picLabel3.getPreferredSize();
		        picLabel3.setBounds(-400, 115, size3.width, size3.height);
			} catch (IOException e) {
				System.out.println("Error cargando imagen ");
				e.printStackTrace();
			}
	        
	    }
		
		
		//void mostrarImagen(JPanel panel, int x, int y) {
		void mostrarImagen(JPanel panel, int x, int y, JLabel picLabel) {	
			/*try {
				BufferedImage myPicture = null;
				myPicture = ImageIO.read(new File(rutaImagenes + "Bicho2.gif"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				//picLabel.setLocation(100, 500);*/
				panel.add(picLabel, 0);
				//panel.add(picLabel);
				Dimension size = picLabel.getPreferredSize();
		        picLabel.setBounds(x, y, size.width, size.height);
			/*} catch (IOException e) {
				System.out.println("Error cargando imagen ");
				e.printStackTrace();
			}*/
	        
	    }
		
		
		void mostrarButtons(JPanel panel1, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
			button1.setText("up"); 
	        Dimension size2 = button1.getPreferredSize();
			button1.setBounds(75, 10, size2.width, size2.height);
	        panel1.add(button1);
	        
	        button2.setText("down"); 
	        Dimension size3 = button2.getPreferredSize();
			button2.setBounds(65, 50, size3.width, size3.height);
	        panel1.add(button2);
	        
	        button3.setText("left"); 
	        Dimension size4 = button3.getPreferredSize();
			button3.setBounds(10, 30, size4.width, size4.height);
	        panel1.add(button3);
	        
	        button4.setText("right"); 
	        Dimension size5 = button4.getPreferredSize();
			button4.setBounds(133, 30, size5.width, size5.height);
	        panel1.add(button4);
	        
	        button5.setText("stop"); 
	        Dimension size6 = button4.getPreferredSize();
			button5.setBounds(68, 85, size6.width, size6.height);
	        panel1.add(button5);
		}
		
		
		int moveImagen(JPanel panel1, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, int dir) {
			
			/*button1.setText("up"); 
	        Dimension size2 = button1.getPreferredSize();
			button1.setBounds(75, 10, size2.width, size2.height);
	        panel1.add(button1);*/			
	        button1.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		setDir(1);
	        	}  
       	    });
	        
	        /*button2.setText("down"); 
	        Dimension size3 = button2.getPreferredSize();
			button2.setBounds(65, 50, size3.width, size3.height);
	        panel1.add(button2);*/
	        button2.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		setDir(2);
	        	}  
       	    });
	        
	        
	        /*button3.setText("left"); 
	        Dimension size4 = button3.getPreferredSize();
			button3.setBounds(10, 30, size4.width, size4.height);
	        panel1.add(button3);*/
	        button3.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		setDir(3);
	        	}  
       	    });
	        
	        
	        /*button4.setText("right"); 
	        Dimension size5 = button4.getPreferredSize();
			button4.setBounds(133, 30, size5.width, size5.height);
	        panel1.add(button4);*/
	        button4.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		setDir(4);
	        	}  
       	    });
	        
	        /*button5.setText("stop"); 
	        Dimension size6 = button4.getPreferredSize();
			button5.setBounds(68, 85, size6.width, size6.height);
	        panel1.add(button5);*/
	        button5.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){
	        		setDir(5);
	        	}  
       	    });
	        
	        return dir;
		}
		
		void setDir(int num) {
			this.dir = num;
		}
}

