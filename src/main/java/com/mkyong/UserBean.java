package com.mkyong;

import com.mkyong.user.bo.UserBo;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("session")
public class UserBean {

    @Inject
    UserBo userBo;

    public void setUserBo(UserBo userBo) {
        this.userBo = userBo;
    }

    public String printMsgFromSpring() {

        return userBo.getMessage();

    }
}
