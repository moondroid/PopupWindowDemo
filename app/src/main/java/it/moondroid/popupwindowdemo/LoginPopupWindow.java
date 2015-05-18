package it.moondroid.popupwindowdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPopupWindow extends android.widget.PopupWindow implements
		OnClickListener, OnCheckedChangeListener {

	private final Context mContext;
	private View mPopupView;
	private LoginPopupListener mInterface;
	
	public static interface LoginPopupListener {
		void onLogin();
	}
	
	public LoginPopupWindow(Context context) {

		super(context);

		mContext = context;
		mInterface = (LoginPopupListener) context;
		
		mPopupView = LayoutInflater.from(context).inflate(R.layout.popup_login,
				null);
		setContentView(mPopupView);

		setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		setWidth(WindowManager.LayoutParams.MATCH_PARENT);

		// Closes the popup window when touch outside of it - when looses focus
		setOutsideTouchable(true);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable());

		Button btnLogin = (Button) mPopupView.findViewById(R.id.btn_login);
		Button btnInfo = (Button) mPopupView.findViewById(R.id.btn_info);

		btnLogin.setOnClickListener(this);
		btnInfo.setOnClickListener(this);

		CheckBox cbRicorda =(CheckBox)mPopupView.findViewById(R.id.cb_ricorda);
		cbRicorda.setOnCheckedChangeListener(this);
	}

	
	public void showToggle(View anchor, int x, int y) {
		if (isShowing()) {
			dismiss();
		} else {
			// Attaches the view to its parent anchor-view at position x and y
			showAsDropDown(anchor, 0, 0);
		}

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btn_login:
			//TODO
			Toast.makeText(mContext, "logged in", Toast.LENGTH_SHORT).show();
			dismiss();
			if (mInterface != null) {
				mInterface.onLogin();
			}
			break;

		case R.id.btn_info:	
//			BasePopupFragment popupInfomativa = BasePopupFragment.newInstance(R.layout.popup_informativa);
//			FragmentManager fm = ((Activity)mContext).getFragmentManager();
//			popupInfomativa.show(fm, "informativa");
			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		
		switch (buttonView.getId()){
		
		case R.id.cb_ricorda:
			if(isChecked){
//				RicordaCredenzialiPopupFragment popupRicorda = RicordaCredenzialiPopupFragment.newInstance(R.layout.popup_ricorda);
//				FragmentManager fm = ((Activity)mContext).getFragmentManager();
//				popupRicorda.show(fm, "ricorda");
			}
			break;
		}
		
	}

}
