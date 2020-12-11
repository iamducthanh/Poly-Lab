package bai2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textCalculator;
	StringBuilder calculator = new StringBuilder();
	String phepTinh = "";
	double ketQua = 0;
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn0 = new JButton("0");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	DecimalFormat fm = new DecimalFormat("#.###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setTitle("Coculator");
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CASIO", JLabel.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(217, 11, 118, 36);
		contentPane.add(lblNewLabel);

		textCalculator = new JTextField();
		textCalculator.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				getKeyButton(e.getKeyChar());
			}
		});
		textCalculator.setEditable(false);
		textCalculator.setToolTipText("");
		textCalculator.setFont(new Font("Tahoma", Font.BOLD, 17));
		textCalculator.setHorizontalAlignment(JTextField.RIGHT);
		textCalculator.setBounds(10, 49, 325, 36);
		contentPane.add(textCalculator);
		textCalculator.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textCalculator.setColumns(10);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn1.getText());
			}
		});
		btn1.setBackground(SystemColor.activeCaptionBorder);
		btn1.setBounds(10, 96, 57, 30);
		contentPane.add(btn1);

		btn2.setBackground(SystemColor.activeCaptionBorder);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn2.getText());
			}
		});
		btn2.setBounds(77, 96, 57, 30);
		contentPane.add(btn2);

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn3.getText());
			}
		});
		btn3.setBackground(SystemColor.activeCaptionBorder);
		btn3.setBounds(144, 96, 57, 30);
		contentPane.add(btn3);

		JButton btnChia = new JButton("/");
		btnChia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getKetQua("/");
			}
		});
		btnChia.setBackground(SystemColor.activeCaptionBorder);
		btnChia.setBounds(211, 96, 57, 30);
		contentPane.add(btnChia);

		JButton btnSqrt = new JButton("sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonMath(btnSqrt.getText());
			}
		});
		btnSqrt.setBackground(SystemColor.activeCaptionBorder);
		btnSqrt.setBounds(278, 96, 57, 30);
		contentPane.add(btnSqrt);

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn4.getText());
			}
		});
		btn4.setBackground(SystemColor.activeCaptionBorder);
		btn4.setBounds(10, 130, 57, 30);
		contentPane.add(btn4);

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn5.getText());
			}
		});
		btn5.setBackground(SystemColor.activeCaptionBorder);
		btn5.setBounds(77, 130, 57, 30);
		contentPane.add(btn5);

		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn6.getText());
			}
		});
		btn6.setBackground(SystemColor.activeCaptionBorder);
		btn6.setBounds(144, 130, 57, 30);
		contentPane.add(btn6);

		JButton btnNhan = new JButton("*");
		btnNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getKetQua("*");
			}
		});
		btnNhan.setBackground(SystemColor.activeCaptionBorder);
		btnNhan.setBounds(211, 130, 57, 30);
		contentPane.add(btnNhan);

		JButton btnPhanTram = new JButton("%");
		btnPhanTram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonMath(btnPhanTram.getText());
			}
		});
		btnPhanTram.setBackground(SystemColor.activeCaptionBorder);
		btnPhanTram.setBounds(278, 130, 57, 30);
		contentPane.add(btnPhanTram);

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn7.getText());
			}
		});
		btn7.setBackground(SystemColor.activeCaptionBorder);
		btn7.setBounds(10, 164, 57, 30);
		contentPane.add(btn7);

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn0.getText());
			}
		});
		btn0.setBackground(SystemColor.activeCaptionBorder);
		btn0.setBounds(10, 199, 57, 30);
		contentPane.add(btn0);

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn8.getText());
			}
		});
		btn8.setBackground(SystemColor.activeCaptionBorder);
		btn8.setBounds(77, 164, 57, 30);
		contentPane.add(btn8);

		JButton btnAm = new JButton("+/-");
		btnAm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonMath(btnAm.getText());
			}
		});
		btnAm.setBackground(SystemColor.activeCaptionBorder);
		btnAm.setBounds(77, 199, 57, 30);
		contentPane.add(btnAm);

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCalculatorText(btn9.getText());
			}
		});
		btn9.setBackground(SystemColor.activeCaptionBorder);
		btn9.setBounds(144, 164, 57, 30);
		contentPane.add(btn9);

		JButton btnTru = new JButton("-");
		btnTru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getKetQua("-");
			}
		});
		btnTru.setBackground(SystemColor.activeCaptionBorder);
		btnTru.setBounds(211, 164, 57, 30);
		contentPane.add(btnTru);

		JButton btnNghichDao = new JButton("1/x");
		btnNghichDao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonMath(btnNghichDao.getText());
			}
		});
		btnNghichDao.setBackground(SystemColor.activeCaptionBorder);
		btnNghichDao.setBounds(278, 164, 57, 30);
		contentPane.add(btnNghichDao);

		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonC();
			}
		});
		btnC.setBackground(SystemColor.activeCaptionBorder);
		btnC.setBounds(144, 199, 57, 30);
		contentPane.add(btnC);

		JButton btnCong = new JButton("+");
		btnCong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getKetQua("+");
			}
		});
		btnCong.setBackground(SystemColor.activeCaptionBorder);
		btnCong.setBounds(211, 199, 57, 30);
		contentPane.add(btnCong);

		JButton btnBang = new JButton("=");
		btnBang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getKetQua("=");
			}
		});
		btnBang.setBackground(SystemColor.activeCaptionBorder);
		btnBang.setBounds(278, 199, 57, 30);
		contentPane.add(btnBang);
		textCalculator.setText("0");
	}

	public void setCalculatorText(String text) {

		if (phepTinh == "=") {
			buttonC();
		}
		calculator.append(text);
		textCalculator.setText(calculator.toString());
	}

	public void getKetQua(String phepTinhString) {
		double so = Double.parseDouble(textCalculator.getText());
		newForm();
	a: if (phepTinh == "" && phepTinhString == "=") {
			phepTinh = phepTinhString;
			ketQua = so;
			textCalculator.setText(String.valueOf(so));
		} else if (phepTinh == "") {
			phepTinh = phepTinhString;
			ketQua = so;
		} else {
			switch (phepTinh) {
			case "=":
				phepTinh = phepTinhString;
				break;
			case "+":
				ketQua = ketQua + so;
				break;
			case "-":
				ketQua = ketQua - so;
				break;
			case "*":
				ketQua = ketQua * so;
				break;
			case "/":
				if(so == 0) {
					buttonC();
					textCalculator.setText("Cannot divide by zero");
					break a;
				} else {
				ketQua = ketQua / so;
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + phepTinh);
			}
			phepTinh = phepTinhString;
			if (phepTinh.equals("=")) {
				printKetQua(ketQua);
				calculator.setLength(0);
			}
		}
		System.out.println(so);
		System.out.println(phepTinh);
		System.out.println("ketQua " + ketQua);
	}

	public void printKetQua(double ketQua) {
		System.out.println("Ket qua là : " + ketQua);
		textCalculator.setText(fm.format(ketQua));
	}

	public void getKeyButton(char keyChar) {
		switch (keyChar) {
		case '1': btn1.doClick();
			break;
		case '2': btn2.doClick();
			break;
		case '3': btn3.doClick();
			break;
		case '4': btn4.doClick();
			break;
		case '5': btn5.doClick();
			break;
		case '6': btn6.doClick();
			break;
		case '7': btn7.doClick();
			break;
		case '8': btn8.doClick();
			break;
		case '9': btn9.doClick();
			break;
		case '0': btn0.doClick();
			break;
		default:
			System.out.println("Nhập số thôi");
		}
	}

	public void newForm() {
		textCalculator.setText("");
		calculator.setLength(0);
	}

	public void buttonC() {
		phepTinh = "";
		ketQua = 0;
		calculator.setLength(0);
		textCalculator.setText("0");
	}

	public void buttonMath(String math) {
		double so = Double.parseDouble(textCalculator.getText());
		switch (math) {
		case "+/-":
			if (textCalculator.getText().isBlank()) {
				setCalculatorText("-");
			} else {
				so = -so;
			}
			break;
		case "1/x":
			so = 1 / so;
			break;
		case "%":
			so = so / 100;
			break;
		case "sqrt":
			so = Math.sqrt(so);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + math);
		}
		calculator.setLength(0);
		setCalculatorText(String.valueOf(so));
		printKetQua(so);
	}

}
