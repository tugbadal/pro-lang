package AcademyTechExample;

import javax.swing.JOptionPane;


public class Menu {

	
	public static void main(String[] args) {
		boolean secim_flag = true;
		while (secim_flag) {
			
			String secim = JOptionPane.showInputDialog(null, "Bir sayi giriniz: (1, 2, 3, 4)");
			int sayi = Integer.parseInt(secim);
			secim_flag = false;
			
			switch (sayi) {
			case 1:
				JOptionPane.showMessageDialog(null, "Sectiginiz sayi: bir");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Sectiginiz sayi: iki");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Sectiginiz sayi: uc");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Sectiginiz sayi: dort");
				break;
			default:
				secim_flag = true;
				JOptionPane.showMessageDialog(null, "Beklenenden farkli bir sayi girdiniz");
				break;
			}
		}
		System.exit(0);
	}
}
