package test;


import util.Tools;

import java.util.List;

public class RegExTest {
    public static void main(String[] args) {
        String result = queryPayment(" "," ");
        System.out.println("result:====" + result);

    }
    /**
     *查询缴费信息的方法
     * @param phoneNum 手机号码（传进来的）
     * @param iccid 身份证号码（传进来的）
     * @return "话费金额："+billAmount+"  缴费日期"+paymentDate;
     * @author NTEAAG520
     */
    public static String queryPayment(String phoneNum,String iccid){
        String string = "";
        List list2 = Tools.getLstVal(string.replaceAll("\\s", ""), "<tdheight=\"25\">(.+?)</td>");
        System.out.println(list2.toString());
        String billAmount = "";
        String paymentDate = "";
        if (list2.size() > 1) {
            billAmount = (String) list2.get(21);//1.0
            paymentDate = (String) list2.get(16);//20170802183624
            paymentDate = transDate(paymentDate);
        }
        System.out.println("billAmount: " + billAmount);//1.0
        System.out.println("paymentDate: " + paymentDate);//20170802183624
        if ("".equals(billAmount)) {
            return "查询缴费信息失败,参数为空,method_j1551_1!";
        }
        if ("".equals(billAmount)) {
            return "查询缴费信息失败,参数为空,method_j1551_1!";
        }
        return "话费金额："+billAmount+"元  缴费日期："+paymentDate;
    }

    /**
     *把数字日期转换的方法
     * @return 格式化以后的完整日期
     */
    public static String transDate(String dateString){
        StringBuilder sb = new StringBuilder(dateString);//构造一个StringBuilder对象
        sb.insert(4, "年");//在指定的位置1，插入指定的字符串
        dateString = sb.toString();
        sb.insert(7, "月");
        sb.insert(10, "日 ");
        sb.insert(14, ":");
        sb.insert(17, ":");
        dateString = sb.toString();
        return dateString;
    }
}
