/**
 * 
 */
package com.progressoft.induction;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;

import com.progressoft.induction.dao.DBUtilEmployeeDao;
import com.progressoft.induction.dao.EmployeeDao;
import com.progressoft.induction.processor.CSVFileProcessor;
import com.progressoft.induction.processor.FileProcessor;

/**
 * @author PSLPT 147
 *
 */
public class Main {
	// my injection

	public static void main(String[] args) throws ParserConfigurationException {
		BasicDataSource dataSource = createDataSource();

		QueryRunner runner = new QueryRunner(dataSource);

		EmployeeDao dao = new DBUtilEmployeeDao(runner);

		FileProcessor processor = createProcessor(dao);

		DefaultWatchService service = new DefaultWatchService();
		Path pathToWatch = Paths.get(".", "path");

		service.setPathToWatch(Arrays.asList(pathToWatch));
		service.setProcessor(processor);

		service.start();
		System.out.println("started");


	}

	protected static FileProcessor createProcessor(EmployeeDao dao) {
		CSVFileProcessor processor = new CSVFileProcessor();
		processor.setEmployeeDao(dao);
		return processor;
	}

	protected static BasicDataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/Employees");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dataSource;
	}

}
