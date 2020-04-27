package com.generate.alphanumeric.controllers;

import com.generate.alphanumeric.models.Response;
import com.generate.alphanumeric.components.GenerateText;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/generate/alpha")
public class AlphanumericController {

    private static final Integer RECORDS_PER_PAGE = 25;

    @GetMapping(value = "/{number}/{page}")
    public @ResponseBody Response getAlpha(@PathVariable String number, @PathVariable Integer page) {
        Response response = new Response();
        GenerateText generateText = new GenerateText(number, page, RECORDS_PER_PAGE);

        response.setData(generateText.getCurrentPageData());
        response.setCount(generateText.getCount());

        return response;
    }
}
