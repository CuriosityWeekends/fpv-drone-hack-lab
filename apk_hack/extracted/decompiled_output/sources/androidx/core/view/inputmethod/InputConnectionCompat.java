package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnCommitContentListener {
        boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i3, Bundle bundle);
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i3, @Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        boolean commitContent;
        ClipDescription description = inputContentInfoCompat.getDescription();
        boolean z3 = false;
        for (String str7 : EditorInfoCompat.getContentMimeTypes(editorInfo)) {
            if (description.hasMimeType(str7)) {
                if (Build.VERSION.SDK_INT >= 25) {
                    commitContent = inputConnection.commitContent(a.k(inputContentInfoCompat.unwrap()), i3, bundle);
                    return commitContent;
                }
                int protocol = EditorInfoCompat.getProtocol(editorInfo);
                if (protocol != 2) {
                    if (protocol != 3 && protocol != 4) {
                        return false;
                    }
                } else {
                    z3 = true;
                }
                Bundle bundle2 = new Bundle();
                if (z3) {
                    str = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
                } else {
                    str = COMMIT_CONTENT_CONTENT_URI_KEY;
                }
                bundle2.putParcelable(str, inputContentInfoCompat.getContentUri());
                if (z3) {
                    str2 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
                } else {
                    str2 = COMMIT_CONTENT_DESCRIPTION_KEY;
                }
                bundle2.putParcelable(str2, inputContentInfoCompat.getDescription());
                if (z3) {
                    str3 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
                } else {
                    str3 = COMMIT_CONTENT_LINK_URI_KEY;
                }
                bundle2.putParcelable(str3, inputContentInfoCompat.getLinkUri());
                if (z3) {
                    str4 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
                } else {
                    str4 = COMMIT_CONTENT_FLAGS_KEY;
                }
                bundle2.putInt(str4, i3);
                if (z3) {
                    str5 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
                } else {
                    str5 = COMMIT_CONTENT_OPTS_KEY;
                }
                bundle2.putParcelable(str5, bundle);
                if (z3) {
                    str6 = COMMIT_CONTENT_INTEROP_ACTION;
                } else {
                    str6 = COMMIT_CONTENT_ACTION;
                }
                return inputConnection.performPrivateCommand(str6, bundle2);
            }
        }
        return false;
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull final OnCommitContentListener onCommitContentListener) {
        if (inputConnection != null) {
            if (editorInfo != null) {
                if (onCommitContentListener != null) {
                    if (Build.VERSION.SDK_INT >= 25) {
                        return new InputConnectionWrapper(inputConnection, false) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.1
                            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                            public boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
                                if (onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i3, bundle)) {
                                    return true;
                                }
                                return super.commitContent(inputContentInfo, i3, bundle);
                            }
                        };
                    }
                    if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
                        return inputConnection;
                    }
                    return new InputConnectionWrapper(inputConnection, false) { // from class: androidx.core.view.inputmethod.InputConnectionCompat.2
                        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
                        public boolean performPrivateCommand(String str, Bundle bundle) {
                            if (InputConnectionCompat.handlePerformPrivateCommand(str, bundle, onCommitContentListener)) {
                                return true;
                            }
                            return super.performPrivateCommand(str, bundle);
                        }
                    };
                }
                throw new IllegalArgumentException("onCommitContentListener must be non-null");
            }
            throw new IllegalArgumentException("editorInfo must be non-null");
        }
        throw new IllegalArgumentException("inputConnection must be non-null");
    }

    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean handlePerformPrivateCommand(@Nullable String str, @NonNull Bundle bundle, @NonNull OnCommitContentListener onCommitContentListener) {
        boolean z3;
        String str2;
        ResultReceiver resultReceiver;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        ?? r02 = 0;
        r02 = 0;
        if (bundle == null) {
            return false;
        }
        if (TextUtils.equals(COMMIT_CONTENT_ACTION, str)) {
            z3 = false;
        } else if (!TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, str)) {
            return false;
        } else {
            z3 = true;
        }
        if (z3) {
            str2 = COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY;
        } else {
            str2 = COMMIT_CONTENT_RESULT_RECEIVER_KEY;
        }
        try {
            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable(str2);
            if (z3) {
                str3 = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
            } else {
                str3 = COMMIT_CONTENT_CONTENT_URI_KEY;
            }
            try {
                Uri uri = (Uri) bundle.getParcelable(str3);
                if (z3) {
                    str4 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
                } else {
                    str4 = COMMIT_CONTENT_DESCRIPTION_KEY;
                }
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(str4);
                if (z3) {
                    str5 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
                } else {
                    str5 = COMMIT_CONTENT_LINK_URI_KEY;
                }
                Uri uri2 = (Uri) bundle.getParcelable(str5);
                if (z3) {
                    str6 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
                } else {
                    str6 = COMMIT_CONTENT_FLAGS_KEY;
                }
                int i3 = bundle.getInt(str6);
                if (z3) {
                    str7 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
                } else {
                    str7 = COMMIT_CONTENT_OPTS_KEY;
                }
                Bundle bundle2 = (Bundle) bundle.getParcelable(str7);
                if (uri != null && clipDescription != null) {
                    r02 = onCommitContentListener.onCommitContent(new InputContentInfoCompat(uri, clipDescription, uri2), i3, bundle2);
                }
                if (resultReceiver2 != null) {
                    resultReceiver2.send(r02, null);
                }
                return r02;
            } catch (Throwable th) {
                th = th;
                resultReceiver = resultReceiver2;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            resultReceiver = null;
        }
    }
}
