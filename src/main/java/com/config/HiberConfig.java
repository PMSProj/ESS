package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class HiberConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("Prity@13");
		ds.setPassword("SYSTEM");
		System.out.println("Connected");
		return ds;

	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean lb = new LocalSessionFactoryBean();
		lb.setDataSource(dataSource());
		lb.setPackagesToScan(new String[] { "com.Model" });
		lb.setHibernateProperties(getHiberProperties());
		return lb;
	}

	private Properties getHiberProperties() {
		Properties p = new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		p.put("hibernate.hbm2ddl.auto", "update ");
		p.put("hibernate.show_sql", "true");
		System.out.println("Data table created in database");
		return p;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sf) {
		HibernateTransactionManager hbm = new HibernateTransactionManager();
		hbm.setSessionFactory(sf);
		return hbm;
	}

}
