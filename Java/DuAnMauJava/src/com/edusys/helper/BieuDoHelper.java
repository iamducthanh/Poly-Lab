package com.edusys.helper;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class BieuDoHelper {
	//double slXuatSac, slGioi, slKha, slTrungBinh, slKem;

	@SuppressWarnings("deprecation")
	public void thongKeDiem(DefaultTableModel model, int tong) {
		double slXuatSac, slGioi, slKha, slTrungBinh, slKem;
		slXuatSac = 0;
		slGioi = 0;
		slKha = 0;
		slTrungBinh = 0;
		slKem = 0;
		
		for(int i=0;i<model.getRowCount();i++) {
			if(model.getValueAt(i, 3).equals("Xuất sắc")) {
				slXuatSac += 1;
			} else if(model.getValueAt(i, 3).equals("Giỏi")) {
				slGioi += 1;
			} else if(model.getValueAt(i, 3).equals("Khá")) {
				slKha += 1;
			} else if(model.getValueAt(i, 3).equals("Trung bình")) {
				slTrungBinh += 1;
			} else if(model.getValueAt(i, 3).equals("Kém")) {
				slKem += 1;
			}
		}

		DefaultPieDataset dataPieChart = new DefaultPieDataset();
		dataPieChart.setValue("Xuất sắc", new Double(slXuatSac / tong * 100));
		dataPieChart.setValue("Giỏi", new Double(slGioi / tong * 100));
		dataPieChart.setValue("Khá", new Double(slKha / tong * 100));
		dataPieChart.setValue("Trung bình", new Double(slTrungBinh / tong * 100));
		dataPieChart.setValue("Kém", new Double(slKem / tong * 100));
		JFreeChart freeChart = ChartFactory.createPieChart("Biểu đồ thống kê xếp loại học lực trong khóa", dataPieChart,
				true, true, true);
		ChartPanel chartPanel1 = new ChartPanel(freeChart);
		JFrame bieuDo = new JFrame();
		bieuDo.getContentPane().add(chartPanel1);
		bieuDo.setTitle("Biểu đồ thống kê xếp loại học lực trong khóa");
		bieuDo.setSize(400, 300);
		bieuDo.setLocationRelativeTo(null);
		bieuDo.setResizable(false);
		bieuDo.setVisible(true);
	}
	
	public void thongKeNguoiHoc(DefaultTableModel model1) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(int i=0;i<model1.getRowCount();i++) {
			Number soNguoi = (Number) model1.getValueAt(i, 1);
			String nam = String.valueOf(model1.getValueAt(i, 0));
			dataset.addValue(soNguoi, "Số người", nam);
		}
		JFreeChart barChart = ChartFactory.createBarChart("Biểu đồ thống kê lượng người học qua các năm", "Năm", "Số người", dataset, PlotOrientation.VERTICAL, false, false, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.getContentPane().add(chartPanel);
        frame.setTitle("Biểu đồ thống kê lượng người học qua các năm");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
	}
}
