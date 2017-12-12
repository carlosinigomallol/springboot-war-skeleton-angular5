package es.test.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.charlie.example.model.entity.Article;
import com.charlie.example.services.service.IArticleService;
import com.charlie.example.web.MyApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(classes =MyApplication.class)
public class TestDao {

	@Autowired
	IArticleService testDaoService;
	
	
	@Test
	public void testArticleDao(){
		
		for(Article a: testDaoService.getAllArticles()){
			System.out.println(a.getArticleId());
		}
		
	}
	
}
