package com.example.designpatternspider.selenium.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * EMA（12）= 前一日EMA（12）×11/13＋今日收盘价×2/13
 * EMA（26）= 前一日EMA（26）×25/27＋今日收盘价×2/27
 * DIFF=今日EMA（12）- 今日EMA（26）
 * DEA（MACD）= 前一日DEA×8/10＋今日DIF×2/10 
 * BAR=2×(DIFF－DEA)
 */

public class MacdIndicator {

    /**
     * Calculate EMA,
     *
     * @param list :Price list to calculate，the first at head, the last at tail.
     * @return
     */
    public static final Double getEXPMA(final List<Double> list, final int number) {
        // 开始计算EMA值，
        Double k = 2.0 / (number + 1.0);// 计算出序数
        Double ema = list.get(0);// 第一天ema等于当天收盘价
        for (int i = 1; i < list.size(); i++) {
            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
            ema = list.get(i) * k + ema * (1 - k);
        }
        return ema;
    }

    /**
     * Calculate EMA, FOR BIGDECIMAL
     *
     * @param list :Price list to calculate，the first at head, the last at tail.
     * @return
     */
    public static final BigDecimal getEXPMABigDecimal(final List<BigDecimal> list, final int number) {
        // 开始计算EMA值，计算出序数
        BigDecimal k = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(number + 1));
        // 第一天ema等于当天收盘价
        BigDecimal ema = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
            ema = list.get(i).multiply(k).add(ema.multiply(BigDecimal.ONE.subtract(k)));
        }
        return ema;
    }

    /**
     * calculate MACD values
     *
     * @param list        :Price list to calculate，the first at head, the last at
     *                    tail.
     * @param shortPeriod :the short period value.
     * @param longPeriod  :the long period value.
     * @param midPeriod   :the mid period value.
     * @return
     */
    public static final HashMap<String, Double> getMACD(final List<Double> list, final int shortPeriod,
            final int longPeriod, int midPeriod) {
        HashMap<String, Double> macdData = new HashMap<>();
        List<Double> diffList = new ArrayList<>();
        Double shortEMA = 0.0;
        Double longEMA = 0.0;
        Double dif = 0.0;
        Double dea = 0.0;

        for (int i = list.size() - 1; i >= 0; i--) {
            List<Double> sublist = list.subList(0, list.size() - i);
            shortEMA = getEXPMA(sublist, shortPeriod);
            longEMA = getEXPMA(sublist, longPeriod);
            dif = shortEMA - longEMA;
            diffList.add(dif);
        }
        dea = getEXPMA(diffList, midPeriod);
        macdData.put("DIF", dif);
        macdData.put("DEA", dea);
        macdData.put("MACD", (dif - dea) * 2);
        return macdData;
    }

    public static final HashMap<String, BigDecimal> getMACDBigDecimal(final List<BigDecimal> list,
            final int shortPeriod, final int longPeriod, int midPeriod) {
        HashMap<String, BigDecimal> macdData = new HashMap<>();
        List<BigDecimal> diffList = new ArrayList<>();
        BigDecimal shortEMA = BigDecimal.ZERO;
        BigDecimal longEMA = BigDecimal.ZERO;
        BigDecimal dif = BigDecimal.ZERO;
        BigDecimal dea = BigDecimal.ZERO;

        for (int i = list.size() - 1; i >= 0; i--) {
            List<BigDecimal> subList = list.subList(0, list.size() - i);
            shortEMA = getEXPMABigDecimal(subList, shortPeriod);
            longEMA = getEXPMABigDecimal(subList, longPeriod);
            dif = shortEMA.subtract(longEMA);
            diffList.add(dif);
        }
        dea = getEXPMABigDecimal(diffList, midPeriod);
        macdData.put("DIF", dif);
        macdData.put("DEA", dea);
        macdData.put("MACD", dif.subtract(dea).multiply(BigDecimal.valueOf(2)));
        return macdData;
    }

}