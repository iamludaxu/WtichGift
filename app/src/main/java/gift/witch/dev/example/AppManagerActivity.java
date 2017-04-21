package gift.witch.dev.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import gift.witch.dev.install.AppManager;

public class AppManagerActivity extends AppCompatActivity {


    private EditText mPackNameET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appmanager);
        mPackNameET = (EditText)findViewById(R.id.packname);
        mPackNameET.setText("com.mygirl.mygirl");
        findViewById(R.id.isIntalled).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packName = mPackNameET.getText().toString();
                boolean isIntalled = AppManager.isIntalled(getBaseContext(),packName);
                if(isIntalled){
                    Toast.makeText(getBaseContext(),"已安装应该",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"没有安装应该",Toast.LENGTH_SHORT).show();
                }
            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packName = mPackNameET.getText().toString();
                boolean uninstall = AppManager.uninstall(getBaseContext(),packName);
                if(uninstall){
                    Toast.makeText(getBaseContext(),"卸载成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"卸载失败",Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.launch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packName = mPackNameET.getText().toString();
                boolean uninstall = AppManager.launchIntentForPackage(getBaseContext(),packName);
                if(uninstall){
                    Toast.makeText(getBaseContext()," 启动成功",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(),"启动失败",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
