package com.ispw.circularbook.engineering.mediator.concretemediator;

import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.dao.SignInDAOJDBC;
import com.ispw.circularbook.engineering.dao.SignInDAOCSV;
import com.ispw.circularbook.engineering.enums.MediatorEvent;
import com.ispw.circularbook.engineering.mediator.Component;
import com.ispw.circularbook.engineering.mediator.Mediator;

public class ConcreteMediator implements Mediator {

    private final SignInDAOJDBC signInDAOJDBC;

    private final SignInDAOCSV signInDAOCSV;

    private boolean[] flag;

    public ConcreteMediator(SignInDAOJDBC signInDAOJDBC, SignInDAOCSV signInDAOCSV)
    {
        this.signInDAOJDBC = signInDAOJDBC;
        this.signInDAOCSV=signInDAOCSV;
        flag = new boolean[2]; //La prima posizione è per SignInDAOJDBC la seconda per SignInDAOCSV
    }

    public synchronized void setFlag()
    {
        flag[0]=true;
        flag[1]=true;
    }

    @Override
    public void notify(Component sender, MediatorEvent event, SignInBean signInBean) {
        if (sender == signInDAOJDBC && flag[0]) {
            flag[0]=false;
            flag[1]=false;
            checkSignInCSV(event, signInBean);
        }else if(sender == signInDAOCSV && flag[1]){
            flag[0]=false;
            flag[1]=false;
            checkSignInDAO(event, signInBean);
        }
    }

    private void checkSignInDAO(MediatorEvent event, SignInBean signInBean) {
        if (event == MediatorEvent.SIGN_IN_BOOK_SHOP) {
            signInDAOJDBC.signInB(signInBean);
        } else {
            signInDAOJDBC.signInU(signInBean);
        }
    }

    private void checkSignInCSV(MediatorEvent event, SignInBean signInBean) {
        if (event == MediatorEvent.SIGN_IN_BOOK_SHOP) {
            signInDAOCSV.signInB(signInBean);
        } else {
            signInDAOCSV.signInU(signInBean);

        }
    }
}
