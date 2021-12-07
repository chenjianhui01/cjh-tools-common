package com.cjh.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description:
 * @author: chenJianHui
 * @date: 2021/11/29 09:26
 */
public class DictUtil {

    private DictUtil() {
    }

    private static final Map<String, String> SMS_SEND_ERROR_CODE_FAILURE_REASON_MAP;
    private static final Map<String, String> CSMD_SMS_ERROR_CODE_REASON_MAP;
    private static final Map<String, String> SMS_FAIL_REASON_CODE_MAP;


    static {
        Map<String, String> smsSendErrorCodeFailureReasonMapTemp;
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(DictUtil.class.getResourceAsStream("/dict/sms_error_code.txt")))) {
            String line;
            smsSendErrorCodeFailureReasonMapTemp = new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() < 1) {
                    continue;
                }
                String[] items = line.trim().split("\t");
                if (items.length == 2) {
                    smsSendErrorCodeFailureReasonMapTemp.put(items[1], items[0]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred wile loading SMS_SEND_ERROR_CODE_FAILURE_REASON_MAP. ", e);
        }
        SMS_SEND_ERROR_CODE_FAILURE_REASON_MAP = Collections.unmodifiableMap(smsSendErrorCodeFailureReasonMapTemp);
    }

    static {
        Map<String, String> csmdSmsErrorCodeReasonMap;
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(DictUtil.class.getResourceAsStream("/dict/csmd_sms_error_code.txt"))))  {
            String line;
            csmdSmsErrorCodeReasonMap=new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() < 1) {
                    continue;
                }
                String[] items = line.trim().split(" ");
                if (items.length == 2) {
                    csmdSmsErrorCodeReasonMap.put(items[0], items[1]);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException("Error occurred wile loading CSMD_SMS_ERROR_CODE_REASON_MAP. ", e);
        }
        CSMD_SMS_ERROR_CODE_REASON_MAP=Collections.unmodifiableMap(csmdSmsErrorCodeReasonMap);
    }

    static {
        Map<String, String> smsFailReasonCodeMap;
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(DictUtil.class.getResourceAsStream("/Users/chenjianhui/Desktop/LeWater/IdeaProjects/cjh-tools-common/src/main/resources/dict/sms_fail_reason.txt"))))  {
            String line;
            smsFailReasonCodeMap=new HashMap<>();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() < 1) {
                    continue;
                }
                String[] items = line.trim().split("\t");
                if (items.length == 2) {
                    smsFailReasonCodeMap.put(items[0], items[1]);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException("Error occurred wile loading SMS_FAIL_REASON_CODE_MAP. ", e);
        }
        SMS_FAIL_REASON_CODE_MAP=Collections.unmodifiableMap(smsFailReasonCodeMap);

    }

    public static Map<String, String> getSmsSendErrorCodeFailureReasonMap() {
        return SMS_SEND_ERROR_CODE_FAILURE_REASON_MAP;
    }

    public static Map<String, String> getCsmdSmsErrorCodeReasonMap(){
        return CSMD_SMS_ERROR_CODE_REASON_MAP;
    }

    public static Map<String, String> getSmsFailReasonCodeMap() {
        return SMS_FAIL_REASON_CODE_MAP;
    }
}
