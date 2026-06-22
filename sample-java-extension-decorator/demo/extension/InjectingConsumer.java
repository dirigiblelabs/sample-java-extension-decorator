package demo.extension;

import java.util.List;

import org.eclipse.dirigible.sdk.http.Controller;
import org.eclipse.dirigible.sdk.http.Get;

/**
 * Spring-style "inject all implementations of an interface": the bean container populates the
 * List<SampleExtensionPoint> with every @Extension contribution (each is also a @Component), so no
 * explicit Extensions.find() lookup is needed.
 */
@Controller
public class InjectingConsumer {

    private final List<SampleExtensionPoint> contributions;

    public InjectingConsumer(List<SampleExtensionPoint> contributions) {
        this.contributions = contributions;
    }

    @Get("/injected-contributions")
    public List<String> list() {
        return contributions.stream()
                            .map(SampleExtensionPoint::describe)
                            .toList();
    }
}
