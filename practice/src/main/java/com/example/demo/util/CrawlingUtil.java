package com.example.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrawlingUtil {
	public static WebDriver webDriverSetting() {
		
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
