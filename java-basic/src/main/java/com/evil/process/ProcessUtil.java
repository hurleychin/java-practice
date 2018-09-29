package com.evil.process;

import com.evil.util.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author qinhu
 * @date 2018-09-28
 */
public class ProcessUtil {

    private static final String TASKLIST = "tasklist";
    private static final String KILL = "taskkill /F /IM ";

    public static boolean isProcessRunning(String serviceName) throws Exception {

        boolean isRunning=false;

        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {

            if (line.contains(serviceName)) {
                isRunning=true;
            }
        }
        reader.close();
        return isRunning;
    }

    public static void killProcess(String serviceName) throws Exception {

        Runtime.getRuntime().exec(KILL + serviceName);
    }

    public static void main(String[] args) throws Exception {
        String serviceName="chrome.exe";
       if(isProcessRunning(serviceName)){
           killProcess(serviceName);
       }
    }
}
