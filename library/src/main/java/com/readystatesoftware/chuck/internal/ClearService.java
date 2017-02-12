package com.readystatesoftware.chuck.internal;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.readystatesoftware.chuck.internal.data.ChuckContentProvider;
import com.readystatesoftware.chuck.internal.support.NotificationHelper;

public class ClearService extends IntentService {

  public ClearService() {
    super("ClearService");
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
    getContentResolver().delete(ChuckContentProvider.TRANSACTION_URI, null, null);
    NotificationHelper.clearBuffer();
    NotificationHelper notificationHelper = new NotificationHelper(this);
    notificationHelper.dismiss();
  }
}
