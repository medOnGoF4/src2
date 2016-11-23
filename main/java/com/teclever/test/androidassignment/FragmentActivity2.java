package com.teclever.test.androidassignment;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FragmentActivity2 extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.activity_fragment2,container,false);
        if(externalSpaceAvailable())
            newsFolderFile();
        return v;
    }
    private boolean externalSpaceAvailable()
    {
        String str= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(str))
            return true;
        else
            return false;
    }
    private File newsFolderFile()
    {
        File file=new File(Environment.getExternalStorageDirectory()+File.separator+"News");
        try
        {
            if (!file.exists())
                file.mkdirs();
            File f = new File(file, "Information.txt");
            if (!f.exists())
                f.createNewFile();
            FileWriter fw = null;
            fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Info 1\nInfo 2\nInfo 3\nInfo 4\nInfo 5\nInfo 6\nInfo 7\nInfo 8\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
