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

package tech.sunyx.matrixhelper;


import org.json.JSONObject;


/**
 * 委托Issue中除了Plugin以外的属性
 *
 * @author by SunYuXing on 2019-07-16.
 */

public class Issue {

    public static final String ISSUE_REPORT_TYPE = "type";
    public static final String ISSUE_REPORT_TAG = "tag";
    public static final String ISSUE_REPORT_PROCESS = "process";
    public static final String ISSUE_REPORT_TIME = "time";

    private com.tencent.matrix.report.Issue rawIssue;

    Issue(com.tencent.matrix.report.Issue rawIssue) {
        this.rawIssue = rawIssue;
    }

    public JSONObject getContent() {
        return rawIssue.getContent();
    }

    public Integer getType() {
        return rawIssue.getType();
    }

    public String getKey() {
        return rawIssue.getKey();
    }

    public String getTag() {
        return rawIssue.getTag();
    }

    public Plugin getPlugin() {
        return MatrixHelper.pluginMap.get(rawIssue.getPlugin().getTag());
    }

    @Override
    public String toString() {
        return rawIssue.toString();
    }
}
