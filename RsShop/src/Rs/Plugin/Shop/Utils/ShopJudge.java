package Rs.Plugin.Shop.Utils;

/**
 * Created by Rlx on 2016/2/16.
 */
public class ShopJudge {
    public boolean isNewShop(String text){
        //System.out.println(sign.getText()[0]);
        if(text.equals("SHOP")){
            return true;
        }else if(text.equals("shop")) {
            return true;
        }else{
            return false;
        }
    }
}
