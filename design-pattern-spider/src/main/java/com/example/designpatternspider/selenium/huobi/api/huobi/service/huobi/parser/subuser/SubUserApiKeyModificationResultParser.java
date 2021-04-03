package com.example.designpatternspider.selenium.huobi.api.huobi.service.huobi.parser.subuser;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.designpatternspider.selenium.huobi.api.huobi.model.subuser.SubUserApiKeyModificationResult;
import com.example.designpatternspider.selenium.huobi.api.huobi.service.huobi.parser.HuobiModelParser;

public class SubUserApiKeyModificationResultParser implements HuobiModelParser<SubUserApiKeyModificationResult> {

  @Override
  public SubUserApiKeyModificationResult parse(JSONObject json) {
    return json.toJavaObject(SubUserApiKeyModificationResult.class);
  }

  @Override
  public SubUserApiKeyModificationResult parse(JSONArray json) {
    return null;
  }

  @Override
  public List<SubUserApiKeyModificationResult> parseArray(JSONArray jsonArray) {
    return null;
  }
}
