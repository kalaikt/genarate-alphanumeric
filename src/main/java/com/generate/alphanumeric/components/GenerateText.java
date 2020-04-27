package com.generate.alphanumeric.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class GenerateText {
    private ArrayList<String> responseList = new ArrayList<String>();
    private String numbers;
    private Integer recordsPerPage;
    private Integer currentPage;

    public GenerateText(){}

    public GenerateText(String numbers, Integer currentPage, Integer recordsPerPage) {
        this.numbers = numbers;
        this.currentPage = currentPage;
        this.recordsPerPage = recordsPerPage;
        this.generageLetterCombinations();
    }

    private void generageLetterCombinations() {

        ArrayList<String> preResList = new ArrayList<String>();
        responseList.add("");

        for(int i = 0; i < numbers.length(); i++) {
            String letters = map.get(numbers.charAt(i));
            if (letters.length() == 0)
                continue;
            for(String str : responseList) {
                for(int j = 0; j < letters.length(); j++)
                    preResList.add(str + letters.charAt(j));
            }
            responseList = preResList;
            preResList = new ArrayList<String>();
        }
    }

    public ArrayList<String> getAllCombinations(){
        return responseList;
    }

    public List<String> getCurrentPageData(){
        return responseList.subList(getStartIndex(), getEndIndex());
    }

    public Integer getCount(){
        return responseList.size();
    }

    public Integer getStartIndex(){
        return (recordsPerPage * currentPage) - recordsPerPage;
    }

    public Integer getEndIndex(){
        return recordsPerPage * currentPage;
    }

    static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('1', "");
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
        put('0', "");
    }} ;
}
