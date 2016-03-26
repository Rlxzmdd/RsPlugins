package Rs.Plugin.Plot.utils;


import Rs.Plugin.Plot.IsLand;
import cn.nukkit.Player;

/**
 * Created by Rlx on 2016/2/5.
 */
public class IsLandCoordinate {


    public long x;
    public long z;
    public String XZ;


    public IsLandCoordinate(Player x){
        this.XZ = (Long.parseLong(x.getX()+""))+"."+(Long.parseLong(x.getZ()+""));
        this.x = this.getX(this.XZ);
        this.z = this.getZ(this.XZ);
    }
    public IsLandCoordinate(Double x,Double z){
        this.XZ = this.getXZ(x,z);
        this.x = this.getX(this.XZ);
        this.z = this.getZ(this.XZ);
    }
    public IsLandCoordinate(long x,long z){
        this.XZ = this.getXZ(x,z);
        this.x = this.getX(this.XZ);
        this.z = this.getZ(this.XZ);
    }
    public IsLandCoordinate(String XZ){
        String[] strs = XZ.split("\\.");
        this.x = Long.parseLong(strs[0]);
        this.z = Long.parseLong(strs[1]);
        this.XZ = x+"."+z;
    }
    public IsLand getIsLand(){
        return (new IsLand(this.getCoordinate()));
    }
    public String getXZ(Player player){
        long x = Long.parseLong(player.getX()+"");
        long z = Long.parseLong(player.getZ()+"");
        if (((x > 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L - 1L;
            return (CX + "." + CZ);
        }if (((x > 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L - 1L;
            return (CX + "." + CZ);
        }
        return ("0.0");
    }
    public String getXZ(Double xx ,Double zz){
        long x = xx.longValue();
        long z = zz.longValue();
        if (((x > 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L - 1L;
            return (CX + "." + CZ);
        }if (((x > 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L - 1L;
            return (CX + "." + CZ);
        }
        return ("0.0");
    }
    public String getXZ(long xx ,long zz){
        long x = xx;
        long z = zz;
        if (((x > 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z > 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L + 1L;
            return (CX + "." + CZ);
        }if (((x < 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L - 1L;
            long CZ = z / 64L - 1L;
            //System.out.println(CX + ".= = =." + CZ);
            return (CX + "." + CZ);
        }if (((x > 0L ? 1 : 0) & (z < 0L ? 1 : 0)) != 0) {
            long CX = x / 64L + 1L;
            long CZ = z / 64L - 1L;
            return (CX + "." + CZ);
        }
        return ("0.0");
    }
    public long getX(){
        return this.x;
    }
    public long getZ(){
        return this.z;
    }
    public String getCoordinate(){
        return this.XZ;
    }
    public long getX(String xz){
        String[] strs = XZ.split("\\.");
        this.x = Long.parseLong(strs[0]);
        this.z = Long.parseLong(strs[1]);
        this.XZ = x+"."+z;
        return this.x;
    }
    public long getZ(String xz){
        String[] strs = XZ.split("\\.");
        this.x = Long.parseLong(strs[0]);
        this.z = Long.parseLong(strs[1]);
        this.XZ = x+"."+z;
        return this.z;
    }
}
