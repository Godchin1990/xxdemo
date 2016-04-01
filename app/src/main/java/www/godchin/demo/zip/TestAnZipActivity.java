package www.godchin.demo.zip;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;

import www.godchin.demo.R;

public class TestAnZipActivity extends Activity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_unzip_activity);
        progressBar = (ProgressBar) findViewById(R.id.Progress);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        //在sd卡的根目录放一个test.zip文件
        File out = new File(path, "test.zip");
        try {
            Zip4jSp.Unzip(out, path + "/unzip", null, null, new Zip4jSp.ZipProcess() {
                @Override
                public void start() {
                    progressBar.setVisibility(View.VISIBLE);

                }

                @Override
                public void error() {

                }

                @Override
                public void completed() {
                    progressBar.setVisibility(View.INVISIBLE);

                }

                @Override
                public void handling(int percentDone) {
                    progressBar.setProgress(percentDone);

                }
            }, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
