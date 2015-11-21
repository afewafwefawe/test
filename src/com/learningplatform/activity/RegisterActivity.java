package com.learningplatform.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo1.R;
import com.learningplatfrom.utils.RegisterInfoCheckState;
import com.learningplatfrom.utils.VerificationCode;
public class RegisterActivity extends Activity {
	private Button mRegisterButton = null;//ע�ᰴť
	private Button mReturnButton = null;  //���������ذ�ť
	private ImageView mCodeImage = null;  //���������֤��
	private TextView mCodeText = null;  //������֤��
	private EditText mCodeInput = null; //������֤���
	private EditText mRegisterName = null;
	private EditText mRegisterPasswordFrist = null;
	private EditText mRegisterPasswordSecond = null;
	private EditText mRegisterEmail = null;
	private boolean mRigsterInfoFlag = false;  //��ʶ������Ϣ�Ƿ�������ȷ
	private int mUserNameState = RegisterInfoCheckState.REGISTER_USERNAME_NULL;
	private int mPasswordFristState = RegisterInfoCheckState.REGISTER_PASSWORDFRIST_NULL;
	private int mPasswordSecondState = RegisterInfoCheckState.REGISTER_PASSWORDSECOND_NULL;
	private int mEmailState = RegisterInfoCheckState.REGISTER_USEREMAIL_NULL;
	private int mVertificationState = RegisterInfoCheckState.REGISTER_VERTIFICATION_NULL;
	private String codeString = null;  //��֤���ַ���
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_layout);
		initView();
		readyToPostRegisterInfoToServer();
	}
	public void readyToPostRegisterInfoToServer(){ //����ע�ᰴť��׼���������ύ����������
		mRegisterButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				checkInputRegisterInfoIsRight();
				if(mUserNameState == RegisterInfoCheckState.REGISTER_USERNAME_NULL){
					Toast.makeText(getApplicationContext(), "�û�������Ϊ��",Toast.LENGTH_SHORT).show();return;
				}else if(mUserNameState == RegisterInfoCheckState.REGISTER_USERNAME_INPUT_ERROR){
					Toast.makeText(getApplicationContext(), "�����û�����ʽ����ȷ", Toast.LENGTH_SHORT).show();return;
				}
				if(mPasswordFristState == RegisterInfoCheckState.REGISTER_PASSWORDFRIST_NULL){
					Toast.makeText(getApplicationContext(), "���벻��Ϊ��",Toast.LENGTH_SHORT).show();return;
				}else if(mPasswordFristState == RegisterInfoCheckState.REGISTER_PASSWORDFRIST_INPUT_ERROR){
					Toast.makeText(getApplicationContext(), "���������ʽ����ȷ", Toast.LENGTH_SHORT).show();return;
				}
				if(mPasswordSecondState == RegisterInfoCheckState.REGISTER_PASSWORDSECOND_NULL){
					Toast.makeText(getApplicationContext(), "���벻��Ϊ��",Toast.LENGTH_SHORT).show();return;
				}else if(mPasswordSecondState == RegisterInfoCheckState.REGISTER_PASSWORDSECOND_INPUT_ERROR){
					Toast.makeText(getApplicationContext(), "�����������벻һ�£�����������", Toast.LENGTH_SHORT).show();return;
				}
				if(mEmailState == RegisterInfoCheckState.REGISTER_USEREMAIL_NULL){
					Toast.makeText(getApplicationContext(), "���䲻��Ϊ��",Toast.LENGTH_SHORT).show();return;
				}else if(mEmailState == RegisterInfoCheckState.REGISTER_USEREMAIL_INPUT_ERROR){
					Toast.makeText(getApplicationContext(), "������������ʽ����ȷ", Toast.LENGTH_SHORT).show();return;
				}
				if(mVertificationState == RegisterInfoCheckState.REGISTER_VERTIFICATION_NULL){
					Toast.makeText(getApplicationContext(), "��֤�벻��Ϊ��",Toast.LENGTH_SHORT).show();return;
				}else if(mVertificationState == RegisterInfoCheckState.REGISTER_VERTIFICATION_ERROR){
					Toast.makeText(getApplicationContext(), "������֤�벻��ȷ", Toast.LENGTH_SHORT).show();return;
				}
			}
		});
	}
	public void checkInputRegisterInfoIsRight(){  //��������ʽ���������Ϣ�Ƿ���ȷ
		String userName = mRegisterName.getText().toString(); 
		String userPasswordFirst = mRegisterPasswordFrist.getText().toString();
		String userPasswordSecond = mRegisterPasswordSecond.getText().toString();
		String userEmail = mRegisterEmail.getText().toString();  //��ø����༭���������Ϣ
		String mInputCode = mCodeInput.getText().toString();
		Pattern mPattern = Pattern.compile("[a-zA-Z0-9]{8,31}");
		Matcher mMatcher = mPattern.matcher(userName);
		if(userName.equals("")){
			mUserNameState = RegisterInfoCheckState.REGISTER_USERNAME_NULL;
		}else if(!mMatcher.matches()){
			mUserNameState = RegisterInfoCheckState.REGISTER_USERNAME_INPUT_ERROR;
		} else{
			mUserNameState = RegisterInfoCheckState.REGISTER_USEREMAIL_INPUT_RIGHT;
		}
		mPattern = Pattern.compile("[a-zA-Z0-9]{6,31}");
		mMatcher = mPattern.matcher(userPasswordFirst);
		if(userPasswordFirst.equals("")){
			mPasswordFristState = RegisterInfoCheckState.REGISTER_PASSWORDFRIST_NULL;
		}else if(!mMatcher.matches()){
			mPasswordFristState = RegisterInfoCheckState.REGISTER_PASSWORDFRIST_INPUT_ERROR;
		}else{
			mPasswordFristState = RegisterInfoCheckState.REGISTER_PASSWORDFIRST_INPUT_RIGHT;
		}
		if(!userPasswordSecond.equals(userPasswordFirst)){
			mPasswordSecondState = RegisterInfoCheckState.REGISTER_PASSWORDSECOND_INPUT_ERROR;
		}else if(userPasswordSecond.equals("")){
			mPasswordSecondState = RegisterInfoCheckState.REGISTER_PASSWORDSECOND_NULL;
		} else{
			mPasswordSecondState = RegisterInfoCheckState.REGISTER_PASSWORDSECOND_INPUT_RIGHT;
		}
		mPattern = Pattern.compile("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
		mMatcher = mPattern.matcher(userEmail);
		if(!mMatcher.matches()){
			mEmailState = RegisterInfoCheckState.REGISTER_USEREMAIL_INPUT_ERROR;
		}else if(userEmail.equals("")){
			mEmailState = RegisterInfoCheckState.REGISTER_USEREMAIL_NULL;
		}else{
			mEmailState = RegisterInfoCheckState.REGISTER_USEREMAIL_INPUT_RIGHT;
		}
		if(mInputCode.equals("")){
			mVertificationState = RegisterInfoCheckState.REGISTER_VERTIFICATION_NULL;
		}else if(!mInputCode.equalsIgnoreCase(codeString)){
			mVertificationState = RegisterInfoCheckState.REGISTER_VERTIFICATION_ERROR;
		}else{
			mVertificationState = RegisterInfoCheckState.REGISTER_VERTIFICATION_RIGHT;
		}
	}
	public void initView(){		//��ʼ����ͼ
		mRegisterButton = (Button)this.findViewById(R.id.register_registerbt);
		mReturnButton = (Button)this.findViewById(R.id.return_button);
		mCodeImage = (ImageView)this.findViewById(R.id.register_vertificationcode_imageview);
		mCodeText = (TextView)this.findViewById(R.id.register_changecode_textview);
		mRegisterName = (EditText)this.findViewById(R.id.register_username_textview);
		mRegisterPasswordFrist = (EditText)this.findViewById(R.id.register_passwordfirst_textview);
		mRegisterPasswordSecond = (EditText)this.findViewById(R.id.register_passwordsecond_textview);
		mCodeInput = (EditText)this.findViewById(R.id.register_inputcode_edittext);
		mRegisterEmail = (EditText)this.findViewById(R.id.register_email_textview);
		mCodeImage.setImageBitmap(VerificationCode.getInstance().createCodeBitmap());
		mReturnButton.setOnClickListener(new Button.OnClickListener(){  //������ҳ��
			@Override
			public void onClick(View view) {
				Intent intent = new Intent();
				intent.setClass(RegisterActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
		mCodeText.setOnClickListener(new TextView.OnClickListener(){ //�������һ����֤����������һ����֤��
			@Override
			public void onClick(View view) {
				VerificationCode mBitmapCode = VerificationCode.getInstance();
				mCodeImage.setImageBitmap(mBitmapCode.createCodeBitmap());
				codeString = mBitmapCode.getRandomCode();
			}
		});
	}
}
