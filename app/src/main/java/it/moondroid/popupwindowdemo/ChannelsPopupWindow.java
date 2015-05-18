package it.moondroid.popupwindowdemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ChannelsPopupWindow extends android.widget.PopupWindow implements
		OnClickListener {

	private Context mContex;
	private View mPopupView;

	public ChannelsPopupWindow(Context context) {

		super(context);

		mContex = context;
		mPopupView = LayoutInflater.from(context).inflate(R.layout.popup_channels,
				null);
		setContentView(mPopupView);

		//setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		final float scale = mContex.getResources().getDisplayMetrics().density;
		final int heightDp = 500;
		int heightPixels = (int) (heightDp * scale + 0.5f);
		setWidth(heightPixels);
		setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

				
		// Closes the popup window when touch outside of it - when looses focus
		setOutsideTouchable(true);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable());

		Button btnNewChannel = (Button) mPopupView.findViewById(R.id.btn_new_channel);
		
		btnNewChannel.setOnClickListener(this);

		ListView lvChannels = (ListView)mPopupView.findViewById(R.id.lv_dispositive);
		String[] channelsName =  mContex.getResources().getStringArray(R.array.channels_name); 
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(mContex, R.layout.listitem_channels, R.id.tv_channel_title, channelsName);
		lvChannels.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lvChannels.setAdapter(adapter);
	}

	// Attaches the view to its parent anchor-view at position x and y
	public void showToggle(View anchor, int x, int y) {
		// showAtLocation(anchor, Gravity.CENTER, x, y);
		if (isShowing()) {
			dismiss();
		} else {
			showAsDropDown(anchor, 0, 0);
		}

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.btn_new_channel:
			//TODO
			Toast.makeText(mContex, "new channel", Toast.LENGTH_SHORT).show();
			break;
		
		}

	}
	
	

}
