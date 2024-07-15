package com.ispw.circularbook.engineering.dao;

import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.mediator.Component;

import java.io.*;

public class SignInDAOCSV extends Component {

    private static final String CSV_LOGIN_NAME = "CircularBook/src/main/res/Login.csv";
    private static final String CSV_USER_NAME = "CircularBook/src/main/res/Login.csv";
    private static final String CSV_BOOK_SHOP_NAME = "CircularBook/src/main/res/BookShop.csv";


    public void signInU(SignInBean signInBean)
    {
        File fileLog = new File(CSV_LOGIN_NAME);
        File fileU = new File(CSV_USER_NAME);

        try(BufferedWriter bufferedWriterLog = new BufferedWriter(new FileWriter(fileLog,true));
            BufferedWriter bufferedWriterU = new BufferedWriter(new FileWriter(fileU,true))){

            bufferedWriterLog.write(signInBean.getEmail()+","+signInBean.getPassword());
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
            bufferedWriterU.newLine();

            super.mediator.notify(this, MediatorEvent.SIGN_IN_USER,signInBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public  void signInB(SignInBean signInBean)
    {
        File fileLog = new File(CSV_LOGIN_NAME);
        File fileL = new File(CSV_BOOK_SHOP_NAME);

        try(BufferedWriter bufferedWriterLog = new BufferedWriter(new FileWriter(fileLog,true));
            BufferedWriter bufferedWriterL = new BufferedWriter(new FileWriter(fileL,true))){


            bufferedWriterLog.write(signInBean.getEmail());
            bufferedWriterLog.write(",");
            bufferedWriterLog.write(signInBean.getPassword());
            bufferedWriterLog.newLine();


            bufferedWriterL.newLine();
            bufferedWriterL.write(signInBean.getEmail());
            bufferedWriterL.write(",");
            bufferedWriterL.write(signInBean.getNameBookShop());
            bufferedWriterL.write(",");
            bufferedWriterL.write(signInBean.getCittaString());
            bufferedWriterL.write(",");
            bufferedWriterL.write(signInBean.getAddress());
            bufferedWriterL.write(",");
            bufferedWriterL.write(signInBean.getPhoneNumber());
            bufferedWriterL.newLine();

            super.mediator.notify(this, MediatorEvent.SIGN_IN_BOOK_SHOP,signInBean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
