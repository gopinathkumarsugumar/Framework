# Automation Framework

Selenium + TestNG + REST Assured framework suitable for interview practice.

## Run

```bash
mvn clean test
```

UI configuration is in `src/test/resources/config.properties`.

## API authentication

The OrangeHRM employee-create endpoint requires authentication. Configure a valid token before running the API test:

Windows PowerShell:

```powershell
$env:ORANGEHRM_API_TOKEN="<token>"
mvn clean test
```

Without a token, the API test is skipped rather than falsely asserting an unauthenticated `401` as success.

## Design principles

- ThreadLocal WebDriver for safe parallel execution.
- Driver lifecycle belongs to the UI test base, not page objects.
- Page Objects contain locators and page behavior.
- Common actions are composition-friendly utilities, not test bases.
- Configuration is loaded from the classpath and can be overridden by environment variables.
- UI and API tests have separate responsibilities.
- Generated reports stay under `target/` and are not committed.
