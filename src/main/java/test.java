import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.*;

/**
 * @author Yan
 * @create 2022-12-07 22:40
 **/
public class test {
    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime localDateTime1 = LocalDateTime.of(2022,12,14,10,57);
//        System.out.println(localDate);
//        System.out.println(localTime);
//        System.out.println(localDateTime1);
//        Instant instant = Instant.now();
//        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
//        System.out.println(offsetDateTime);
//        String time = "2077-8-16";
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime dateTime = LocalDateTime.parse(time, dateTimeFormatter);
//        TemporalAccessor accessor = dateTimeFormatter.parse(time);
//        java.sql.Date date = new java.sql.Date(accessor.);

        Season spring = Season.SPRING;
        System.out.println(spring);
    }
    public static int getCount(String str,String subStr) {
        int index = 0;
        int count = 0;
        int strLength = str.length();
        int subStrLength = subStr.length();
        if (strLength > subStrLength){

            while ((index = str.indexOf(subStr,index)) != -1){
                count++;
                index += subStrLength;
            }
            return count;
        }else {
            return 0;
        }

    }
    public static String getMaxSameString(String str1,String str2){
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;

        for (int i = 0 ; i < minStr.length();i++){

            for (int j = 0, k = minStr.length() - i; k <= minStr.length(); j++,k++) {

                String subStr = minStr.substring(j,k);
                if (maxStr.contains(subStr)){
                    return subStr;
                }

            }
        }
        return null;
    }

    public static void fishOrNot(Date date1){
        Date date = new Date();
        long l = (date1.getTime() - date.getTime()) / (1000*60*60*24) + 1;
        int i = (int) (l % 5);
        if ( i == 1 || i == 2 || i == 3){
            System.out.println("fish");
        }else if (i == 4 || i == 0){
            System.out.println("Not fish");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    }
    public static void testCalender(){
        Calendar calendar = Calendar.getInstance();
//        System.out.println(instance.getClass());

        //get
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //set
        //add
        //getTime
        //setTime
    }
    public void sort(){
        String[] arrays = new String[5];
        arrays[0] = "we";
        arrays[1] = "qsd";
        arrays[2] = "asd";
        arrays[3] = "asd";
        arrays[4] = "qweasd";
        Arrays.sort(arrays, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                return 0;


            }

        });
    }


}

class Season{
    private final String seasonName;
    private final String seasonDesc;

    private Season(String seasonName,String seasonDesc){
        this.seasonDesc = seasonDesc;
        this.seasonName = seasonName;
    }

    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
