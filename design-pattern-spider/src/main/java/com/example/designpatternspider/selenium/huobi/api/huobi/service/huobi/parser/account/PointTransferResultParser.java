package com.example.designpatternspider.selenium.huobi.api.huobi.service.huobi.parser.account;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.designpatternspider.selenium.huobi.api.huobi.model.account.PointTransferResult;
import com.example.designpatternspider.selenium.huobi.api.huobi.service.huobi.parser.HuobiModelParser;

public class PointTransferResultParser implements HuobiModelParser<PointTransferResult> {

  @Override
  public PointTransferResult parse(JSONObject json) {
    return json.toJavaObject(PointTransferResult.class);
  }

  @Override
  public PointTransferResult parse(JSONArray json) {
    return null;
  }

  @Override
  public List<PointTransferResult> parseArray(JSONArray jsonArray) {
    return null;
  }

}
