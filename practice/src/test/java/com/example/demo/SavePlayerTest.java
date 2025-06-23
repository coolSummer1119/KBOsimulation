package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.demo.dao.Player;
import com.example.demo.repository.LegacyPlayerRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.util.CrawlingUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

class SavePlayerTest {

	DataSource dataSource;
	
    PlayerRepository playerRepository = new LegacyPlayerRepository(dataSource);

    @Test
    void savePlayer() {
        WebDriver driver = CrawlingUtil.webDriverSetting();

        try {
            // 크롤링할 웹사이트 접속
            driver.get("https://statiz.sporki.com/stats/?m=main&m2=batting&m3=default&so=WAR&ob=DESC&year=2024&sy=2024&ey=2024&te=3001&po=&lt=10100&reg=A&pe=&ds=&de=&we=&hr=&ha=&ct=&st=&vp=&bo=&pt=&pp=&ii=&vc=&um=&oo=&rr=&sc=&bc=&ba=&li=&as=&ae=&pl=&gc=&lr=&pr=50&ph=&hs=&us=&na=&ls=&sf1=&sk1=&sv1=&sf2=&sk2=&sv2=");

            List<Player> players = new ArrayList<>();
            List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr")); // 테이블 행 선택

            for (WebElement row : rows) {
            	List<WebElement> cols = row.findElements(By.tagName("td"));

                if (cols.size() > 31) { // 데이터 컬럼 개수 확인
                    Player player = new Player();
                    player.setName(cols.get(1).getText());
                    
                    String position = cols.get(2).getText();
                    if(position.substring(position.length()-1).equals("C") || position.substring(position.length()-1).equals("P")) {
                    	position = position.substring(position.length()-1);
                    } else {
                    	position = position.substring(position.length()-2);
                    }
                    player.setPosition(position);
                    
                    player.setWar(cols.get(3).getText());
                    player.setOWar(cols.get(4).getText());
                    player.setDWar(cols.get(5).getText());
                    player.setG(cols.get(6).getText());
                    player.setPa(cols.get(7).getText());
                    player.setEPA(cols.get(8).getText());
                    player.setAb(cols.get(9).getText());
                    player.setR(cols.get(10).getText());
                    player.setH(cols.get(11).getText());
                    player.setSecondB(cols.get(12).getText());
                    player.setThirdB(cols.get(13).getText());
                    player.setHr(cols.get(14).getText());
                    player.setTb(cols.get(15).getText());
                    player.setRbi(cols.get(16).getText());
                    player.setSb(cols.get(17).getText());
                    player.setCs(cols.get(18).getText());
                    player.setBb(cols.get(19).getText());
                    player.setHp(cols.get(20).getText());
                    player.setIb(cols.get(21).getText());
                    player.setSo(cols.get(22).getText());
                    player.setGdp(cols.get(23).getText());
                    player.setSh(cols.get(24).getText());
                    player.setSf(cols.get(25).getText());
                    player.setAvg(cols.get(26).getText());
                    player.setObp(cols.get(27).getText());
                    player.setSlg(cols.get(28).getText());
                    player.setOps(cols.get(29).getText());
                    player.setRePA(cols.get(30).getText());
                    player.setWrcP(cols.get(31).getText());
                    player.setTeam("lotte");

                    // 데이터 저장
                    playerRepository.save(player);
                    players.add(player);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }
}
