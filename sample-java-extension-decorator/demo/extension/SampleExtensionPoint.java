package demo.extension;

import org.eclipse.dirigible.sdk.extensions.ExtensionPoint;

/**
 * Demonstrates {@code @ExtensionPoint}: declares the typed contract that contributing classes
 * implement. Consumers retrieve every registered implementor via
 * {@code Extensions.find(SampleExtensionPoint.class)} and call {@link #describe()} directly,
 * with no reflection.
 */
@ExtensionPoint("Sample Java extension point")
public interface SampleExtensionPoint {

    String describe();

}
