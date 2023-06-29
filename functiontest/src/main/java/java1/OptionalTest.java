package java1;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Yan
 * @create 2023-01-17 12:56
 **/
public class OptionalTest {

    @Test
    public void test(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("周也"));
        System.out.println(girl2);


    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test1(){

    }


}
