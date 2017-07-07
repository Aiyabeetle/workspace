package com.example.web;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aiyabeetle on 2017/5/30.
 */
public class MathCalcController {
    public static void main(String[] args){
        BigDecimal xi,xj,yi,yj;
        int count = 0;
        DecimalFormat fd  =   new  DecimalFormat("##0.00");
        List<Map> list = new ArrayList<>();
        Map<BigDecimal,BigDecimal> map = new HashMap<>();
        while (true){
            xi = getRandomNum();
            xj = getRandomNum();
            yi = getRandomNum();
            yj = getRandomNum();
            double sumX = xi.subtract(xj).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double sumY = yi.subtract(yj).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            double num = Math.pow(sumX,2)+Math.pow(sumY,2);
            if( num < 0.09){
                map.put(xi,yi);
                System.out.println("第"+count+"组:xi:yi==="+xi+":"+yi);
                count++;
            }
            if(count>9){
                break;
            }
        }
    }

    public static BigDecimal getRandomNum(){
        return new BigDecimal(Math.random()*(Math.random()>0.5?2:-2)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
