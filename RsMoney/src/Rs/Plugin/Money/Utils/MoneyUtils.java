package Rs.Plugin.Money.Utils;

import Rs.Plugin.Money.MoneyMainClass;

/**
 * Created by admin on 2016/3/23.
 */
public class MoneyUtils {
    public MoneyMainClass main;
    public MoneyUtils(MoneyMainClass main){
        this.main = main;
    }
    public String getMoneyCoin(){
        return main.getCoinAndMoney().get("Money|Coin").get("Money").toString();
    }
    public String getPointCoin(){
        return main.getCoinAndMoney().get("Money|Coin").get("Point").toString();
    }
    public Float getMoneyNumber(){
        return Float.valueOf(main.getCoinAndMoney().get("Money|Number").get("Money").toString());
    }
    public Float getPointNumber(){
        return Float.valueOf(main.getCoinAndMoney().get("Money|Number").get("Point").toString());
    }
}
