package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PracticeApplicationTests {

	@Test
	void contextLoads() {
	        WebDriver driver = webDriverSetting();
	        
	        try {
	        	 // 크롤링할 웹사이트 접속
	            driver.get("https://statiz.sporki.com/stats/?m=main");

	            // 선수명 가져오기 (테이블의 두 번째 열)
	            List<WebElement> playerNames = driver.findElements(By.cssSelector("table tbody tr td:nth-child(2)"));
	            
	            // war 가져오기 (테이블의 다섯 번째 열)
	            List<WebElement> battingAverages = driver.findElements(By.cssSelector("table tbody tr td:nth-child(5)"));

	            // 결과 출력
	            System.out.println("선수명 - war");
	            for (int i = 0; i < playerNames.size(); i++) {
	                String player = playerNames.get(i).getText();
	                String average = battingAverages.get(i).getText();
	                System.out.println(player + " - " + average);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // WebDriver 종료
	            driver.quit();
	        }
	}
	
	public WebDriver webDriverSetting() {
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless=new"); // 브라우저 창 없이 실행
	        options.addArguments("--disable-gpu"); // GPU 가속 비활성화 (Linux에서 필수)
	        options.addArguments("--window-size=1920x1080"); 
	        options.addArguments("--no-sandbox");  
	        options.addArguments("--disable-dev-shm-usage");  
	        System.out.println("Chrome 옵션: " + options.toString());
	
	        // Chrome 브라우저 실행
	        WebDriver driver = new ChromeDriver(options);
		return driver;
	}

}
