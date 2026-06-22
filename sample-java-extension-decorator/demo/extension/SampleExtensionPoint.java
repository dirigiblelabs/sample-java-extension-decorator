package demo.extension;

/**
 * An extension point is just a plain Java interface — no annotation needed. Contributions are
 * {@code @Component} beans that implement it; consumers receive them all via collection injection
 * ({@code List<SampleExtensionPoint>}) or {@code Extensions.find(SampleExtensionPoint.class)}.
 */
public interface SampleExtensionPoint {

    String describe();

}
