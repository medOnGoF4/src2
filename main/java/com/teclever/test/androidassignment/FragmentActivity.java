package com.teclever.test.androidassignment;

import android.app.Fragment;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FragmentActivity extends Fragment  {
    String getName=null;
    TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.activity_fragment,container,false);
        if(externalSpaceAvailable())
            newsFolderFile();
        final ListView newslist=(ListView)v.findViewById(R.id.newslist);

        ArrayList<String> alist=new ArrayList<String>(100);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Environment.getExternalStorageDirectory()
                    + File.separator + "News/Headlines.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                alist.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OurListAdapter adapter=new OurListAdapter(getActivity(),alist);
        newslist.setAdapter(adapter);

        newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               getName=(String)newslist.getItemAtPosition(i);
               FragmentActivity2 fm2=(FragmentActivity2)getFragmentManager().findFragmentById(R.id.container2);
               tv=(TextView)fm2.getView().findViewById(R.id.textView2);
                Log.d("Debug", String.valueOf(i));

               ArrayList<String> lines = new ArrayList<String>(100);
               try {
                   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Environment.getExternalStorageDirectory()
                           + File.separator + "News/Information.txt")));
                   String line;
                   while ((line = br.readLine()) != null) {
                       lines.add(line);
                       //if(lines.get(i)!=null)break;
                   }
                   br.close();
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               tv.setText(lines.get(i));
           }
       });
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
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "News");
        try{
            if (!file.exists())
                file.mkdirs();

            File f = new File(file, "Headlines.txt");
            if (!f.exists())
                f.createNewFile();
            FileWriter fw = null;
            fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Headline 1\nHeadline 2\nHeadline 3\nHeadline 4\nHeadline 5\nHeadline 6\nHeadline 7\nHeadline 8\n");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
