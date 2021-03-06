package Rs.Plugin.Money.Object;

import Rs.Plugin.Money.MoneyMainClass;
import Rs.Plugin.Money.Object.MoneyConfig;
import cn.nukkit.Player;

/**
 * Created by Rlx on 2016/2/15.
 */
public class MoneyClass {
    public String name;
    public MoneyClass(String name){
        this.name = name;
    }
    public MoneyClass(Player player){
        name = player.getName();
    }
    public MoneyConfig getMoneyConfig(){
        return new MoneyConfig(name);
    }
    public float reduceMoney(float money){
        float mon = this.getMoneyConfig().getMoney();
        if(money > mon){
            return money-mon;
        }
        this.getMoneyConfig().setMoney(mon-money);
        return 0;
    }
    public float reducePoint(float money){
        float mon = this.getMoneyConfig().getPoint();
        if(money > mon){
            return money-mon;
        }
        this.getMoneyConfig().setPoint(mon - money);
        return 0;
    }
    public void setMoney(float money){
        this.getMoneyConfig().setMoney(money);
    }
    public void setPoint(float money){
        this.getMoneyConfig().setPoint(money);
    }
    public void addMoney(float money){
        float mon = this.getMoneyConfig().getMoney();
        this.getMoneyConfig().setMoney(mon + money);
    }
    public void addPoint(float point){
        float mon = this.getMoneyConfig().getPoint();
        this.getMoneyConfig().setPoint(mon + point);
    }
    public float getMoney(){
        return this.getMoneyConfig().getMoney();
    }
    public float getPoint(){
        return this.getMoneyConfig().getPoint();
    }
}
