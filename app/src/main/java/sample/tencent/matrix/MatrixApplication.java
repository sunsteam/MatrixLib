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

package sample.tencent.matrix;

import android.app.Application;
import android.content.Context;

import tech.sunyx.matrixhelper.MatrixAllConfig;
import tech.sunyx.matrixhelper.MatrixHelper;

/**
 * Created by caichongyang on 17/5/18.
 */

public class MatrixApplication extends Application {
    private static final String TAG = "Matrix.Application";

    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MatrixAllConfig allConfig = MatrixAllConfig.builder()
                .matrixEnable(true)
                .traceEnable(true)
                .fpsEnable(true)
                .anrTraceEnable(true)
                .ioEnable(true)
                .resourceEnable(true)
                .sqlEnable(true)
                .build();

        new MatrixHelper().init(this, allConfig);
    }
}
