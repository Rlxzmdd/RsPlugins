package Rs.Plugin.Land.Utils;

import Rs.Plugin.Land.LandObject.LandCoordinate;

/**
 * Created by admin on 2016/3/14.
 */
public class LandJudge {
    public boolean isOverlap(LandCoordinate a,LandCoordinate b){
        //�ж�y,
        //����Ϊ��b�����������a��
        if(a.getV3a().getY()  > a.getV3b().getY()){
            //�ж� a �������жϵ�Ĵ�С
            //����a���жϵ��y����a���жϵ�b
            if(a.getV3a().getY() >= b.getV3a().getY() && a.getV3b().getY() <= b.getV3a().getY()){
                //ֻҪ��һ����������y֮��Ļ�����ô��˵��y֮�������Ӵ�
                //���ˣ����е���
                // todo �ж�x,z
            }else if(a.getV3a().getY() >= b.getV3b().getY() && a.getV3b().getY() <= b.getV3b().getY()){
                //todo//
            }else{
                //��Ȼû���жϵ�������Ҳ��������û��
                //��Ϊ���п���b����a��
            }
        }else if(a.getV3a().getY() == a.getV3b().getY()){
            //���ڵ�ʱ�� 
            if(a.getV3a().getY() == b.getV3a().getY() || a.getV3a().getY() == b.getV3b().getY()){
               //todo x,z
            }else{
                return false;
            }
        }else{
            //С�ڵ�ʱ��
            if(a.getV3a().getY() <= b.getV3a().getY() && a.getV3b().getY() >= b.getV3a().getY()){
                //todo x,z
            }else if(a.getV3a().getY() <= b.getV3b().getY() && a.getV3b().getY() >= b.getV3b().getY()){
                //todo x,z
            }else{
                //todo
            }
        }
        //�����û�У�����������bΪ��������ٴ��ж�
        return true;
    }
}
