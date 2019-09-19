import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * {@link lombok.Setter}
 * {@link lombok.Getter}
 * {@link lombok.ToString}
 * {@link lombok.experimental.Accessors}
 * <p>
 * 给类添加上 @Setter,@Getter,@ToString,@Accessors
 * </p>
 *
 * @author mengjian.ke@hand-china.com
 * 2019/8/12 15:58
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface LombokGSTA {
}
