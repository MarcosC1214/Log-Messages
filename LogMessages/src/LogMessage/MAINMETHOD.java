package LogMessage;

import java.awt.EventQueue;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import resources.SoundEffects;
import LogMessage.Gui;

public class MAINMETHOD { // Main booter method to run the whole program.

	public static SoundEffects sound = new SoundEffects();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception { // Satic method to run program. 
		FullMessages.generateFullMessages();
		
		// TODO Auto-generated method stub
		 //Main sound = new Main("resources/Nature.wav");
		 sound.Run("Micro.wav");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui Main = new Gui();
					Main.createAndShowGUI();	
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
	}
}

