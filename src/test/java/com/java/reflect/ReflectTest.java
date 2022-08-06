package com.java.reflect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

/**
 * @Package com.java.reflect
 * @ClassName ReflectTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/16
 */
public class ReflectTest {
    private final Logger log = LogManager.getLogger(ReflectTest.class);

    @Test
    public void testReflect() {

        try {
            Class c = Class.forName("com.thread.threadlocal.ThreadLocalTest");
            Constructor[] constructor = c.getConstructors();

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("\n");
            stringBuilder.append(Modifier.toString(c.getModifiers()));
            stringBuilder.append("\tclass\t");
            stringBuilder.append(c.getSimpleName());
            stringBuilder.append("{\n");


            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                stringBuilder.append("\t");
                stringBuilder.append(Modifier.toString(field.getModifiers()));
                stringBuilder.append("\t");
                stringBuilder.append(field.getType().getSimpleName());
                stringBuilder.append("\t");
                stringBuilder.append(field.getName());
                stringBuilder.append(";\n");
            }

            for (Constructor constructor1 : constructor) {
                stringBuilder.append("\t");
                stringBuilder.append(Modifier.toString(constructor1.getModifiers()));
                stringBuilder.append("\t");
                stringBuilder.append(c.getSimpleName());
                stringBuilder.append("(");
                Parameter[] parameters = constructor1.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getType().getTypeName());
                    stringBuilder.append(parameters[i].getName());
                    if (i != parameters.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("){}\n");
            }

            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                stringBuilder.append("\t");
                stringBuilder.append(Modifier.toString(method.getModifiers()));
                stringBuilder.append("\t");
                stringBuilder.append(method.getReturnType().getSimpleName());
                stringBuilder.append("\t");
                stringBuilder.append(method.getName());
                stringBuilder.append("(");
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    stringBuilder.append(parameters[i].getType().getSimpleName());
                    stringBuilder.append(parameters[i].getName());
                    if (i != parameters.length - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append("){ }\n");
            }

            stringBuilder.append("}");
            log.info(stringBuilder.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
