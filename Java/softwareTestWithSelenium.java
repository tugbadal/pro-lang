package n11_test;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class n11_all_test {
	private WebDriver driver;
	
	@Before
	public  void openBrowser(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void tests(){
		// giriþ yap > facebook ile giriþ sayfasýna gidiyor
		driver.get("https://www.n11.com/giris-yap");
		driver.get("https://www.facebook.com/login.php?skip_api_login=1&api_key=1374274239476709&signed_next=1&next=https%3A%2F%2Fwww.facebook.com%2Fv2.2%2Fdialog%2Foauth%3Fredirect_uri%3Dhttps%253A%252F%252Fwww.n11.com%252Fsocial%252FWEB_REGULAR_FB%252FfacebookConnectCallback%26display%3Dpopup%26scope%3Demail%252Cpublic_profile%252Cuser_birthday%252Cuser_friends%252Cuser_location%252Cuser_relationship_details%252Cuser_relationships%252Cuser_work_history%26client_id%3D1374274239476709%26ret%3Dlogin&cancel_url=https%3A%2F%2Fwww.n11.com%2Fsocial%2FWEB_REGULAR_FB%2FfacebookConnectCallback%3Ferror%3Daccess_denied%26error_code%3D200%26error_description%3DPermissions%2Berror%26error_reason%3Duser_denied%23_%3D_&display=popup");
		
		// kullanýcý adý ve þifre ile login oluyor
		driver.findElement(By.id("email")).sendKeys("eposta");
		driver.findElement(By.id("pass")).sendKeys("facebookpassword");
		driver.findElement(By.id("u_0_2")).click();
		
		// getTitle ile control ediliyor
		Assert.assertEquals("n11.com",driver.getTitle());
		
		// sýrasýyla kitap,müzik,film,oyun > kitap > yazarlar linklerine týklar ve yazarlar sayfasýna gider
		driver.get("http://www.n11.com/");
		driver.findElement(By.linkText("Kitap, Müzik, Film, Oyun")).click();
		driver.findElement(By.linkText("Kitap")).click();
		driver.findElement(By.linkText("Yazarlar")).click();
		driver.get("http://www.n11.com/yazarlar");
		
		// gelen yazarlar sayfasýnda ki bütün linkleri alýyor.
		java.util.List <WebElement> all_links = driver.findElements(By.tagName("a"));	
		boolean is_startA = true; // yazarýn basharfi A mý? varsayýlan true
		ArrayList firstpage_authorlist = new ArrayList(); // ilk sayfadaki yazarlarýn listesini tutacak liste
		for (WebElement link : all_links){
			
			// linklerin href deðerinden bir string oluþturuyor
			String a = link.getAttribute("href");
			// bütün linkler listesinde null deðerli elemanlar olduðu için bu kontrol yapýlýyor
			if (a != null){
				// sadece yazarlarýn linkinde 'kiyap?yzr' ifadesi olduðu için bu þart yazýldý
				if (a.contains("kitap?yzr")){
					
					int boy = a.length();
					//linkten yazarýn adýný alýyor, stringde 29 dan sonrasý yazarýn adý
					String author_name = a.substring(29, boy);
					System.out.println(author_name);
					// yazarýn isimlerini listeye ekliyor
					firstpage_authorlist.add(author_name);
					
					if (author_name.startsWith("A")){
						is_startA = true; // eklediði elemanýn ilk harfi a ise deðer hala true kalýyor
					}
					else {
						is_startA = false; // A deðilse false yapýyor
					}
				}
			}
		}
		// sayfadaki yazar sayýsý 80 mi kontrolü
		Assert.assertEquals(80, firstpage_authorlist.size());
		System.out.printf("ilk sayfadaki toplam yazar sayýsý: %s ve isimleri yukarýdadýr", firstpage_authorlist.size());
		
		// Tüm yazarlarýn baþharfleri A mý kontrolü yapýlýyor , deðer true  deðilse mesajý verecek
		Assert.assertTrue(is_startA == true, "Sayfada A ile baþlamayan yazar var");
		
		driver.get("http://www.n11.com/yazarlar/A?pg=2");
		java.util.List <WebElement> secondpage_alllinks = driver.findElements(By.tagName("a"));		
		ArrayList secondpage_authorlist = new ArrayList();
		
		for (WebElement link : secondpage_alllinks){
			String b = link.getAttribute("href");
			if (b != null){
				if (b.contains("kitap?yzr")){
					int boy = b.length();
					String authorname2 = b.substring(29, boy);
					secondpage_authorlist.add(authorname2);
				}
			}	
		}
		
		/* NOT : Ýlk sayfanýn son sýradaki yazarý 2. sayfada var mý? kontrolü Ahmet Hamdi Tanpýnar ve
		Ahmet Hamdi TANPINAR gibi yazýmlar olduðu için eðer harf duyarlýlýðýna göre yapýlýrsa
		yok çýkýyor. Ama büyük küçük harflere duyarsýz yaparsak var çýkýyor.
		*/
		
		Assert.assertNotEquals(firstpage_authorlist.get((firstpage_authorlist.size()-1)) , secondpage_authorlist.get(0));
		System.out.printf("evet ilk sayfanýn son yazarý  ikinci sayfada yok ");
		
	}
	
	
}

