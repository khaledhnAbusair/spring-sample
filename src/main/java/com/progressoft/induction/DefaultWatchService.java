/**
 * 
 */
package com.progressoft.induction;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.util.List;

import com.progressoft.induction.processor.FileProcessor;

/**
 * @author PSLPT 147
 *
 */
public class DefaultWatchService implements WatchService {

	// those are my dependencies
	private List<Path> pathToWatch;
	private FileProcessor processor;

	// for internal use
	private java.nio.file.WatchService watchService;

	/**
	 * 
	 */
	public DefaultWatchService() {

	}

	/**
	 * @return the pathToWatch
	 */
	public List<Path> getPathToWatch() {
		return pathToWatch;
	}

	/**
	 * @param pathToWatch
	 *            the pathToWatch to set
	 */
	public void setPathToWatch(List<Path> pathToWatch) {
		this.pathToWatch = pathToWatch;
	}

	/**
	 * @return the processor
	 */
	public FileProcessor getProcessor() {
		return processor;
	}

	/**
	 * @param processor
	 *            the processor to set
	 */
	public void setProcessor(FileProcessor processor) {
		this.processor = processor;
	}

	@Override
	public void start() {
		FileSystem fileSystem = FileSystems.getDefault();
		try {
			watchService = fileSystem.newWatchService();
			System.out.println("start to listen for: " + pathToWatch.size());
			for (Path path : pathToWatch) {
				path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
				new Thread(new WatchThread()).start();
			}
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * @author PSLPT 147
	 *
	 */
	private class WatchThread implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					WatchKey take = watchService.take();
					List<WatchEvent<?>> events = take.pollEvents();
					for (WatchEvent<?> watchEvent : events) {
						Path path = (Path) watchEvent.context();
						processor.process(path);
					}
					take.reset();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ProcessException e) {
				e.printStackTrace();
			}
		}

	}

}
