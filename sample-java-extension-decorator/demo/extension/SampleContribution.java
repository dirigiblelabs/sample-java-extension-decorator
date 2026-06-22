package demo.extension;

import org.eclipse.dirigible.sdk.component.Component;

/**
 * A contribution is simply a {@code @Component} bean implementing the extension-point interface —
 * no {@code @Extension} annotation. Its {@code @Component} name ("sample-contribution") is the
 * contribution name. Consumers receive it via {@code List<SampleExtensionPoint>} or
 * {@code Extensions.find(SampleExtensionPoint.class)}.
 */
@Component("sample-contribution")
public class SampleContribution implements SampleExtensionPoint {

    @Override
    public String describe() {
        return "Hello from SampleContribution!";
    }
}
