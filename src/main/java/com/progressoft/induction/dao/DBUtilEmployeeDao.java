/**
 * 
 */
package com.progressoft.induction.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.progressoft.induction.beans.Employee;

/**
 * @author PSLPT 147
 *
 */
public class DBUtilEmployeeDao implements EmployeeDao {

	private QueryRunner runner;
	private static String INSERT_STATE = "insert into employee (id,first_name,last_name,position) values(?,?,?,?)";

	/**
	 * @param runner
	 */
	public DBUtilEmployeeDao(QueryRunner runner) {
		this.runner = runner;
	}

	public DBUtilEmployeeDao(QueryRunner runner, Connection connection) {
		this.runner = runner;
		System.out.println("second");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.progressoft.induction.dao.EmployeeDao#create(com.progressoft.
	 * induction.beans.Employee)
	 */
	public void create(Employee employee) throws DaoException {
		try {
			runner.update(INSERT_STATE, employee.getId(), employee.getFirstName(), employee.getLastName(),
					employee.getPosition());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
