package io.immersive.event.listeners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Listener {

    boolean ignoreCancelled() default false;

    ListenerPriority priorty() default ListenerPriority.NORMAL;

}
