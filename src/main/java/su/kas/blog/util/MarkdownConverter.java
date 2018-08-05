package su.kas.blog.util;

import org.commonmark.ext.autolink.AutolinkExtension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Collections;

public class MarkdownConverter {
    private static Parser parser = Parser.builder().extensions(Collections.singletonList(AutolinkExtension.create())).build();
    private static HtmlRenderer renderer = HtmlRenderer.builder().build();

    public static String convert(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        return renderer.render(parser.parse(input));
    }
}
