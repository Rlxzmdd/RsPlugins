package Rs.Plugin.Plot;

import Rs.Plugin.Plot.utils.IsLandCoordinate;
import cn.nukkit.math.Vector3;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class IsLand {
    public IsLandCoordinate xz;
    public IsLand(Long x, Long z) {
        this.xz = new IsLandCoordinate(x, z);
    }
    public IsLand(Double x, Double z) {
        this.xz = new IsLandCoordinate(x, z);
    }
    public IsLand(String zx) {
        this.xz = new IsLandCoordinate(zx);
    }
    public IsLand(IsLandCoordinate coor) {
        this.xz = coor;
    }
    public Long getX() {
        return xz.getX();
    }
    public Long getZ() {
        return xz.getZ();
    }
    public IsLandCoordinate getCoordinate() {
        return xz;
    }

    public String getFile() {
        return (new File("plugins/RsPlot/IsLands/").getAbsolutePath());
    }
    public void newConfig() {
        File is = new File(this.getFile(), "/" + this.xz.getCoordinate() + ".json");
        if (is.exists()) {
            return;
        }
        Config config = new Config(is, Config.JSON);
        // this.plugin.getLogger().info(this.isLandXZ);
        config.set("Host", 0);
        Map<String, Boolean> asd = new HashMap<String, Boolean>();
        asd.put("place", false);
        asd.put("break", false);
        asd.put("chest", false);
        asd.put("move", true);
        asd.put("use", false);
        asd.put("pvp", false);
        asd.put("tp", true);
        config.set("Permission", asd);
        config.set("Trusts", new HashMap<String, Map<String, Boolean>>());
        config.set("Spawn", "0.0.0");
        config.set("Home","0.0.0");
        config.save();
        //asdasd.put("233","233");
        //            config.set("trusted",asdasd);
        //           config.save();
        //         /*�յ��ļ��ṹ:
        //         �ļ���:x:z
        //    host: String
        //  trusted: HashMap<String,String>
        //               */           //
        // Map<String,String> map = (Map<String,String>)config.get("trusted");
        // config.set("123",map.get("233"));
        // config.save();        }
    }
    Config config = null;
    public Config getConfig() {
        this.newConfig();
        Config config = new Config(this.getFile() + "/" + this.getCoordinate().getCoordinate() + ".json", Config.JSON);
        if (this.config == null) {
            this.config = config;
            return config;
        } else {
            return this.config;
        }
    }

    public String getHost() {
        Config config = this.getConfig();
        return config.get("Host").toString();
    }
    public void setHost(String name) {
        Config config = this.getConfig();
        config.set("Host", name);
        config.save();
        return;
    }
    public Boolean isHost(String name) {
        return getHost().equals(name);
    }
    public boolean canMove(String name) {
        if(isHost(name)){
            return true;
        }
        if(isTrustPlayer(name)){
            return getTrustPlayerAuto(name,"move");
        }else{
            return getPermission("move");
        }
    }
    public boolean canPlace(String name) {
        if(isHost(name)){
            return true;
        }
        if(isTrustPlayer(name)){
            return getTrustPlayerAuto(name,"place");
        }else{
            return getPermission("place");
        }
    }
    public boolean canBreak(String name) {
        if(isHost(name)){
            return true;
        }
        if(isTrustPlayer(name)){
            return getTrustPlayerAuto(name,"break");
        }else{
            return getPermission("break");
        }
       // return isHost(name);
    }
    //优先度：
    //优先判断玩家下的权限
    //然后再获取空岛默认的权限
    public Map<String, Map<String, Boolean>> getTrusts() {
        return (Map<String, Map<String, Boolean>>) this.getConfig().get("Trusts");
    }
    public boolean addTrustPlayer(String name) {
        Map<String, Map<String, Boolean>> trusts = this.getTrusts();
        if (trusts.containsKey(name)) {
            return false;
        }
        //false为已存在
        Map<String, Boolean> player = new HashMap<String, Boolean>();
        player.put("place", false);
        player.put("break", false);
        player.put("chest", false);
        player.put("move", false);
        player.put("use", false);
        player.put("pvp", false);
        player.put("tp", false);
        trusts.put(name, player);
        this.config.set("Trusts", trusts);
        this.config.save();
        return true;
    }
    public boolean removeTrustPlayer(String name) {
        Map<String, Map<String, Boolean>> trusts = this.getTrusts();
        if (trusts.containsKey(name)) {
            return false;
        }
        trusts.remove(name);
        this.config.set("Trusts", trusts);
        this.config.save();
        return true;
    }
    public boolean setTrustPlayerAuth(String name, String Per, String bool) {
        Map<String, Boolean> trusts = this.getTrusts().get(name);
        System.out.println(trusts);
        if(!this.getTrusts().containsKey(name)){
            this.addTrustPlayer(name);
            this.getConfig().save();
        }
        if (trusts == null || !trusts.containsKey(Per)) {
            return false;
            //不存在的权限
        }
        if(Per.equals("trust")){
            if (bool.equals("T") || bool.equals("t") || bool.equals("true") || bool.equals("True")) {
                trusts.put("place", true);
                trusts.put("break", true);
                trusts.put("chest", true);
                trusts.put("move", true);
                trusts.put("use", true);
                trusts.put("pvp", true);
                trusts.put("tp", true);

                this.config.set("Trusts", this.getTrusts().put(name,trusts));
                this.config.save();
                return true;
            } else if (bool.equals("f") || bool.equals("false") || bool.equals("F") || bool.equals("False")) {
                trusts.put("place", false);
                trusts.put("break", false);
                trusts.put("chest", false);
                trusts.put("move", false);
                trusts.put("use", false);
                trusts.put("pvp", false);
                trusts.put("tp", false);
                this.config.set("Trusts", this.getTrusts().put(name,trusts));
                this.config.save();
                return true;
            } else {
                return false;
            }
        }
        if (bool.equals("T") || bool.equals("t") || bool.equals("true") || bool.equals("True")) {
            trusts.put(Per, true);
            this.config.set("Trusts", this.getTrusts().put(name,trusts));
            this.config.save();
            return true;
        } else if (bool.equals("f") || bool.equals("false") || bool.equals("F") || bool.equals("False")) {
            trusts.put(Per, false);
            this.config.set("Trusts", this.getTrusts().remove(name));
            this.config.save();
            return true;
        } else {
            return false;
        }
    }
    public boolean getTrustPlayerAuto(String name, String Per) {
        Map<String, Boolean> trusts = this.getTrusts().get(name);
        if (!trusts.containsKey(Per)) {
            return false;
            //不存在的权限
        }
        return trusts.get(Per);
    }
    public boolean isTrustPlayer(String name){
        if(this.getTrusts().containsKey(name)){
            return true;
        }else{
            return false;
        }
    }

    public Map<String, Boolean> getPermission() {
        return (Map<String, Boolean>) this.getConfig().get("Permission");
    }
    public boolean getPermission(String per){
        if(this.getPermission().containsKey(per)){
            if(this.getPermission().get(per)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public boolean setPermission(String Per, String bool) {
        Map<String, Boolean> trusts = this.getPermission();
        if (!trusts.containsKey(Per)) {
            return false;
            //不存在的权限
        }
        if (bool.equals("T") || bool.equals("t") || bool.equals("true") || bool.equals("True")) {
            trusts.put(Per, true);
            this.getConfig().set("Permission", trusts);
            this.getConfig().save();
            return true;
        } else if (bool.equals("f") || bool.equals("false") || bool.equals("F") || bool.equals("False")) {
            trusts.put(Per, false);
            this.getConfig().set("Permission", trusts);
            this.getConfig().save();
            return true;
        } else {
            return false;
        }
    }

    Long ex;
    Long ez;
    public void setIsLandSpawn(long x ,long y,long z){
        //System.out.println(x+"."+y+"."+z);
        this.getConfig().set("Spawn",x+"."+y+"."+z);
        this.getConfig().save();
    }
    public Vector3 getIsLandSpawn(){/*
        if(this.getConfig().get("Spawn").toString().equals("0.65.0")){
            if (xz.getX() < 0L)
                this.ex = (xz.getX() * 64L + 32L);
            else if (xz.getX() > 0L) {
                this.ex = (xz.getX() * 64L - 32L);
            }
            if (xz.getZ() < 0L)
                this.ez = (xz.getZ() * 64L + 32L);
            else if (xz.getZ() > 0L) {
                this.ez = (xz.getZ() * 64L - 32L);
            }
            //System.out.print(new Vector3(this.ex, 65.0D, this.ez).toString() + "===322");
            System.out.println("233333???" +
                    "");
            return (new Vector3(this.ex.doubleValue(),69,this.ez.doubleValue()));
        }else{
            System.out.println(this.getConfig().get("Spawn").toString());
        }
        String[] strs = this.getConfig().get("Spawn").toString().split("\\.");
        long ex = Long.parseLong(strs[0]);
        long ey = Long.parseLong(strs[1]);
        long ez = Long.parseLong(strs[2]);
        //System.out.print(new Vector3(this.ex, 65.0D, this.ez).toString() + "===322");
        return (new Vector3(ex,ey,ez));*/
        if (xz.getX() < 0L)
            this.ex = (xz.getX() * 64L + 32L);
        else if (xz.getX() > 0L) {
            this.ex = (xz.getX() * 64L - 32L);
        }
        if (xz.getZ() < 0L)
            this.ez = (xz.getZ() * 64L + 32L);
        else if (xz.getZ() > 0L) {
            this.ez = (xz.getZ() * 64L - 32L);
        }
        //System.out.print(new Vector3(this.ex, 65.0D, this.ez).toString() + "===322");
       // System.out.println("233333???" +"");
        return (new Vector3(this.ex,90,this.ez));
    }
}