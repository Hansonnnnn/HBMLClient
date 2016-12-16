package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 12/16/16.
 */
public class PromotionConditionHelper {
    public List<Map<String, Object>> conditions = new ArrayList<>();

    /**
     *
     * @param left
     * @param relation
     * @param right
     * @param identifier
     */
    public void add(Object left ,String relation,Object right,String identifier) {
        Map<String, Object> param = new HashMap<>();
        param.put("left", left);
        param.put("relation", relation);
        param.put("right", right);
        param.put("identifier",identifier);
        conditions.add(param);
    }
    public void del(String name) {
        for (int i = 0; i < conditions.size(); i++) {
            Map<String, Object> param = conditions.get(i);
            if (param.get("identifier").equals(name)) {
                conditions.remove(i);
            }
        }
    }

    public boolean decodeCondition(int i){
        boolean ret=true;
        Map<String,Object> param=conditions.get(i);
        if(param.get("relation").equals("=")){
            if(!param.get("left").equals(param.get("right"))){
                ret=false;
            }
        }else if(param.get("relation").equals("!=")){
            if(param.get("left").equals(param.get("right"))){
                ret=false;
            }
        }else if(param.get("relation").equals(">")){
            //only int is in this case
            ret=(int)(param.get("left"))>(int)(param.get("right"));
        }else if(param.get("relation").equals(">=")){
            //only int is in this case
            ret=(int)(param.get("left"))>=(int)(param.get("right"));
        }else if(param.get("relation").equals("<")){
            //only int is in this case
            ret=(int)(param.get("left"))<(int)(param.get("right"));
        }else if(param.get("relation").equals("<=")){
            //only int is in this case
            ret=(int)(param.get("left"))<=(int)(param.get("right"));
        }
        return ret;
    }

    public boolean decodeConditions(){
        int i;
        boolean ret=true;
        for(i=0;i<conditions.size();i++){
            if(decodeCondition(i)==false){
                ret=false;
                break;
            }
        }
        return ret;
    }
}
