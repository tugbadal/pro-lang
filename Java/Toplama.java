package AcademyTechExample;

import javax.swing.JOptionPane;

public class Toplama {

	public static void main(String[] args) {
		int toplam = 0;
		for (int i = 0; i<10; i++){
			if (i % 3 == 0){
				continue;
			}
			toplam += i;
		}
		JOptionPane.showMessageDialog(null, "Toplam: " + toplam);
		System.exit(0);
	}
}
