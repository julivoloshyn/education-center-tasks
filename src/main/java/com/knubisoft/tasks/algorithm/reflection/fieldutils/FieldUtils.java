//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.knubisoft.tasks.algorithm.reflection.fieldutils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface FieldUtils {

    Field getField(Class<?> cls, String fieldName);

    Field getField(Class<?> cls, String fieldName, boolean forceAccess);

    Field getDeclaredField(Class<?> cls, String fieldName);

    Field[] getAllFields(Class<?> cls);

    Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> annotationCls);

}
