package com.example.designpatternspider.selenium.huobi.api.huobi.client.req.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.example.designpatternspider.selenium.huobi.api.huobi.constant.enums.OrderSideEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BatchCancelOpenOrdersRequest {

  private Long accountId;

  private String symbol;

  private OrderSideEnum side;

  private Integer size;

}
