package exer;

import java.util.*;

/**
 * @author Yan
 * @create 2022-12-20 21:05
 **/
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id,T entity){
        map.put(id,entity);
    }
    //从map中获取id对应的对象
    public T get(String id){
        return map.get(id);
    }
    //替换map中key为id的内容，改为entity对象
    public void update(String id , T entity){
        map.replace(id,entity);
    }
    //返回map中存放的所有T对象
    public List<T> list(){
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T i : values){
            list.add(i);
        }
        return list;

    }
    //删除指定id对象
    public void delete(String id){
        map.remove(id);
    }

}
