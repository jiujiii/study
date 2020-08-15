package com;

import com.se.collection.SetObjectEquals;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用来测试对象类,rebase3
 * </p>
 *
 * @author mengjian.ke@hand-china.com 2020/6/20 09:57
 */
@Setter
@Getter
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class Node {

    private int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }

        Node node = (Node) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
