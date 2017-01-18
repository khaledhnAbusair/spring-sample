/**
 *
 */
package com.progressoft.induction.processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import com.progressoft.induction.ProcessException;
import com.progressoft.induction.beans.Employee;
import com.progressoft.induction.dao.EmployeeDao;

/**
 * @author PSLPT 147
 */
public class CSVFileProcessor implements FileProcessor {

    private EmployeeDao employeeDao;

    /**
     * @param employeeDao
     */
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.progressoft.induction.processor.FileProcessor#process(java.nio.file.
     * Path)
     */
    public void process(Path path) throws ProcessException {
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("process record: " + line);
                String[] record = line.split(",");
                Employee employee = new Employee();

                employee.setId(record[0]);
                employee.setFirstName(record[1]);
                employee.setLastName(record[2]);
                employee.setPosition(record[3]);

                this.employeeDao.create(employee);
            }

        } catch (IOException e) {
            throw new ProcessException(e);
        }
    }

}
