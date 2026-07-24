# CLAUDE.md

See [AGENTS.md](AGENTS.md) for the companion agent guide.


This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

Java project built with Maven 3.9.X: a collection of small, self-contained security-related examples (e.g. zip bomb construction). Run `mvn install` from the root to build.

## Commands

- Build (root): `mvn install`
- Run all tests: `mvn test`
- Run a single test class: `mvn test -pl examples -Dtest=ZipBTest`
- Run a single test method: `mvn test -pl examples -Dtest=ZipBTest#happyPath`

## Architecture

- Multi-module Maven reactor: the root `pom.xml` (`packaging=pom`) declares only `dependencyManagement`/`pluginManagement`; the `examples` module (artifact `security.examples`) is currently the only module and must not declare its own dependency versions or plugin versions — those come from the root only, per the Maven rule below.
- Base package for all example code: `io.github.adamw7.security`.
- Each security example is a standalone, runnable class with a `main` method (e.g. `ZipB`), paired with a unit test class of the same name + `Test` suffix in `src/test/java` under the same package.
- Logging is via Log4j2, configured in `examples/src/main/resources/log4j2.properties`.

## Java version
Java 25.

## Maven
All versions and scopes are defined only in root pom.xml in dependency management.
All maven plugin versions are defined only in root pom.xml in plugin management.

## Principles for Java Development
Use SOLID Principles for all code.
Use clean code. No continue or break instructions. Short methods. Meaningul parameter names.

## Testing
Write unit tests for all new logic. Focus on behavior, edge cases, and error paths.

## Dependencies
Use the existing maven depdendencies. Always ask before adding a new one.
