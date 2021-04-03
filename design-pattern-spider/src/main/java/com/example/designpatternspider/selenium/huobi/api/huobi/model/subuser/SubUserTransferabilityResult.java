package com.example.designpatternspider.selenium.huobi.api.huobi.model.subuser;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubUserTransferabilityResult {

  private List<SubUserTransferabilityState> list;

}
