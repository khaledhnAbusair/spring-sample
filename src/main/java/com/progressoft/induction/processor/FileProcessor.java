/**
 * 
 */
package com.progressoft.induction.processor;

import java.nio.file.Path;

import com.progressoft.induction.ProcessException;

/**
 * @author PSLPT 147
 *
 */
public interface FileProcessor {

	/**
	 * 
	 * @param path
	 * @throws ProcessException
	 */
	public void process(Path path) throws ProcessException;

}
