package com.teclever.test.androidassignment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class OurListAdapter extends BaseAdapter
{

    TextView tvnews;
    ImageView imageView;
    Activity activity;
    ArrayList<String> alist=new ArrayList<>(100);
    public OurListAdapter(Activity activity, ArrayList<String> alist)
    {
        this.alist=alist;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int i) {
        return alist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        String[] urls = {"http://4.bp.blogspot.com/-ASbur6zWkAs/T70OsfiYdhI/AAAAAAAABbY/ZuYOvLdqGHM/s640/batman%252Bsimbolo.jpg",
                "http://files.site-fusion.co.uk/webfusion101281/image/superman_logo-5.jpg"};

        LayoutInflater inflater=activity.getLayoutInflater();
        if(view==null) {
            view = inflater.inflate(R.layout.activity_list_column, null);
            tvnews = (TextView) view.findViewById(R.id.tvnews);
            tvnews.setText(alist.get(i));
            imageView = (ImageView) view.findViewById(R.id.imageview);
            if (i % 2 == 0) {
                //Picasso.with(activity.getBaseContext()).load(urls[0]).into(imageView);
                if (ImageStorage.checkifImageExists("img1")) {
                    File file = ImageStorage.getImage("/" + "img1" + ".jpg");
                    String path = file.getAbsolutePath();
                    if (path != null) {
                        Bitmap b = BitmapFactory.decodeFile(path);
                        imageView.setImageBitmap(b);
                    }
                } else {
                    new GetImages(urls[0], imageView, "img1").execute();
                }
            } else {
                //Picasso.with(activity.getBaseContext()).load(urls[1]).into(imageView);
                if (ImageStorage.checkifImageExists("img2")) {
                    File file = ImageStorage.getImage("/" + "img2" + ".jpg");
                    String path = file.getAbsolutePath();
                    if (path != null) {
                        Bitmap b = BitmapFactory.decodeFile(path);
                        imageView.setImageBitmap(b);
                    }
                } else {
                    new GetImages(urls[1], imageView, "img2").execute();
                }
            }
        }
        return view;
    }
}

 class GetImages extends AsyncTask<Object, Object, Object> {
    private String requestUrl, imagename;
    private ImageView view;
    private Bitmap bitmap ;
    GetImages(String requestUrl, ImageView view, String imagename) {
        this.requestUrl = requestUrl;
        this.view = view;
        this.imagename = imagename ;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        try {
            URL url = new URL(requestUrl);
            URLConnection conn = url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (Exception ex) {ex.printStackTrace();}
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(!ImageStorage.checkifImageExists(imagename))
        {
            view.setImageBitmap(bitmap);
            ImageStorage.saveToSdCard(bitmap, imagename);
        }
    }
}

class ImageStorage {
    public static String saveToSdCard(Bitmap bitmap, String filename) {
        String stored = null;
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "News/images", filename + ".jpg") ;
        if (file.exists())
            return stored ;

        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            stored = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stored;
    }

    public static File getImage(String imagename) {

        File mediaImage = null;
        try {
            String root = Environment.getExternalStorageDirectory().toString();
            File myDir = new File(root);
            if (!myDir.exists())
                return null;
            mediaImage = new File(Environment.getExternalStorageDirectory() + File.separator + "News/images"+imagename+".jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mediaImage;
    }
    public static boolean checkifImageExists(String imagename)
    {
        Bitmap b = null ;
        File file = ImageStorage.getImage("/"+imagename+".jpg");
        String path = file.getAbsolutePath();
        if (path != null)
            b = BitmapFactory.decodeFile(path);
        if(b == null ||  b.equals(""))
            return false ;
        return true ;
    }
}

