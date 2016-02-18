package Rs.Plugin.Shop.Utils;

import Rs.Plugin.Shop.Shop;
import cn.nukkit.blockentity.BlockEntitySign;

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
    public boolean isShop(BlockEntitySign sign){
        return new SignUtils(sign).getFile().exists();
    }
    public boolean isWillShop(Shop shop){
        if(shop.getItem() == null){
            return false;
        }else{
            return true;
        }
    }
}
