package io.immersive.event;

import io.immersive.event.extra.CancellableEvent;
import io.immersive.event.listeners.Listener;
import io.immersive.event.listeners.ListenerPriority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class EventManager {
    @Getter private final Map<Class<? extends Event>, List<ListenerMethod>> events;

    public EventManager() {
        this.events = new HashMap<>();
    }

    public Event call(@NonNull final Event event) {
        final List<ListenerMethod> methods = this.getEvents().get(event.getClass());

        if(methods != null) {
            for(ListenerMethod data : methods) {
                if(event instanceof CancellableEvent)
                    if(((CancellableEvent) event).isCancelled() && data.getListener().ignoreCancelled())
                        continue;

                try {
                    data.getTarget().invoke(data.getSource(), event);
                } catch(Exception ignored) {
                }
            }
        }

        return event;
    }

    public void register(@NonNull final Object object) {
        for(Method method : object.getClass().getDeclaredMethods()) {
            if(!this.isMethodAllowed(method))
                continue;

            register(method, object);
        }
    }

    private void register(@NonNull final Method method, @NonNull final Object object) {
        final Class<? extends Event> indexClass = (Class<? extends Event>) method.getParameterTypes()[0];
        final ListenerMethod data = new ListenerMethod(object, method, method.getAnnotation(Listener.class));

        if(!data.getTarget().isAccessible())
            data.getTarget().setAccessible(true);

        if(this.getEvents().containsKey(indexClass)) {
            if(!this.getEvents().get(indexClass).contains(data)) {
                this.getEvents().get(indexClass).add(data);
                sortEvents(indexClass);
            }
        } else
            this.getEvents().put(indexClass, new CopyOnWriteArrayList<ListenerMethod>() {{
                add(data);
            }});
    }

    private void sortEvents(@NonNull final Class<? extends Event> clazz) {
        final List<ListenerMethod> sorted = new CopyOnWriteArrayList<>();

        for(final ListenerPriority priority : ListenerPriority.values())
            sorted.addAll(this.getEvents().get(clazz).stream().filter(data -> data.getListener().priorty() == priority).collect(Collectors.toList()));

        this.getEvents().put(clazz, sorted);
    }

    private boolean isMethodAllowed(@NonNull final Method method) {
        return method.getParameterTypes().length == 1 || method.isAnnotationPresent(Listener.class);
    }

    private boolean isMethodAllowed(@NonNull final Method method, @NonNull final Class<? extends Event> eventClass) {
        return this.isMethodAllowed(method) || method.getParameterTypes()[0].equals(eventClass);
    }

    @AllArgsConstructor
    private final class ListenerMethod {
        @Getter private final Object source;
        @Getter private final Method target;
        @Getter private final Listener listener;
    }
}
