/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteligentVirusLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class IVL {

    public static final String SITE = "http://www.avira.com/pt-br/support-virus-lab?vdl%5Bsq%5D=";

    public ArrayList<String> metIvl(String nomeArquivo){
        ArrayList<String> meuTexto = new ArrayList<String>();
        String linha = "";
        File arq = new File(nomeArquivo);
        
        System.out.println(""+arq);
        
        if(arq.exists()){
        //URLConnectionReader url = new URLConnectionReader();    
            try{
                String v[], v2[], vT[];
                
                FileReader leitorDeArquivo = new FileReader(nomeArquivo);
                //leitorDeArquivo.getEncoding();
                //faz a leitura do arquivo
                BufferedReader bufferDeArquivo = new BufferedReader(leitorDeArquivo);
                //carregar em memória
                while(true){
                //leitura das linhas até chegar em nula (para)    
                    linha = bufferDeArquivo.readLine();
                    
                    if(linha == null){
                       break;
                    }
                    //System.out.println("Texto: " + linha);
            if(linha.contains("[ D E T E C � � O ]")){
                    v = linha.split(" "); 
                    vT = v[v.length -1].split("/");
                    //url.consultaVirusSite(SITE+vT[1]);
                  
                    System.out.println("Nome: " + vT[1]);
                    meuTexto.add(vT[1]);
                    
                    v2 = v[v.length -1].split("/");
                        System.out.println("Categoria: " + v2[0]);
                }
                
            }
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }
        System.out.println("Quantidade: " + meuTexto.size());
        return meuTexto;
    }
}