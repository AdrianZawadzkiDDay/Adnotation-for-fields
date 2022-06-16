package main.model.list;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ListContains {
    ListDataConstants value();
    boolean isAllowEmpty() default false;
}
