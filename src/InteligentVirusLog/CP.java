/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteligentVirusLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class CP {
      private Document document = new Document("");
      ArrayList desc = new ArrayList<String>();
      
      public CP(String href) {
        
        try {
            this.document = Jsoup.connect("https://"+href).get();
        } catch (IOException ex) {
            Logger.getLogger(CP.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getFooter();//metodo para definir e pegar as tags e classes
    }
      
    
    public static void main(String[] args) {
        new CP("");
        
        
    }
    
    
        //metodo 
    public void getFooter() {
      
      //  Elements elements1 = document.getElementsByClass("list-content");
        //getFooterListadiv(elements1.eq(0));//Definindo a classe list-content que é uma div
        
         Elements elements2 = document.getElementsByClass("list-content");
        getFooterListadiv1(elements2.eq(2));//Definindo a classe list-content que é uma div
        
        Elements elements3 = document.getElementsByClass("list-content");
        getFooterListadiv3(elements3.eq(3));//Definindo a classe list-content que é uma div
        
        Elements elements = document.getElementsByTag("p");
        getFooterPagina(elements.eq(0)); //Definindo a tag p(paragrafo)

    }  
   
    //public void getFooterListadiv(Elements elements1) {
      
        
      // for(Element element : elements1){//verefica os elementos da classe definida no metodo getFooter
        //String cla2 =  element.getElementsByClass("list-content").text();//pegando o conteudo da classe
        //Elements div = element.getElementsByTag("div");//definindo a tag  a ser pegada div 
        //for(Element p : div){//verefica a tag definida
           // String div1  = element.getElementsByTag("div").text();//pega o conteudo da tag
            //System.out.println("Nome Vírus:\n"+div1);//imprimi a nome do virus
            
        //}
        
          //  }
    //}
     
    public void getFooterListadiv1(Elements elements2) {
        for(Element element : elements2){//verefica os elementos da classe definida no metodo getFooter
        
        //String cla2 =  element.getElementsByClass("list-content").text();//pegando o conteudo da classe
        
        Elements div = element.getElementsByTag("div");//definindo a tag  a ser pegada div
        
        
        for(Element p : div){//verefica a tag definida
          //  String div1  = element.getElementsByTag("div").text();//pega o conteudo da tag
            desc.add(p.getElementsByTag("div").text());
            
            
            System.out.println("\nCategoria:\n"+desc);
            
            }    
   
        }
    }
    public void getFooterListadiv3(Elements elements3) {
        for(Element element : elements3){//verefica os elementos da classe definida no metodo getFooter
        //tring cla2 =  element.getElementsByClass("list-content").text();//pegando o conteudo da classe
        Elements div = element.getElementsByTag("div");//definindo a tag  a ser pegada div
        for(Element p : div){//verefica a tag definida
           // String div1  = element.getElementsByTag("div").text();//pega o conteudo da tag
            desc.add(p.getElementsByTag("div").text());
            
            System.out.println("\nIMPACTO:\n"+desc);
            }
        }
    }
    public void getFooterPagina(Elements elements) {
        
        
        //Elements tag = document.getElementsByTag("p");
        for(Element element : elements){//verefica os elementos da tag definida no metodo getFooter
        Elements tag = element.getElementsByTag("p"); //definindo a tag  a ser pegada di
            for(Element pegar : tag){//verefica a tag definida
                     desc.add(pegar.getElementsByTag("p").text()) ;
                    
                     System.out.println("\n\nDescrição do Virus:\n"+desc);
                
                    
            }
        //}
     //return desc;       
     }
    }

    public ArrayList getDesc() {
        return desc;
    }

    public void setDesc(ArrayList desc) {
        this.desc = desc;
    }

 }
