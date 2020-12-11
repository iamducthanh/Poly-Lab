package bai3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Size extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblFontSize = new JLabel("Font size");
	JSlider slider = new JSlider();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Size frame = new Size();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Size() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		slider.setValue(25);
		
		slider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				getSizeFont();
			}
		});
		slider.setMaximum(50);
		slider.setBounds(10, 11, 416, 38);
		contentPane.add(slider);
		
		JLabel lblNewLabel = new JLabel("Gia tri hien tai");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(10, 82, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField("25");
		textField.setBounds(97, 79, 49, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Set value");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSizeFont();
			}
		});
		btnNewButton.setBounds(156, 78, 89, 23);
		contentPane.add(btnNewButton);
		lblFontSize.setForeground(Color.BLUE);
		lblFontSize.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		lblFontSize.setBounds(10, 127, 416, 125);
		contentPane.add(lblFontSize);
	}
	
	public void getSizeFont() {
		int size = slider.getValue();
		textField.setText(String.valueOf(size));
		lblFontSize.setFont(new Font("Tahoma", Font.PLAIN, size));
	}
	
	public void setSizeFont() {
		try {
			int size = Integer.parseInt(textField.getText());
			if(size > 50 || size < 0) {
				JOptionPane.showMessageDialog(null, "max 50, min 0");
			} else {
			lblFontSize.setFont(new Font("Tahoma", Font.PLAIN, size));
			slider.setValue(size);
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nhap sai size");
		}
	}
}
