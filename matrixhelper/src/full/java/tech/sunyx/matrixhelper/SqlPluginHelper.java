package tech.sunyx.matrixhelper;

import android.database.sqlite.SQLiteDatabase;

import com.tencent.sqlitelint.config.SQLiteLintConfig;

import tech.sunyx.matrixhelper.params.MatrixConfig;

class SqlPluginHelper {

    static SQLiteLintConfig.ConcernDb createConcernedDb(SQLiteDatabase db) {
        MatrixConfig matrixConfig = MatrixHelper.allConfig.getMatrixConfig();

        SQLiteLintConfig.ConcernDb concernDb = new SQLiteLintConfig.ConcernDb(db);

        if (matrixConfig.isEnableAvoidAutoIncrementChecker()) {
            concernDb.enableAvoidAutoIncrementChecker();
        }
        if (matrixConfig.isEnableAvoidSelectAllChecker()) {
            concernDb.enableAvoidSelectAllChecker();
        }
        if (matrixConfig.isEnableExplainQueryPlanChecker()) {
            concernDb.enableExplainQueryPlanChecker();
        }
        if (matrixConfig.isEnablePreparedStatementBetterChecker()) {
            concernDb.enablePreparedStatementBetterChecker();
        }
        if (matrixConfig.isEnableRedundantIndexChecker()) {
            concernDb.enableRedundantIndexChecker();
        }
        if (matrixConfig.isEnableWithoutRowIdBetterChecker()) {
            concernDb.enableWithoutRowIdBetterChecker();
        }

        //disable white list by default
        //concernDb.setWhiteListXml(R.xml.sqlite_lint_whitelist)

        return concernDb;
    }
}
