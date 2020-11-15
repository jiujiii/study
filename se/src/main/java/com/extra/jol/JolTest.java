package com.extra.jol;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import com.Node;
import com.se.java8.optional.Fruit;
import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static cn.hutool.core.util.RandomUtil.*;

/**
 * <p>
 *
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/8/28 13:29
 */
public class JolTest {

    @Test
    public void demo1(){
        final Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        final Node node = new Node(1);
        System.out.println(ClassLayout.parseInstance(node).toPrintable());
        final Fruit fruit = new Fruit();
        fruit.setAmount(Long.MAX_VALUE);
        Stream.generate(RandomUtil::randomChar).limit(Long.MAX_VALUE);
        fruit.setName("");
        fruit.setType(Stream.generate(RandomUtil::randomChar).limit(Long.MAX_VALUE).toString());
        System.out.println(fruit);
        System.out.println(ClassLayout.parseInstance(fruit).toPrintable());
    }

}
