package cordova-plugin-beacon;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.wizturn.sdk.peripheral.Peripheral;

/**
 * This class echoes a string called from JavaScript.
 */
public class Beacon extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void setCentralManager() {
        Activity activity = this.cordova.getActivity();
        centralManager = CentralManager.getInstance();
        Log.d("GNCO", "activity: " + activity);
        Log.d("GNCO", "activity.getApplicationContext(): " + activity.getApplicationContext());
        centralManager.init(activity.getApplicationContext());
        centralManager.setPeripheralScanListener(new PeripheralScanListener() {
            @Override
            public void onPeripheralScan(Central central, final Peripheral peripheral) {
                Log.d("GNCO", "onPeripheralScan() : peripheral : " + peripheral);
            }
        });
    }
}
