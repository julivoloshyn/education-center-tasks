package com.knubisoft.tasks.algorithm.reflection.constructorutils;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

public class ConstructorUtilsImpl implements ConstructorUtils {

    @Override
    public <T> T invokeConstructor(Class<T> cls, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (cls == null || args == null){
            throw new NoSuchElementException();
        }

        int count = 0;
        Class<?>[] parameters = new Class[args.length];
        for (Object object : args) {
            if (object.getClass() == String.class) {
                parameters[count] = String.class;
                count++;
            }
        }

        Constructor<T> constructor = cls.getConstructor(parameters);
        return constructor.newInstance(args);
    }

    @SneakyThrows
    @Override
    public <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... parameterTypes) {
        if (cls == null || parameterTypes == null){
            throw new NoSuchElementException();
        }

        return cls.getDeclaredConstructor(parameterTypes);
    }
}
