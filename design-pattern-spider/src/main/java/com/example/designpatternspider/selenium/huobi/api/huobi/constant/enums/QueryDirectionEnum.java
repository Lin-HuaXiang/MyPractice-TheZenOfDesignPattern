package com.example.designpatternspider.selenium.huobi.api.huobi.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QueryDirectionEnum {
  PREV("prev"),
  NEXT("next");

  private final String code;

}
