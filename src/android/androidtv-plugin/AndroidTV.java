package org.apache.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * * This class provides methods for TTK STB.
 * */
public class AndroidTV extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("getStringExtra")) {
			String message = args.getString(0);
			this.getActivityStringExtra(message, callbackContext);
			return true;
		}
		return false;
	}

	private void getActivityStringExtra(String extraString, CallbackContext callbackContext) {
		Intent intent = this.cordova.getActivity().getIntent();
		Log.d("AndroidTVPlugin", "try to get string extra: " + extraString);
		try {
			callbackContext.success(intent.getStringExtra(extraString));
		} catch(ActivityNotFoundException e) {
			callbackContext.error("Failed to get stringExtra");
		}
	}

}
