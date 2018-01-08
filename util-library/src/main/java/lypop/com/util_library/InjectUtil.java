package lypop.com.util_library;

import android.content.Context;

import com.annotation.ContentView;
import com.annotation.InjectView;

import java.lang.reflect.Method;

public class InjectUtil {
    public static void inject(Context context) {
        injectLayout(context);
        injectComponent(context);
    }

    private static void injectComponent(Context context) {
        Class<?> componentClazz = context.getClass();
        InjectView injectView = componentClazz.getAnnotation(InjectView.class);
        int id = injectView.value();
        try {
            Method componentMethod = componentClazz.getMethod("findViewById", int.class);
            componentMethod.invoke(context, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void injectLayout(Context context) {
        Class<?> layoutClazz = context.getClass();
        ContentView contentView = layoutClazz.getAnnotation(ContentView.class);
        int resLayoutId = contentView.value();
        try {
            Method layoutMethod = layoutClazz.getMethod("setContentView", int.class);
            layoutMethod.invoke(context, resLayoutId);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("该类不存在setContentView方法");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
