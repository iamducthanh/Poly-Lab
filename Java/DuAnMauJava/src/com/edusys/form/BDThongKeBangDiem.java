package com.edusys.form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BDThongKeBangDiem extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDThongKeBangDiem frame = new BDThongKeBangDiem();
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
	JPanel panel = new JPanel();
	public BDThongKeBangDiem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(10, 11, 652, 417);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piechart();
			}
		});
		panel.add(btnNewButton);
		
		
	}
	
	
    public void piechart() {
    	DefaultPieDataset pieDataset = new DefaultPieDataset();
    	pieDataset.setValue("Giỏi", new Integer(10));
    	pieDataset.setValue("Khá", new Integer(10));
    	pieDataset.setValue("Trung bình", new Integer(10));
    	pieDataset.setValue("yếu", new Integer(10));
    	JFreeChart freeChart = ChartFactory.createPieChart("Bieu do", pieDataset, true, true, true);
    	Plot piePlot3D =  freeChart.getPlot();
    	piePlot3D.setForegroundAlpha(TOP_ALIGNMENT);
    	ChartFrame frame = new ChartFrame("bieudo", freeChart);

    	frame.setVisible(true);
    }
}
