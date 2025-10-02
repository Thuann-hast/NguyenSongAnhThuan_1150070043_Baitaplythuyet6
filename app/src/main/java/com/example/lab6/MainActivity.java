package com.example.lab6;





import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.animation.AnimationSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnFadeInXml, btnFadeInCode, btnFadeOutXml, btnFadeOutCode,
            btnBlinkXml, btnBlinkCode, btnZoomInXml, btnZoomInCode,
            btnZoomOutXml, btnZoomOutCode, btnRotateXml, btnRotateCode,
            btnMoveXml, btnMoveCode, btnSlideUpXml, btnSlideUpCode,
            btnBounceXml, btnBounceCode, btnCombineXml, btnCombineCode;

    private ImageView ivUitLogo;
    private Animation.AnimationListener animationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewsByIds();
        initVariables();

        // 🎯 Gọi hàm handleClickAnimationXml cho tất cả button XML
        handleClickAnimationXml(btnFadeInXml, R.anim.anim_fade_in);
        handleClickAnimationXml(btnFadeOutXml, R.anim.anim_fade_out);
        handleClickAnimationXml(btnBlinkXml, R.anim.anim_blink);
        handleClickAnimationXml(btnZoomInXml, R.anim.anim_zoom_in);
        handleClickAnimationXml(btnZoomOutXml, R.anim.anim_zoom_out);
        handleClickAnimationXml(btnRotateXml, R.anim.anim_rotate);
        handleClickAnimationXml(btnMoveXml, R.anim.anim_move);
        handleClickAnimationXml(btnSlideUpXml, R.anim.anim_slide_up);
        handleClickAnimationXml(btnBounceXml, R.anim.anim_bounce);
        handleClickAnimationXml(btnCombineXml, R.anim.anim_combine);

        // 🎯 Animation tạo từ Code
        btnFadeInCode.setOnClickListener(v -> {
            AlphaAnimation anim = new AlphaAnimation(0f, 1f);
            anim.setDuration(1000);
            ivUitLogo.startAnimation(anim);
        });

        btnFadeOutCode.setOnClickListener(v -> {
            AlphaAnimation anim = new AlphaAnimation(1f, 0f);
            anim.setDuration(1000);
            ivUitLogo.startAnimation(anim);
        });

        btnBlinkCode.setOnClickListener(v -> {
            AlphaAnimation anim = new AlphaAnimation(0f, 1f);
            anim.setDuration(300);
            anim.setRepeatMode(Animation.REVERSE);
            anim.setRepeatCount(3);
            ivUitLogo.startAnimation(anim);
        });

        btnZoomInCode.setOnClickListener(v -> {
            ScaleAnimation anim = new ScaleAnimation(
                    1f, 3f, 1f, 3f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(1000);
            ivUitLogo.startAnimation(anim);
        });

        btnZoomOutCode.setOnClickListener(v -> {
            ScaleAnimation anim = new ScaleAnimation(
                    1f, 0.5f, 1f, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(1000);
            ivUitLogo.startAnimation(anim);
        });

        btnRotateCode.setOnClickListener(v -> {
            RotateAnimation anim = new RotateAnimation(0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(600);
            anim.setRepeatCount(2);
            ivUitLogo.startAnimation(anim);
        });

        btnMoveCode.setOnClickListener(v -> {
            TranslateAnimation anim = new TranslateAnimation(0, 500, 0, 0);
            anim.setDuration(800);
            ivUitLogo.startAnimation(anim);
        });

        btnSlideUpCode.setOnClickListener(v -> {
            ScaleAnimation anim = new ScaleAnimation(
                    1f, 1f, 1f, 0f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 1f);
            anim.setDuration(500);
            ivUitLogo.startAnimation(anim);
        });

        btnBounceCode.setOnClickListener(v -> {
            ScaleAnimation anim = new ScaleAnimation(
                    1f, 1f, 0f, 1f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 1f);
            anim.setDuration(500);
            anim.setInterpolator(getApplicationContext(), android.R.anim.bounce_interpolator);
            ivUitLogo.startAnimation(anim);
        });

        btnCombineCode.setOnClickListener(v -> {
            AnimationSet set = new AnimationSet(true);

            ScaleAnimation scale = new ScaleAnimation(
                    1f, 3f, 1f, 3f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            scale.setDuration(2000);

            RotateAnimation rotate = new RotateAnimation(
                    0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            rotate.setDuration(1000);
            rotate.setRepeatCount(1);

            set.addAnimation(scale);
            set.addAnimation(rotate);

            ivUitLogo.startAnimation(set);
        });
    }

    // 🟢 Ánh xạ view
    private void findViewsByIds() {
        ivUitLogo = findViewById(R.id.iv_uit_logo);

        btnFadeInXml = findViewById(R.id.btn_fade_in_xml);
        btnFadeInCode = findViewById(R.id.btn_fade_in_code);
        btnFadeOutXml = findViewById(R.id.btn_fade_out_xml);
        btnFadeOutCode = findViewById(R.id.btn_fade_out_code);
        btnBlinkXml = findViewById(R.id.btn_blink_xml);
        btnBlinkCode = findViewById(R.id.btn_blink_code);
        btnZoomInXml = findViewById(R.id.btn_zoom_in_xml);
        btnZoomInCode = findViewById(R.id.btn_zoom_in_code);
        btnZoomOutXml = findViewById(R.id.btn_zoom_out_xml);
        btnZoomOutCode = findViewById(R.id.btn_zoom_out_code);
        btnRotateXml = findViewById(R.id.btn_rotate_xml);
        btnRotateCode = findViewById(R.id.btn_rotate_code);
        btnMoveXml = findViewById(R.id.btn_move_xml);
        btnMoveCode = findViewById(R.id.btn_move_code);
        btnSlideUpXml = findViewById(R.id.btn_slide_up_xml);
        btnSlideUpCode = findViewById(R.id.btn_slide_up_code);
        btnBounceXml = findViewById(R.id.btn_bounce_xml);
        btnBounceCode = findViewById(R.id.btn_bounce_code);
        btnCombineXml = findViewById(R.id.btn_combine_xml);
        btnCombineCode = findViewById(R.id.btn_combine_code);
    }

    // 🟢 Listener cho Animation
    private void initVariables() {
        animationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(getApplicationContext(),
                        "Animation Stopped", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        };
    }

    // 🟢 Hàm gắn sự kiện cho button XML
    private void handleClickAnimationXml(Button btn, int animId) {
        btn.setOnClickListener(v -> {
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), animId);
            anim.setAnimationListener(animationListener);
            ivUitLogo.startAnimation(anim);
        });
    }
}