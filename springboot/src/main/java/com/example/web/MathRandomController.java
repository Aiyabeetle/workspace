package com.example.web;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class MathRandomController {

    private static ArrayList<NumObj> listAll = new ArrayList();
    private Double allNum[] = null;
    private static NumObj num1;
    public static void main(String[] args){
        num1 = getRandomNum();
        listAll.add(num1);
        compareNum();
    }

    //获取随机数
    public static NumObj getRandomNum(){
        DecimalFormat fd  =   new  DecimalFormat("##0.00");
        //List list = new ArrayList();
        double arr1,arr2;
        NumObj obj = new NumObj();
        arr1 = Double.parseDouble(fd.format(Math.random()*(Math.random()>0.5?2:-2)));
        arr2 = Double.parseDouble(fd.format(Math.random()*(Math.random()>0.5?2:-2)));
        obj.setNum1(arr1);
        obj.setNum2(arr2);
        //list.add(obj);
        return obj;
    }

    public static boolean getFlag(NumObj obj1,NumObj obj2){
        if(Math.pow(obj1.getNum1()-obj2.getNum2(),2)+Math.pow(obj1.getNum1()-obj2.getNum2(),2) < 0.09){
            return false;
        }else{
            return  true;
        }
    }

    public static void compareNum(){
        NumObj num2 = getRandomNum();
        List list = new ArrayList();
        for (int i=0; i<list.size();i++){
            list.add(getFlag(num1,num2));

        }
        for (int k=0;k<list.size();k++){
            if (list.get(k).equals(false)){
                compareNum();
            }else{
                listAll.add(num2);
                if (listAll.size() > 9){
                    for(int j=0; j<listAll.size(); j++){
                        System.out.println(listAll.get(j).getNum1()+":"+listAll.get(j).getNum2());

                    }
                }else{
                    compareNum();
                }
            }
        }
    }
}




class NumObj{
    private double num1;
    private double num2;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
}