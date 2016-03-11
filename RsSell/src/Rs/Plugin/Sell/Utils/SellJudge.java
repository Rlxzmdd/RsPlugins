package Rs.Plugin.Sell.Utils;

import Rs.Plugin.Sell.Sell;
import cn.nukkit.blockentity.BlockEntitySign;

/**
 * Created by Rlx on 2016/2/16.
 */
public class SellJudge {
    public boolean isNewShop(String text){
        //System.out.println(sign.getText()[0]);
        if(text.equals("SELL")){
            return true;
        }else if(text.equals("sell")) {
            return true;
        }else{
            return false;
        }
    }
    public boolean isShop(BlockEntitySign sign){
        return new Rs.Plugin.Sell.Utils.SignUtils(sign).getFile().exists();
    }
    public boolean isWillShop(Sell shop){
        if(shop.getItem() == null){
            return true;
        }else{
            return false;
        }
    }
}
