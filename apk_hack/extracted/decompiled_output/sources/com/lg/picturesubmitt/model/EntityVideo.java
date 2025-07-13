package com.lg.picturesubmitt.model;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class EntityVideo {
    public String name;
    public String thumbPath;
    public long value;

    public EntityVideo(long j2, String str, String str2) {
        this.thumbPath = str2;
        this.value = j2;
        this.name = str;
    }

    public boolean equals(Object obj) {
        return this.thumbPath.equalsIgnoreCase(((EntityVideo) obj).thumbPath);
    }
}
