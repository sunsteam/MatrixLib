package tech.sunyx.matrixhelper.params;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import tech.sunyx.matrixhelper.MatrixListener;

/**
 * @author by SunYuXing on 2019-07-14.
 */
@Builder
@ToString
@Getter
public class InitConfig {

    @Builder.Default
    private MatrixConfig matrixConfig = MatrixConfig.builder().build();
    private DynamicConfigInterface dynamicConfig;
    private MatrixListener listener;

}
