package AcademyTechExample;

import javax.swing.JOptionPane;

public class IsimGir {

	public static void main(String[] args) {
		String isim = JOptionPane.showInputDialog(null, "Lütfen isminizi giriniz:");
		String yas;
		yas = JOptionPane.showInputDialog(null, "Þimdi de yasýnýzý giriniz:");
		
		String rapor = "Adýnýz:" + isim + "\nYasýnýz:" +yas;
		JOptionPane.showMessageDialog(null, rapor);
		System.exit(0);
	}

}
