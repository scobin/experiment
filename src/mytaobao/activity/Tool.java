/**
 * 
 */
package mytaobao.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/**
 * @author kawachi
 *
 */
public class Tool {
	
	@SuppressLint("ShowToast")
	public static void ShowMessage(Context context,String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
	}

	/**
	 * Generate a n-digits number string.
	 * @param n the digit's number.
	 * @return String
	 */
	@SuppressLint("UseValueOf")
	public static String getVerifyCode(int n) {
		String strInt = "";
		Integer i = new Integer((int) (Math.random() * Math.pow(10, n)));
		strInt = String.valueOf(i);
		if (strInt.length() != n) {
			return getVerifyCode(n);
		} else {
			return strInt;
		}
	}
}
