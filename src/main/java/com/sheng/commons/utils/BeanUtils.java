//package com.sheng.commons.utils;
//
//import com.google.common.collect.Maps;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.cglib.beans.BeanCopier;
//import org.springframework.cglib.beans.BeanGenerator;
//import org.springframework.cglib.beans.BeanMap;
//
//import java.beans.BeanInfo;
//import java.beans.Introspector;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author zhengzs
// * @since 2017-07-22
// */
//@Slf4j
//public class BeanUtils extends org.springframework.beans.BeanUtils{
//    public static final String CLASS_NAME = "class";
//    public static final String PROPERTY_NAME_SEPARATOR = "_";
//
//    /**
//     * 复制对象属性，并且不做任何数据类型转换
//     *
//     * @param destination
//     * @param origin
//     * @throws RuntimeException
//     */
//    public static void copyProperties(Object origin, Object destination) {
//        try {
//            PropertyUtils.copyProperties(destination, origin);
//        } catch (Exception e) {
//            log.error("CopyProperties error, destination: {}, origin: {}", destination, origin);
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 仅从source复制destination中含有的属性
//     * 如果source中不含有destination的某个属性，则抛出异常
//     */
//    public static void copyPropertiesForDestination(Object source, Object destination) {
//        try {
//            BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
//            PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();
//            HashMap<String, PropertyDescriptor> sourcePropertyMap = Maps.newHashMap();
//            for (PropertyDescriptor d : sourceProperty) {
//                sourcePropertyMap.put(d.getName(), d);
//            }
//
//            BeanInfo destBean = Introspector.getBeanInfo(destination.getClass(), Object.class);
//            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
//            for (PropertyDescriptor d : destProperty) {
//                d.getWriteMethod().invoke(destination, sourcePropertyMap.get(d.getName()).getReadMethod().invoke(source));
//            }
//        } catch (Exception e) {
//            log.error("Copy properties error, source: {}, destination: {}", source, destination, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 复制对象属性，并根据驼峰命名转换自动转换
//     * for example:
//     * source = BeanUtils.Source(firstName=明, last_name=李, age=18)
//     * destination = BeanUtils.Destination(first_name=明, lastName=李)
//     *
//     * @param source
//     * @param destination
//     * @param convertCamelCase 是否使用驼峰命名转换
//     */
//    public static void copyPropertiesForDestination(Object source, Object destination, boolean convertCamelCase) {
//        try {
//            BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
//            PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();
//            HashMap<String, PropertyDescriptor> sourcePropertyMap = Maps.newHashMap();
//            for (PropertyDescriptor d : sourceProperty) {
//                sourcePropertyMap.put(d.getName(), d);
//            }
//
//            BeanInfo destBean = Introspector.getBeanInfo(destination.getClass(), Object.class);
//            PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();
//            PropertyDescriptor sourceDescriptor;
//            for (PropertyDescriptor d : destProperty) {
//                sourceDescriptor = sourcePropertyMap.get(d.getName());
//
//                if (sourceDescriptor == null && convertCamelCase) {
//                    sourceDescriptor = sourcePropertyMap.get(convertToCamelCase(d.getName()));
//                }
//
//                if (sourceDescriptor == null && convertCamelCase) {
//                    sourceDescriptor = sourcePropertyMap.get(convertToNoCamelCase(d.getName()));
//                }
//
//                Object sourceValue = sourceDescriptor.getReadMethod().invoke(source);
//                if (sourceDescriptor != null && sourceValue != null) {
//                    d.getWriteMethod().invoke(destination, sourceValue);
//                }
//            }
//        } catch (Exception e) {
//            log.error("Copy properties error, source: {}, destination: {}", source, destination, e);
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static boolean isNotEmpty(Object target) {
//        PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(target);
//        for (PropertyDescriptor d : descriptors) {
//            Class type = d.getPropertyType();
//            Method m = d.getReadMethod();
//            d.getValue(d.getName());
//            System.out.println(m.getName() + ", " + m.getReturnType());
//        }
//
//        return false;
//    }
//
//
//    /**
//     * 将对象转换成Map，用与HTTP参数
//     *
//     * @param target
//     * @return
//     */
//    public static HashMap<String, String> describeToMap(Object target) {
//        HashMap<String, String> map;
//        try {
//            map = (HashMap<String, String>) org.apache.commons.beanutils.BeanUtils.describe(target);
//            map.remove(CLASS_NAME);
//        } catch (Exception e) {
//            log.error("describeMap error, target: {}", target, e);
//            throw new RuntimeException(e);
//        }
//
//        return map;
//    }
//
//    /**
//     * 利用反射实现对象之间属性复制
//     *
//     * @param from
//     * @param to
//     */
//    public static void copyProperties2(Object from, Object to) throws Exception {
//        copyPropertiesExclude(from, to, null);
//    }
//
//    /**
//     * 复制对象属性
//     *
//     * @param from
//     * @param to
//     * @param excludingProperties 排除属性列表
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public static void copyPropertiesExclude(Object from, Object to, String[] excludingProperties) throws Exception {
//        List<String> excludesList = null;
//        if (excludingProperties != null && excludingProperties.length > 0) {
//            excludesList = Arrays.asList(excludingProperties); //构造列表对象
//        }
//
//        Method[] fromMethods = from.getClass().getDeclaredMethods();
//        Method[] toMethods = to.getClass().getDeclaredMethods();
//        Method fromMethod = null, toMethod = null;
//        String fromMethodName = null, toMethodName = null;
//        for (int i = 0; i < fromMethods.length; i++) {
//            fromMethod = fromMethods[i];
//            fromMethodName = fromMethod.getName();
//            if (!fromMethodName.contains("get"))
//                continue;
//            //排除列表检测
//            if (excludesList != null && excludesList.contains(fromMethodName.substring(3).toLowerCase())) {
//                continue;
//            }
//            toMethodName = "set" + fromMethodName.substring(3);
//            toMethod = findMethodByName(toMethods, toMethodName);
//            if (toMethod == null)
//                continue;
//            Object value = fromMethod.invoke(from, new Object[0]);
//            if (value == null)
//                continue;
//            //集合类判空处理
//            if (value instanceof Collection) {
//                Collection newValue = (Collection) value;
//                if (newValue.size() <= 0)
//                    continue;
//            }
//            toMethod.invoke(to, new Object[]{value});
//        }
//    }
//
//    /**
//     * 对象属性值复制，仅复制指定名称的属性值
//     *
//     * @param from
//     * @param to
//     * @param includesArray
//     * @throws Exception
//     */
//    @SuppressWarnings("unchecked")
//    public static void copyPropertiesInclude(Object from, Object to, String[] includesArray) throws Exception {
//        List<String> includesList = null;
//        if (includesArray != null && includesArray.length > 0) {
//            includesList = Arrays.asList(includesArray); //构造列表对象
//        } else {
//            return;
//        }
//        Method[] fromMethods = from.getClass().getDeclaredMethods();
//        Method[] toMethods = to.getClass().getDeclaredMethods();
//        Method fromMethod = null, toMethod = null;
//        String fromMethodName = null, toMethodName = null;
//        for (int i = 0; i < fromMethods.length; i++) {
//            fromMethod = fromMethods[i];
//            fromMethodName = fromMethod.getName();
//            if (!fromMethodName.contains("get"))
//                continue;
//            //排除列表检测
//            String str = fromMethodName.substring(3);
//            if (!includesList.contains(str.substring(0, 1).toLowerCase() + str.substring(1))) {
//                continue;
//            }
//            toMethodName = "set" + fromMethodName.substring(3);
//            toMethod = findMethodByName(toMethods, toMethodName);
//            if (toMethod == null)
//                continue;
//            Object value = fromMethod.invoke(from, new Object[0]);
//            if (value == null)
//                continue;
//            //集合类判空处理
//            if (value instanceof Collection) {
//                Collection newValue = (Collection) value;
//                if (newValue.size() <= 0)
//                    continue;
//            }
//            toMethod.invoke(to, new Object[]{value});
//        }
//    }
//
//    /**
//     * 从方法数组中获取指定名称的方法
//     *
//     * @param methods
//     * @param name
//     * @return
//     */
//    public static Method findMethodByName(Method[] methods, String name) {
//        for (int j = 0; j < methods.length; j++) {
//            if (methods[j].getName().equals(name))
//                return methods[j];
//        }
//        return null;
//    }
//
//    /**
//     * 转换为驼峰式命名
//     * for example: max_value_object > maxValueObject
//     *
//     * @param originalName
//     * @return
//     */
//    public static String convertToCamelCase(String originalName) {
//        String[] strings = originalName.split(PROPERTY_NAME_SEPARATOR);
//        String result = StringUtils.EMPTY;
//        for (String s : strings) {
//            result += StringUtils.capitalize(s);
//        }
//        return StringUtils.uncapitalize(result);
//    }
//
//    public static String convertToNoCamelCase(String originalName) {
//        char[] chars = originalName.toCharArray();
//        String result = StringUtils.EMPTY;
//        for (char c : chars) {
//            if (Character.isUpperCase(c)) {
//                result += PROPERTY_NAME_SEPARATOR;
//            }
//
//            result += c;
//        }
//
//        return result.toLowerCase();
//    }
//
//    /**
//     * copy 对象属性到另一个对象，默认不使用Convert
//     * @param src
//     * @param clazz 类名
//     * @return T
//     */
//    public static <T> T copy(Object src, Class<T> clazz) {
//        BeanCopier copier = BeanCopier.create(src.getClass(), clazz, false);
//
//        T to = newInstance(clazz);
//        copier.copy(src, to, null);
//        return to;
//    }
//
//    /**
//     * 实例化对象
//     * @param clazz 类
//     * @return 对象
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T newInstance(Class<?> clazz) {
//        return (T) instantiate(clazz);
//    }
//
//    /**
//     * 将对象装成map形式
//     * @param src
//     * @return
//     */
//    @SuppressWarnings("rawtypes")
//    public static Map toMap(Object src) {
//        return BeanMap.create(src);
//    }
//
//    /**
//     * 给一个Bean添加字段
//     * @param superBean 父级Bean
//     * @param props 新增属性
//     * @return  {Object}
//     */
//    public static Object generator(Object superBean, BeanProperty... props) {
//        Class<?> superclass = superBean.getClass();
//        Object genBean = generator(superclass, props);
//        BeanUtils.copy(superBean, genBean);
//        return genBean;
//    }
//
//    /**
//     * 给一个class添加字段
//     * @param superclass 父级
//     * @param props 新增属性
//     * @return {Object}
//     */
//    public static Object generator(Class<?> superclass, BeanProperty... props) {
//        BeanGenerator generator = new BeanGenerator();
//        generator.setSuperclass(superclass);
//        generator.setUseCache(true);
//        for (BeanProperty prop : props) {
//            generator.addProperty(prop.getName(), prop.getType());
//        }
//        return generator.create();
//    }
//
//    /**
//     * 拷贝对象
//     * @param src 源对象
//     * @param dist 需要赋值的对象
//     */
//    public static void copy(Object src, Object dist) {
//        BeanCopier copier = BeanCopier
//                .create(src.getClass(), dist.getClass(), false);
//
//        copier.copy(src, dist, null);
//    }
//
//    /**
//     * 设置Bean属性
//     * @param bean bean
//     * @param propertyName 属性名
//     * @param value 属性值
//     */
//    public static void setProperty(Object bean, String propertyName, Object value) {
//        PropertyDescriptor pd = getPropertyDescriptor(bean.getClass(), propertyName);
//        if (pd == null) {
//            throw new RuntimeException("Could not set property '" + propertyName + "' to bean PropertyDescriptor is null");
//        }
//        Method writeMethod = pd.getWriteMethod();
//        if (writeMethod == null) {
//            throw new RuntimeException("Could not set property '" + propertyName + "' to bean writeMethod is null");
//        }
//        if (!writeMethod.isAccessible()) {
//            writeMethod.setAccessible(true);
//        }
//        try {
//            writeMethod.invoke(bean, value);
//        } catch (Throwable ex) {
//            throw new RuntimeException("Could not set property '" + propertyName + "' to bean", ex);
//        }
//    }
//
//    public static void main(String[] args) {
//        Source s = new Source();
//        s.setFirstName("明");
////        s.setAge(18);
//        s.setLast_name("李");
//
//        Destination d = new Destination();
//        copyPropertiesForDestination(s, d, true);
//        System.out.println("s = " + s);
//        System.out.println("d = " + d);
//    }
//
//    @Data
//    static class Source {
//        private String firstName;
//        private String last_name;
//        private Integer age;
//
//    }
//
//    @Data
//    static class Destination {
//        private String first_name;
//        private String lastName;
//        private Integer age;
//    }
//}
