package io.github.adamw7.security;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipBTest {

	private static final String FILE_NAME = "b.zip";

	@ParameterizedTest
	@ValueSource(ints = {100, 1000, 10000})
	public void happyPath(int len) {
		try {
			ZipB.contruct(len);
			assertTrue(new File(FILE_NAME).exists());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@AfterEach
	public void tearDown() {
		new File(FILE_NAME).delete();
	}
}
