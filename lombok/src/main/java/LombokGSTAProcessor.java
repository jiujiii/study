import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

//@AutoService(Processor.class)
@SupportedAnnotationTypes("com.extra.lombok.LombokGSTA")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LombokGSTAProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(LombokGSTA.class)) {
            System.out.println("------------------------------");
            // 判断元素的类型为Class
            if (element.getKind() == ElementKind.CLASS) {
                // 显示转换元素类型
                TypeElement typeElement = (TypeElement) element;
                // 输出元素名称
                System.out.println(typeElement.getSimpleName());
                // 输出注解属性值
                System.out.println(typeElement.getAnnotation(LombokGSTA.class));
            }
            System.out.println("------------------------------");
        }
        return false;
    }
}
