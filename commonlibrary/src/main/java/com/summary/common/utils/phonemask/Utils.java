package com.summary.common.utils.phonemask;

import android.widget.TextView;

import java.util.regex.Pattern;


public class Utils {
    public static final Pattern notDigitRegex = Pattern.compile("[^\\d]+");

    public static void validatePresetup(TextView editText, String mask){
        //Check setOnFocusChangeListener
        if(editText.getOnFocusChangeListener() != null){
            throw new RuntimeException("If you wanna to use OnFocusChangeListener add him through withOnFocusChangeListener() method");
        }
        //Check mask
        if(mask == null){
            throw new RuntimeException("Mask can't be null");
        }

    }
}
