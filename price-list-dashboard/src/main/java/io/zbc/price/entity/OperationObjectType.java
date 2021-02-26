package io.zbc.price.entity;

/**
 * @author fw13
 * @date 2019/11/20 11:14
 * 操作对象。例如 机器、规则、节点
 */
public enum OperationObjectType {

    GOODS_INFO("goods info"),

    USER("user");

    private String objType;

    OperationObjectType(String objType) {
        this.objType = objType;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }
}
