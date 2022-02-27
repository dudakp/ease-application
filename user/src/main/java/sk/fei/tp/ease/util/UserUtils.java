package sk.fei.tp.ease.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {

    public static String getCurrentUser() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        return ctx.getAuthentication().getName();
    }
}
