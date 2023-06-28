package day0628.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int value() default 0;
    int minLen() default 8;
    int maxLen() default 20;
    int numMin() default 48;
    int numMax() default 57;

    int charMin() default 65;
    int charMax() default 122;



}
