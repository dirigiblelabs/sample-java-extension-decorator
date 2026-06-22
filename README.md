# sample-java-extension-decorator

Showing how to define and consume extension points in
[Eclipse Dirigible](https://www.dirigible.io/) — no dedicated annotation: an extension point is a
plain interface and a contribution is a `@Component` implementing it.

## Layout

```
sample-java-extension-decorator/   # Dirigible project (registry path)
└── demo/
    └── extension/
        ├── SampleExtensionPoint.java  # plain interface — the extension point
        ├── SampleContribution.java    # @Component implementing it — a contribution
        ├── ExtensionConsumer.java     # @Controller — Extensions.find(...) lookup
        └── InjectingConsumer.java     # @Controller — List<SampleExtensionPoint> collection injection
```

## Usage

Drop this project into the Dirigible IDE (clone via the Git perspective and publish, or copy it to
`/registry/public/sample-java-extension-decorator/`). The synchronizer compiles the classes; the bean
container registers `SampleContribution` as a `@Component`.

## Consuming extensions

Two ways, both returning the same contributions:

- **Collection injection (preferred, Spring-style)** — `InjectingConsumer` takes a
  `List<SampleExtensionPoint>` in its constructor; the bean container injects every contribution.
  Verify: `GET /services/java/sample-java-extension-decorator/demo/extension/InjectingConsumer/injected-contributions`
- **Programmatic lookup** — `ExtensionConsumer` calls `Extensions.find(SampleExtensionPoint.class)`.
  Verify: `GET /services/java/sample-java-extension-decorator/demo/extension/ExtensionConsumer/contributions`

Both return `["Hello from SampleContribution!"]`.

See the [Develop guide](https://www.dirigible.io/help/develop/extension-providers/) and the [Java SDK](https://www.dirigible.io/sdk/).
