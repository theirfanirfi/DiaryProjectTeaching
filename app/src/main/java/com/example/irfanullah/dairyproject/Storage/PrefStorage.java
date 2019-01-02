package com.example.irfanullah.dairyproject.Storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefStorage {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public static SharedPreferences getSharedPreferences(Context context){
      return  context.getSharedPreferences("Diary_db",Context.MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor(Context context){
        return getSharedPreferences(context).edit();
    }

    public static void toastHere(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();

    }

}
