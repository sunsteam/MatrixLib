package tech.sunyx.matrixhelper.params;

public final class PluginInfo {

    public static final class SQL {
        public static final String TAG_PLUGIN = "SQLiteLint";
        public static final String ISSUE_KEY_ID = "id";
        public static final String ISSUE_KEY_DB_PATH = "dbPath";
        public static final String ISSUE_KEY_LEVEL = "level";
        public static final String ISSUE_KEY_TABLE = "table";
        public static final String ISSUE_KEY_SQL = "sql";
        public static final String ISSUE_KEY_DESC = "desc";
        public static final String ISSUE_KEY_DETAIL = "detail";
        public static final String ISSUE_KEY_ADVICE = "advice";
        public static final String ISSUE_KEY_CREATE_TIME = "createTime";
        public static final String ISSUE_KEY_STACK = "stack";
        public static final String ISSUE_KEY_SQL_TIME_COST = "sqlTimeCost";
        public static final String ISSUE_KEY_IS_IN_MAIN_THREAD = "isInMainThread";
    }

    public static final class Trace {

        public static final String TAG_PLUGIN = "Trace";
        public static final String TAG_PLUGIN_FPS = TAG_PLUGIN + "_FPS";
        public static final String TAG_PLUGIN_EVIL_METHOD = TAG_PLUGIN + "_EvilMethod";
        public static final String TAG_PLUGIN_STARTUP = TAG_PLUGIN + "_StartUp";

        //    public static final String ISSUE_DEVICE = "machine";
        public static final String ISSUE_SCENE = "scene";
        public static final String ISSUE_DROP_LEVEL = "dropLevel";
        public static final String ISSUE_DROP_SUM = "dropSum";
        public static final String ISSUE_FPS = "fps";
        public static final String ISSUE_STACK = "stack";
        public static final String ISSUE_STACK_KEY = "stackKey";
        public static final String ISSUE_MEMORY = "memory";
        public static final String ISSUE_MEMORY_NATIVE = "native_heap";
        public static final String ISSUE_MEMORY_DALVIK = "dalvik_heap";
        public static final String ISSUE_MEMORY_VM_SIZE = "vm_size";
        public static final String ISSUE_COST = "cost";
        public static final String ISSUE_CPU_USAGE = "usage";
        public static final String ISSUE_STACK_TYPE = "detail";
        public static final String ISSUE_IS_WARM_START_UP = "is_warm_start_up";
        public static final String ISSUE_SUB_TYPE = "subType";
        public static final String STAGE_APPLICATION_CREATE = "application_create";
        public static final String STAGE_APPLICATION_CREATE_SCENE = "application_create_scene";
        public static final String STAGE_FIRST_ACTIVITY_CREATE = "first_activity_create";
        public static final String STAGE_STARTUP_DURATION = "startup_duration";
    }

    public static final class IO {

        public static final String TAG_PLUGIN = "Trace";
        public static final String TAG_PLUGIN_FPS = TAG_PLUGIN + "_FPS";
        public static final String TAG_PLUGIN_EVIL_METHOD = TAG_PLUGIN + "_EvilMethod";
        public static final String TAG_PLUGIN_STARTUP = TAG_PLUGIN + "_StartUp";

        //    public static final String ISSUE_DEVICE = "machine";
        public static final String ISSUE_SCENE = "scene";
        public static final String ISSUE_DROP_LEVEL = "dropLevel";
        public static final String ISSUE_DROP_SUM = "dropSum";
        public static final String ISSUE_FPS = "fps";
        public static final String ISSUE_STACK = "stack";
        public static final String ISSUE_STACK_KEY = "stackKey";
        public static final String ISSUE_MEMORY = "memory";
        public static final String ISSUE_MEMORY_NATIVE = "native_heap";
        public static final String ISSUE_MEMORY_DALVIK = "dalvik_heap";
        public static final String ISSUE_MEMORY_VM_SIZE = "vm_size";
        public static final String ISSUE_COST = "cost";
        public static final String ISSUE_CPU_USAGE = "usage";
        public static final String ISSUE_STACK_TYPE = "detail";
        public static final String ISSUE_IS_WARM_START_UP = "is_warm_start_up";
        public static final String ISSUE_SUB_TYPE = "subType";
        public static final String STAGE_APPLICATION_CREATE = "application_create";
        public static final String STAGE_APPLICATION_CREATE_SCENE = "application_create_scene";
        public static final String STAGE_FIRST_ACTIVITY_CREATE = "first_activity_create";
        public static final String STAGE_STARTUP_DURATION = "startup_duration";
    }


    public static final class Resource {
        public static final String TAG_PLUGIN = "memory";

        public static final String ISSUE_RESULT_PATH = "resultZipPath";
        public static final String ISSUE_ACTIVITY_NAME = "activity";

    }


}
