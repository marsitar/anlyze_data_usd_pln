package com.sitarski.marek;

import com.sitarski.marek.service.FinacialMapper;

public class App {

  public static void main(String[] args) {
    FinacialMapper finacialMapper = new FinacialMapper();
    finacialMapper.doFinacialMapping();
  }
}
