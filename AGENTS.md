# AGENTS.md

This is the single source of truth for agents working in this repository.
[CLAUDE.md](CLAUDE.md) is a quick-reference summary of the essentials below; when
the two disagree, this file wins.

## Project

A Java project demonstrating secure coding examples, built with Maven 3.9.X. The
root `pom.xml` (packaging `pom`) aggregates the `examples` module. Run `mvn
install` from the repository root to build.

The build wires the `claude-code-enforcer` Maven enforcer rule into the root
`pom.xml`: the `claudeMdFormat` rule runs in the `validate` phase and fails the
build when `CLAUDE.md` is missing its title, any required section, or the
reference to this file.

## Java version

Java 25. A JDK 25 must be on the `PATH` with `JAVA_HOME` set.

## Maven

All dependency versions and scopes are defined only in the root `pom.xml` under
`<dependencyManagement>`. All Maven plugin versions are defined only in the root
`pom.xml` under `<pluginManagement>`. Module poms reference dependencies and
plugins without versions.

Common commands (run from the repository root):

```bash
mvn install        # build and install to the local repository
mvn test           # run the unit tests
```

## Principles for Java Development

- **SOLID principles** for all code.
- **Clean code**: short methods, meaningful parameter names, no `continue` or
  `break` statements.

## Testing

Write unit tests for all new logic. Focus on behavior, edge cases, and error
paths.

## Dependencies

Use the existing Maven dependencies. **Always ask before adding a new one.**
