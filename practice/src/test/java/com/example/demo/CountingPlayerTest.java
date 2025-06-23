package com.example.demo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.example.demo.repository.LegacyPlayerRepository;
import com.example.demo.util.CrawlingUtil;
import com.example.demo.dao.Player;

import java.util.ArrayList;
import java.util.List;

class CountingPlayerTest {

    LegacyPlayerRepository playerRepository = new LegacyPlayerRepository();

    @Test
    void ClearPlayer() {
    	try {
			playerRepository.countingPlayer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
