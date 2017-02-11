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
import android.widget.TextView;
import android.widget.Toast;

import com.matangi.zipbundleapp.R;
import com.matangi.zipbundleapp.constants.Constant;
import com.matangi.zipbundleapp.util.NetworkUtil;
import com.matangi.zipbundleapp.util.UpdateFragments;

/**
 * Created by matangi.agarwal on 2/10/2017.
 */

public class SignUpFragment extends Fragment implements View.OnClickListener {

    private View view;
    private EditText et_user_name, et_email, et_password, et_confirm_pass;
    private TextView tv_register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signup, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        initalizer(view);
        setListener();
        return view;
    }

    private void initalizer(View view) {
        et_user_name = (EditText) view.findViewById(R.id.et_user_name);
        et_email = (EditText) view.findViewById(R.id.et_email);
        et_password = (EditText) view.findViewById(R.id.et_password);
        et_confirm_pass = (EditText) view.findViewById(R.id.et_confirm_pass);
        tv_register = (TextView) view.findViewById(R.id.tv_register);
    }

    private void setListener() {
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            getView().setFocusableInTouchMode(true);
            getView().requestFocus();
            getView().setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                        UpdateFragments.backSetFragment(getActivity().getSupportFragmentManager().beginTransaction(), R.id.Frame_Layout);
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register:
                if(NetworkUtil.isConnected(getActivity())){
                    if(validate()){

                    }
                }else {
                    toastShow("Please check your internet connection.");
                }
                break;
        }
    }

    private boolean validate(){
        String user_name = et_user_name.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();
        String confirm_pass = et_confirm_pass.getText().toString();
        if(user_name.length() == 0){
            toastShow("Please enter user name.");
            return false;
        }else if(email.length() == 0){
            toastShow("Please enter the email address.");
            return false;
        }else if(password.length() == 0){
            toastShow("Please enter the password.");
            return false;
        }else if(confirm_pass.length() == 0){
            toastShow("Please enter the confirm password.");
            return false;
        }else if(password.length()<6){
            toastShow("Password length must be greather than 6 character.");
            return false;
        }else if(!password.equals(confirm_pass)){
            toastShow("Password does not match re-enter passwod.");
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
