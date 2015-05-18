package it.moondroid.popupwindowdemo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DispositivePopupWindow extends android.widget.PopupWindow implements OnItemClickListener {

	private Context mContex;
	private View mPopupView;
	private String[] mDispositiveName;

	public DispositivePopupWindow(Context context) {

		super(context);

		mContex = context;
		mPopupView = LayoutInflater.from(context).inflate(
				R.layout.popup_dispositive, null);
		setContentView(mPopupView);

		final float scale = mContex.getResources().getDisplayMetrics().density;
		final int widthDp = 250;
		int widthPixels = (int) (widthDp * scale + 0.5f);
		setWidth(widthPixels);
		setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

		// Closes the popup window when touch outside of it - when looses focus
		setOutsideTouchable(true);
		setFocusable(true);
		setBackgroundDrawable(new BitmapDrawable());

		ListView lvChannels = (ListView) mPopupView
				.findViewById(R.id.lv_dispositive);
		mDispositiveName = mContex.getResources().getStringArray(
				R.array.dispositive_name);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContex,
				R.layout.listitem_dispositive, R.id.tv_channel_title, mDispositiveName);
		lvChannels.setAdapter(adapter);
		
		lvChannels.setOnItemClickListener(this);
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
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(mContex, mDispositiveName[position], Toast.LENGTH_SHORT).show();
	}

}
