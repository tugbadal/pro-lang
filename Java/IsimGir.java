package AcademyTechExample;

import javax.swing.JOptionPane;

public class IsimGir {

	public static void main(String[] args) {
		String isim = JOptionPane.showInputDialog(null, "L�tfen isminizi giriniz:");
		String yas;
		yas = JOptionPane.showInputDialog(null, "�imdi de yas�n�z� giriniz:");
		
		String rapor = "Ad�n�z:" + isim + "\nYas�n�z:" +yas;
		JOptionPane.showMessageDialog(null, rapor);
		System.exit(0);
	}

}
