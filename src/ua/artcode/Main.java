package ua.artcode;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Andrey\\IdeaProjects\\SiteParser\\src\\ua\\artcode\\4pda.json";
        List<Article> articleList = Parser.parse("http://4pda.ru/");


        JSONUtils.writeListIntoFile(path, articleList);

        List<Article> articleList1 = JSONUtils.readListFromFile(path, Article.class);
      //  System.out.println(articleList1);

        List<String> urls = articleList1.stream().map(Article::getUrl).collect(Collectors.toList());
        List<String> names = articleList1.stream().map(Article::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
        urls.forEach(System.out::println);

    }
}
