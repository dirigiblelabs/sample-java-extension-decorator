package demo.extension;

import org.eclipse.dirigible.engine.java.annotations.Extension;

/**
 * Demonstrates {@code @Extension}: registers this class as a contribution to
 * {@code "java-sample-extension-point"}. Consumers that query that extension point via
 * {@code ExtensionService.findByExtensionPoint} will see this class listed and can instantiate it
 * on demand to call {@link #describe()}.
 */
@Extension(name = "sample-contribution", to = "java-sample-extension-point")
public class SampleContribution {

    public String describe() {
        return "Hello from SampleContribution!";
    }

}
