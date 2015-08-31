package jsoup;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class BusinessLogic {
    
    
    @PostConstruct
    public void init() throws IOException{
        System.out.println("business start");
        
        File in = new File("bazzar.txt");
        Document doc = Jsoup.parse(in, "UTF-8");
        Elements newsHeadlines = doc.select("table.bazaarList");
        
        System.out.println(newsHeadlines.get(0).text());
    }

}
