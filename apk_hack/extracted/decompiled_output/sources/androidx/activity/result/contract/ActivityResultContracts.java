package androidx.activity.result.contract;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ActivityResultContracts {

    @TargetApi(19)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CreateDocument extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.CREATE_DOCUMENT").setType("*/*").putExtra("android.intent.extra.TITLE", str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(18)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {
        @NonNull
        public static List<Uri> getClipDataUris(@NonNull Intent intent) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (intent.getData() != null) {
                linkedHashSet.add(intent.getData());
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return Collections.emptyList();
            }
            if (clipData != null) {
                for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                    Uri uri = clipData.getItemAt(i3).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String str) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public final List<Uri> parseResult(int i3, @Nullable Intent intent) {
            if (intent != null && i3 == -1) {
                return getClipDataUris(intent);
            }
            return Collections.emptyList();
        }
    }

    @TargetApi(19)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).setType("*/*");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(21)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@NonNull Context context, @Nullable Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @Nullable Uri uri) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && uri != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", uri);
            }
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Uri parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    @TargetApi(19)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@NonNull Context context, @NonNull String[] strArr) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", strArr).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public final List<Uri> parseResult(int i3, @Nullable Intent intent) {
            if (i3 == -1 && intent != null) {
                return GetMultipleContents.getClipDataUris(intent);
            }
            return Collections.emptyList();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Intent createIntent(@NonNull Context context, @Nullable Void r22) {
            return new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public Uri parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return intent.getData();
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
            return createIntent(strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@NonNull Context context, @Nullable String[] strArr) {
            if (strArr != null && strArr.length != 0) {
                ArrayMap arrayMap = new ArrayMap();
                boolean z3 = true;
                for (String str : strArr) {
                    boolean z5 = ContextCompat.checkSelfPermission(context, str) == 0;
                    arrayMap.put(str, Boolean.valueOf(z5));
                    if (!z5) {
                        z3 = false;
                    }
                }
                if (z3) {
                    return new ActivityResultContract.SynchronousResult<>(arrayMap);
                }
                return null;
            }
            return new ActivityResultContract.SynchronousResult<>(Collections.emptyMap());
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Map<String, Boolean> parseResult(int i3, @Nullable Intent intent) {
            if (i3 != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra != null && stringArrayExtra != null) {
                HashMap hashMap = new HashMap();
                int length = stringArrayExtra.length;
                for (int i5 = 0; i5 < length; i5++) {
                    hashMap.put(stringArrayExtra[i5], Boolean.valueOf(intArrayExtra[i5] == 0));
                }
                return hashMap;
            }
            return Collections.emptyMap();
        }

        @NonNull
        public static Intent createIntent(@NonNull String[] strArr) {
            return new Intent(ACTION_REQUEST_PERMISSIONS).putExtra(EXTRA_PERMISSIONS, strArr);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull String str) {
            return RequestMultiplePermissions.createIntent(new String[]{str});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @Nullable String str) {
            if (str == null) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.FALSE);
            }
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Boolean parseResult(int i3, @Nullable Intent intent) {
            if (intent != null && i3 == -1) {
                int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
                if (intArrayExtra == null || intArrayExtra.length == 0) {
                    return Boolean.FALSE;
                }
                return Boolean.valueOf(intArrayExtra[0] == 0);
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull Intent intent) {
            return intent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int i3, @Nullable Intent intent) {
            return new ActivityResult(i3, intent);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public Intent createIntent(@NonNull Context context, @NonNull IntentSenderRequest intentSenderRequest) {
            return new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, intentSenderRequest);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public ActivityResult parseResult(int i3, @Nullable Intent intent) {
            return new ActivityResult(i3, intent);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        public final Boolean parseResult(int i3, @Nullable Intent intent) {
            return Boolean.valueOf(i3 == -1);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @Nullable Void r22) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @Nullable Void r22) {
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Bitmap parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@NonNull Context context, @NonNull Uri uri) {
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @NonNull
        @CallSuper
        public Intent createIntent(@NonNull Context context, @NonNull Uri uri) {
            return new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", uri);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.activity.result.contract.ActivityResultContract
        @Nullable
        public final Bitmap parseResult(int i3, @Nullable Intent intent) {
            if (intent == null || i3 != -1) {
                return null;
            }
            return (Bitmap) intent.getParcelableExtra("data");
        }
    }

    private ActivityResultContracts() {
    }
}
