package com.teclever.test.slidingfragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class MainActivity extends AppCompatActivity {

   GridView gridview;
   GridViewAdapter adapter;
    Integer[] imageId=null;
    String[] imagestr=null;

    int mul;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview=(GridView)findViewById(R.id.gridview);



        File file=new File(Environment.getExternalStorageDirectory()+File.separator+"images");
        if(!file.exists())
            file.mkdirs();


//        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download1);
//        File file1=new File(file+"/download1.jpg");
//        FileOutputStream out=null;
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//
//        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download2);
//        file1=new File(file+"/download2.jpg");
//
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//
//
//        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download3);
//
//        file1=new File(file+"/download3.jpg");
//
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//
//        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download4);
//
//        file1=new File(file+"/download4.jpg");
//
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//
//        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download5);
//
//        file1=new File(file+"/download5.jpg");
//
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//        bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.download6);
//
//        file1=new File(file+"/download6.jpg");
//
//        try
//        {
//            out=new FileOutputStream(file1);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,out);
//
//        try {
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
      //  fetchImages();
       // imageId= new Integer[]{R.drawable.download1, R.drawable.download2, R.drawable.download3, R.drawable.download4, R.drawable.download5, R.drawable.download6, R.drawable.download7, R.drawable.download8, R.drawable.download9, R.drawable.download10};
 //       ImageUrlLoadThread obj=new ImageUrlLoadThread();
  //      Bitmap[] bitmap1=obj.loadImageMethod();

        File textfile=new File(Environment.getExternalStorageDirectory()+File.separator+"images");
       // File textfile=new File("/sdcard/doc/urlfile.txt");
        if(!textfile.exists())
            textfile.mkdirs();
        File f = new File(file, "Myurls.txt");
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        FileWriter fw= null;
        try
        {
            fw = new FileWriter(f);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        BufferedWriter bw=new BufferedWriter(fw);

        try
        {
          //  RandomAccessFile ran=new RandomAccessFile(textfile,"rw");
           // ran.seek(0);
            bw.write("3*3");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.write("https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg");
            bw.newLine();
            bw.write("https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg");
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        String str=null;
        try
        {
            FileReader file1=new FileReader(f);
            BufferedReader bf=new BufferedReader(file1);

            str=bf.readLine();
           // Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

            char c1=str.charAt(0);
            char c2=str.charAt(2);
            //Toast.makeText(getApplicationContext(),String.valueOf(c),Toast.LENGTH_LONG).show();
            int i2=Character.getNumericValue(c2);

            int i1=Character.getNumericValue(c1);
            mul=i1*i2;
//            Toast.makeText(getApplicationContext(),String.valueOf("i1"+i1),Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(),String.valueOf("i2"+i2),Toast.LENGTH_LONG).show();
//            Toast.makeText(getApplicationContext(),String.valueOf("mul"+mul),Toast.LENGTH_LONG).show();

            FileReader file2 = new FileReader(f);
            BufferedReader bf2 = new BufferedReader(file2);
            String str3=null;
            int linenumber=0;
            if(file.exists())
            {
                while((bf2.readLine())!=null)
                {
                    linenumber++;
                }
            }

            File[] fileSize=textfile.listFiles();
            if(mul >= linenumber )
            {
                Toast.makeText(getApplicationContext(),"Number of Urls are less ! Please add more urls",Toast.LENGTH_LONG).show();

            }
            else
            {
                gridview.setNumColumns(i2);
                gridview.setHorizontalSpacing(40);
                gridview.setVerticalSpacing(40);
                gridview.setColumnWidth(50);
                String str2 = null;
                int i = 0;
                String[] URL1 = new String[linenumber];

                file2 = new FileReader(f);
                bf2 = new BufferedReader(file2);

                while ((str2 = bf2.readLine()) != null)
                {
                    URL1[i++] = str2;
                }
                String[] URL2 = new String[(URL1.length) - 1];
                int k = 0;
                for (int j = 1; j <= mul; j++)
                {
                    URL2[k++] = URL1[j];
                }
                adapter = new GridViewAdapter(this, URL2);
                gridview.setAdapter(adapter);
                Animation anim = AnimationUtils.loadAnimation(getApplication(), R.anim.slideup);

                gridview.startAnimation(anim);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//        String[] URL1={"https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg"
//                ,"https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg",
//                "https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg",
//                "https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg","https://s-media-cache-ak0.pinimg.com/564x/61/60/2c/61602c3c36502bf78bbf6dc2dc0b5f20.jpg",
//                "https://cdn.vectorstock.com/i/composite/19,01/flower-single-icon-vector-731901.jpg"};


        
    }

//    private void fetchImages()
//    {
//        File file=new File(Environment.getExternalStorageDirectory()+"/images");
//        File[] len= file.listFiles();
//
//        imagestr=new String[len.length];
//        for (int i=0;i<len.length;i++)
//        {
//            imagestr[i]=len[i].getAbsolutePath();
//        }
//    }

.

