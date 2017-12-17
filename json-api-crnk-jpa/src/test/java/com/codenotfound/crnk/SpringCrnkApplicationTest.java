package com.codenotfound.crnk;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.codenotfound.crnk.client.BlogClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringCrnkApplicationTest {
  @Autowired
  BlogClient blogClient;

  @Test
  public void testFindOneArticle() {
    assertThat(blogClient.findOneArticle(1L).getTitle()).isEqualTo("JSON API paints my bikeshed!");
  }
}
