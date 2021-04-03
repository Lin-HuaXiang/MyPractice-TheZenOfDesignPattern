package com.example.designpatternspider.selenium.huobi.api.huobi.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  SubUserManagementActionEnum {

  LOCK("lock"),
  UNLOCK("unlock"),

  ;
  private String action;
}
