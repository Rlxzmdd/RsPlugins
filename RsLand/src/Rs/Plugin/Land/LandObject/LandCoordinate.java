package Rs.Plugin.Land.LandObject;

import Rs.Plugin.Land.Commands.Commands.Land;
import Rs.Plugin.Land.Utils.LandV3;
import cn.nukkit.math.Vector3;

/**
 * Created by admin on 2016/3/14.
 */
public class LandCoordinate {
    long x1,y1,z1,x2,y2,z2;
    public LandCoordinate(long x1 , long y1 , long z1,long x2 , long y2 , long z2){
        this.x1=x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }
    public LandV3 getV3a(){
        return new LandV3(x1,y1,z1);
    }
    public LandV3 getV3b(){
        return new LandV3(x2,y2,z2);
    }
}
