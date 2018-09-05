package youtubeapidemo.examples.com.qrdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import youtubeapidemo.examples.com.qrdemo.zxinglibrary.android.CaptureActivity;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.bean.ZxingConfig;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.common.Constant;

public class MainActivity extends Activity implements View.OnClickListener {
    private int REQUEST_CODE_SCAN = 111;

    TextView result;
    EditText edit_text;
    Button scan;
    Button create;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.iv);
        String content = "BEGIN:VCARD\n" +
                "VERSION:3.3\n" +
                "N:蒋帅\n" +
                "EMAIL:369600738@qq.com\n" +
                "TEL:18280038716\n" +
                "TEL;CELL:18582828008\n" +
                "ADR:四川省成都市软件园C11栋16楼狮之吼\n" +
                "ORG:成都\n" +
                "TITLE:程序猿\n" +
                "URL:http://www.baidu.com\n" +
                "NOTE:测试测试\n" +
                "END:VCARD\n";
        String content2 = "tel:18280038716\n";
        result = findViewById(R.id.result);
        edit_text = findViewById(R.id.edit_test);
        scan = findViewById(R.id.scan);
        create = findViewById(R.id.create);
        scan.setOnClickListener(this);
        create.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create:
                String text = edit_text.getText().toString();
                if (!TextUtils.isEmpty(text)) {
                    mImageView.setImageBitmap(QRCodeUtil.createQRCodeBitmap(text, 800, 800));
                }else {
                    Toast.makeText(this,"请输入生成二维码内容",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.scan:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                /*ZxingConfig是配置类
                 *可以设置是否显示底部布局，闪光灯，相册，
                 * 是否播放提示音  震动
                 * 设置扫描框颜色等
                 * 也可以不传这个参数
                 * */
                ZxingConfig config = new ZxingConfig();
                config.setPlayBeep(true);//是否播放扫描声音 默认为true
                config.setShake(true);//是否震动  默认为true
                config.setDecodeBarCode(false);//是否扫描条形码 默认为true
                config.setReactColor(R.color.white);//设置扫描框四个角的颜色 默认为淡蓝色
                config.setFrameLineColor(R.color.white);//设置扫描框边框颜色 默认无色
                config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                startActivityForResult(intent, REQUEST_CODE_SCAN);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                result.setText("扫描结果为：" + content);
            }
        }
    }

}
