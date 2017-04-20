package com.codenotfound.katharsis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.codenotfound.katharsis.client.BlogClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringKatharsisApplicationTest {
  @Autowired
  BlogClient blogClient;

  @Test
  public void testFindOneArticle() {
    assertThat(blogClient.findOneArticle(1L).getTitle().equals("John"));
  }

  @Test
  public void findOnePerson() {
    assertThat(blogClient.findOnePerson(1L).getName().equals("John"));
  }
}
