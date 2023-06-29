package java1;

/**
 * @author Yan
 * @create 2023-01-17 12:54
 **/
public class Boy {

    private Girl girl;

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy(){

    }

}
