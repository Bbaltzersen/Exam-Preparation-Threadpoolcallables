/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.preparation_threadpoolcallables;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class GetInfo implements Callable<String> {
    
    String url;

    public GetInfo(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        return info(url);
    }

    private String info(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements authors = doc.select("#authors");
        Elements classCBA = doc.select("#class");
        Elements group = doc.select("#group");
        String info = authors.text() + "#" + classCBA.text() + "#" + group.text();
        return info;
    }

}

public class ScrapeInfo {
     List<Group> groups = new ArrayList<>();

    public List<Group> getGroups() {
        return groups;
    }
    /**
     *
     * @param urls
     * @param threadCount how many threads do we have avaliable?
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public void scapeInfo(List<String> urls, int threadCount) throws InterruptedException, ExecutionException {
        //The list that will have all the responses from the executor
        
        List<Future<String>> list = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < urls.size(); i++) {
            Callable<String> task = new GetInfo(urls.get(i));
            list.add(executor.submit(task));
        }
        executor.shutdown();

        for (Future<String> list1 : list) {
            groups.add(new Group().fixGroup(list1.get()));
        }
        System.out.println(groups.size());
//        
//        System.out.println("Number of primes: " + primes);
    }

}
