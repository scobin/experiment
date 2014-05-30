package mytaobao.activity;

import mytaobao.dao.biz.UserManager;
import mytaobao.model.User;

import com.example.mytaobao.R;
import com.example.mytaobao.R.layout;
import com.example.mytaobao.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Context context = null;
	private static final int DIALOG_EXIT = 0;
	private static final int DIALOG_LOGIN = 1;
	private static final int DIALOG_REGISTER = 2;
	private LayoutInflater inflater = null;
	private User loginUser = null;
	private UserManager userManager = null;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
		showDialog(DIALOG_LOGIN);
		//setContentView(R.layout.activity_main);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateDialog(int)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = this.buildDialog(id);
		return dialog;
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onPrepareDialog(int, android.app.Dialog)
	 */
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		if (id == DIALOG_REGISTER) {
		    TextView txtVrfCode = (TextView) dialog.findViewById(R.id.txt_register_VrfCode);
		    String strInt = Tool.getVerifyCode(4);
		    txtVrfCode.setText(strInt);
		}
	}
	
	// Internal function is defined below.

	/**
	 * Initialization the global variables.
	 */
	private void init() {
		userManager = new UserManager();
		context = this;
		this.inflater = LayoutInflater.from(this);
	}
	
	/**
	 * Create dialog according to flag
	 * @param flag
	 * @return
	 */
	private Dialog buildDialog(int flag) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		switch (flag) {
		case DIALOG_EXIT:
			builder.setMessage(R.string.login_exit_message)
			.setPositiveButton(R.string.common_btn_confirm, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
				
			})
			.setNegativeButton(R.string.common_btn_cancel, null);
			break;
		case DIALOG_LOGIN:
			createLoginDialog(builder);
		    break;
		case DIALOG_REGISTER:
			createRegisterDialog(builder);
			break;
		default:
			break;
		}
		return builder.create();
	}

	/**
	 * Create the login dialog.
	 * @param builder
	 */
	private void createLoginDialog(AlertDialog.Builder builder) {
		View v = inflater.inflate(R.layout.login_ui, null);
		builder.setTitle(R.string.login_dlg_title)
		       .setIcon(R.drawable.ic_launcher)
		       .setView(v)
		       .setCancelable(false);
		Button btnLogin = (Button) v.findViewById(R.id.btn_login_Login);
		final EditText edtUserId = (EditText) v.findViewById(R.id.edt_login_UserId);
		final EditText edtPassword = (EditText) v.findViewById(R.id.edt_login_Password);
		btnLogin.setOnClickListener(new OnClickListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				loginUser = userManager.login(edtUserId.getText().toString(), edtPassword.getText().toString());
				if (loginUser != null) {
					dismissDialog(DIALOG_LOGIN);
					setContentView(R.layout.main);
				} else {
					Tool.ShowMessage(context, getResources().getString(R.string.msg_login_fail));
				}
			}
			
		});
		
		Button btnExit = (Button) v.findViewById(R.id.btn_login_Exit);
		btnExit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				finish();
			}
			
		});
		v.findViewById(R.id.txt_login_Register).setOnClickListener(new OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(DIALOG_REGISTER);				
			}
			
		});
	}

	/**
	 * Create the register dialog.
	 * @param builder
	 */
	private void createRegisterDialog(AlertDialog.Builder builder) {
		View v = inflater.inflate(R.layout.register_ui, null);
		builder.setTitle(R.string.register_dlg_title)
		       .setIcon(R.drawable.ic_launcher)
		       .setView(v)
		       .setCancelable(false);
		Button btnConfirm = (Button) v.findViewById(R.id.btn_register_Confirm);
		final EditText edtUserId = (EditText) v.findViewById(R.id.edt_register_UserId);
		final EditText edtPassword = (EditText) v.findViewById(R.id.edt_register_Password);
		final TextView txtVrfCode = (TextView) v.findViewById(R.id.txt_register_VrfCode);
		final EditText edtVrfCode = (EditText) v.findViewById(R.id.edt_register_VrfCode);
		txtVrfCode.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				((TextView) v).setText(Tool.getVerifyCode(4));
			}
			
		});
		btnConfirm.setOnClickListener(new OnClickListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				if (edtVrfCode.getText().toString().equals(txtVrfCode.getText().toString())) {
					User user = new User(edtUserId.getText().toString(), edtPassword.getText().toString());
					User result = userManager.Register(user);
					if (result != null) {
						dismissDialog(DIALOG_REGISTER);
						//Tool.ShowMessage(context, getResources().getString(R.string.msg_register_succeeded));
					} else {
						Tool.ShowMessage(context, getResources().getString(R.string.msg_register_fail));
					}
				} else {
					Tool.ShowMessage(context, getResources().getString(R.string.msg_register_vrfcode_incorrect));
					String strInt = Tool.getVerifyCode(4);
					txtVrfCode.setText(strInt);
				}
				
			}
			
		});
		
		Button btnCancel = (Button) v.findViewById(R.id.btn_register_Cancel);
		btnCancel.setOnClickListener(new OnClickListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				dismissDialog(DIALOG_REGISTER);
			}
			
		});
		
	}
	
	
}
