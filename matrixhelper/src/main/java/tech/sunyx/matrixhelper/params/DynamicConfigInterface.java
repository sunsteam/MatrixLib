package tech.sunyx.matrixhelper.params;

public interface DynamicConfigInterface {

    String get(String key, String defStr);

    int get(String key, int defInt);

    long get(String key, long defLong);

    boolean get(String key, boolean defBool);

    float get(String key, float defFloat);
}
