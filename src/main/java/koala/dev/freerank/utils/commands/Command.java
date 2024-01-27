package koala.dev.freerank.utils.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    public String name();
    public String permission() default "";
    public String noPerm() default "You do not have permission to perform that action.";
    public String[] aliases() default {};

    /**
     * The description that will appear in /help of the command
     *
     * @return
     */
    public String description() default "";

    /**
     * The usage that will appear in /help (commandname)
     *
     * @return
     */
    public String usage() default "";

    /**
     * Whether or not the command is available to players only
     *
     * @return
     */
    public boolean inGameOnly() default false;

}
