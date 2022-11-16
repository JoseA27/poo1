package prueba;
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
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;

	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JLabel;
public class Main implements KeyListener{
		
	public static String rutaImagenes = "C:\\Users\\Erick Kauffmann\\eclipse-workspace\\ejemplo\\src\\ejemplo\\Imagen\\";
	public int dir = 0;
	public boolean dirIzq = false;
	public boolean dirDer = false;
	public boolean dirArriba = false;
	public boolean dirAbajo = false;
	
	public void Simular() {
		JFrame frame = new JFrame("Prueba");  
	    JPanel panel1 = new JPanel();
	    panel1.setSize(1300, 800);

	    frame.addKeyListener(this);
	    
	    BufferedImage myPicture = null;
	    BufferedImage myPicture2 = null;
		try {
			myPicture = ImageIO.read(new File(rutaImagenes + "Bicho4.png"));
			myPicture2 = ImageIO.read(new File(rutaImagenes + "Dano1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
	    
		Interfaz(frame, panel1);
		mostrarTrampas(panel1);
		Background(panel1);

		boolean simulacion = true;
		int s = 0;
		int x = 550;
		int y = 200;
					
		while(simulacion == true) {
			//panel1.removeAll();
			panel1.remove(picLabel);
			panel1.remove(picLabel2);
			s++;
			
			if(dirIzq == true) {
				if(x<=-100) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x -= 20;//25;//50;//75;
				}
				else {
					x -= 20;//25;//50;//75;
				}
			}
			else if(dirDer == true) {
				if(x>=1200) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					x += 20;//25;//50;//75;
				}
				else {
					x += 20;//25;//50;//75;
				}
			}
			else if(dirArriba == true) {
				if(y<=-200) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y -= 20;//25;//50;//75;
				}
				else {
					y -= 20;//25;//50;//75;
				}
			}
			else if(dirAbajo == true) {
				if(y>=600) {
					x = x;
					y = y;
				}
				else if((x>=950)&&(x<=1100)&&(y<=10)&&(y>-100)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else if((y>=550)&&(x>=300)&&(x<=900)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else if((y>=10)&&(y<=500)&&(x<=10)) {
					//x = x;
					//y = y;
					mostrarDano(panel1, x, y, picLabel2);
					y += 20;//25;//50;//75;
				}
				else {
					y += 20;//25;//50;//75;
				}
			}
			
			
			
			System.out.println("--------------------------------");
			try {
				System.out.println(s);
				//System.out.println("izquierda: " + dirIzq);
				//System.out.println("derecha: " + dirDer);
				//System.out.println("arriba: " + dirArriba);
				//System.out.println("abajo: " + dirAbajo);
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
			panel.add(picLabel);
			Dimension size = picLabel.getPreferredSize();
	        picLabel.setBounds(1000, 0, size.width, size.height);
	        
	        BufferedImage myPicture2 = null;
			myPicture2 = ImageIO.read(new File(rutaImagenes + "Trampa2.png"));
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			panel.add(picLabel2);
			Dimension size2 = picLabel2.getPreferredSize();
	        picLabel2.setBounds(350, 565, size2.width, size2.height);
	        
	        BufferedImage myPicture3 = null;
			myPicture3 = ImageIO.read(new File(rutaImagenes + "Trampa3.png"));
			JLabel picLabel3 = new JLabel(new ImageIcon(myPicture3));
			panel.add(picLabel3, 2);
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
	
	
	void mostrarDano(JPanel panel, int x, int y, JLabel picLabel) {	
		/*try {
			BufferedImage myPicture = null;
			myPicture = ImageIO.read(new File(rutaImagenes + "Dano1.png"));
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
	

	@Override
	public void keyTyped(KeyEvent e) {
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = true;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = true;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = true;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = true;
	    }
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	    if (key == KeyEvent.VK_LEFT) {
	        dirIzq = false;
	    }

	    else if (key == KeyEvent.VK_RIGHT) {
	        dirDer = false;
	    }

	    else if (key == KeyEvent.VK_UP) {
	        dirArriba = false;
	    }

	    else if (key == KeyEvent.VK_DOWN) {
	        dirAbajo = false;
	    }
	}
	
	
	
	
	 private void displayInfo(KeyEvent e, String keyStatus){
         
	        //You should only rely on the key char if the event
	        //is a key typed event.
	        int id = e.getID();
	        String keyString;
	        if (id == KeyEvent.KEY_TYPED) {
	            char c = e.getKeyChar();
	            keyString = "key character = '" + c + "'";
	        } else {
	            int keyCode = e.getKeyCode();
	            keyString = "key code = " + keyCode
	                    + " ("
	                    + KeyEvent.getKeyText(keyCode)
	                    + ")";
	        }
	         
	        int modifiersEx = e.getModifiersEx();
	        String modString = "extended modifiers = " + modifiersEx;
	        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	        if (tmpString.length() > 0) {
	            modString += " (" + tmpString + ")";
	        } else {
	            modString += " (no extended modifiers)";
	        }
	         
	        String actionString = "action key? ";
	        if (e.isActionKey()) {
	            actionString += "YES";
	        } else {
	            actionString += "NO";
	        }
	         
	        String locationString = "key location: ";
	        int location = e.getKeyLocation();
	        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	            locationString += "standard";
	        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	            locationString += "left";
	        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	            locationString += "right";
	        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	            locationString += "numpad";
	        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	            locationString += "unknown";
	        }     
	        
	        System.out.println(keyStatus + "\n"
	                + "    " + keyString + "\n"
	                + "    " + modString + "\n"
	                + "    " + actionString + "\n"
	                + "    " + locationString + "\n");
		    }
		
		
		
		
		
}




