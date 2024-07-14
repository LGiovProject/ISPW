package com.ispw.circularbook.engineering.mediator;

import com.ispw.circularbook.engineering.bean.SignInBean;
import com.ispw.circularbook.engineering.enums.MediatorEvent;

public interface Mediator {
    void notify(Component sender, MediatorEvent event, SignInBean signInBean);
}
