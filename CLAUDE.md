# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

A collection of self-contained security examples (e.g. zip bombs). Each example demonstrates
a security-relevant technique for educational/defensive purposes. The user takes full responsibility
for how these examples are used — see README.md.

## Build & Test

Java 25, built with Maven 3.9.X (multi-module, aggregator root pom).

- Build everything: `mvn install` (from repo root)
- Build/package only: `mvn -B package --file pom.xml`
- Run all tests: `mvn test`
- Run a single test class: `mvn -pl examples test -Dtest=ZipBTest`
- Run a single test method: `mvn -pl examples test -Dtest=ZipBTest#happyPath`

## Architecture

- Root `pom.xml` is a `pom`-packaged aggregator: it declares the module list and holds the single
  source of truth for `dependencyManagement` (dependency versions/scopes) and plugin `pluginManagement`
  (plugin versions). Child modules must not redeclare versions/scopes — they only reference
  `groupId`/`artifactId`.
- `examples/` is the (currently only) module, packaged as a jar, containing the actual example code
  under `io.github.adamw7.security`.
- Each example is a standalone class with a `main` method plus a corresponding JUnit 5
  (parameterized) test class, e.g. `ZipB` / `ZipBTest`. New examples should follow this same
  pattern: one class per technique, with matching tests.
- Logging uses Log4j2, configured via `examples/src/main/resources/log4j2.properties`
  (rolling file appender writing to `logs/`, size- and time-based rotation, 30-day retention).

## Maven

- All dependency versions and scopes are defined only in the root `pom.xml`'s `dependencyManagement`.
- All Maven plugin versions are defined only in the root `pom.xml`'s `pluginManagement`.
- Use existing dependencies; always ask before adding a new one.

## Java coding principles

- Follow SOLID principles.
- Clean code: no `continue`/`break`, short methods, meaningful parameter names.

## Testing

Write unit tests for all new logic, focused on behavior, edge cases, and error paths (see
`ZipBTest` for the expected style: parameterized happy-path and invalid-input cases, with
`@AfterEach` cleanup of generated files).


## Java version

See [AGENTS.md](AGENTS.md).

## Principles for Java Development

See [AGENTS.md](AGENTS.md).

## Dependencies

See [AGENTS.md](AGENTS.md).
