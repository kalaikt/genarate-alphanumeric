package com.generate.alphanumeric.components;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GenerateTextTest {

  private GenerateText mockGenText() {
    GenerateText generateText = new GenerateText("23", 1, 5);

    return generateText;
  }

  @Test
  void getAllCombinations() {
    assertEquals("23", mockGenText().getAllCombinations().get(0));
  }

  @Test
  void getCombinationsByPage() {
    assertEquals(5, mockGenText().getCombinationsByPage().size());
  }

  @Test
  void getCount() {
    assertEquals(16, mockGenText().getAllCombinations().size());
  }
}
