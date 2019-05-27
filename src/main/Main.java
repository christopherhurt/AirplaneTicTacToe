package main;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	private Button[] buttons;
	private Listener listener;
	
	public Main(){
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		
		buttons = new Button[9];
		listener = new Listener();
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new Button();
			buttons[i].addKeyListener(listener);
			panel.add(buttons[i]);
		}
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private class Listener extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_ENTER){
				for(int i = 0; i < buttons.length; i++){
					buttons[i].setState(0);
				}
			}
		}
		
	}
	
	private class Button extends JButton implements MouseListener {
		
		private static final long serialVersionUID = -7346072758266233776L;
		
		public int state;
		
		public Button(){
			addMouseListener(this);
			state = 0;
		}
		
		public void setState(int state){
			this.state = state;
			
			if(state == 0){
				this.setIcon(null);
			}else if (state == 1){
				this.setIcon(new ImageIcon("src/res/X.png"));
			}else{
				this.setIcon(new ImageIcon("src/res/O.png"));
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e){
			if(e.getButton() == MouseEvent.BUTTON1){
				state = (state + 1) % 3;
				setState(state);
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String args[]){
		new Main();
	}
	
}
