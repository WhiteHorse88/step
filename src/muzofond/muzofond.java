package muzofond;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class muzofond {
	private static char[] text;

	public static void main(String[] args) throws InterruptedException, IOException {
		String someMUSIC = getSearchMusic();
	}

	public static String getSearchMusic() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		WebDriver webdr = new FirefoxDriver();
		webdr.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		webdr.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		webdr.get("https://muzofond.com");
		// Thread.sleep(1000 * 10);
		WebElement music = webdr.findElement(
				By.className("module-layout")/* .className("desc") */);
		// WebElement music1 = webdr.findElement(By.className("desc"));
		// Thread.sleep(1000 * 10);
		String musicName = music.getAttribute("text");
		// String musicName2 = music1.getAttribute("text");
		Thread.sleep(1000 * 10);
		for (int i = 0; i<=15; i++) {
			Thread.sleep(1000 * 10);
			FileWriter file = new FileWriter("D:\\test\\out.txt");
			file.write(i + '\n');
			file.write(music.getText());
			FileReader file1 = new FileReader("D:\\test\\out.txt");
			file.close();
			Thread.sleep(1000 * 10);
			System.out.println(music.getText());
		}

		webdr.quit();

		return null;

	}
}