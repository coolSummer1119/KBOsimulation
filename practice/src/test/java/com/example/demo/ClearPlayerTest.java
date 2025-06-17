package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.demo.repository.PlayerRepository;
import com.example.demo.util.CrawlingUtil;
import com.example.demo.dao.Player;

import java.util.ArrayList;
import java.util.List;

class ClearPlayerTest {

    PlayerRepository playerRepository = new PlayerRepository();

    @Test
    void ClearPlayer() {
    	try {
			playerRepository.clearAllPlayer();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
