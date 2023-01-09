package io.github.adamw7.security;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZipBTest {

	private static final String FILE_NAME = "b.zip";

	@ParameterizedTest
	@ValueSource(ints = {100, 1000, 10000})
	public void happyPath(int len) {
		try {
			ZipB.construct(len);
			assertTrue(new File(FILE_NAME).exists());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@ParameterizedTest
	@ValueSource(ints = {0, -1, -99999999})
	public void nagitiveInvalidLength(int len) {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			ZipB.construct(len);
		}, "Expected construct method to throw, but it didn't");

		assertEquals("Invalid length: " + len, thrown.getMessage());
	}
	
	@AfterEach
	public void tearDown() {
		new File(FILE_NAME).delete();
	}
}
