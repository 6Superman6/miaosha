package demo.utils;

import java.math.BigDecimal;

/**
 * Created by geely
 */
public class BigDecimalUtil {

    private BigDecimalUtil(){

    }

    public static BigDecimal add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(2,BigDecimal.ROUND_HALF_UP);   //保留两位小数
    }

    public static BigDecimal sub(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(2,BigDecimal.ROUND_HALF_UP);   //保留两位小数
    }


    public static BigDecimal mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(2,BigDecimal.ROUND_HALF_UP);   //保留两位小数
    }

    public static BigDecimal div(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,4,BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100L));//四舍五入,保留4位小数
//        return b1.divide(b2,5,BigDecimal.ROUND_HALF_UP);//四舍五入,保留2位小数
    }





}
