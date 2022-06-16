package main.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.model.Consts.*;

public class ObjectVO {
    private String name;
    private String dealType;
    @DealType({DEAL_TYPE_ALL})
    private String dealName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }


    @Override
    public String toString() {
        return "ObjectVO{" +
                "name='" + name + '\'' +
                ", dealType='" + dealType + '\'' +
                ", dealName='" + dealName + '\'' +
                '}';
    }

    public void cleanUp() throws IllegalAccessException {
        Class<? extends  ObjectVO> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            field.setAccessible(true);
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            if(declaredAnnotations.length <= 0 ||
                    field.getDeclaredAnnotation(DealType.class) == null) {
                continue;
            }

            String[] value = field.getDeclaredAnnotation(DealType.class).value();
            if(!Arrays.asList(value).contains(dealType)) {
                setFieldValueToEmpty(field, this);
            }

        }
    }

    public static void setFieldValueToEmpty(Field field, Object object) throws IllegalAccessException {
        if(field == null)return;

        switch (field.getType().getName()) {
            case "double":
                field.set(object, 0d);
                break;
            case "int":
                field.set(object, 0);
                break;
            case "boolean":
                field.set(object, false);
                break;
            case "long":
                field.set(object, 0L);
                break;
            default:
                field.set(object, null);
                break;
        }
    }
}
