package bai1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButtonMenuItem;

public class MenuJava3 extends JFrame {

	private JPanel contentPane;
	JEditorPane editorPane = new JEditorPane();
	static MenuJava3 frame = new MenuJava3();
	JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("Menu java 3");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MenuJava3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNew.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\new.png"));
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\open.png"));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\save.png"));
		mnFile.add(mntmSave);
		
		JMenu mnColor = new JMenu("Color");
		menuBar.add(mnColor);
		
		JRadioButtonMenuItem rdbtnmntmRed = new JRadioButtonMenuItem("Red");
		mnColor.add(rdbtnmntmRed);
		
		JRadioButtonMenuItem rdbtnmntmGreen = new JRadioButtonMenuItem("Green");
		mnColor.add(rdbtnmntmGreen);
		
		JRadioButtonMenuItem rdbtnmntmBlue = new JRadioButtonMenuItem("Blue");
		mnColor.add(rdbtnmntmBlue);
		
		JSeparator separator = new JSeparator();
		mnColor.add(separator);
		
		JMenuItem mntmTextColor = new JMenuItem("Text color");
		mnColor.add(mntmTextColor);
		
		JMenu mnSystem = new JMenu("System");
		menuBar.add(mnSystem);
		
		JMenuItem mntmAbount = new JMenuItem("Abount us");
		mnSystem.add(mntmAbount);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		mnSystem.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 426, 47);
		contentPane.add(toolBar);
		
		JButton btnNew = new JButton("");
		btnNew.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\newTool.png"));
		btnNew.setContentAreaFilled(false);
		toolBar.add(btnNew);
		
		JButton btnSystem = new JButton("");
		btnSystem.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\userTool.png"));
		btnSystem.setContentAreaFilled(false);
		toolBar.add(btnSystem);
		
		JButton btnExit = new JButton("");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab4\\src\\image\\exitTool.png"));
		btnExit.setContentAreaFilled(false);
		toolBar.add(btnExit);
		
		editorPane.setBounds(10, 58, 416, 131);
		contentPane.add(editorPane);
		
		panel.setBackground(Color.GREEN);
		panel.setBounds(10, 200, 416, 30);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Fpoly - Java 3", JLabel.CENTER);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNew.addActionListener(newFile);
		mntmNew.addActionListener(newFile);
		mntmSave.addActionListener(saveFile);
		mntmTextColor.addActionListener(colorChose);
		btnSystem.addActionListener(abount);
		mntmAbount.addActionListener(abount);
		
		ButtonGroup rdo = new ButtonGroup();
		rdo.add(rdbtnmntmBlue);
		rdo.add(rdbtnmntmRed);
		rdo.add(rdbtnmntmGreen);
		rdbtnmntmBlue.addActionListener(colorEdit);
		rdbtnmntmRed.addActionListener(colorEdit);
		rdbtnmntmGreen.addActionListener(colorEdit);
	}
	
	public void openFile() {
		JFileChooser file = new JFileChooser();
		int i = file.showOpenDialog(null);
		if(i == 0) {
			String path = file.getSelectedFile().getPath();
			System.out.println(path);
			try {
				editorPane.setPage("file:///" + path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Không thể đọc file vừa chọn!");
			}
		}
	}
	
	ActionListener newFile = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			editorPane.setText("");
		}
	};
	
	ActionListener saveFile = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser file = new JFileChooser();
			int i = file.showSaveDialog(null);
			if(i == 0) {
				String path = file.getSelectedFile().getPath();
				try {
					PrintWriter pw = new PrintWriter(path);
					pw.println(editorPane.getText());
					pw.close();
					JOptionPane.showMessageDialog(null, "Save file thành công!");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener colorEdit = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String color = e.getActionCommand();
			switch (color) {
			case "Red": 
					panel.setBackground(Color.red);
				break;
			case "Blue": 
				panel.setBackground(Color.blue);
				break;
			case "Green": 
				panel.setBackground(Color.green);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + color);
			}
		}
	};
	
	ActionListener colorChose = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color color = JColorChooser.showDialog(null, "Chọn màu text", null);
			panel.setBackground(color);
		}
	};
	
	ActionListener abount = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "Program Demo Menu \nAuthor: Thanhndph12794 \nLast update: 18-11-2020 \nEducation: Fpoly");
		}
	};
}
