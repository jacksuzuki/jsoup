package jsoup;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main  {
    
    @Autowired
    BusinessLogic logic;

    public static void main(String[] args) throws IOException, ParseException {
//        SpringApplication.run(Main.class, args);
        
        System.out.println("business start");
        
        File in = new File("bazzar.txt");
        Document doc = Jsoup.parse(in, "UTF-8");
        Elements list= doc.select("table.bazaarList td");
        
        String regex = ".*個数：(\\d{1,2})こ 価格：(\\d{1,3}(,\\d{3})*)G .*";
        Pattern p = Pattern.compile(regex);
        
        NumberFormat nf= NumberFormat.getIntegerInstance();
       for(int i=0;i<list.size();i++){
//          if(i%3==0){
//               System.out.println("detail");
//          }
          if(i%3==1){
              Matcher m = p.matcher(list.get(i).text());
              if(m.find()){
                  int count = Integer.valueOf(m.group(1));
                 Number value = nf.parse(m.group(2));
                 
                 System.out.println(count);
                 System.out.println(value);
              }
             
              
          }
       }
        
        
//       

    }

}
