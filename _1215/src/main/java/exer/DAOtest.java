package exer;

import org.junit.Test;

import java.util.List;

/**
 * @author Yan
 * @create 2022-12-20 21:27
 **/
public class DAOtest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,23,"王伟"));
        dao.save("1002",new User(1004,24,"王1"));
        dao.save("1003",new User(1005,25,"王2"));
        dao.save("1004",new User(1006,26,"王3"));
        dao.update(
                "1004",new User(1004,23,"wang4"));
        List<User> list = dao.list();
        list.forEach(System.out::println);

    }

}
