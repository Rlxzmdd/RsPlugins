package Rs.Plugin.Auto;

import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.UUID;


public class RsAuto {
    public Player Player;
    public String Password;
    public Plugin main;

    public RsAuto(Player player, String Password, Plugin main) {
        this.main = main;
        this.Player = player;
        this.Password = Password;
    }

    public RsAuto(Player player, String Password) {
        this.Player = player;
        this.Password = Password;
    }

    public RsAuto() {

    }
    public File getDataFolder(){
        return ((new File("plugins/RsAuto/")).getAbsoluteFile());
    }
    // public int OnloadPlayer(){
    //0为密码输入错误
    //1为密码输入正确
    //2为发送了一些错误，比如数据库无法连接，但是会自动转为本地的数据
    //通常不返回2
    //3为未注册
    //}
    public String getPassword(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + name + ".json", Config.JSON);
            return config.get("Password").toString();
        } else {
            return null;
        }
    }
    public String getUUID(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + name + ".json", Config.JSON);
            return config.get("UUID").toString();
        } else {
            return null;
        }
    }
    public String getAddress(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + name + ".json", Config.JSON);
            return config.get("LastIP").toString();
        } else {
            return null;
        }
    }
    public String getLastTime(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (!file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            return config.get("LastTime").toString();
        } else {
            return null;
        }
    }
    public String getPassword() {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            return config.get("Password").toString();
        } else {
            return null;
        }
    }
    public String getUUID() {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            return config.get("UUID").toString();
        } else {
            return null;
        }
    }
    public String getAddress() {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (!file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            return config.get("LastIP").toString();
        } else {
            return null;
        }
    }
    public String getLastTime() {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (!file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            return config.get("LastTime").toString();
        } else {
            return null;
        }
    }
    public boolean setPassword(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("Password", name);
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setPassword(String name,String pwd) {
        File file = new File((new File("plugins/RsAuto").getAbsolutePath()) + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(file, Config.JSON);
            config.set("Password", pwd);
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setAddress(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("Address", name);
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setAddress(String name,String pwd) {
        File file = new File(this.getDataFolder() + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + name + ".json", Config.JSON);
            config.set("Address", pwd);
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setUUID(UUID uuid) {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("UUID", uuid);
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setUUID(String name,UUID uuid) {
        File file = new File(this.getDataFolder() + "/Players/" + name + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + name + ".json", Config.JSON);
            config.set("UUID", uuid.toString());
            config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean setLastTime(String name) {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("LastTime", name);
            config.save();
            return true;
        } else {
            return false;
        }
    }

    public void NewPlayer() {
        //1注册成功
        //2，失败
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (!file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("Password", this.Password);
            config.set("LastIP", this.Player.getAddress());
            config.set("LastTime", "");
            config.set("UUID", this.Player.getUniqueId().toString());
            config.save();
            //return 1;
        } else {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            config.set("Password", this.Password);
            config.save();
            //return 1;
        }
    }

    public int HasRsg() {
        File file = new File(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json");
        if (file.exists()) {
            Config config = new Config(this.getDataFolder() + "/Players/" + this.Player.getName() + ".json", Config.JSON);
            if (config.get("Password").toString().equals("")) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    public int HasRsg(String name) {
        File file = new File((new File("plugins/RsAuto").getAbsolutePath())+ "/Players/" + name + ".json");
        //System.out.println(file);
        if (file.exists()) {
            Config config = new Config(file);
            if (config.get("Password").toString().equals("")) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
        /*if(getStat() == null) {

        }else{
            stmt = this.getStat();
            try {
                ResultSet rs = stmt.executeQuery("select * from `Players` where `ID` = '"+this.Player.getName()+"'");
                while (rs.next()) {
                    return 1;
                }
                return 0;
            } catch (SQLException e) {
                return 2;
            }
        }
        */
}

