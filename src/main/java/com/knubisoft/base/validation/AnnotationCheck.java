package com.knubisoft.base.validation;

import com.knubisoft.base.validation.annotation.MaxLength;
import com.knubisoft.base.validation.annotation.NotNull;
import com.knubisoft.base.validation.annotation.PrimaryKey;
import com.knubisoft.base.validation.annotation.ReferClass;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationCheck {

    @SneakyThrows
    public boolean trackMaxLength(Object user) {
        List<Field> fields = getNameOfField(user, MaxLength.class);
        List<Method> methods = getNameOfMethod(user, fields);
        for (int i = 0; i < fields.size(); i++) {
            Object invoke = methods.get(i).invoke(user);
            MaxLength length = fields.get(i).getAnnotation(MaxLength.class);
            if (((String) invoke).length() > length.maxLength()) {
                System.out.println("You can't use for " + fields.get(i).getName() + " more than " + length.maxLength() + " symbols");
                return false;
            }
        }
        System.out.println("is Ok");
        return true;
    }


    @SneakyThrows
    public boolean trackNotNull(Object user) {
        List<Field> fields = getNameOfField(user, NotNull.class);
        List<Method> methods = getNameOfMethod(user, fields);
        for (int i = 0; i < fields.size(); i++) {
            Object invoke = methods.get(i).invoke(user);
            if (invoke == null || invoke == "") {
                System.out.println(fields.get(i).getName() + " can't be null");
                return false;
            }
        }
        return true;
    }

    public boolean trackEntity(Class<?> cls) {
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation a : annotations) {
            if (a.toString().contains("Entity"))
                return true;
        }
        System.out.println("Your class doesn't have annotation @Entity. You can't create " + cls.getSimpleName());
        return false;
    }

    @SneakyThrows
    public boolean trackPrimaryKey(Object user) {
        List<Field> fields = getNameOfField(user, PrimaryKey.class);
        List<Method> methods = getNameOfMethod(user, fields);
        List<Object> o = new ArrayList<>();
        for (int i = 0; i < fields.size(); i++) {
            Object invoke = methods.get(i).invoke(user);
            if (o.contains(invoke)) {
                return false;
            }
            o.add(invoke);
        }
        return true;
    }

    @SneakyThrows
    public boolean trackReferClass(Object user) {
        ValidationTasks object = new ValidationTasksImpl();
        ValidationTasks.UserGeneralDetails userGeneralDetails = object.buildUserGeneralDetails();
        ValidationTasks.UserAddressDetails userAddressDetails = object.buildUserAddressDetails();
        List<Field> fields = getNameOfField(user, ReferClass.class);
        if (fields.isEmpty())
            return true;
        List<Method> method = getNameOfMethod(user, fields);
        Object invoke = method.get(0).invoke(user);
        Long id = null;
        for (Field f : fields) {
            ReferClass annotation = f.getAnnotation(ReferClass.class);
            Class<?> cls = annotation.referClass();
            Object o = cls.getConstructor(null).newInstance();
            if (o instanceof ValidationTasks.UserGeneralDetails) {
                id = userGeneralDetails.getId();
            }
            if (o instanceof ValidationTasks.UserAddressDetails) {
                id = userAddressDetails.getId();
            }
        }
        return invoke.equals(id);
    }

    private List<Field> getNameOfField(Object user, Class<? extends Annotation> cls) {
        Field[] fields = user.getClass().getDeclaredFields();
        List<Field> annotationField = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(cls))
                annotationField.add(f);
        }
        return annotationField;
    }

    @SneakyThrows
    private List<Method> getNameOfMethod(Object user, List<Field> fields) {
        List<Method> methods = new ArrayList<>();
        for (Field f : fields) {
            String s = f.getName();
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
            Method method = user.getClass().getMethod("get" + s);
            methods.add(method);
        }
        return methods;
    }
}
