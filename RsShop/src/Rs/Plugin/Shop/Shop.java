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
        sign.setText(sign.getText()[0],sign.getText()[1],sign.getText()[2],new Config(new File("plugins/RsShop/")+"/config.yml").getString("Text4").replaceAll("%item",""+item.getId()+"."+item.getDamage()).replaceAll("%number", item.getCount() + ""));
    }
    public void del(){
       new File( new SignUtils(sign).file, new SignUtils(sign).getFileName()).delete();
    }
    public float getMoney(){
        float money = Float.parseFloat(getConfig().getString("Money"));
        return ( money);
    }
    public void setMoney(){
        float money = Float.parseFloat(getConfig().getString("Money"));
    }
    /*
    public void canFly(Player p){
        //�ļ���ʽ��
        //x1: x1
        Double x1,z1,x2,z2;
        //z1: z1
        //x2: x2
        //z2: z2
        //�Ͳ�����y�ˣ�Ҳ���Ǹ߶�

        if(x1 > x2){//x��������������
            if(p.getX() > x2 || p.getX() < x1){
                //�ж�����Ƿ�������x֮��
                //�ж�y
            }else{
                return;
            }
        }else if(x2 > x1){
            if(p.getX() < x2 || p.getX() > x1){
                //�ж�����Ƿ�������x֮��
                //Ȼ���ж�y
            }else{
                return;
            }
        }else{
            //�ж�y
        }
    }
    */
}
