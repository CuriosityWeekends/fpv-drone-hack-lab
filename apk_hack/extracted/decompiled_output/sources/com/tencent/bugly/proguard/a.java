package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        int i3;
        int i5;
        int i6;
        StringBuffer stringBuffer = new StringBuffer();
        int i7 = 0;
        while (true) {
            String str = "map";
            if (i7 < arrayList.size()) {
                String str2 = arrayList.get(i7);
                if (!str2.equals("java.lang.Integer") && !str2.equals("int")) {
                    if (!str2.equals("java.lang.Boolean") && !str2.equals("boolean")) {
                        if (!str2.equals("java.lang.Byte") && !str2.equals("byte")) {
                            String str3 = "double";
                            if (!str2.equals("java.lang.Double") && !str2.equals("double")) {
                                str3 = "float";
                                if (!str2.equals("java.lang.Float") && !str2.equals("float")) {
                                    if (!str2.equals("java.lang.Long") && !str2.equals("long")) {
                                        str3 = "short";
                                        if (!str2.equals("java.lang.Short") && !str2.equals("short")) {
                                            if (!str2.equals("java.lang.Character")) {
                                                if (str2.equals("java.lang.String")) {
                                                    str = "string";
                                                } else if (str2.equals("java.util.List")) {
                                                    str = "list";
                                                } else if (!str2.equals("java.util.Map")) {
                                                    str = str2;
                                                }
                                            } else {
                                                throw new IllegalArgumentException("can not support java.lang.Character");
                                            }
                                        }
                                    } else {
                                        str = "int64";
                                    }
                                }
                            }
                            str = str3;
                        } else {
                            str = "char";
                        }
                    } else {
                        str = "bool";
                    }
                } else {
                    str = "int32";
                }
                arrayList.set(i7, str);
                i7++;
            } else {
                Collections.reverse(arrayList);
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    String str4 = arrayList.get(i8);
                    if (str4.equals("list")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i6));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals("map")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i5) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str4.equals("Array")) {
                        arrayList.set(i8 - 1, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }
}
