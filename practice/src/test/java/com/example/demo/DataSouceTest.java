package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class DataSouceTest {
	
	@Autowired
	ApplicationContext ctx;

	@Autowired 
	DataSource ds;

	@Test
	void testConn() throws SQLException {
	    try (Connection con = ds.getConnection()) {
	        assertFalse(con.isClosed());
	    }
	}
		
	@Test
	void dataSourceBeanExists() {
	    assertTrue(ctx.containsBean("dataSource"));
	    DataSource ds = ctx.getBean(DataSource.class);
	    assertNotNull(ds);
	}
}
