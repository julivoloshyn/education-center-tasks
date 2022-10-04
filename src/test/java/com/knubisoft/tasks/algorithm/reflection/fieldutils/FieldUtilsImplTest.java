package com.knubisoft.tasks.algorithm.reflection.fieldutils;

import com.knubisoft.tasks.algorithm.reflection.annotation.AnnotationForTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FieldUtilsImplTest {

    FieldUtilsImpl instance = new FieldUtilsImpl();

    @SneakyThrows
    @Test
    public void getFieldSuccess(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertEquals(cls.getField("id"), instance.getField(cls, "id"));
        assertEquals(cls.getField("type"), instance.getField(cls, "type"));
    }

    @SneakyThrows
    @Test
    public void getFieldFail(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertThrows(NullPointerException.class,
                () -> instance.getField(null, "name"));
        assertThrows(NullPointerException.class,
                () -> instance.getField(cls, null));
        assertThrows(NullPointerException.class,
                () -> instance.getField(null, null));

        assertThrows(NoSuchElementException.class,
                () -> instance.getField(cls, ""));
        assertThrows(NoSuchElementException.class,
                () -> instance.getField(cls, "     "));
    }

    @SneakyThrows
    @Test
    public void getFieldUsingAccessSuccess(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertEquals(cls.getField("id"), instance.getField(cls, "id", true));
        assertEquals(cls.getField("type"), instance.getField(cls, "type", true));
    }

    @SneakyThrows
    @Test
    public void getFieldUsingAccessFail(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertThrows(NullPointerException.class,
                () -> instance.getField(null, "name", false));
        assertThrows(NullPointerException.class,
                () -> instance.getField(cls, null));
        assertThrows(NullPointerException.class,
                () -> instance.getField(null, null, true));

        assertThrows(NoSuchElementException.class,
                () -> instance.getField(cls, ""));
        assertThrows(NoSuchElementException.class,
                () -> instance.getField(cls, "     ", true));
        assertThrows(NoSuchElementException.class,
                () -> instance.getField(cls, "id", false));
    }

    @SneakyThrows
    @Test
    public void getDeclaredFieldSuccess(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertEquals(cls.getDeclaredField("id"), instance.getDeclaredField(cls, "id"));
        assertEquals(cls.getDeclaredField("type"), instance.getDeclaredField(cls, "type"));
    }

    @SneakyThrows
    @Test
    public void getDeclaredFieldFail(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");

        assertThrows(NullPointerException.class,
                () -> instance.getDeclaredField(null, "name"));
        assertThrows(NullPointerException.class,
                () -> instance.getDeclaredField(cls, null));
        assertThrows(NullPointerException.class,
                () -> instance.getDeclaredField(null, null));

        assertThrows(NoSuchElementException.class,
                () -> instance.getDeclaredField(cls, ""));
        assertThrows(NoSuchElementException.class,
                () -> instance.getDeclaredField(cls, "     "));
    }

    @SneakyThrows
    @Test
    public void getAllFieldsSuccess(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");
        Field[] fields = cls.getDeclaredFields();

        assertEquals(fields[0], instance.getAllFields(cls)[0]);
        assertEquals(fields[1], instance.getAllFields(cls)[1]);
    }

    @SneakyThrows
    @Test
    public void getAllFieldsFail(){
        assertThrows(NoSuchElementException.class,
                () -> instance.getAllFields(null));
    }

    @SneakyThrows
    @Test
    public void getFieldsWithAnnotationSuccess(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");
        Class<? extends Annotation> annotation = AnnotationForTest.class;
        Field[] fields = instance.getFieldsWithAnnotation(cls, annotation);

        assertEquals(fields[0], instance.getFieldsWithAnnotation(cls, annotation)[0]);
    }

    @SneakyThrows
    @Test
    public void getFieldsWithAnnotationFail(){
        Class<?> cls = Class.forName("com.knubisoft.tasks.algorithm.ModelRoot$Batter");
        Class<? extends Annotation> annotation = AnnotationForTest.class;

        assertThrows(NullPointerException.class,
                () -> instance.getFieldsWithAnnotation(null, annotation));
        assertThrows(NullPointerException.class,
                () -> instance.getFieldsWithAnnotation(cls, null));
        assertThrows(NullPointerException.class,
                () -> instance.getFieldsWithAnnotation(null, null));
    }

}