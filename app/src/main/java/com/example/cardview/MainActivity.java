package com.example.cardview;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<AppModel> appModelList;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        appModelList = new ArrayList<>();
        adapter = new Adapter(this, appModelList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        insertDataIntoCards();
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        int spanCount;
        int spacing;
        boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                // top edge
                if (position < spanCount) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount) {
                    outRect.top = spacing;
                }
            }
        }
    }

    int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    void insertDataIntoCards() {
        // add card data and display them
        int[] appCovers = new int[] {
            R.drawable.download,
            R.drawable.download,
            R.drawable.download,
            R.drawable.download,
            R.drawable.download,
        };

//        appModelList.add(new AppModel("aaa", 800000, appCovers[0]));
//        appModelList.add(new AppModel("bbb", 800000, appCovers[1]));
//        appModelList.add(new AppModel("ccc", 800000, appCovers[2]));
//        appModelList.add(new AppModel("ddd", 800000, appCovers[3]));
//        appModelList.add(new AppModel("eee", 800000, appCovers[4]));
        Collections.addAll(appModelList,
            new AppModel("aaa", 800000, appCovers[0]),
            new AppModel("bbb", 800000, appCovers[1]),
            new AppModel("ccc", 800000, appCovers[2]),
            new AppModel("ddd", 800000, appCovers[3]),
            new AppModel("eee", 800000, appCovers[4])
        );

        adapter.notifyDataSetChanged();
    }

}