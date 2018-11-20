package com.futureGadgeLab;

import com.futureGadgeLab.app.Parking;
import com.futureGadgeLab.dao.JdbcParkingDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AppTest {
    public static void main(String args[]) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss"); //Date format string is passed as an argument to the Date format object
        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");


        JdbcParkingDAO dao = (JdbcParkingDAO) context.getBean("jpdao");
        int stat = dao.saveParking(new Parking(16160, 1, simpleDateFormat.parse("2010-07-16 19:19:00"), simpleDateFormat.parse("2010-07-16 19:19:00"), BigDecimal.valueOf(10.50)));
        System.out.println(stat);
    }
}
