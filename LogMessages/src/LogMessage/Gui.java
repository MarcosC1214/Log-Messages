package LogMessage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import resources.Images;
import resources.SoundEffects;

import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JPanel { // GUI class for all visible panels and effects.
	
	public static SoundEffects sound = new SoundEffects();
	protected static final String inputValue = null;
	private static final long serialVersionUID = 1L;
	private javax.swing.Timer timer;
	private int index = 0;
	private Panel panel_1;
	private Panel panel_2;
	static JFrame frame;
	
	SoundEffects sound2 = new SoundEffects();
	Images image = new Images();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	void createAndShowGUI() throws IOException { // GUI initializer method that runs all panels.
		
		JFrame frmMainMenu = new JFrame("Main Menu");
		frmMainMenu.setBackground(Color.BLACK);
		frmMainMenu.getContentPane().setBackground(Color.BLACK);
		frmMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rober\\Desktop\\870px-Unofficial_Windows_logo_variant_-_2002\u20132012_(Multicolored).svg.png"));
		frmMainMenu.setBounds(600, 180, 500, 500);
		frmMainMenu.setTitle("Marcosoft Windows");
		frmMainMenu.getContentPane().setForeground(Color.GREEN);
		frmMainMenu.getContentPane().setLayout(new GridLayout(5, 5, 5, 5));
		frmMainMenu.setMaximumSize(new Dimension(100,100));
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		frmMainMenu.getContentPane().add(menuBar);
		
		JButton btnNewButton = new JButton("Show Messages");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.GREEN);
		menuBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.showMessages(); 
			}
		});
		
		JButton btnNewButton_1 = new JButton("Search Messages");
		btnNewButton_1.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBackground(Color.BLACK);
		menuBar.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.search();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Add Messages");
		btnNewButton_2.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.GREEN);
		menuBar.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.addMessage();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Remove Messages");
		btnNewButton_3.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_3.setForeground(Color.GREEN);
		btnNewButton_3.setBackground(Color.BLACK);
		menuBar.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.remove();
			}
		});
		
		JButton btnNewButton_4 = new JButton("Generate Random");
		btnNewButton_4.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnNewButton_4.setBackground(Color.BLACK);
		btnNewButton_4.setForeground(Color.GREEN);
		menuBar.add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.addRandomDes();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Show Total Count");
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setForeground(Color.GREEN);
		btnNewButton_5.setFont(new Font("Consolas", Font.PLAIN, 11));
		menuBar.add(btnNewButton_5);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullMessages.showCount();
			}
		});
		
		final JTextArea txtrPleaseEnterIn = new JTextArea();
		txtrPleaseEnterIn.setText("Click and press enter below to begin.\n");
		
		txtrPleaseEnterIn.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrPleaseEnterIn.setMinimumSize(new Dimension(0, 50));
		txtrPleaseEnterIn.setMargin(new Insets(25, 25, 25, 25));
		txtrPleaseEnterIn.setForeground(Color.GREEN);
		txtrPleaseEnterIn.setDisabledTextColor(Color.GREEN);
		txtrPleaseEnterIn.setBackground(new Color (0,0,0));
		frmMainMenu.getContentPane().add(txtrPleaseEnterIn);
		
		txtrPleaseEnterIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String message = " Welcome to Marcosoft Windows! Navigate through the Menu listed above!";
					slowPrint(message, 50);
				}
			}
			
			 public void slowPrint(final String message, int millisPerChar) {
			        txtrPleaseEnterIn.setEditable(false);
			        txtrPleaseEnterIn.setFocusable(false);

			        final Timer timer = new Timer(millisPerChar, null);
			        timer.addActionListener(new ActionListener() {
			            int counter = 0;

			            @Override
			            public void actionPerformed(ActionEvent e) {
			                txtrPleaseEnterIn.append(String.valueOf(message.charAt(counter++)));
			                txtrPleaseEnterIn.setCaretPosition(txtrPleaseEnterIn.getDocument().getLength());
			                if (counter >= message.length()) {
			                    timer.stop();
			                    txtrPleaseEnterIn.setEditable(true);
			                    txtrPleaseEnterIn.setFocusable(true);
			                    txtrPleaseEnterIn.requestFocusInWindow();
			                }
			            }
			        });
			        timer.start();
			    }
		});
		
		
		
        frmMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try 
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
           e.printStackTrace();
        }

        frmMainMenu.pack();
        frmMainMenu.setVisible(true);
	}
	public void SoundPlusImage(String s, String x, String y, String z) throws Exception { // Sound effects method.
        SoundEffects.clip1.stop();
        sound2.Run2(s);
        image.display(x, y, z);
        SoundEffects.clip2.stop();
        SoundEffects.clip1.start();
    }
}

