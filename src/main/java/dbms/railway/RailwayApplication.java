package dbms.railway;

import dbms.railway.dao.UserJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class RailwayApplication  {

//    @Autowired
//    private UserJdbcDao userJdbcDao;
    public static void main(String[] args)  {

        SpringApplication.run(RailwayApplication.class, args);
    }
//    @Override
//    public void run(String... args)throws Exception{
//        System.out.println(this.userJdbcDao.CreateTable());
//
//        this.creteUser();
//    }
//    public void creteUser() throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Enter User ID: ");
//        Integer userID = Integer.parseInt(br.readLine());
//
//        System.out.println("Enter User name: ");
//        String name = br.readLine();
//
//        System.out.println("Enter User age: ");
//        Integer age = Integer.parseInt(br.readLine());
//
//        System.out.println("Enter User city: ");
//        String city = br.readLine();
//
//        int i = this.userJdbcDao.InsertUser(userID,name,age,city);
//        System.out.println(i+" user added");
//    }
}