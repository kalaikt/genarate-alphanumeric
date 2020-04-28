/** This class use to generate combination of alphanumeric list to given input */
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
  private Integer pageNumber;

  public GenerateText() {}

  /**
   * This constructor will set the initial values
   *
   * @param numbers telephone keypad numbers
   * @param pageNumber page number
   * @param recordsPerPage total no of records per page
   */
  public GenerateText(String numbers, Integer pageNumber, Integer recordsPerPage) {
    this.numbers = numbers;
    this.pageNumber = pageNumber;
    this.recordsPerPage = recordsPerPage;
    this.generateLetterCombinations();
  }

  /** This method used to generate combination of alphanumeric list */
  private void generateLetterCombinations() {

    ArrayList<String> preResList = new ArrayList<String>();
    responseList.add("");

    for (int i = 0; i < numbers.length(); i++) {
      String letters = map.get(numbers.charAt(i));
      if (letters.length() == 0) continue;
      for (String str : responseList) {
        for (int j = 0; j < letters.length(); j++) preResList.add(str + letters.charAt(j));
      }
      responseList = preResList;
      preResList = new ArrayList<String>();
    }
  }

  /**
   * This method returns all combination list
   *
   * @return ArrayList<string>
   */
  public ArrayList<String> getAllCombinations() {
    return responseList;
  }

  /**
   * This method returns alphanumeric combination by page
   *
   * @return List<String>
   */
  public List<String> getCombinationsByPage() {
    return responseList.subList(getStartIndex(), getEndIndex());
  }

  /**
   * This method return total count
   *
   * @return Integer
   */
  public Integer getCount() {
    return responseList.size();
  }

  /**
   * This method return starting index
   *
   * @return Integer
   */
  public Integer getStartIndex() {
    return (recordsPerPage * pageNumber) - recordsPerPage;
  }

  /**
   * This method return ending index
   *
   * @return Integer
   */
  public Integer getEndIndex() {
    return recordsPerPage * pageNumber;
  }

  /** Storing telephone keypad alphanumeric in hash map */
  static final HashMap<Character, String> map =
      new HashMap<Character, String>() {
        {
          put('1', "1");
          put('2', "2abc");
          put('3', "3def");
          put('4', "4ghi");
          put('5', "5jkl");
          put('6', "6mno");
          put('7', "7pqrs");
          put('8', "8tuv");
          put('9', "9wxyz");
          put('0', "0");
        }
      };
}
