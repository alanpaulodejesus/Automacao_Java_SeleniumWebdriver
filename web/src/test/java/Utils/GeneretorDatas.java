package Utils;

import com.github.javafaker.Faker;

public  class GeneretorDatas {

    static Faker datas = new Faker();

    public static String firstName = datas.name().firstName();
    public static String lastName = datas.name().lastName();
    public static String email = datas.internet().emailAddress();
    public static String company = datas.company().name();

}
