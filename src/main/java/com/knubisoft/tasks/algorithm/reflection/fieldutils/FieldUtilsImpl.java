package com.knubisoft.tasks.algorithm.reflection.fieldutils;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FieldUtilsImpl implements FieldUtils{

    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName) {
        if(cls == null || fieldName == null){
            throw new NullPointerException();
        }

        if(fieldName.isBlank()){
            throw new NoSuchElementException();
        }

        return cls.getField(fieldName);
    }

    @SneakyThrows
    @Override
    public Field getField(Class<?> cls, String fieldName, boolean forceAccess) {
        if(cls == null || fieldName == null){
            throw new NullPointerException();
        }

        if(fieldName.isBlank() || !forceAccess){
            throw new NoSuchElementException();
        }

        Field field = cls.getDeclaredField(fieldName);
        field.setAccessible(forceAccess);

        return field;
    }

    @SneakyThrows
    @Override
    public Field getDeclaredField(Class<?> cls, String fieldName) {if(cls == null || fieldName == null){
        throw new NullPointerException();
    }

        if(fieldName.isBlank()){
            throw new NoSuchElementException();
        }

        return cls.getDeclaredField(fieldName);
    }

    @Override
    public Field[] getAllFields(Class<?> cls) {
        if(cls == null){
            throw new NoSuchElementException();
        }

        return cls.getFields();
    }

    @Override
    public Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls) {
        if (cls == null || annotationCls == null) {
            throw new NullPointerException();
        }

        List<Field> fields = new ArrayList<>();
        for (Field field : cls.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotationCls)) {
                fields.add(field);
            }
        }

        return fields.toArray(new Field[0]);
    }
}
