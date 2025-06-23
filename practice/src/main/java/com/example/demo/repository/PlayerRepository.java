package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.dao.Player;

public interface PlayerRepository {
	 Player save(Player player);
	 Optional<Player> findById(Long id);
	 ArrayList<Player> findByTeam(String team);
	 Optional<Player> findByNameAndTeam(String name, String team);
	 List<Player> findAll();
	 void deleteAll();
	 int countingAll();
}
