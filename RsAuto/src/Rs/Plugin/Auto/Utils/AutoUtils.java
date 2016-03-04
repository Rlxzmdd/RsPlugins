package Rs.Plugin.Auto.Utils;

import cn.nukkit.Player;

/**
 * Created by admin on 2016/3/3.
 */
public class AutoUtils {
    protected int isLogin;
    protected boolean isOp;
    protected long Maths;
    protected String Password;
    public AutoUtils(int isLogin,boolean isOp,long Maths,String Password){
        this.isLogin = isLogin;
        this.isOp = isOp;
        this.Maths = Maths;
        this.Password = Password;
    }
    public AutoUtils(){
    }
    public void setIsLogin(int isLogin){
        this.isLogin = isLogin;
    }
    public void setIsOp(boolean isOp){
        this.isOp = isOp;
    }
    public void setMaths(long Maths){
        this.Maths = Maths;
    }
    public void setPassword(String password){
        this.Password = password;
    }



    public boolean sameIsLogin(int isLogin){
        if(this.isLogin == isLogin){
            return true;
        }else{
            return false;
        }
    }
    public boolean sameIsOp(boolean isOp){
        if(this.isOp == isOp){
            return true;
        }else{
            return false;
        }
    }
    public boolean sameMaths(long Maths){
        if(this.Maths == Maths){
            return true;
        }else{
            return false;
        }
    }
    public boolean sameMaths(String Maths){
        if(this.Maths == Long.valueOf(Maths)){
            return true;
        }else{
            return false;
        }
    }
    public boolean samePassword(String password){
        if(this.Password.equals(password)){
            return true;
        }else{
            return false;
        }
    }



    public int getIsLogin(){
        return this.isLogin;
    }
    public boolean getIsOp(){
        return this.isOp;
    }
    public long getMaths(){
        return this.Maths;
    }
    public String  getPassword(){
        return this.Password;
    }
}
