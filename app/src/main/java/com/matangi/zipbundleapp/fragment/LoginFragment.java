package com.matangi.zipbundleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.matangi.zipbundleapp.R;
import com.matangi.zipbundleapp.constants.Constant;
import com.matangi.zipbundleapp.util.NetworkUtil;
import com.matangi.zipbundleapp.util.UpdateFragments;

/**
 * Created by matangi.agarwal on 2/10/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_donthaveacc, tv_login;
    private RelativeLayout rl_loginwithfacebook;
    private EditText et_password, et_email;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_login, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        initalizer(view);
        setListener();
        return view;
    }

    private void initalizer(View view) {
        tv_donthaveacc = (TextView) view.findViewById(R.id.tv_donthaveacc);
        tv_login = (TextView) view.findViewById(R.id.tv_login);
        rl_loginwithfacebook = (RelativeLayout) view.findViewById(R.id.rl_loginwithfacebook);
        et_password = (EditText) view.findViewById(R.id.et_password);
        et_email = (EditText) view.findViewById(R.id.et_email);
    }

    private void setListener() {
        tv_donthaveacc.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        rl_loginwithfacebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_donthaveacc:
                UpdateFragments.setFragment(getActivity().getSupportFragmentManager().beginTransaction(),new SignUpFragment(), R.id.Frame_Layout);
                break;
            case R.id.tv_login:
                if(NetworkUtil.isConnected(getActivity())){
                    if(validate()){
                        String email = et_email.getText().toString();
                        String password = et_password.getText().toString();
                    }
                }else{
                    toastShow("Please check your internet connection.");
                }
                break;
            case R.id.rl_loginwithfacebook:
                break;
        }
    }

    private boolean validate(){
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        if(email.length() == 0){
            toastShow("Please enter the email address.");
            return false;
        }else if(password.length() == 0){
            toastShow("Please enter the password.");
            return false;
        }else if(!email.matches(Constant.EMAIL_REGEX)){
            toastShow("Please enter the vaild email address.");
            return false;
        }else {
            return true;
        }
    }

    private void toastShow(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
