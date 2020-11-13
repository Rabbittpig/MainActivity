package com.example.mainactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化数据
     */
    public void initView() {
        btn1 = findViewById(R.id.btn1);
        // 为按钮添加监听事件
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast提示
                Toast.makeText(MainActivity.this,"你点击了Btn1",Toast.LENGTH_SHORT).show();
              /*  // 显示Intent，通过显示Intent可以打开新的Activity
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);*/
           /*   //隐式意图
                Intent intent = new Intent("com.example.mainactivity.START_ACTION");
                startActivity(intent);*/
                // 通过隐式Intent调用系统应用
                //Intent intent = new Intent();
                //ACTION_DIAL 拨号功能
//                intent.setAction(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
              /*  //  设置窗口
                intent.setAction("android.settings.SETTINGS");*/
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("Data","Hello SecondActivity");
//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String resultData = data.getStringExtra("data_return");
                    Log.d("MainActivity",resultData);
                }
                break;
        }
    }

    /**
     * 重写方法，创建选项菜单
     *
     * @param menu
     * @return true 或者 false
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 选中菜单项 点击事件
     *
     * @param item 不同的项
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "点击了Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "点击了Remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}