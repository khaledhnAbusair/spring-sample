/**
 * 
 */
package com.progressoft.induction.dao;

import com.progressoft.induction.beans.Employee;

/**
 * @author PSLPT 147
 *
 */
public interface EmployeeDao {

	/**
	 * @param employee
	 * @throws DaoException
	 */
	public void create(Employee employee) throws DaoException;
}
