package com.learningplatfrom.utils;

public final class RegisterInfoCheckState {
	public static final int REGISTER_USERNAME_NULL = 0;  	//����ע���û���Ϊ��
	public static final int REGISTER_USERNAME_INPUT_ERROR = 1;  	//ע���û��������ʽ���� 
	public static final int REGISTER_USERNAME_INPUT_REPEATE = 2; //ע���û����ظ�
	public static final int REGISTER_USERNAME_INPUT_RIGHT = 3; //ע���û���������ȷ
	public static final int REGISTER_PASSWORDFRIST_NULL = 4;		//��һ������Ϊ��
	public static final int REGISTER_PASSWORDFRIST_INPUT_ERROR = 5;	//��һ�����������ʽ����
	public static final int REGISTER_PASSWORDSECOND_NULL = 6;//�ڶ�������Ϊ��
	public static final int REGISTER_PASSWORDSECOND_INPUT_ERROR = 7;	//ȷ�������������
	public static final int	REGISTER_USEREMAIL_NULL = 8;	//����Ϊ��
	public static final int REGISTER_USEREMAIL_INPUT_ERROR = 9;//���������ʽ����
	public static final int REGISTER_USEREMAIL_INPUT_REPEATE = 10;//�����Ѿ�ע��
	public static final int REGISTER_USEREMAIL_INPUT_RIGHT = 11; //�����ʽ������ȷ
	public static final int REGISTER_USEREMAIL_INPUT_PASSED = 12; 	//��������ͨ��
	public static final int REGISTER_VERTIFICATION_NULL = 13;	//��֤��Ϊ��
	public static final int REGISTER_VERTIFICATION_ERROR = 14; //��֤���������
	public static final int REGISTER_VERTIFICATION_RIGHT = 15; //��֤��������ȷ
	public static final int REGISTER_PASSWORDFIRST_INPUT_RIGHT = 16;  //��һ������������ȷ
	public static final int REGISTER_PASSWORDSECOND_INPUT_RIGHT = 16;  //�ڶ�������������ȷ
}
