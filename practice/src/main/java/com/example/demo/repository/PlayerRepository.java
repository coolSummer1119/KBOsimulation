package com.example.demo.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.Player;
import com.example.demo.util.DBConnectionUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PlayerRepository {
	
	public Player savePlayer(Player player) throws Exception {
		String sql = "INSERT INTO player"
			    + "(name, position, war, oWar, dWar, g, pa, ePA, ab, r, h, "
			    + "secondB, thirdB, hr, tb, rbi, sb, cs, bb, hp, ib, so, gdp, sh, sf, "
			    + "\"AVG\", obp, slg, ops, rePAm, wrcP, team)"
			    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			//TODO 커넥션 풀로 바꿔서 선수생성할때마다 커넥션을 새로 따지말고 Hikari에서 꺼내 쓰는 방법으로 or 그룹화
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, player.getName());
			pstmt.setString(2, player.getPosition());
			pstmt.setString(3, player.getWar());
			pstmt.setString(4, player.getOWar());
			pstmt.setString(5, player.getDWar());
			pstmt.setString(6, player.getG());
			pstmt.setString(7, player.getPa());
			pstmt.setString(8, player.getEPA());
			pstmt.setString(9, player.getAb());
			pstmt.setString(10, player.getR());
			pstmt.setString(11, player.getH());
			pstmt.setString(12, player.getSecondB());
			pstmt.setString(13, player.getThirdB());
			pstmt.setString(14, player.getHr());
			pstmt.setString(15, player.getTb());
			pstmt.setString(16, player.getRbi());
			pstmt.setString(17, player.getSb());
			pstmt.setString(18, player.getCs());
			pstmt.setString(19, player.getBb());
			pstmt.setString(20, player.getHp());
			pstmt.setString(21, player.getIb());
			pstmt.setString(22, player.getSo());
			pstmt.setString(23, player.getGdp());
			pstmt.setString(24, player.getSh());
			pstmt.setString(25, player.getSf());
			pstmt.setString(26, player.getAvg());
			pstmt.setString(27, player.getObp());
			pstmt.setString(28, player.getSlg());
			pstmt.setString(29, player.getOps());
			pstmt.setString(30, player.getRePA());
			pstmt.setString(31, player.getWrcP());
			pstmt.setString(32, player.getTeam());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
		
		return player;
	}
	
	public ArrayList<Player> selectedTeamPlayer(String team) throws Exception {
		ArrayList<Player> players = new ArrayList<>();
		
		String sql = "select * from player where team='" + team + "'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Player player = new Player();
				player.setName(rs.getString("name"));
				player.setPosition(rs.getString("position"));
				player.setWar(rs.getString("war"));
				player.setOWar(rs.getString("owar"));
				player.setDWar(rs.getString("dwar"));
				player.setG(rs.getString("g"));
				player.setPa(rs.getString("pa"));
				player.setEPA(rs.getString("epa"));
				player.setAb(rs.getString("ab"));
				player.setR(rs.getString("r"));
				player.setH(rs.getString("h"));
				player.setSecondB(rs.getString("secondb"));
				player.setThirdB(rs.getString("thirdb"));
				player.setHr(rs.getString("hr"));
				player.setTb(rs.getString("tb"));
				player.setRbi(rs.getString("rbi"));
				player.setSb(rs.getString("sb"));
				player.setCs(rs.getString("cs"));
				player.setBb(rs.getString("bb"));
				player.setHp(rs.getString("hp"));
				player.setIb(rs.getString("ib"));
				player.setSo(rs.getString("so"));
				player.setGdp(rs.getString("gdp"));
				player.setSh(rs.getString("sh"));
				player.setSf(rs.getString("sf"));
				player.setAvg(rs.getString("avg"));
				player.setObp(rs.getString("obp"));
				player.setSlg(rs.getString("slg"));
				player.setOps(rs.getString("ops"));
				player.setRePA(rs.getString("repam"));
				player.setWrcP(rs.getString("wrcp"));
				player.setTeam(rs.getString("team"));
				
                players.add(player);
			}
			
			
		} catch (Exception e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
		
		return players;
	}
	
	public void removeAllPlayer() throws Exception {
		String sql = "delete from player;";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("db 전체 삭제 완료!!");
			
		} catch (Exception e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
	}

	public void countingPlayer() throws Exception {
		String sql = "Select COUNT(*) AS CNT from player;";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int cnt = -1;
			if(rs.next()) {
				cnt = rs.getInt("CNT");
			}
			
			System.out.println("총 선수 데이터 갯수 : " + cnt);
			
		} catch (Exception e) {
			log.error("db error",e);
			throw e;
		} finally {
			close(con, pstmt, null);
		}
	}
	
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		if(rs != null ) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.info("error",e);
			}
		} 
		if(stmt != null ) {
			try {
				stmt.close();
			} catch (SQLException e) {
				log.info("error",e);
			}
		} 
		if(con != null ) {
			try {
				con.close();
			} catch (SQLException e) {
				log.info("error",e);
			}
		} 
	}
	
	private Connection getConnection() {
		return DBConnectionUtil.getConnection();
	}
}
