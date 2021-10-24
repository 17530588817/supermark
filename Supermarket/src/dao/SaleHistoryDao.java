package dao;

import entity.SaleHistory;
/*
 *
 *
 * */
public class SaleHistoryDao {
    public boolean newSaleHistoryDao(SaleHistory saleHistory){
        boolean flag = false;
        if (saleHistory.getCustomerNo()==0) {
            System.out.println("这个人的信息没必要插入");
            return flag;
        }
        else{
            String sql = "insert into salehistory(productno,salecount,price,discount,userID,saletime,customerno) values(?,?,?,?,?,?,?)";
            Object[] objs = {saleHistory.getProductNo(),saleHistory.getSaleCount(),saleHistory.getPrice(),saleHistory.getDiscount()
                    ,saleHistory.getUserId(),saleHistory.getSaleTime(),saleHistory.getCustomerNo()};
            flag = DBManager.executeUpdate(sql, objs);
            System.out.println("插入在当前收银台的这个会员的消费信息");
            return flag;
        }
    }
}
