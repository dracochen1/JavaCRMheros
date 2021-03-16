package com.crmheros.crmheros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication

public class CrmherosApplication {

    public static void main(String[] args) {
        //SimpleDateFormat formatingdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SpringApplication.run(CrmherosApplication.class, args);
        //Date d1 = new Date(848271600000l);
        //Date d2 = new Date(848275200000l);
        //System.out.println(formatingdate.format(d1));
        //System.out.println(formatingdate.format(d2));
        //System.out.println(Locale.getDefault());
        //Locale.CANADA_FRENCH
    }

}
