package io.github.springroe.intellij.salesforce.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewRightModel {

    private NewEntityModel newEntityModel;

    /**
     * 所选择的类的类型
     */
    private String classType;

    /**
     * 创建java类所在的包
     */
    private String dataText;

}
