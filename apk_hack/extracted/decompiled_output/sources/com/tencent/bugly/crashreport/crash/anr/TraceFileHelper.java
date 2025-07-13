package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TraceFileHelper {

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f1219a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface b {
        boolean a(long j2);

        boolean a(long j2, long j5, String str);

        boolean a(String str, int i3, String str2, String str3);
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine.concat("\n"));
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, boolean z3) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new com.tencent.bugly.crashreport.crash.anr.b(aVar, z3));
        if (aVar.f1219a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.f1219a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z3) {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new com.tencent.bugly.crashreport.crash.anr.a(aVar, str, z3));
            if (aVar.f1219a > 0 && aVar.c > 0 && aVar.b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        BufferedReader bufferedReader;
        int i3 = 0;
        if (str != null && bVar != null) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            file.lastModified();
            file.length();
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader(file));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
            try {
                Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                while (true) {
                    Pattern[] patternArr = new Pattern[1];
                    patternArr[i3] = compile;
                    Object[] a5 = a(bufferedReader, patternArr);
                    if (a5 != null) {
                        Pattern[] patternArr2 = new Pattern[1];
                        patternArr2[i3] = compile3;
                        Object[] a6 = a(bufferedReader, patternArr2);
                        if (a6 == null) {
                            al.d("Failed to find process name.", new Object[i3]);
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e6) {
                                if (!al.a(e6)) {
                                    e6.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        String[] split = a5[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Matcher matcher = compile3.matcher(a6[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!bVar.a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e7) {
                                if (!al.a(e7)) {
                                    e7.printStackTrace();
                                    return;
                                }
                                return;
                            }
                        }
                        while (true) {
                            Object[] a7 = a(bufferedReader, compile4, compile2);
                            if (a7 == null) {
                                break;
                            } else if (a7[0] == compile4) {
                                String obj = a7[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader), b(bufferedReader));
                            } else if (!bVar.a(Long.parseLong(a7[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e8) {
                                    if (!al.a(e8)) {
                                        e8.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                        i3 = 0;
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e9) {
                            if (!al.a(e9)) {
                                e9.printStackTrace();
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Exception e10) {
                e = e10;
                bufferedReader2 = bufferedReader;
                if (!al.a(e)) {
                    e.printStackTrace();
                }
                String name = e.getClass().getName();
                al.d("trace open fail:%s : %s", name, e.getMessage());
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        if (!al.a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!al.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    private static String a(BufferedReader bufferedReader) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < 3; i3++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine.concat("\n"));
        }
        return stringBuffer.toString();
    }
}
