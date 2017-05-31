
import java.io.IOException;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Crawling {
	public static void main(String[] args)throws IOException{
		System.out.println("웹 파싱 시작");
    	String item;
    	
    	ArrayList<String> naverShopURL = new ArrayList<String>();
        String base = "http://shopping.naver.com/search/all.nhn?query=";
        String KEYWORD = "아메리카노";
        
        Crawling crawler = new Crawling();
        IDparsing parse = new IDparsing();
        ManipulateUrl manipulateUrl = new ManipulateUrl();
        
    	
    	//final String query = "http://shopping.naver.com/search/all.nhn?query=가습기";
    	
    	
    	
    	
    	naverShopURL = manipulateUrl.makeUrl("http://shopping.naver.com/detail/detail.nhn?",KEYWORD,parse.getModelId(base, KEYWORD));
    		
    		
    	for(int i=0;i<naverShopURL.size();i++){
    		crawler.getCategory(KEYWORD);
    		crawler.getBrandName(naverShopURL.get(i));
    		crawler.getUrl(naverShopURL.get(i));
    		
			
    	}
    	
    	for(int i=0;i<naverShopURL.size();i++){
    		//crawler.getProductReview(naverShopURL.get(i));
    		
    	}
    	
		//http://shopping.naver.com/search/all.nhn?query=%EA%B0%80%EC%8A%B5%EA%B8%B0
    	//http://shopping.naver.com/search/all.nhn?query=

		
		}
	void getCategory(String keyword){
		System.out.print("||");
		System.out.print(keyword);
		System.out.print("||");
	}
	
	void getBrandName(String url) throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements brandName = doc.select("div.h_area h2");
		System.out.print(brandName.text());
		System.out.print("||");	
		
		
	}
	void getUrl(String url){
		System.out.print(url);
		System.out.println("||");
	}
	
	void getProductReview(String url) throws IOException{
		
    	int cnt1=1;
    	int cnt2=1;
    	
    	
    	
    	for(cnt1 = 1; cnt1<=1 ; cnt1++){
    		url = url + "&page="+cnt1;
		Document doc = Jsoup.connect(url).get();
		//Document doc_query = Jsoup.connect(query).get();
		
		Elements scraping = doc.select("div.atc");
		
		for(Element e : scraping){
		System.out.println(cnt2+e.text());
		System.out.print("||");
		cnt2++;
		}
		
    	}
	}
	
	
}

