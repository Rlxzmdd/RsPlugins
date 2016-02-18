package Rs.Plugin.Shop;

import Rs.Plugin.Shop.Utils.SignUtils;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/15.
 */
public class Shop {
    public BlockEntitySign sign;
    public cn.nukkit.utils.Config config =  null;
    public Shop(BlockEntitySign sign){
        this.sign = sign;
    }
    public boolean isShop(){
        return getFile().exists();
    }
    public File getFile(){
        return new SignUtils(sign).getFile();
    }
    public Config getConfig(){
        if(this.config == null) {
            Config config = new Config(getFile(),Config.JSON);
            this.config = config;
            return this.config;
        }
        return this.config;
    }
    public Item getItem() {
        if (getConfig().get("Item").toString().equals("0")) {
            return null;
        }else{
            String[] asd = getConfig().get("Item").toString().split("\\.");
            return new Item((
                    Integer.parseInt(asd[0]))
                    , new Integer(asd[1])
                    ,Integer.parseInt(getConfig().get("Number").toString()));
        }
    }
    public void setItem(Item item){
        getConfig().set("Item",item.getId()+"."+item.getDamage());
        getConfig().set("Numbet",item.getCount());
    }
}
