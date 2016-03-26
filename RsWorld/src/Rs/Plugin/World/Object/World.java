package Rs.Plugin.World.Object;

import Rs.Plugin.World.WorldMainClass;
import sun.java2d.opengl.WGLSurfaceData;

/**
 * Created by admin on 2016/3/21.
 */
public class World {
    public WorldMainClass main;
    public String WorldName;
    public World(WorldMainClass main,String WorldName){
        this.main = main;
        this.WorldName = WorldName;
    }
    public Trust getTrustPlayers(){
        return new Trust(main.getAllWorld().get(WorldName));
    }
}
