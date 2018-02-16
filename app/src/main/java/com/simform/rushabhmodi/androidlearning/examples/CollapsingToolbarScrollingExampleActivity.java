package com.simform.rushabhmodi.androidlearning.examples;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.simform.rushabhmodi.androidlearning.R;

public class CollapsingToolbarScrollingExampleActivity extends AppCompatActivity {

    private TextView collapsingContentTextView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView collapsingImageView;
    private String contentString = "A random text.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_scrolling_example);
        Toolbar toolbar = findViewById(R.id.toolbar_collapsing);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        for (int i = 1; i <= 50; i++) {
            contentString += i + "\nA random text.";
        }

        collapsingContentTextView = findViewById(R.id.textview_collapsing_content);
        collapsingContentTextView.setText(contentString);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);

        collapsingImageView = findViewById(R.id.imageview_collapsing);

        Bitmap bitmap = ((BitmapDrawable) collapsingImageView.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                applyPalette(palette);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab_collapsing);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.collapsing_uri))));
            }
        });

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Snackbar.make(view, R.string.collapsing_snackbar, Snackbar.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private void applyPalette(Palette palette) {
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(getResources().getColor(R.color.colorPrimary)));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(getResources().getColor(R.color.colorPrimaryDark)));
        //updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
        supportStartPostponedEnterTransition();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return false;
    }
}
