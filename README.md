# sample-java-extension-decorator

Showing how to use `@Extension` to register a contribution to an extension point in
[Eclipse Dirigible](https://www.dirigible.io/).

## Layout

```
sample-java-extension-decorator/   # Dirigible project (registry path)
└── demo/
    └── extension/
        ├── SampleContribution.java  # @Extension — registers to "java-sample-extension-point"
        └── ExtensionConsumer.java   # @Controller — queries the registry and returns contributions
```

## Usage

Drop this project into the Dirigible IDE (clone via the Git perspective and publish, or copy it
to `/registry/public/sample-java-extension-decorator/`). The synchronizer compiles the classes and
registers `SampleContribution` against the extension point. Verify via:

```
GET /services/java/sample-java-extension-decorator/demo/extension/ExtensionConsumer/contributions
```

Returns a JSON array including `{ "name": "sample-contribution", "module": "demo.extension.SampleContribution" }`.

## Consuming extensions

Two ways:

- **Programmatic lookup** — `ExtensionConsumer` calls `Extensions.find(SampleExtensionPoint.class)`.
- **Collection injection (Spring-style)** — `InjectingConsumer` takes a `List<SampleExtensionPoint>` in its constructor; the bean container injects every contribution.

See the [Develop guide](https://www.dirigible.io/help/develop/extension-providers/) and the [Java SDK](https://www.dirigible.io/sdk/).
