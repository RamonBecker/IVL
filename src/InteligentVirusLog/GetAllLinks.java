package InteligentVirusLog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class GetAllLinks {
 
    public static void main(String[] args) throws IOException {
 
        Document doc = Jsoup.connect("https://www.avira.com/pt-br/support-virus-lab?vdl%5Bsq%5D=TR%2FSamca").get();
 
        // Elements extends ArrayList<Element>.
        Elements aElements = doc.getElementsByTag("a");
 
        for (Element aElement : aElements) {
            String href = aElement.attr("href");
            String text = aElement.text();
            //System.out.println(text);
            //System.out.println("\t" + href);
            if(href.contains("tid"))
                System.out.println(href);           
        }
    }
 
}
   
 


