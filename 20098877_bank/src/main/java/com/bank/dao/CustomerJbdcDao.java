package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;

@Repository
@Component
public class CustomerJbdcDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	class CustomerRowMapper implements RowMapper<Customer>{
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setCustomerId(rs.getInt("customerId"));
		customer.setCustomerName(rs.getString("customerName"));
		customer.setCustomerAccountType(rs.getString("customerAccountType"));
		return customer;
		}
		
	}

	public List<Customer> findAll() {
		return jdbcTemplate.query("select * from customer", 
				new CustomerRowMapper());

}
	public List<Customer> findById(int id) {
		return jdbcTemplate.query("select * from customer where customerId=?", new Object[] { id }, 
				new BeanPropertyRowMapper(Customer.class));

}
	
	public int deleteById(int id) {
		return jdbcTemplate.update
				("delete from customer where customerId=?", new Object[] { id });
	}
	
	public int insert(Customer customer) {
		return jdbcTemplate.update("insert into customer (customerId, customerName, customerAccountType) " + "values(?,  ?, ?)",
				new Object[] { customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAccountType()});
	}
}
