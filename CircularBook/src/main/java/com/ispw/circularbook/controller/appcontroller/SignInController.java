package com.ispw.circularbook.controller.appcontroller;

import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.dao.SignInDAOJDBC;
import com.ispw.circularbook.engineering.dao.SignInDAOCSV;
import com.ispw.circularbook.engineering.exception.EmailUsedException;
import com.ispw.circularbook.engineering.mediator.concretemediator.ConcreteMediator;

import java.time.LocalTime;

public class SignInController {

    private final SignInDAOJDBC signInDAOJDBC;
    private final SignInDAOCSV signInDAOCSV;
    private final ConcreteMediator concreteMediator;

    public SignInController()
    {
        signInDAOJDBC =new SignInDAOJDBC();
        signInDAOCSV = new SignInDAOCSV();
        concreteMediator = new ConcreteMediator(signInDAOJDBC,signInDAOCSV);
        signInDAOJDBC.setMediator(concreteMediator);
        signInDAOCSV.setMediator(concreteMediator);
        concreteMediator.setFlag();
    }

    public void signInU(SignInBean signInBean) {
        // Verifica se il minuto attuale è pari in modo da utilizzare in maniera randomica signInDAOJDBC o signInDAOCSV
        concreteMediator.setFlag();
        if (LocalTime.now().getMinute() % 2 == 0) {
            signInDAOJDBC.signInU(signInBean);
        } else {
            signInDAOCSV.signInU(signInBean);
        }
    }

    public void signInL(SignInBean signInBean) {
        // Verifica se il minuto attuale è pari in modo da utilizzare in maniera randomica signInDAOJDBC o signInDAOCSV
        concreteMediator.setFlag();
        if (LocalTime.now().getMinute() % 2 == 0) {
            signInDAOJDBC.signInB(signInBean);
        } else {
            signInDAOCSV.signInB(signInBean);
        }
    }

    public void checkMail(String email) throws EmailUsedException {
        SignInDAOJDBC.checkEmail(email);
    }
}
