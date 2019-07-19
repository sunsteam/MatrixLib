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

package sample.tencent.matrix.sqlitelint;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import sample.tencent.matrix.R;
import sample.tencent.matrix.issue.IssueFilter;
import tech.sunyx.matrixhelper.MatrixHelper;
import tech.sunyx.matrixhelper.Plugin;

public class TestSQLiteLintActivity extends AppCompatActivity {
    private final static String TAG = "TestSQLiteLintActivity";
    private static int only1 = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_sqlite_lint);

        IssueFilter.setCurrentFilter(IssueFilter.ISSUE_SQLITELINT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MatrixHelper.clearIssueStorage();

        Plugin plugin = MatrixHelper.getSqlLiteLintPlugin();
        if (plugin == null) {
            return;
        }

        if (plugin.isPluginStarted()) {
            plugin.stop();
        }

    }

    private void insert() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Id", System.currentTimeMillis());
        contentValues.put("name", TestSQLiteLintHelper.genRandomString(5));
        contentValues.put("age", System.currentTimeMillis() % 90);
        TestDBHelper.get().getWritableDatabase().insert(TestDBHelper.TABLE_NAME, null, contentValues);
    }

    //test PreparedStatementBetterChecker
    private void batchInsert(final int repeatCnt) {
        String sql;
        for (int i = 0; i < repeatCnt; i++) {
            sql = "insert into testTable(Id, name, age) values (" + System.currentTimeMillis() + i + ", '" + TestSQLiteLintHelper.genRandomString(5) + "'"
                    + ", " + System.currentTimeMillis() % 90 + ")";
            TestDBHelper.get().getWritableDatabase().execSQL(sql);
        }

    }

    private void deleteAll() {
        String sql = "delete from testTable";
        TestDBHelper.get().getWritableDatabase().execSQL(sql);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.create_db) {

            toastStartTest("create_db");
            startDBCreateTest();
        }
        if (v.getId() == R.id.start) {

            toastStartTest("start");
            startTest();
        }
    }


    public void toastStartTest(String val) {
        Toast.makeText(this, "starting sqlite lint -> " + val + " test", Toast.LENGTH_SHORT).show();
    }


    private void doTest() {
        String[] list = TestSQLiteLintHelper.getTestSqlList();
        /**
         * if use {@link SQLiteLint.SqlExecutionCallbackMode#CUSTOM_NOTIFY}, need SQLiteLint.notifySqlExecution, for example:
         * long start;
         * int cost;
         * final String dbPath = TestDBHelper.get().getWritableDatabase().getPath();
         * for (String sql : list) {
         *     start = System.currentTimeMillis();
         *     Cursor cursor = TestDBHelper.get().getReadableDatabase().rawQuery(sql, null);
         *     cursor.moveToFirst();
         *     cursor.close();
         *     cost = (int) (System.currentTimeMillis() - start);
         *     SQLiteLint.notifySqlExecution(dbPath, sql, cost);
         * }
         * else if use {@link SQLiteLint.SqlExecutionCallbackMode#HOOK}, no need to care about {@link SQLiteLint#notifySqlExecution(String, String, int)}
         * like following below. 
         */
        for (String sql : list) {
            Cursor cursor = TestDBHelper.get().getReadableDatabase().rawQuery(sql, null);
            cursor.moveToFirst();
            cursor.close();
        }

        deleteAll();
        insert();
        batchInsert(40);
    }

    private void startTest() {

        Log.d(TAG, "start test, please wait");
        doTest();
    }

    private void startDBCreateTest() {
        only1 += 1;
        if (only1 > 1) {
            Toast.makeText(this, "install twice!! ignore.", Toast.LENGTH_LONG).show();
        }

        Toast.makeText(this, "start create db, please wait", Toast.LENGTH_LONG).show();
        Plugin plugin = MatrixHelper.getSqlLiteLintPlugin();
        if (plugin == null) {
            return;
        }

        if (!plugin.isPluginStarted()) {
            plugin.start();
        }

        MatrixHelper.addConcernedSqlLintDb(TestDBHelper.get().getWritableDatabase());
    }
}
