/*
 * Tencent is pleased to support the open source community by making wechat-matrix available.
 * Copyright (C) 2018 THL A29 Limited, a Tencent company. All rights reserved.
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.tencent.matrix.trace;

import android.app.Activity;
import android.os.Bundle;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

import sample.tencent.matrix.R;
import sample.tencent.matrix.issue.IssueFilter;

/**
 * Created by caichongyang on 2017/11/14.
 */

public class TestFpsActivity extends Activity {
    private static final String TAG = "Matrix.TestFpsActivity";
    private ListView mListView;
    private static HandlerThread sHandlerThread = new HandlerThread("test");

    static {
        sHandlerThread.start();
    }

    private int count;
    private long time = System.currentTimeMillis();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_fps_layout);

        IssueFilter.setCurrentFilter(IssueFilter.ISSUE_TRACE);

        time = System.currentTimeMillis();
        mListView = (ListView) findViewById(R.id.list_view);
        String[] data = new String[200];
        for (int i = 0; i < 200; i++) {
            data[i] = "MatrixTrace:" + i;
        }
        mListView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, data) {
            Random random = new Random();

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                int rand = random.nextInt(10);
                if (rand % 3 == 0) {
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return super.getView(position, convertView, parent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "[onDestroy] count:" + count + " time:" + (System.currentTimeMillis() - time) + "");
    }
}
