package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.demo.dao.Player;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.util.CrawlingUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

class SelectPlayerTest {

    PlayerRepository playerRepository = new PlayerRepository();

    @Test
    void savePlayer() {
        WebDriver driver = CrawlingUtil.webDriverSetting();

        try {
            List<Player> players = new ArrayList<>();
            
            players = playerRepository.selectedTeamPlayer("lotte");
            
            for (Player player : players) {
            	System.out.println("\"" + player.getName() +"\"의 데이터" + player.toString());
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
    }
}
