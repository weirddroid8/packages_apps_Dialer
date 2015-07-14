/*
 * Copyright (C) 2013-2014, The Linux Foundation. All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions are
 met:
         * Redistributions of source code must retain the above copyright
           notice, this list of conditions and the following disclaimer.
         * Redistributions in binary form must reproduce the above
           copyright notice, this list of conditions and the following
           disclaimer in the documentation and/or other materials provided
           with the distribution.
         * Neither the name of The Linux Foundation nor the names of its
           contributors may be used to endorse or promote products derived
           from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED "AS IS" AND ANY EXPRESS OR IMPLIED
 WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT
 ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.android.dialer;

import android.content.Context;
import android.content.SharedPreferences;

public class SpeedDialUtils {
    private static final String NUMBER_KEY_PREFIX = "number_";

    public static void saveNumber(Context context, int position, String phoneNumber) {
        if (position < 2 || position > 15) {
            return;
        }
        SharedPreferences.Editor editor = getPrefs(context).edit();
        String key = NUMBER_KEY_PREFIX + position;
        if (phoneNumber == null) {
            editor.remove(key);
        } else {
            editor.putString(key, phoneNumber);
        }
        editor.commit();
    }

    public static String getNumber(Context context, int position) {
        if (position < 2 || position > 15) {
            return null;
        }
        String key = NUMBER_KEY_PREFIX + position;
        return getPrefs(context).getString(key, null);
    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("speeddial", context.MODE_PRIVATE);
    }
}
