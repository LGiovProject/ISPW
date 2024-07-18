package com.ispw.circularbook.engineering.dao;


import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.mediator.Component;

import java.io.*;

public class SignInDAOCSV extends Component {

    private static final String CSV_LOGIN_NAME = "src/main/res/Login.csv";
    private static final String CSV_USER_NAME = "src/main/res/User.csv";
    private static final String CSV_BOOK_SHOP_NAME = "src/main/res/BookShop.csv";



    public void signInU(SignInBean signInBean)
    {
        File fileLog = findFile(CSV_LOGIN_NAME);
        File fileU = findFile(CSV_USER_NAME);
        startBufferedWriterU(signInBean, fileLog, fileU);
        super.mediator.notify(this, MediatorEvent.SIGN_IN_USER,signInBean);

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
        File fileLog = findFile(CSV_LOGIN_NAME);
        File fileB = findFile(CSV_BOOK_SHOP_NAME);
        startBufferedWriterB(signInBean,fileLog,fileB);
        super.mediator.notify(this, MediatorEvent.SIGN_IN_BOOK_SHOP,signInBean);

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

    private static File findFile(String path)
    {
            return new File(path);
    }



}
