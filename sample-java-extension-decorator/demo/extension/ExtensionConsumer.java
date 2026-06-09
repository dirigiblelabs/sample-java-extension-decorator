package demo.extension;

import java.util.List;
import java.util.Map;

import org.eclipse.dirigible.components.base.spring.BeanProvider;
import org.eclipse.dirigible.components.extensions.service.ExtensionService;
import org.eclipse.dirigible.engine.java.annotations.http.Controller;
import org.eclipse.dirigible.engine.java.annotations.http.Get;

/**
 * REST endpoint that queries the Dirigible extension registry to verify that
 * {@link SampleContribution} was registered by {@code ExtensionClassConsumer} on publish.
 *
 * <p>
 * {@code GET /services/java/sample-java-extension-decorator/demo/extension/ExtensionConsumer/contributions}
 * returns a JSON array of {@code {name, module}} objects for every contribution registered against
 * {@code "java-sample-extension-point"}.
 */
@Controller
public class ExtensionConsumer {

    static final String EXTENSION_POINT = "java-sample-extension-point";

    @Get("/contributions")
    public List<Map<String, String>> listContributions() {
        ExtensionService extensionService = BeanProvider.getBean(ExtensionService.class);
        return extensionService.findByExtensionPoint(EXTENSION_POINT)
                               .stream()
                               .map(e -> Map.of("name", e.getName(), "module", e.getModule()))
                               .toList();
    }

}
