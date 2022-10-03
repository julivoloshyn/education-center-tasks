package com.knubisoft.base.reflection;

import com.knubisoft.base.reflection.model.EntryModel;
import com.knubisoft.base.reflection.model.InheritedEntryModel;
import com.knubisoft.base.string.StringTasksImpl;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ReflectionTasksImpl implements ReflectionTasks {

    private Object instance;

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        if(cls == null){
            throw new NoSuchElementException();
        }

        if(!cls.equals(InheritedEntryModel.class)){
            throw new RuntimeException();
        }

        return new InheritedEntryModel(cls.getName());
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        if(cls == null){
            throw new NoSuchElementException();
        }

        if(!cls.equals(EntryModel.class)){
            throw new IllegalArgumentException();
        }

        EntryModel entryModel = new InheritedEntryModel(cls.getName());
        return (Class<? extends T>) entryModel.getClass();
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        if(cls == null){
            throw new NoSuchElementException();
        }

        Map<String, Object> map = new HashMap<>();

        if(!cls.equals(InheritedEntryModel.class)){
            return map;
        } else {
            Field[] fields = cls.getSuperclass().getDeclaredFields();

            for(Field field : fields){
                field.setAccessible(true);
                map.put(field.getName(), field);
            }
        }

        return map;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if(cls == null){
            throw new NoSuchElementException();
        }

        int count = 0;
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.getModifiers() == Modifier.PRIVATE){
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        if(method == null || annotationUnderMethod == null){
            throw new NoSuchElementException();
        }

        Annotation[] annotations = method.getAnnotations();
        boolean hasAnnotation = false;

        if(annotations.length > 0){
            hasAnnotation = true;
        }

        return hasAnnotation;
    }

    @SneakyThrows
    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        if(cls == null || name == null){
            throw new NoSuchElementException();
        }

        StringTasksImpl stringTasks = new StringTasksImpl();
        Method method = cls.getDeclaredMethod(name);
        return method.invoke(stringTasks);
    }

    @SneakyThrows
    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if(obj == null || name == null || args == null){
            throw new IllegalArgumentException();
        }

        Method method;
        if(args.length > 1){
            method = obj.getClass().getMethod(
                    name,
                    args.getClass().getTypeName().getClass(),
                    args.getClass().getTypeName().getClass()
            );
        } else {
            method = obj.getClass().getMethod(
                    name,
                    args.getClass().getTypeName().getClass()
            );
        }

        StringTasksImpl stringTasks = new StringTasksImpl();
        return method.invoke(stringTasks, args);
    }

    @SneakyThrows
    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        if(instance == null || name == null || newValue == null){
            throw new NoSuchElementException();
        }

        StringTasksImpl stringTasks = new StringTasksImpl();

        Field field = instance.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(name, newValue);

        return field.get(stringTasks);
    }
}
