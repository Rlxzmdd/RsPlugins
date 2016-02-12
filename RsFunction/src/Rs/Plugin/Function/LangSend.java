package Rs.Plugin.Function;

import cn.nukkit.Player;

/**
 * Created by Rlx on 2016/2/5.
 */
public class LangSend {
    public Player player = null;
    public Lang lang = null;
    public LangSend(Player player,Lang lang){
        this.player = player;
        this.lang = lang;
    }
    public LangSend(Lang lang){
        this.lang = lang;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public String getMsg(String msg){
        if(player != null){
            return this.lang.getMsg(msg,new position(this.player.getAddress(),player).getLang());
        }else{
            return this.lang.getMsg(msg,new RsFunction().getLang());
        }
    }
    public void sM(String msg){
        if(player != null){
            player.sendMessage(this.getMsg(msg));
        }
    }
    public void sM(String msg,String msg2){
        if(player != null){
            player.sendMessage(this.getMsg(msg));
        }
    }
    public String getMsg(String msg,Player player){
        if(player != null){
            //System.out.print(new position(this.player.getAddress(),player).getLang());
            return this.lang.getMsg(msg,new RsFunction().getPlayerLang(player));
        }else{
            return this.lang.getMsg(msg,new RsFunction().getLang());
        }
    }

    public void sM(String msg,Player player){
        player.sendMessage(this.getMsg(msg,player));
    }
    public void sM(String msg,Player player,String msg2){
        player.sendMessage(this.getMsg(msg,player)+msg);
    }

}
