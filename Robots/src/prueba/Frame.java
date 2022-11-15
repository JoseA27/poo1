package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import robotwar.common.IConstants;

public class Frame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Timer timer = new Timer(5,this);
	
	public Frame(int w, int h) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("ROBOTWARS");
		this.setSize(w, h);
		panel myPanel = new panel(IConstants.ARENA_WIDTH,IConstants.ARENA_HEIGTH);
		this.add(myPanel);
		timer.start();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
