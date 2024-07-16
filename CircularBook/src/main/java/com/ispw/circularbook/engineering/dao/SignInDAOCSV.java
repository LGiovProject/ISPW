package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.Main;
import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.mediator.Component;

import java.io.*;
import java.net.URISyntaxException;

public class SignInDAOCSV extends Component {

    private static final String CSV_LOGIN_NAME = "res/Login.csv";
    private static final String CSV_USER_NAME = "res/User.csv";
    private static final String CSV_BOOK_SHOP_NAME = "res/BookShop.csv";



    public void signInU(SignInBean signInBean)
    {
        try{
            File fileLog = new File(Main.class.getResource(CSV_LOGIN_NAME).toURI());
            File fileU = new File(Main.class.getResource(CSV_USER_NAME).toURI());
            startBufferedWriterU(signInBean, fileLog, fileU);
            super.mediator.notify(this, MediatorEvent.SIGN_IN_USER,signInBean);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void startBufferedWriterU(SignInBean signInBean, File fileLog, File fileU){
        try(BufferedWriter bufferedWriterLog = new BufferedWriter(new FileWriter(fileLog,true));
            BufferedWriter bufferedWriterU = new BufferedWriter(new FileWriter(fileU,true));) {


            bufferedWriterLog.write(signInBean.getEmail() + "," + signInBean.getPassword());
            bufferedWriterLog.write(",");
            bufferedWriterLog.write(signInBean.getPassword());
            bufferedWriterLog.newLine();


            bufferedWriterU.write(signInBean.getEmail());
            bufferedWriterU.write(",");
            bufferedWriterU.write(signInBean.getUsername());
            bufferedWriterU.write(",");
            bufferedWriterU.write(signInBean.getName());
            bufferedWriterU.write(",");
            bufferedWriterU.write(signInBean.getSurname());
            bufferedWriterU.write(",");
            bufferedWriterU.write(signInBean.getCittaString());

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public  void signInB(SignInBean signInBean)
    {
        try{
            File fileLog = new File(getClass().getResource(CSV_LOGIN_NAME).toURI());
            File fileB = new File(getClass().getResource(CSV_BOOK_SHOP_NAME).toURI());
            startBufferedWriterB(signInBean,fileLog,fileB);
            super.mediator.notify(this, MediatorEvent.SIGN_IN_BOOK_SHOP,signInBean);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void startBufferedWriterB(SignInBean signInBean, File fileLog, File fileB)
    {
        try(BufferedWriter bufferedWriterLog = new BufferedWriter(new FileWriter(fileLog,true));
            BufferedWriter bufferedWriterB = new BufferedWriter(new FileWriter(fileB,true));) {


            bufferedWriterLog.write(signInBean.getEmail());
            bufferedWriterLog.write(",");
            bufferedWriterLog.write(signInBean.getPassword());
            bufferedWriterLog.newLine();


            bufferedWriterB.newLine();
            bufferedWriterB.write(signInBean.getEmail());
            bufferedWriterB.write(",");
            bufferedWriterB.write(signInBean.getNameBookShop());
            bufferedWriterB.write(",");
            bufferedWriterB.write(signInBean.getCittaString());
            bufferedWriterB.write(",");
            bufferedWriterB.write(signInBean.getAddress());
            bufferedWriterB.write(",");
            bufferedWriterB.write(signInBean.getPhoneNumber());
            bufferedWriterB.newLine();

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }



}
