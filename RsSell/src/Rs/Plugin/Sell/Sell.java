package Rs.Plugin.Sell;

import Rs.Plugin.Sell.Utils.*;
import cn.nukkit.blockentity.BlockEntitySign;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;

import java.io.File;

/**
 * Created by Rlx on 2016/2/15.
 */
public class Sell {
    public BlockEntitySign sign;
    public cn.nukkit.utils.Config config =  null;
    public Sell(BlockEntitySign sign){
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
        if (getConfig().get("Number").toString().equals("0")) {
            return null;
        }else{
           // System.out.print(getConfig().get("Number").toString());
            String[] asd = getConfig().get("Item").toString().split("\\.");
            return new Item((
                    Integer.parseInt(asd[0]))
                    , new Integer(asd[1])
                    ,Integer.parseInt(getConfig().get("Number").toString()));
        }
    }
    public void setItem(Item item){
        if(item.getId() == 0){
            return;
        }
        getConfig().set("Item",item.getId()+"."+item.getDamage());
        getConfig().set("Number",item.getCount()+"");
        getConfig().save();
        sign.setText(sign.getText()[0],sign.getText()[1],sign.getText()[2],new Config(new File("plugins/RsSell/")+"/config.yml").getString("Text4").replaceAll("%item",""+item.getId()+"."+item.getDamage()).replaceAll("%number", item.getCount() + ""));
    }
    public void del(){
        ( new File( new SignUtils(sign).file+"/Shops/", new SignUtils(sign).getFileName())).delete();
    }
    public float getMoney(){
        float money = Float.parseFloat(getConfig().getString("Money"));
        return ( money);
    }
    public String  getCoin(){
        String money = (getConfig().getString("Coin"));
        return ( money);
    }
    public void setMoney(){
        float money = Float.parseFloat(getConfig().getString("Money"));
    }
    /*
    public void canFly(Player p){
        //文件格式：
        //x1: x1
        Double x1,z1,x2,z2;
        //z1: z1
        //x2: x2
        //z2: z2
        //就不考虑y了（也就是高度

        if(x1 > x2){//x坐标的三种种情况
            if(p.getX() > x2 || p.getX() < x1){
                //判断玩家是否在两个x之间
                //判断y
            }else{
                return;
            }
        }else if(x2 > x1){
            if(p.getX() < x2 || p.getX() > x1){
                //判断玩家是否在两个x之间
                //然后判断y
            }else{
                return;
            }
        }else{
            //判断y
        }
    }
    */
}
