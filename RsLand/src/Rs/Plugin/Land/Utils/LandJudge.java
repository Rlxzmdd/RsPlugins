package Rs.Plugin.Land.Utils;

import Rs.Plugin.Land.LandObject.LandCoordinate;

/**
 * Created by admin on 2016/3/14.
 */
public class LandJudge {
    public boolean isOverlap(LandCoordinate a,LandCoordinate b){
        //判断y,
        //以下为，b的坐标大致在a中
        if(a.getV3a().getY()  > a.getV3b().getY()){
            //判断 a 的两个判断点的大小
            //此外a的判断点的y大于a的判断点b
            if(a.getV3a().getY() >= b.getV3a().getY() && a.getV3b().getY() <= b.getV3a().getY()){
                //只要当一个点在两个y之间的话，那么就说明y之间有所接触
                //对了，还有等于
                // todo 判断x,z
            }else if(a.getV3a().getY() >= b.getV3b().getY() && a.getV3b().getY() <= b.getV3b().getY()){
                //todo//
            }else{
                //虽然没有判断到，但是也不代表市没在
                //因为是有可能b包含a的
            }
        }else if(a.getV3a().getY() == a.getV3b().getY()){
            //等于的时候 
            if(a.getV3a().getY() == b.getV3a().getY() || a.getV3a().getY() == b.getV3b().getY()){
               //todo x,z
            }else{
                return false;
            }
        }else{
            //小于的时候
            if(a.getV3a().getY() <= b.getV3a().getY() && a.getV3b().getY() >= b.getV3a().getY()){
                //todo x,z
            }else if(a.getV3a().getY() <= b.getV3b().getY() && a.getV3b().getY() >= b.getV3b().getY()){
                //todo x,z
            }else{
                //todo
            }
        }
        //如果都没有，还会再用以b为主的情况再次判断
        return true;
    }
}
