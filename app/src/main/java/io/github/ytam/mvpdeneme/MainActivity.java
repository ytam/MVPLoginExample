package io.github.ytam.mvpdeneme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.ytam.customtoast.CustomToast;
import io.github.ytam.mvpdeneme.Presenter.ILoginPresenter;
import io.github.ytam.mvpdeneme.Presenter.LoginPresenter;
import io.github.ytam.mvpdeneme.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    ILoginPresenter loginPresenter;

    @BindView(R.id.edtEmail) EditText edtEmail;
    @BindView(R.id.edtPassword) EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);

    }

    @OnClick(R.id.btnLogin) void  btnLoginClick(){

        loginPresenter.onLogin(edtEmail.getText().toString(),edtPassword.getText().toString());
    }

    @Override
    public void onLoginSuccess(String message) {

        CustomToast.success(this, message,Toast.LENGTH_LONG);

    }

    @Override
    public void onLoginError(String message) {

        CustomToast.error(this, message,Toast.LENGTH_LONG);

    }

}
