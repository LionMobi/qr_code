package youtubeapidemo.examples.com.qrdemo;

import android.app.Fragment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import java.io.IOException;

import youtubeapidemo.examples.com.qrdemo.R;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.bean.ZxingConfig;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.camera.CameraManager;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.common.Constant;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.decode.DecodeImgCallback;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.decode.DecodeImgThread;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.decode.ImageUtil;
import youtubeapidemo.examples.com.qrdemo.zxinglibrary.view.ViewfinderView;


public class CaptureFragment extends Fragment {


}
