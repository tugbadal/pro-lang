package n11_test;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginPage {
	private WebDriver driver;
	
	@Test
	public void openBrowser(){
		
		// tarayýcýyý açar ve facebookla login olacaðý sayfaya gider
		driver = new FirefoxDriver();
		driver.get("https://www.n11.com/giris-yap");
		driver.get("https://www.facebook.com/login.php?skip_api_login=1&api_key=1374274239476709&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.2%2Fdialog%2Foauth%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.n11.com%252Fsocial%252FWEB_REGULAR_FB%252FfacebookConnectCallback%26display%3Dpopup%26scope%3Demail%252Cpublic_profile%252Cuser_birthday%252Cuser_friends%252Cuser_location%252Cuser_relationship_details%252Cuser_relationships%252Cuser_work_history%26client_id%3D1374274239476709%26ret%3Dlogin&cancel_url=https%3A%2F%2Fwww.n11.com%2Fsocial%2FWEB_REGULAR_FB%2FfacebookConnectCallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%23_%3D_&display=popup");
		
		
		// facebook ile login olunur
		driver.findElement(By.id("email")).sendKeys("hotmail");
		driver.findElement(By.id("pass")).sendKeys("facebookpassword");
		driver.findElement(By.id("u_0_2")).click();
		
		driver.get("http://www.n11.com/");
		driver.findElement(By.linkText("Kitap, Müzik, Film, Oyun")).click();
		driver.findElement(By.linkText("Kitap")).click();
		driver.findElement(By.linkText("Yazarlar")).click();
		driver.get("http://www.n11.com/yazarlar");
		
		java.util.List <WebElement> authors = driver.findElements(By.tagName("a"));	
		int acount = 0;
		boolean startA = true;
		for (WebElement link : authors){
			//System.out.println(link.getText());
			//System.out.println(link.getAttribute("href"));
			String a = link.getAttribute("href");
		
			if (a != null){
				
				if (a.contains("kitap?yzr")){
					acount = acount + 1;
					int boy = a.length();
					String yazdirilacakyazarlar = a.substring(29, boy);
					System.out.println(yazdirilacakyazarlar);
					if (yazdirilacakyazarlar.startsWith("A")){
						startA = true;
					}
					else {
						startA = false;
					}
				}
			}
		}
		
		System.out.printf("ilk sayfadaki toplam yazar sayýsý: %s ve isimleri yukarýdadýr", acount);
		
		Assert.assertTrue("A ile baþlamayan yazar var", startA == true);
		
		/*
		if (startA == true){
			System.out.println("ve tüm yazarlarýn baþharfi doðrudur");
		}
		else {
			System.out.println("yazarlarýn baþharfinde yanlýþlýk var");
		}
		*/
		
	}
	
	

}
