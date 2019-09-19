package com.extra.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.junit.Test;

import java.io.StringReader;
import java.util.List;

public class JSqlParserUtil {

    private static final String sql = "select if(h.SETTLE_AMOUNT > 0, '标准', '贷项通知单')             INVOICE_TYPE,\n" +
            "       party.MERCHANT_NUMBER                              VENDOR_NUM,\n" +
            "       z.party_site_number,\n" +
            "       h.ACCOUNTING_DATE,\n" +
            "       h.PO_SETTLE_NUMBER,\n" +
            "       (select group_concat(hbbi.BILL_CODE separator '/')\n" +
            "        from hscs_bl_bill_info hbbi\n" +
            "        where hbbi.CORRELATE_NUMBER = h.CORRELATE_NUMBER) ACTUAL_INVOICE_NUM,\n" +
            "       h.SETTLE_AMOUNT,\n" +
            "       h.ACCOUNTING_DATE,\n" +
            "       h.COMMENTS,\n" +
            "       h.PAY_CONDITION,\n" +
            "       h.PAY_METHOD,\n" +
            "       et.EXRATE_TYPE_CODE,\n" +
            "       h.EXCHANGE_RATE,\n" +
            "       h.EXRATE_DATE,\n" +
            "       cd.CURRENCY_CODE,\n" +
            "       h.SIGN_COMPANY,\n" +
            "       h.DEPARTMENT_CODE,\n" +
            "       h.TAX_AMOUNT,\n" +
            "       h.PROJECT_CODE,\n" +
            "       h.CONTRACT_NUMBER,\n" +
            "       party.MERCHANT_NUMBER                              PARTY_CODE,\n" +
            "       bt.BUSINESS_TYPE_CODE,\n" +
            "       h.BUSINESS_NATURE,\n" +
            "       0                                                  SPARE1,\n" +
            "       0                                                  SPARE2,\n" +
            "       bt.DESCRIPTION                                     FUNDING_PLAN_ITEM,\n" +
            "       h.DEPARTMENT_CODE,\n" +
            "       h.CONTRACT_NUMBER,\n" +
            "       h.BUSINESS_NATURE                                  BUSINESS_LINE,\n" +
            "       'ITEM'                                             LINE_TYPE,\n" +
            "       tbi.TAX_CODE,\n" +
            "       h.SETTLE_AMOUNT                                    LINE_AMT,\n" +
            "       h.COMMENTS                                         LINE_DESC,\n" +
            "       h.ACCOUNTING_DATE,\n" +
            "       h.CASH_FLOW\n" +
            "from hscs_ap_po_settle_orders h\n" +
            "         left join hscs_pub_party_merchant party on h.MERCHANT_ID = party.MERCHANT_ID\n" +
            "         LEFT JOIN hscs_pub_party_sites z ON h.PARTY_SITE_ID = z.PARTY_SITE_ID\n" +
            "         left join HSCS_PUB_EXRATE_TYPE et on et.EXRATE_TYPE_ID = h.EXRATE_TYPE_ID\n" +
            "         left join HSCS_PUB_CURRENCY_DETAILS cd on cd.CURRENCY_ID = h.CURRENCY_ID\n" +
            "         left join HSCS_PUB_BUSINESS_TYPE_B bt on h.BUSINESS_TYPE_ID = bt.BUSINESS_TYPE_ID,\n" +
            "     hscs_ap_settle_order_lines l\n" +
            "         left join hscs_pub_tax_basic_info tbi on l.TAX_ID = tbi.TAX_ID\n" +
            "where h.PO_SETTLE_ID = l.PO_SETTLE_ID\n" +
            "  and h.SETTLE_ORDER_STATUS = 'APPROVED'\n" +
            "  and (1 = 2 or h.PO_SETTLE_NUMBER in ('321', '123'))";

    @Test
    public void demo() throws JSQLParserException {
        Statement statement = CCJSqlParserUtil.parse(sql);
        System.out.println(statement.toString());
    }

    @Test
    public void demo1() throws JSQLParserException {
        CCJSqlParserManager pm = new CCJSqlParserManager();
        Statement statement = pm.parse(new StringReader(sql));

        Select selectStatement = (Select) statement;
        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        List tableList = tablesNamesFinder.getTableList(selectStatement);
        for (Object o : tableList) {
            System.out.println(o);
        }
    }

}
