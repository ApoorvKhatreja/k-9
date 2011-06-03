package com.fsck.k9.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;

public class TextInputDialog {



    public static Dialog create(final Activity activity, final int dialogId, final int icon, final int title,
                                final String message, final int confirmButton, final int cancelButton, final View dialogView, final Runnable action) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setIcon(icon);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setView(dialogView);
        builder.setPositiveButton(confirmButton,
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.dismissDialog(dialogId);
                action.run();
            }
        });
        builder.setNegativeButton(cancelButton,
        new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.dismissDialog(dialogId);
            }
        });
        return builder.create();
    }
}
