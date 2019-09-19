package com.se.strings;

import org.junit.Test;

public class StringReplace {

    @Test
    public void demo1(){
        String str = "[\n" +
                "    {\n" +
                "        \"objectVersionNumber\": 1,\n" +
                "        \"itemId\": 4,\n" +
                "        \"mdmId\": null,\n" +
                "        \"itemNumber\": \"1001000001\",\n" +
                "        \"itemDesc\": \"大麦次粉\",\n" +
                "        \"itemCategory\": null,\n" +
                "        \"itemCategoryCode\": null,\n" +
                "        \"organizationName\": \"1007_A02_广汉国雄_非生产库存组织\",\n" +
                "        \"itemPp\": null,\n" +
                "        \"itemPm\": \"大麦次粉\",\n" +
                "        \"itemXl\": null,\n" +
                "        \"itemGg\": null,\n" +
                "        \"itemXh\": null,\n" +
                "        \"itemBz\": null,\n" +
                "        \"primaryUomCode\": \"kg\",\n" +
                "        \"secondaryUomCode\": null,\n" +
                "        \"lotControl\": \"完全控制\",\n" +
                "        \"minMinmaxQuantity\": null,\n" +
                "        \"maxMinmaxQuantity\": null,\n" +
                "        \"__status\": \"delete\"\n" +
                "    }\n" +
                "]";
        System.out.println(str.replace("\n","").replace(" ","").replace("\r",""));
    }

}
