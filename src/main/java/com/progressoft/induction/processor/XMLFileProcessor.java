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
public class XMLFileProcessor implements FileProcessor {

	@Override
	public void process(Path path) throws ProcessException {
		System.out.println("process file :)--> " + path);
	}

}
