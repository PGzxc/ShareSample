package com.pgzxc.sharesample.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.widget.Toast;
import com.pgzxc.sharesample.R;
import java.util.ArrayList;

/**
 * 分享工具类
 */

public class ShareUtils {

    /**
     * 分享文字
     *
     * @param context
     */
    public static void shareText(Context context) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, "这是一段分享的文字");
        context.startActivity(Intent.createChooser(textIntent, "分享"));
    }

    /**
     * 分享图片
     *
     * @param context
     */
    public static void sharePic(Activity context) {
        String path = getResourcesUri(R.drawable.ic_launcher, context);
        Intent imageIntent = new Intent(Intent.ACTION_SEND);
        imageIntent.setType("image/jpeg");
        imageIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(path));
        context.startActivity(Intent.createChooser(imageIntent, "分享"));
    }

    /**
     * 分享多个图片
     *
     * @param context
     */
    public static void shareMoreFile(Activity context) {
        ArrayList<Uri> imageUris = new ArrayList<>();
        Uri uri1 = Uri.parse(getResourcesUri(R.drawable.ic_launcher, context));
        Uri uri2 = Uri.parse(getResourcesUri(R.drawable.ic_launcher, context));
        imageUris.add(uri1);
        imageUris.add(uri2);
        imageUris.add(uri1);
        imageUris.add(uri2);
        Intent mulIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
        mulIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        mulIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(mulIntent, "多文件分享"));
    }

    /**
     * 分享到微信
     *
     * @param context
     */
    public static void shareWeixin(Context context) {
        Intent wechatIntent = new Intent(Intent.ACTION_SEND);
        wechatIntent.setPackage("com.tencent.mm");
        wechatIntent.setType("text/plain");
        wechatIntent.putExtra(Intent.EXTRA_TEXT, "分享到微信的内容");
        context.startActivity(wechatIntent);
    }

    /**
     * 分享到QQ
     *
     * @param context
     */
    public static void shareQQ(Context context) {
        Intent qqIntent = new Intent(Intent.ACTION_SEND);
        qqIntent.setPackage("com.tencent.mobileqq");
        qqIntent.setType("text/plain");
        qqIntent.putExtra(Intent.EXTRA_TEXT, "分享到QQ的内容");
        context.startActivity(qqIntent);
    }

    /**
     * 获得资源路径
     *
     * @param id
     * @param context
     * @return
     */
    private static String getResourcesUri(@DrawableRes int id, Context context) {
        Resources resources = context.getResources();
        String uriPath = ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                resources.getResourcePackageName(id) + "/" +
                resources.getResourceTypeName(id) + "/" +
                resources.getResourceEntryName(id);
        Toast.makeText(context, "Uri:" + uriPath, Toast.LENGTH_SHORT).show();
        return uriPath;
    }
}
