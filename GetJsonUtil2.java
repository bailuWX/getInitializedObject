
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 工具类!!!
 * 传入一个javaBean，为它所有的字段都赋好合适的值，并返回。
 * 注意：这里为了解耦，返回的任然是一个对象，而不是json，这样子方便调用者的处理。
 *
 * @author hwx1031036
 * @since 2021-03-12
 */
public class GetJsonUtil {

    /**
     * 生成一个map实例，map的key就是字段的类型，而value保存的则是随机生成的值用来填充一个对象
     *
     * @return paramValueMap
     */
    private HashMap<Object, Object> getParamValueMap() {
        HashMap<Object, Object> paramValueMap = new HashMap<>();
        int num = (int) (Math.random() * 100 + 1);
        byte[] bytes = {1, 2, 3};
        paramValueMap.put(String.class, "test" + num);

        paramValueMap.put(Integer.class, num);
        paramValueMap.put(int.class, num);

        paramValueMap.put(Long.class, (long) num);
        paramValueMap.put(long.class, num);

        paramValueMap.put(Double.class, (double) num);
        paramValueMap.put(double.class, num);

        paramValueMap.put(BigDecimal.class, new BigDecimal(10));

        paramValueMap.put(byte[].class, bytes);

        return paramValueMap;
    }

    public static void main(String[] args) throws Exception {
        // new GetJsonUtil().getInitializedObject(WxUserEntity.class);

    }

    /**
     * 该类的核心方法，用来返回一个处理完毕的对象
     *
     * @param clazz clazz
     * @param <T> T
     * @return 返回一个初始化完毕的对象
     * @throws Exception
     */
    public <T> T getInitializedObject(Class<T> clazz) throws Exception {

        T demo = clazz.newInstance(); //生成一个实例

        Field[] f = clazz.getDeclaredFields();//反射获取所有的属性

        for (int i = 0; i < f.length; i++) {//循环遍历，把demo对象的每一个字段都赋上合适的值

            if (!Modifier.isFinal(f[i].getModifiers()) && isBaseType(f[i].getType())) { //必须是基本数据类型且不为final
                f[i].setAccessible(true);
                String attributeName = f[i].getName();   //获取属性名
                // String type = f[i].getType().getName();//获取属性的类型
                Class<?> type1 = f[i].getType();//获取属性的类型

                //将属性名的首字母变为大写，为执行set/get方法做准备
                String methodName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
                try {
                    //获取Test类当前属性的setXXX方法（私有和公有方法）
                    Method setMethod = clazz.getMethod("set" + methodName, type1);

                    //随机生成这个属性对应类型的一个值
                    Object param = getParamValueMap().get(type1);

                    //执行该set方法,如：setName(num)
                    setMethod.invoke(demo, param); //填充java实例的某一个字段

                } catch (NullPointerException nu) {//异常的处理
                    // System.out.println(MessageFormat.format("本处{0}类型没有值", type));
                    System.out.println(String.format("本处%s类型没有值", type1.getName()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
        System.out.println("传参的jason为：" + JSONObject.toJSONString(demo)); //打印传了什么

        return demo;//返回塞得满满的实例，给单元测试来使用。
    }

    private static boolean isBaseType(Class className) {

        return className.equals(Integer.class) || className.equals(int.class) || className.equals(Byte.class)
            || className.equals(byte.class) || className.equals(Long.class) || className.equals(long.class) || className
            .equals(Double.class) || className.equals(double.class) || className.equals(Float.class)
            || className.equals(float.class) || className.equals(Character.class) || className.equals(char.class)
            || className.equals(Short.class) || className.equals(short.class) || className.equals(Boolean.class)
            || className.equals(boolean.class) || className.equals(String.class);
    }

}
