package com.example.demo.dao;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class Player {
	
	private int playerId;		//선수 고유 번호
	private String name;		//선수명
	private String team;		//팀명
	private String position;	//포지션
	private String war;			//대체선수 대비 승리기여도
	private String oWar;		//대체선수 대비 승리기여도(공격)
	private String dWar;		//대체선수 대비 승리기여도(수비)
	private String g;			//출장경기 수
	private String pa;			//타석 수
	private String ePA;			//실질타석
	private String ab;			//타수
	private String r;			//득점
	private String h;			//안타
	private String secondB;		//2루타
	private String thirdB;		//3루타
	private String hr;			//홈런
	private String tb;			//루타
	private String rbi;			//타점
	private String sb;			//도루성공 (stolen base)
	private String cs;			//도루실패 (caught stealing)
	private String bb;			//4구
	private String hp;			//사구
	private String ib;			//고의사구
	private String so;			//삼진
	private String gdp;			//병살
	private String sh;			//희생번트
	private String sf;			//희생플라이
	private String avg;			//타울
	private String obp;			//출루율 (On the Base Percentage)
	private String slg;			//장타율
	private String ops;			//출루율 + 장타율
	private String rePA;
	private String wrcP;		//조정득점창출력
}
