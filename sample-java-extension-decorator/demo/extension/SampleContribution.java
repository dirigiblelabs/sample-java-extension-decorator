package demo.extension;

import org.eclipse.dirigible.sdk.extensions.Extension;

/**
 * Demonstrates {@code @Extension}: registers this class as a typed contribution to
 * {@link SampleExtensionPoint}. The runtime validates the implementation at registration time —
 * consumers that call {@code Extensions.find(SampleExtensionPoint.class)} receive a
 * {@code List<SampleExtensionPoint>} that they can invoke directly.
 */
@Extension(target = SampleExtensionPoint.class, name = "sample-contribution")
public class SampleContribution implements SampleExtensionPoint {

    @Override
    public String describe() {
        return "Hello from SampleContribution!";
    }

}
