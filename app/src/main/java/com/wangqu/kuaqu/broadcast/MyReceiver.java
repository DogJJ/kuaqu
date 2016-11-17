package com.wangqu.kuaqu.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.igexin.sdk.PushConsts;
import com.wangqu.kuaqu.app.App;
import com.wangqu.kuaqu.util.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MyReceiver extends BroadcastReceiver {
    Context context;
    private GetMessageListener getMessageListener;

    public MyReceiver() {
        super();
    }

    public MyReceiver(Context context) {
        this.context = context;
    }

    public void setGetMessageListener(GetMessageListener getMessageListener) {
        this.getMessageListener = getMessageListener;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_CLIENTID:

                String cid = bundle.getString("clientid");
                // TODO:处理cid返回
                SharedPreferencesUtil.put(App.getInstance(), App.clientId, cid);

                break;
            case PushConsts.GET_MSG_DATA:
                byte[] payload = bundle.getByteArray("payload");
                if (payload != null) {
                    String message = new String(payload);
//                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    getMessageListener.geTuiMesage(message);
                }
                break;
        }
    }

    public interface GetMessageListener {
        public void geTuiMesage(String message);
    }

}
