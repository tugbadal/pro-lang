package AcademyTechExample;

import javax.swing.JOptionPane;

public class Sifre {

	
	public static void main(String[] args) {
		String kontrol_isim = "elvantasbas";
		String k_adi = JOptionPane.showInputDialog(null, "Lutfen kullanici adinizi giriniz:");
		boolean x_flag = false;
		
		while (!k_adi.equals(kontrol_isim)){
			if(k_adi.equals("x")) {
				JOptionPane.showMessageDialog(null, "Islem sonland?r?l?yor..");
				x_flag = true;
				break;
			}
			k_adi = JOptionPane.showInputDialog(null, "Girdiginiz isim yanlis. Tekrar giriniz:");
		}
		if(x_flag) {
			JOptionPane.showMessageDialog(null, "Hoscakalin");
		}
		else {
			JOptionPane.showMessageDialog(null, "Merhaba "+k_adi);
		}
		System.exit(0);

	}

}
