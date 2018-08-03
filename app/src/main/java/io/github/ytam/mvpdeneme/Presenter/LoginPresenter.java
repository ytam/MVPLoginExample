package io.github.ytam.mvpdeneme.Presenter;

import io.github.ytam.mvpdeneme.Model.User;
import io.github.ytam.mvpdeneme.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {

        User user = new User(email, password);

        int loginCheck = user.isValidData();

        if(loginCheck == 0){

            loginView.onLoginError("You must enter your email");

        } else if(loginCheck == 1){

            loginView.onLoginError("You must enter valid email");

        }else if(loginCheck == 2){

            loginView.onLoginError("Password must greater than 6 digit");
        }
        else

            loginView.onLoginSuccess("Login Success");

    }
}
