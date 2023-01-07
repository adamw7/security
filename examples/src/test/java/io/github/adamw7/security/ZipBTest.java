package io.github.adamw7.security;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ZipBTest {

	@ParameterizedTest
	@ValueSource(ints = {100, 1000, 10000})
	public void happyPath(int len) {
		try {
			ZipB.contruct(len);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
