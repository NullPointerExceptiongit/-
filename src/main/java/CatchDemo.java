

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CatchDemo {
	
	public static void main(String[] args) throws Exception{
		String url="https://gongyi.sina.com.cn/";
		Document doc = Jsoup.connect(url).get();
		String selector="ul[class=seo_data_list]>li>a";
		File f=new File("D:/a/news.text");
		if(!f.exists()){
			f.createNewFile();
		}		
		PrintWriter pw=new PrintWriter(
				new BufferedOutputStream(
						new FileOutputStream(f)));
		
		Elements eles = doc.select(selector);
		int count=0;
		for(Element e:eles){
			pw.println(e.text());
			pw.flush();
			System.out.println(e.text());
			count++;
		}
		System.out.println(count);
		pw.close();
	}
	
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


