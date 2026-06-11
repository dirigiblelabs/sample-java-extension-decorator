package demo.extension;

import java.util.List;

import org.eclipse.dirigible.sdk.extensions.Extensions;
import org.eclipse.dirigible.sdk.http.Controller;
import org.eclipse.dirigible.sdk.http.Get;

/**
 * REST endpoint that exercises the typed extension API end-to-end. Every implementor of
 * {@link SampleExtensionPoint} registered by {@code ExtensionClassConsumer} on publish is
 * returned by {@code Extensions.find(...)} as the interface type, so {@link #listContributions()}
 * calls {@link SampleExtensionPoint#describe()} directly — no reflection, no Map payloads.
 *
 * <p>
 * {@code GET /services/java/sample-java-extension-decorator/demo/extension/ExtensionConsumer/contributions}
 * returns a JSON array of the descriptions produced by each contribution.
 */
@Controller
public class ExtensionConsumer {

    @Get("/contributions")
    public List<String> listContributions() throws Exception {
        return Extensions.find(SampleExtensionPoint.class)
                         .stream()
                         .map(SampleExtensionPoint::describe)
                         .toList();
    }

}
