/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.preparation_threadpoolcallables;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author bbalt
 */
public class GetInfoFromUrl {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> urls = new Utility().urls;
        ScrapeInfo si = new ScrapeInfo();
        si.scapeInfo(urls, 3);
        System.out.println(si.getGroups().size());
        
    }
    
}
