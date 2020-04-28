package com.generate.alphanumeric.controllers;

import com.generate.alphanumeric.models.Response;
import com.generate.alphanumeric.components.GenerateText;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/generate/alphanumeric")
public class AlphanumericController {

  private static final Integer RECORDS_PER_PAGE = 50;

  /**
   * This method will read the request and send generated alphanumeric list
   *
   * @param number telephone number
   * @param pageNumber page number
   * @return Response object
   */
  @GetMapping(value = "/{number}/{pageNumber}")
  public @ResponseBody Response getAlpha(
      @PathVariable String number, @PathVariable Integer pageNumber) {
    Response response = new Response();
    GenerateText generateText = new GenerateText(number, pageNumber, RECORDS_PER_PAGE);

    response.setData(generateText.getCombinationsByPage());
    response.setCount(generateText.getCount());

    return response;
  }
}
