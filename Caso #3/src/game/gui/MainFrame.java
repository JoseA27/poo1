package game.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.json.simple.parser.ParseException;

import game.controller.MainFrameController;
import games.roulette.Constants;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private MainFrameController controller;
	private JLabel daysLabel;
	private JLabel climaLabel;
	private JLabel estacionLabel;
	private JPanel panelPlantas;
	private ArrayList<JPanel>paneles= new ArrayList<JPanel>();;
	
	public MainFrame(String pTitle, MainFrameController pController) {
		super(pTitle);
		controller = pController;
		controller.setWindow(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(0, 0, 900, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(10,5)); // this allows this frame to locate the components with freedom in the screen
		this.setBackground(Color.GREEN);
		//this.setTitle("Caso 3");
		this.initComponents();
		
		this.setVisible(true);	
		
	}

	public void update(int pDay, String estacion, String clima) {
		daysLabel.setText(Integer.toString(pDay));
		estacionLabel.setText(estacion);
		climaLabel.setText(clima);
	}
	
	
	public void Planta(ArrayList<String>imgs) {
		int i =0;
		for (JPanel panel:paneles) {
			ImageIcon imageIcon = new ImageIcon(imgs.get(i)); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it 
			Image newimg = image.getScaledInstance(120, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			imageIcon = new ImageIcon(newimg);  // transform it back
			JLabel imagen=new JLabel(imageIcon);
			panel.removeAll();
			panel.add(imagen);
			panelPlantas.validate();
			i++;
		}
	}
	
	private void initComponents() {
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
		panel.setBackground(Color.DARK_GRAY);
		
		JLabel estacion = new JLabel("Estacion: ");
		estacion.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
		estacion.setForeground(Color.white);
    	panel.add(estacion);
    	
    	estacionLabel = new JLabel("");
    	estacionLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	estacionLabel.setForeground(Color.white);
    	panel.add(estacionLabel);
    	
    	
    	JLabel clima = new JLabel("Clima: ");
    	clima.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	clima.setForeground(Color.white);
    	panel.add(clima);
    	
    	climaLabel = new JLabel("");
    	climaLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	climaLabel.setForeground(Color.white);
    	panel.add(climaLabel);
    	
    	
    	JLabel days = new JLabel("Days: ");
    	days.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	days.setForeground(Color.white);
    	panel.add(days);
    	
    	daysLabel = new JLabel("0");
    	daysLabel.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	daysLabel.setForeground(Color.white);
    	panel.add(daysLabel);
    	
    	
    	panelPlantas = new JPanel(new GridLayout(5,5));
    	panelPlantas.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
    	panelPlantas.setBackground(Color.white);
    	
    	
    	
    	JScrollPane scrollPane = new JScrollPane(panelPlantas);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        this.add(panelPlantas);
		//Botones Planta
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
		panelButton.setBackground(Color.DARK_GRAY);
		
		JButton buttonPlanta = new JButton("Cactus");  
		buttonPlanta.setBackground(Color.orange);
		buttonPlanta.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			try {
					controller.crearPlanta(2);
					
					JPanel newPlant = new JPanel();
					newPlant.setSize(new Dimension(50,30));
					newPlant.setLayout(new FlowLayout(FlowLayout.CENTER, 40,30));
					newPlant.setBackground(Color.red);
					paneles.add(newPlant);
					panelPlantas.add(newPlant);
					panelPlantas.validate();
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
				}
    		}  
    	});
		panelButton.add(buttonPlanta);
		
		JButton buttonCulantro = new JButton("Culantro");  
		buttonCulantro.setBackground(Color.orange);
		buttonCulantro.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			try {
					controller.crearPlanta(0);
					JPanel newPlant = new JPanel();
					newPlant.setSize(new Dimension(50,30));
					newPlant.setLayout(new FlowLayout(FlowLayout.CENTER, 40,30));
					newPlant.setBackground(Color.blue);
					panelPlantas.add(newPlant);
					paneles.add(newPlant);
					panelPlantas.validate();
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
				}
    		}  
    	});
		panelButton.add(buttonCulantro);
		
		JButton buttonLimon = new JButton("Limon");  
		buttonLimon.setBackground(Color.orange);
		buttonLimon.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			try {
					controller.crearPlanta(1);
					JPanel newPlant = new JPanel();
					newPlant.setSize(new Dimension(50,30));
					newPlant.setLayout(new FlowLayout(FlowLayout.CENTER, 40,30));
					newPlant.setBackground(Color.green);
					panelPlantas.add(newPlant);
					paneles.add(newPlant);
					panelPlantas.validate();
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
				}
    		}  
    	});
		panelButton.add(buttonLimon);
		
		JButton buttonRegar = new JButton("Regar");
		buttonRegar.setBackground(Color.cyan);
		buttonRegar.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			controller.regarPlantas();
    		}  
    	});
		panelButton.add(buttonRegar);
		
		JButton buttonAbonar = new JButton("Abonar"); 
		buttonAbonar.setBackground(Color.cyan);
		buttonAbonar.addActionListener(new ActionListener(){  
    		public void actionPerformed(ActionEvent e){
    			controller.abonarPlantas();
    		}  
    	});
		panelButton.add(buttonAbonar);
		
		
		this.add(panelButton, BorderLayout.SOUTH);
		this.add(panel, BorderLayout.NORTH);

	
	
	}
}
