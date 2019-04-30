package com.jskaleel.linkifysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.bluecabin.textoo.LinksHandler;
import org.bluecabin.textoo.Textoo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "Link1 : https://www.google.com/search?client=firefox-b-d&channel=crow&q=linkify+test" +
                "\n" +
                "\n" +
                "Link2 : https://developer.android.com/reference/android/text/util/Linkify" +
                "\n" +
                "\n" +
                "Link3 : https://developer.android.com/reference/java/lang/Object.html" +
                "\n" +
                "\n" +
                "Link4 : http://www.facebook.com/" +
                "\n" +
                "\n" +
                "Link5 : mail.google.com" +
                "\n" +
                "\n" +
                "Link6 : http://goo.gl/l6MS" +
                "\n" +
                "\n" +
                "Link7 : https://play.google.com/store/apps/details?id=com.jskaleel.fte" +
                "\n" +
                "\n" +
                "Link8 : +91-9876543210" +
                "\n" +
                "\n" +
                "Link9 : abcd@gmail.com";

        TextView urlTextView = findViewById(R.id.urlTextView);

        Spannable spannedText = (Spannable) Textoo.config(text).linkifyAll()
                .addLinksHandler(new LinksHandler() {
                    @Override
                    public boolean onClick(View view, String url) {
                        Toast.makeText(MainActivity.this, url, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }).apply();

        NoUnderLineSpan noUnderLineSpan = new NoUnderLineSpan();
        spannedText.setSpan(noUnderLineSpan, 0, spannedText.length(), Spanned.SPAN_MARK_MARK);
        urlTextView.setText(spannedText);
        urlTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }


    class NoUnderLineSpan extends UnderlineSpan {
        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            //set true to draw underline for links
            ds.setUnderlineText(false);
        }
    }
}
