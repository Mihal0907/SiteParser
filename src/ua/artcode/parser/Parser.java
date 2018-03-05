package ua.artcode.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ua.artcode.model.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Article> parse(String url) throws IOException {

        List<Article> articleList = new ArrayList<>();

        Document document = Jsoup.connect(url).get();

        Elements h2Elements = document.getElementsByAttributeValue("class", "list-post-title");

        h2Elements.forEach(h2Element -> {
            Element element = h2Element.child(0);
            String link = element.attr("href");
            String title = element.child(0).text();

            articleList.add(new Article(link, title));
        });

        return articleList;
    }
}
