/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.android.systemui.tuner;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.preference.Preference;
import android.support.v14.preference.SwitchPreference;
import android.support.v14.preference.PreferenceFragment;
import com.android.systemui.R;

public class StatusbarItems extends PreferenceFragment {

	private static final String NFC_KEY = "nfc";

	private StatusBarSwitch mNfcSwitch;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ContentResolver resolver = getActivity().getContentResolver();

	mNfcSwitch = (StatusBarSwitch) findPreference(NFC_KEY);

        final boolean isNfcAvailable = pm.hasSystemFeature(PackageManager.FEATURE_NFC);
         if (!isNfcAvailable) {
            prefScreen.removePreference(mNfcSwitch);
         }
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.statusbar_items);
    }
}
