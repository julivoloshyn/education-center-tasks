package com.knubisoft.tasks.algorithm.reflection.constructorutils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public interface ConstructorUtils {

    <T> T invokeConstructor(Class<T> cls, Object... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... parameterTypes);
}
