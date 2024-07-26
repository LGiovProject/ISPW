package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.mediator.Component;

import java.io.*;

public class SignInDAOCSV extends Component {

    private static final String CSV_LOGIN_PATH = "src/main/res/Login.csv";
    private static final String CSV_USER_PATH = "src/main/res/User.csv";
    private static final String CSV_BOOK_SHOP_PATH = "src/main/res/BookShop.csv";



    public void signInU(SignInBean signInBean)
    {
        FileWriter fileLog = findFile(CSV_LOGIN_PATH);
        FileWriter fileU = findFile(CSV_USER_PATH);
        startBufferedWriterU(signInBean, fileLog, fileU);
        super.mediator.notify(this, MediatorEvent.SIGN_IN_USER,signInBean);

    }

    private void startBufferedWriterU(SignInBean signInBean, FileWriter fileLog, FileWriter fileU){
        try(BufferedWriter bufferedWriterLog = new BufferedWriter(fileLog);
            BufferedWriter bufferedWriterU = new BufferedWriter(fileU);) {

            bufferedWriterLog.newLine();
            bufferedWriterLog.write(signInBean.getEmail() + "," + signInBean.getPassword());
            bufferedWriterLog.newLine();

            bufferedWriterU.newLine();
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

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public  void signInB(SignInBean signInBean)
    {
        FileWriter fileLog = findFile(CSV_LOGIN_PATH);
        FileWriter fileB = findFile(CSV_BOOK_SHOP_PATH);
        startBufferedWriterB(signInBean,fileLog,fileB);
        super.mediator.notify(this, MediatorEvent.SIGN_IN_BOOK_SHOP,signInBean);

    }

    private void startBufferedWriterB(SignInBean signInBean, FileWriter fileLog, FileWriter fileB)
    {
        try(BufferedWriter bufferedWriterLog = new BufferedWriter( fileLog);
            BufferedWriter bufferedWriterB = new BufferedWriter( fileB)){


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

    private static FileWriter findFile(String path) {
        try {
            return new FileWriter(path, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
