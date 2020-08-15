package com.se.lang.strings;

import cn.hutool.core.util.ReUtil;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReplace {

    @Test
    public void demo1() {
        String str = "{\\n  \\\"invoiceHeader\\\":[\\n    {\\n      \\\"invoiceNum\\\":\\\"I20190900004\\\",\\n      \\\"hsspLineType\\\":null,\\n      \\\"hsspLineNum\\\":null,\\n      \\\"returnStatus\\\":\\\"E\\\",\\n      \\\"message\\\":\\\"ATTRIBUTE2 不能为空。 ATTRIBUTE3 不能为空。 get_ccid:值集 TMWH_COMPANY 中不存在弹性域段 公司 的值 01. 。\\\"\\n    }\\n  ],\\n  \\\"apply\\\":[\\n    {\\n      \\\"invoiceNum\\\":null,\\n      \\\"prepayInvoiceNum\\\":null,\\n      \\\"returnStatus\\\":null,\\n      \\\"message\\\":null\\n    }\\n  ]\\n}";

        System.out.println(str
                                   .replace(
                                           "\n",
                                           ""
                                   )
                                   .replace(
                                           " ",
                                           ""
                                   )
                                   .replace(
                                           "\r",
                                           ""
                                   ));
    }

    static int sum = 0;

    @Test
    public void demo2() {
        System.out.println(njj2(9));
    }
    
    @Test
    public void demo3(){
        final StringBuffer stringBuffer = new StringBuffer();
        final StringBuilder stringBuilder = new StringBuilder();
    }

    public int njj(int n){
        if(n == 1){
            return 1;
        }else{
            return n + njj(n-1);
        }
    }

    public int njj2(int n){
        boolean y = n > 1 && njj2(n - 1) > 1;
        sum +=n;
        return sum;
    }
}
