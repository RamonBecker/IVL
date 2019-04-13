/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteligentVirusLog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PegandoLinks {
 
    public static void main(String[] args) throws IOException {
       
        Document doc = Jsoup.connect("https://www.avira.com/pt-br/support-virus-lab?vdl%5Bsq%5D=TR%2FSamca").get();
 
        
       
    
       
        Elements aElements = doc.getElementsByTag("a");
        String href=null;        
        for (Element aElement : aElements) {
            href = aElement.attr("href");
            String text = aElement.text();
            //System.out.println(text);
            //System.out.println("\t" + href);
            if(href.contains("tid")){
                System.out.println(href);
                break;
            }                          
        }
                  
        
         href = "www.avira.com"+href;
         System.out.println(href);    

  
    }

    
}
   

